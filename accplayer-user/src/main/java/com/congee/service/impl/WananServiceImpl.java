package com.congee.service.impl;

import com.congee.dao.WananRepository;
import com.congee.domain.Wanan;
import com.congee.service.WananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 小米粥
 * @description: com.congee.service.impl
 * @date: 2019/11/13
 * @time: 15:44
 */
@Service
public class WananServiceImpl implements WananService {
    @Autowired
    private WananRepository wananRepository;
    @Override
    public Wanan findByName(String name) {
        return wananRepository.findByName(name);
    }
}
