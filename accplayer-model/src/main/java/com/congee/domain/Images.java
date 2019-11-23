package com.congee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: 小米粥
 * @description: com.congee.domain
 * @date: 2019/11/9
 * @time: 17:52
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_images")
public class Images implements Serializable {

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer eid;//图片详情id

    @Column(name = "accplayer_id")
    private Integer apid;//陪玩id

    @Column(name = "accplayer_pic1")
    private String aPic1;//陪玩小图1

    @Column(name = "accplayer_pic2")
    private String aPic2;//陪玩小图2

    @Column(name = "accplayer_pic3")
    private String aPic3;//陪玩小图3

    @Column(name = "accplayer_pic4")
    private String aPic4;//陪玩小图4

    @Column(name = "accplayer_video")
    private String aVideo;//陪玩音频文件
}
