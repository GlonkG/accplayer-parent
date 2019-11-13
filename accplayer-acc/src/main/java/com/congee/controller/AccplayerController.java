package com.congee.controller;

import com.congee.domain.Accplayer;
import com.congee.service.AccplayerService;
import com.congee.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/12
 * @time: 19:21
 */
@RestController
@RequestMapping("/acc")
public class AccplayerController {

    private final static Logger log = LoggerFactory.getLogger(AccplayerController.class);

    @Autowired
    private AccplayerService accplayerService;

    //后台专员审核陪玩入驻资质
    @RequestMapping("/check/{apid}")
    public String checkAccplayer(@PathVariable("apid")Integer apid){
        Accplayer accplayer = accplayerService.findByApid(apid);
        accplayer.setAAudit(1);//审核通过更改为1
        accplayerService.updAccplayer(accplayer);
        return "check success";
    }

    //后台分页查询待审核 & 已通过
    @RequestMapping("/findByAAudit/{aAudit}/{page}/{size}")
    public Result findByAAudit(@PathVariable("aAudit")Integer aAudit,
                               @PathVariable("page")Integer page,
                               @PathVariable("size")Integer size){
        log.info("前端传输的参数为============"+aAudit+page+size);
        Result zero = accplayerService.findByZero(aAudit, page, size);
        return zero;
    }

     //后台echarts分页查询
     @RequestMapping("/echarts/bar/{page}/{size}")
     public Result bar(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Result echarts = accplayerService.findEcharts(page, size);
        return echarts;
    }
}
