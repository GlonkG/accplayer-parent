package com.congee.dao;

import com.congee.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {

    //测试根据游戏名称查询游戏板块ID
    public List<Game> findByGName(String gName);
}
