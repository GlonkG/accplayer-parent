package com.congee.service;

import com.congee.domain.*;

import java.util.List;

public interface AccplayerDetailService {
    /*//根据陪玩pic查询个人详情
    List<AccplayerDetail> findByPic(String pic);

    //根据游戏名查询(异步)信息（多表联查）
    AccplayerDetail2 findByGameName(String gameName);

    //根据陪玩pid查询个人详情
    List<GameDetail> findByPid(Integer pid);

    //根据pid查询陪玩的详情
    AccpalyerDetail3 findById(Integer pid);

    ImagesDetail findByPidToImages(Integer pid);*/

    //根据游戏名查询(异步)信息
    Game findByGameName1(String gameName);

    //根据游戏名查询(异步)对应游戏名历史接单数量
    Order findByGameName2(String gameName);

    //陪玩被关注的总数量(pid,aStaus)
    int findNum(Integer apid, Integer aStatus);

    //根据uid和pid查询对象是否存在
   Attention findUp( Integer apid , Integer uid);

    //根据uid,pid新增
//    Attention saveAttention(Attention attention);
    Integer saveAttention(Integer uid, Integer apid);

    //取消关注(修改aStatus)
    Integer update(Integer uid, Integer apid);

    public List<Attention> findByApidAndUid(Integer apid,Integer pid);
}
