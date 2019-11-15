package com.congee.service;

import com.congee.domain.Accplayer;
import com.congee.utils.Result;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.service
 * @date: 2019/11/12
 * @time: 18:59
 */
public interface AccplayerService {
    //后台专员审核陪玩入驻资质
    public void updAccplayer(Accplayer accplayer);
    //后台分页查询待审核 & 已通过
    public Result findByZero(Integer aAudit,Integer page,Integer size);
    //后台根据apid更改陪玩资质
    public Accplayer findByApid(Integer apid);
    //后台echarts分页查询
    public Result findEcharts(Integer page,Integer size);

    //后台删除陪玩信息
    public void delAccplayer(Integer apid);

    //根据板块名称查询陪玩--by yhf
    public List<Accplayer> findByGName(String gName);

    //批量删除陪玩
    public boolean deleteAccplayers(String[] apid);

    //陪玩申请入驻服务
    public void addAccplayer(Accplayer accplayer);
}
