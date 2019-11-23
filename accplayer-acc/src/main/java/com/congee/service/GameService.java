package com.congee.service;

import com.congee.domain.Game;

import java.util.List;

public interface GameService {

    //测试根据游戏名称查询游戏板块ID
    public List<Game> findByGName(String gName);
}
