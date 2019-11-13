package com.congee.dao;

import com.congee.domain.Accplayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/12
 * @time: 18:58
 */
public interface AccplayerRepository extends JpaRepository<Accplayer,Integer> {
    //根据陪玩资质分页查询
    public Page<Accplayer> findByAAudit(Integer aAudit,Pageable pageable);
}
