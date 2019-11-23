package com.congee.domain;

import lombok.Data;

@Data
public class GameDetail {
    private Integer pid; //陪玩id
    private Integer gid;//游戏对应的id
    private String pInfo; //陪玩 自我介绍
    private String pAttentionNum; //陪玩被关注数
    private String gName; //陪玩 所有的陪玩游戏
    private String gDuanWei;// 陪玩游戏对应得段位
}
