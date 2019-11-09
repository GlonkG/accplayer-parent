package com.congee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/9
 * @time: 16:46
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_user")
public class User implements Serializable {

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer uid;//用户id

    @Column(name = "user_nickname")
    private String userNickname;//昵称

    @Column(name = "user_name")
    private String userName;//用户姓名

    @Column(name = "user_pwd")
    private String userPwd;//密码

    @Column(name = "user_tel")
    private String userTel;//电话号码

    @Column(name = "user_gender")
    private String userGender;//性别

    @Column(name = "user_birthday")
    private Date userBirthday;//出生日期

    @Column(name = "user_qq")
    private String userQq;//QQ

    @Column(name = "user_weixin")
    private String userWeixin;//微信

    @Column(name = "user_pic")
    private String userPic;//头像

    @Column(name = "user_address")
    private String userAddress;//住址

    @Column(name = "user_content")
    private String userContent;//签名

    @Column(name = "user_createtime")
    private Date userCreatetime;//创建时间

    @Column(name = "user_becometime")
    private Date userBecometime;//成为陪玩时间

    @Column(name = "user_identify")
    private Integer userIdentify;//标识：0 老板(普通用户) 1 陪玩 2 管理员

    @Column(name = "user_status")
    private Integer userStatus;//用户申请状态： 0 未认证 1 正常



}
