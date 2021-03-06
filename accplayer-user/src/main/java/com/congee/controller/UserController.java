package com.congee.controller;
import com.aliyuncs.exceptions.ClientException;
import com.congee.client.AccplayerClient;
import com.congee.domain.Accplayer;
import com.congee.domain.User;
import com.congee.service.MailService;
import com.congee.service.UserService;
import com.congee.utils.Result;
import com.congee.utils.TelUtils;
import com.congee.utils.UploadUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/11
 * @time: 14:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    //获得手机发送的验证码
    @RequestMapping("/phone/{userTel}")
    public String phoneCode(@PathVariable("userTel")String userTel) throws ClientException {
        log.info("前端传输的手机号为==================="+userTel);
        String code = TelUtils.telUtil(userTel);
        log.info("发送的验证码为======================="+code);
        if("fail".equals(code)){
            log.info("发送验证码失败");
            return code;
        }
        redisTemplate.opsForValue().set(userTel,code,15,TimeUnit.MINUTES);
        return code;
    }

    //用户新增==注册
    @RequestMapping(value = "/regist/{userTel}/{userPwd}/{code}")
    public String userRegist(@PathVariable("userTel")String userTel,
                             @PathVariable("userPwd")String userPwd,
                             @PathVariable("code")String code){
        log.info("前端传输的手机号为==================="+userTel+",验证码为=============="+code);
        User user = userService.findByUserTel(userTel);
        if(user!=null){
            log.info("该手机号已被使用");
            return "该手机号已被使用";
        }else{
            String code1 = redisTemplate.opsForValue().get(userTel).toString();
            if(code.equals(code1)){
                log.info("验证码正确");
                User user1 = new User();
                user1.setUserTel(userTel);
                user1.setUserPwd(userPwd);
                user1.setUserStatus(0);//用户使用状态： 0 正常使用
                user1.setUserIdentify(1);//默认身份
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String format1 = format.format(new Date());
                ParsePosition pos = new ParsePosition(8);
                Date date1 = format.parse(format1, pos);
                user1.setUserCreatetime(date1);//用户注册时间
                userService.addUser(user1);
                return "regist success";
            }
        }
        return "regist failure";
    }

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLogin(@RequestBody User user){
        log.info("前端传输的手机号为==================="+user.getUserTel());
        User userTel = userService.findByUserTel(user.getUserTel());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(userTel.getUserTel(),userTel.getUserPwd());
        try{
            subject.login(token);
            if(subject.isAuthenticated()&&userTel.getUserStatus()==0){//用户使用状态： 0 正常使用 可以登录
                redisTemplate.opsForValue().set("telToken",userTel.getUserTel());
                Object teltoken = redisTemplate.opsForValue().get("telToken");
                log.info("得到手机号为====================="+teltoken);
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

    /*//登录
    @Autowired
    private MailService mailService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLogin(@RequestBody User user){
        log.info("前端传输的手机号为==================="+user.getUserTel());
        User userTel = userService.findByUserTel(user.getUserTel());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(userTel.getUserTel(),userTel.getUserPwd());
        try{
            subject.login(token);
            if(subject.isAuthenticated()&&userTel.getUserStatus()==1){
                redisTemplate.opsForValue().set("telToken",userTel.getUserTel());
                Object teltoken = redisTemplate.opsForValue().get("telToken");
                log.info("得到手机号为====================="+teltoken);
                return "login success";
            }else{
                mailService.send(userTel);//异步通知，无返回值
                return "login failure";
            }
        }catch(Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return "login failure";
    }*/

    //注销
    @RequestMapping("/loginout")
    public void loginout(HttpServletRequest request ){
        HttpSession session=request.getSession();
        session.removeAttribute("telToken");
    }
    //个人资料获取登录手机号:再通过手机号查询个人信息
    @RequestMapping("/getInfoByTel")
    public User getInfoByTel(){
        String userTel =(String)redisTemplate.opsForValue().get("telToken");
        User user = userService.findByUserTel(userTel);
        return user;
    }

    //判断用户状态是否在线：从redis查询用户名
    @RequestMapping("/finduserTel")
    public String findusername(HttpServletRequest request){
        String teltoken =(String)redisTemplate.opsForValue().get("telToken");
        log.info("得到手机号为====================="+teltoken);
        if(teltoken!=null){
            log.info("The ID is already online");
            String userTel = userService.findByUserTel(teltoken).getUserTel();
            User user = userService.findByUserTel(userTel);
            return user.getUserNickname();
        }
        return "The ID is already offline";
    }
    //改为将用户账号改为被禁用--by 11/16 11:28
    @RequestMapping("/updUserStatus/{uid}")
    public String updUserStatus(@PathVariable("uid")Integer uid){
        User user = userService.findByUid(uid);
        user.setUserStatus(1);//被禁用
        userService.updUser(user);
        return "updUserStatus success";
    }
    /*//根据用户id进行用户删除
    @RequestMapping("/delUser/{uid}")
    public String delUser(@PathVariable("uid")Integer uid){
        userService.delUser(uid);
        return "delUser success";
    }*/

    //用户修改
    //1.根据用户id进行原有信息查询
    @RequestMapping("/findByUid/{uid}")
    public User findByUid(@PathVariable("uid")Integer uid){
        User user = userService.findByUid(uid);
        return user;
    }
    //2.修改用户信息
    @RequestMapping(value = "/updUser",method = RequestMethod.POST)
    public String updUser(@RequestBody User user){
        userService.updUser(user);
        return "updUser success";
    }

    //后台管理分页查询展示用户
    @RequestMapping("/findUserByPage/{page}/{size}")
    public Result findUserByPage(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Result result = userService.findUserByPage(page, size);
        return result;
    }

    @Autowired
    private UploadUtils uploadUtils;
    //用户上传头像&修改头像
    @RequestMapping(value = "/loadingUserPic",method = RequestMethod.POST)
    public String uploadUserPic(MultipartFile file){
        String upload = uploadUtils.upload(file);
        return upload;
    }

    //测试简单注册
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        log.info("前端传来的值为============="+user);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(new Date());
        ParsePosition pos = new ParsePosition(8);
        Date date1 = format.parse(format1, pos);
        user.setUserCreatetime(date1);//用户注册时间
        userService.addUser(user);
        return "test success";
    }

    //批量删除用户
    @RequestMapping(value = "/deleteUsers")
    public String deleteUsers(@RequestBody String[] uid){
        log.info("前端传输的数组为==============="+uid.toString());
        boolean b = userService.deleteUsers(uid);
        if(b){
            return "deleteUsers success";
        }
        return "deleteUsers failure";
    }

    //根据用户名查询用户--by wgb
    @RequestMapping("/searchByUserName/{username}")
    public List<User> searchByUserName(@PathVariable("username") String username){
        List<User> nickname = userService.findByUserNickname(username);
        return nickname;
    }

    @Autowired
    private AccplayerClient accplayerClient;
    //后台专员审核陪玩入驻资质
    @RequestMapping("/check/{apid}")
    public String checkAccplayer(@PathVariable("apid")Integer apid){
        log.info("前端传输的陪玩ID为====================="+apid);
        Accplayer accplayer = accplayerClient.checkAccplayer(apid);
        User user = userService.findByUid(accplayer.getUid());
        user.setUserBecometime(new Date());//陪玩审核通过，成功入驻的时间
        userService.updUser(user);//修改入驻的时间
        return "openFeign success";
    }


}
