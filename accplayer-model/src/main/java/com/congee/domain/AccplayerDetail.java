package com.congee.domain;

import lombok.Data;

@Data
public class AccplayerDetail {
    //user
    private String userNickname;//昵称
    private String userGender;//性别
    private String userAddress;//住址
    //accplayer
    private Integer pid;//陪玩id
    private String gName;//板块名(游戏名称)
    private String gDuanwei;//游戏段位
    private  Double gPrice;//陪玩的游戏每小时收费
    private String gLogo;//游戏logo
    //image
    private String aPic;
    private String aPic1;
    private String aPic2;
    private String aPic3;
    private String aPic4;
    private String aVideo;

}
