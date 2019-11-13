package com.congee.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.congee.UserApplication;
import com.congee.domain.User;
import com.congee.service.UserService;
import com.congee.utils.Result;
import com.congee.utils.UploadUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Convert;
import java.text.SimpleDateFormat;

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

    //用户新增==注册

    //根据用户id进行用户删除
    @RequestMapping("/delUser/{uid}")
    public String delUser(@PathVariable("uid")Integer uid){
        userService.delUser(uid);
        return "delUser success";
    }

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
        user.setUserCreatetime(simpleDateFormat.format(user.getUserCreatetime()));
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
}
