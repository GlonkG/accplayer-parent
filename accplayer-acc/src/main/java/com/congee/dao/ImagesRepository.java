package com.congee.dao;

import com.congee.domain.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/18
 * @time: 23:38
 */
public interface ImagesRepository extends JpaRepository<Images,Integer> {
    //测试根据陪玩ID--apid查询详情图片
    public List<Images> findByApid(Integer apid);
}