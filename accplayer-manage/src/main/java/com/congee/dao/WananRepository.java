package com.congee.dao;

import com.congee.domain.Wanan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/13
 * @time: 15:39
 */
public interface WananRepository extends JpaRepository<Wanan,Integer> {
    //根据名字查询对象
    public Wanan findByName(String name);
}
