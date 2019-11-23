package com.congee.service.impl;

import com.congee.dao.AttentionRepository;
import com.congee.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    private AttentionRepository attentionRepository;
    @Override
    public int countByUidAndApid(Integer uid, Integer apid) {
        int i = attentionRepository.countByUidAndApid(uid, apid);
        return i;
    }
}
