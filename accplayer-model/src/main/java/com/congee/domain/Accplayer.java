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
 * @time: 17:06
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc_accplayer")
public class Accplayer implements Serializable {

    //定义程序序列化ID.相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性。
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accplayer_id")
    private Integer apid;//陪玩id

    @Column(name = "user_id")
    private Integer uid;//用户id

    @Column(name = "game_id")
    private Integer gid;//板块id

    @Column(name = "game_name")
    private String gName;//板块名

    @Column(name = "game_daqu")
    private String gDaqu;//游戏大区

    @Column(name = "game_duanwei")
    private String gDuanwei;//游戏段位

    @Column(name = "game_playerid")
    private String gPid;//陪玩游戏id

    @Column(name = "game_price")
    private Double gPrice;//陪玩的价格xx元/小时

    @Column(name = "accplayer_description")
    private String aDescription;//服务介绍

    @Column(name = "attention_num")
    private Integer aNum;//关注数量

    @Column(name = "accplayer_audit")
    private Integer aAudit;//陪玩入驻资质：默认-1待审核 1已通过

    @Column(name = "acc_pic")
    private String accPic;//认证资料图

    @Column(name = "acc_voice")
    private String accVoice;//语音介绍

    @Column(name = "user_nickname")
    private String userNickname;//昵称

}
