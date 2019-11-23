package com.congee.dao;

import com.congee.domain.Attention;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/15
 * @time: 9:30
 */
public interface AttentionRepository extends JpaRepository<Attention,Integer> {

   //使用count计数方法
    public int countByUidAndApid(Integer uid,Integer apid);
}
