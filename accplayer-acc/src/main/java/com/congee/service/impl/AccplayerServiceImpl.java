package com.congee.service.impl;

import com.congee.dao.AccplayerRepository;
import com.congee.domain.Accplayer;
import com.congee.service.AccplayerService;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: 小米粥
 * @description: com.congee.service.impl
 * @date: 2019/11/12
 * @time: 19:04
 */
@Service
public class AccplayerServiceImpl implements AccplayerService {
    @Autowired
    private AccplayerRepository accplayerRepository;
    @Override
    public void updAccplayer(Accplayer accplayer) {
        accplayerRepository.saveAndFlush(accplayer);
    }

    @Override
    public Result findByZero(Integer aAudit,Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Accplayer> accplayers = accplayerRepository.findByAAudit(aAudit, pageable);
        Result result = new Result();
        if(aAudit==1){
            result.setCode(200);
            result.setMessage("审核通过");
        }else{
            result.setCode(-1);
            result.setMessage("审核不通过，请检查自我信息是否有误");
        }
        result.setList(accplayers.getContent());
        result.setTotal(accplayers.getTotalElements());
        return result;
    }

    @Override
    public Accplayer findByApid(Integer apid) {
        Optional<Accplayer> byId = accplayerRepository.findById(apid);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public Result findEcharts(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Accplayer> all = accplayerRepository.findAll(pageable);
        Result result = new Result();
        result.setTotal(all.getTotalElements());
        result.setList(all.getContent());
        result.setMessage("后台echarts分页查询成功");
        result.setCode(200);
        return result;
    }


}
