package com.congee.service.impl;

import com.congee.domain.*;
import com.congee.mapper.PlayerMapper;
import com.congee.mapper.PlayerRepository;
import com.congee.service.AccplayerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.redis.core.RedisTemplate;*/
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AccplayerDetailServiceImpl implements AccplayerDetailService {
    @Autowired
    private PlayerMapper playerMapper;
    /*@Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //根据陪玩pic查询信息（详情页）
    @Override
    public List<AccplayerDetail> findByPic(String pic) {
        //1.redis 取
//        AccplayerDetail player = (AccplayerDetail)redisTemplate.opsForValue().get("key");
//        if (player!=null){
//            return player;
//        }
        //2.查库
        List<AccplayerDetail> byPic = playerMapper.findByPic(pic);
        //3.存 redis
//        redisTemplate.opsForValue().set("playerDetail",byPic,60*10,TimeUnit.MILLISECONDS);
        return byPic;
    }
    //根据游戏名查询(异步)信息(多表)
    @Override
    public AccplayerDetail2 findByGameName(String gameName) {
//        AccplayerDetail2 game = (AccplayerDetail2)redisTemplate.opsForValue().get("gameName");
//        if (game!=null){
//            return game;
//        }
        AccplayerDetail2 byGameName = playerMapper.findByGameName(gameName);
//        redisTemplate.opsForValue().set("gameName",byGameName,60*10,TimeUnit.MILLISECONDS) ;
        return byGameName;
    }



    //根据pid查询信息（详情页）
    @Override
    public List<GameDetail> findByPid(Integer pid) {
        List<GameDetail> byPid = playerMapper.findByPid(pid);
        if(byPid!=null){
            return byPid;
        }
        return null;
    }
    */
    //根据游戏名查询(异步)信息（单表）
    @Override
    public Game findByGameName1(String gameName) {
        Game byGameName1 = playerMapper.findByGameName1(gameName);
        if (byGameName1!=null){
            return byGameName1;
        }
        return null;
    }

    //根据游戏名查询(异步)对应游戏名历史接单数量（单表）
    @Override
    public Order findByGameName2(String gameName) {
        Order byGameName2 = playerMapper.findByGameName2(gameName);
        if (byGameName2!=null){
            return byGameName2;
        }
        return null;
    }
    //新增关注数
    @Override
    public Integer saveAttention(Integer uid,Integer apid ) {
        //新增的对象确定在库中有无
//        Integer pid = attention.getPid();
//        Integer uid = attention.getUid();
        Attention up = playerMapper.findUp(uid, apid);
        if (up==null){
            Attention attention=new Attention();
            attention.setUid(uid);
            attention.setApid(apid);
            attention.setAStatus(1);
            Integer integer = playerMapper.saveAttention(attention);
            return integer;
        }
//        System.err.println(up.getAStatus());
        //    调运修改方法
        up.setAStatus(1);

        Integer update = playerMapper.update(up);
//        System.err.println(update);
//        update.setAStatus(1);
        return update;
    }
    //取消关注
    @Override
    public Integer update(Integer uid, Integer apid) {
        //先查询出对应得数据--进行修改
        Attention up = playerMapper.findUp(uid, apid);
        if (up!=null){
            up.setAStatus(0);
            Integer update = playerMapper.update(up);
            return update;
        }
        return null;
    }
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public List<Attention> findByApidAndUid(Integer apid, Integer pid) {
        List<Attention> byApidAndUid = playerRepository.findByApidAndUid(apid, pid);
        if(byApidAndUid!=null){
            return byApidAndUid;
        }
        return null;
    }

    //陪玩被关注的总数量(pid,aStatus)
    @Override
    public int findNum(Integer apid, Integer aStatus) {
        Integer num = playerMapper.findNum(apid, aStatus);
        if (num!=null){
            return num;
        }
        return 0;
    }

    /*@Override
    public AccpalyerDetail3 findById(Integer pid) {
        AccpalyerDetail3 byId = playerMapper.findById(pid);
        if (byId!=null){
            return byId;
        }
        return null;
    }

    @Override
    public ImagesDetail findByPidToImages(Integer pid) {
        ImagesDetail byPidToImages = playerMapper.findByPidToImages(pid);
        if (byPidToImages!=null){
            return byPidToImages;
        }
        return null;
    }*/

    //陪玩有无被用户关注
    @Override
    public Attention findUp(Integer apid, Integer uid) {
        Attention up = playerMapper.findUp(apid, uid);
        if (up!=null){
            return up;
        }
        return null;
    }
}
