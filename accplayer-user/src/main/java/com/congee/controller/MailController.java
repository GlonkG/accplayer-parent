package com.congee.controller;
import com.congee.domain.User;
import com.congee.service.MailService;
import com.congee.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 小米粥
 * @description: com.itqf.com.itqf.controller
 * @date: 2019/10/25
 * @time: 11:20
 */
@RestController
public class MailController {
    private final static Logger log = LoggerFactory.getLogger(MailController.class);
    /*@Autowired
    private MailService mailService;
    @RequestMapping("mail")
    public String mail(@RequestBody User user){
        mailService.send(user);//异步通知，无返回值
        return "success";
    }*/

    @Autowired
    private UserService userService;
    @RequestMapping("/active/{id}")
    public String active(@PathVariable("id")Integer id){
        log.info("要激活的用户ID为==============="+id);
        User user = userService.findByUid(id);
        log.info("用户激活之前状态为================="+user.getUserStatus());
        if(user.getUserStatus()==0){
            user.setUserStatus(1);//激活成功*/
            userService.updUser(user);
            log.info("用户激活之后状态为================="+user.getUserStatus());
            return "active success";
        }
        return "active failure";
    }

}
