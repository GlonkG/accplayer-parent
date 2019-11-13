package com.congee.service;

import com.congee.domain.Wanan;

/**
 * @author: 小米粥
 * @description: com.congee.service
 * @date: 2019/11/13
 * @time: 15:43
 */
public interface WananService {
    //根据名字查询对象
    public Wanan findByName(String name);
}
