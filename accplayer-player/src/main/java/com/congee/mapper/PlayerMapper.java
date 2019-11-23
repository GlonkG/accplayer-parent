package com.congee.mapper;



import com.congee.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PlayerMapper {

    /*//根据pic查询陪玩的详情和服务技能
    List<AccplayerDetail> findByPic(String pic);

    //根据游戏名查询(异步)信息
    AccplayerDetail2 findByGameName(String gameName);

    //根据陪玩昵称查询陪玩详情(陪玩表,use表 ,用陪玩id)
    List<GameDetail> findByPid(Integer pid);
    //根据pid查询陪玩的详情
    AccpalyerDetail3 findById(Integer pid);
    //根据pid查询陪玩的详情
    ImagesDetail findByPidToImages(Integer pid);*/

    //根据游戏名查询(异步)信息
    Game findByGameName1(String gameName);

    //根据游戏名查询(异步)对应游戏名历史接单数量
    Order findByGameName2(String gameName);

    //根据游戏名（game_name）查询陪玩人员的接单数量
    Integer orderTotal(String gameName);

    //陪玩被关注的总数量(pid,aStatus)
    int findNum(@Param("apid") Integer apid, @Param("aStatus") Integer aStatus);

    //根据uid和pid查询对象是否存在
    Attention findUp(@Param("uid") Integer uid, @Param("apid") Integer apid);

    //根据uid和aid新增关注数
    Integer saveAttention(Attention attention);

    //取消关注
    Integer update(Attention attention);



}