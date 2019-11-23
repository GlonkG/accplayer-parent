package com.congee.domain;

import lombok.Data;

@Data
public class AccplayerDetail2 {
    private Integer orderNumber; //陪玩游戏历史接单数量
    private String gName;        //陪玩的游戏名
    private String gameLogo;     //陪玩logo
    private String gameDuanWei;  //陪玩游戏段位
    private Double gamePrice;    //陪玩的游戏价格
    private String accplayerDescription; //自我介绍
    private Integer orderAppointedTime;  //预约时长
    private String accplayerVideo;      // 音频
}
