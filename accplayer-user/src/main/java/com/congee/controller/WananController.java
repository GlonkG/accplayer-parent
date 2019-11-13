package com.congee.controller;

import com.congee.UserApplication;
import com.congee.domain.Wanan;
import com.congee.service.WananService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/13
 * @time: 15:51
 */
@RestController
@RequestMapping("/wanan")
public class WananController {
    private final static Logger log = LoggerFactory.getLogger(WananController.class);
    @Autowired
    private WananService wananService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLogin(@RequestBody Wanan wanan){
        log.info("前端传输的登录名为==================="+wanan.getName());
        Wanan wanan1 = wananService.findByName(wanan.getName());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(wanan.getName(),wanan.getPass());
        try{
            subject.login(token);
            if(subject.isAuthenticated()){
                redisTemplate.opsForValue().set("usertoken",wanan.getName());
                Object usertoken = redisTemplate.opsForValue().get("usertoken");
                log.info("得到用户名为====================="+usertoken);
                return "login success";
            }else{
                return "login failure";
            }
        }catch(Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return "login failure";
    }

    //注销
    @RequestMapping("/loginout")
    public void loginout(HttpServletRequest request ){
        HttpSession session=request.getSession();
        session.removeAttribute("usertoken");
    }
    //从redis查询用户名
    @RequestMapping("/findusername")
    public String findusername(HttpServletRequest request){
        String usertoken =(String)redisTemplate.opsForValue().get("usertoken");
        log.info("得到用户名为====================="+usertoken);
        if(usertoken!=null){
            log.info("The ID is already online");
            String name = wananService.findByName(usertoken).getName();
            return name;
        }
        return "The ID is already offline";
    }
}
