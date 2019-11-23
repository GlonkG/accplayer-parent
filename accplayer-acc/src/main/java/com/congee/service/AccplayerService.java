package com.congee.service;

import com.congee.domain.Accplayer;
import com.congee.domain.Game;
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
    public Accplayer updAccplayer(Accplayer accplayer);
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

    //根据类型对陪玩的查询--找陪玩--by sml
    public List<Accplayer> findAccplayerBygName(String game);
    //根据陪玩性别查询陪玩--找陪玩
    List<Accplayer> findAccplayerByUserGender(String usergender);
    //根据游戏类型And陪玩性别查找
    public List<Accplayer> findAccplayerBygNameAndUserGender(String game,String usergender);
    //备注：暂未用
    List<Accplayer> findAccplayerByGNameContainingAndApid(String gname,Integer apid);
    //根据陪玩昵称查找陪玩--?
    List<Accplayer> findAccplayerByuserNicknamer(String userNicknamer);
    //最新入驻--首页
    List<Accplayer> findUserBecometime();

    //价格
    List<Accplayer> findUserPrice();

    //测试详情
    public List<Accplayer> findByApids(Integer apid);

    //人气榜
    public List<Accplayer> findANum();

    //测试根据用户ID查询
    public Accplayer findByUid(Integer uid);

    List<Accplayer> findAccplayerByGPrice(Double gprice);
}
