package com.congee;

import com.aliyuncs.exceptions.ClientException;
import com.congee.domain.User;
import com.congee.service.UserService;
import com.congee.utils.TelUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/14
 * @time: 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTel {



    @Test
    public void test1(){
        try {
            TelUtils.telUtil("17809163801");
            System.out.println("已调用");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private UserService userService;
    @Test
    public void test2(){
        User user = new User();
        for(int i=0;i<5;i++){
            user.setUserNickname("glonk");//昵称
            user.setUserName("Amani");//姓名
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date("1997-01-01");
            String dateString = dateFormat.format(date);
            ParsePosition pos = new ParsePosition(8);
            Date date1 = dateFormat.parse(dateString, pos);
            user.setUserBirthday(date1);//生日
            if(i%2==0){
                user.setUserGender("女");
                user.setUserPic("http://q04va6ogc.bkt.clouddn.com/Fr0WoZijj4gUhT9rOMRBRfCyrs7R");
            }else{
                user.setUserGender("男");
                user.setUserPic("http://q04va6ogc.bkt.clouddn.com/FgUlYOPtRb3V0gVhizWLuMg_OZb0");
            }
            user.setUserQq("11283576");//qq
            user.setUserWeixin("QYJY4737");//weixin
            user.setUserAddress("西安千峰立人科技");//address
            user.setUserContent("小可爱唱歌是真的好听！");//content
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String format1 = dateFormat1.format(new Date());
            Date date2 = dateFormat1.parse(format1, pos);
            user.setUserCreatetime(date2);//用户注册时间
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            String format2 = dateFormat2.format(new Date());
            Date date3 = dateFormat2.parse(format2, pos);
            user.setUserBecometime(date3);//陪玩注册时间
            user.setUserIdentify(0);//用户身份
            user.setUserStatus(1);//正常
        }
        userService.addUser(user);
        System.out.println("新增用户成功");
    }
}
