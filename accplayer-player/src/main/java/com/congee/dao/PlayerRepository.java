package com.congee.dao;

import com.congee.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/15
 * @time: 9:30
 */
public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
