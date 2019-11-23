package com.congee.controller;

import com.congee.domain.*;
import com.congee.service.AccplayerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private AccplayerDetailService accplayerDetailService;
    //根据陪玩pid查询陪玩的服务技能详情
    /*@RequestMapping("/gnameDetail")
    @ResponseBody
    public List<GameDetail>  findByPid(@RequestParam("pid") Integer pid){
        //Integer pid1=Integer.parseInt(pid);
        List<GameDetail> byPid = accplayerDetailService.findByPid(pid);
        return byPid;
    }*/
    // 根据用户点击陪玩详情图查询player信息
    /*@RequestMapping("/playerDetail")
    @ResponseBody
    public List<AccplayerDetail> findByPic(@RequestParam("pic") String pic) {
        List<AccplayerDetail> byPic = accplayerDetailService.findByPic(pic);
        return byPic;
    }*/
//   根据模块名称(游戏名称查询)（多表）
   /* @RequestMapping("/gname")
    @ResponseBody
    public AccplayerDetail2 findByGameName(@RequestParam("gameName")String gameName){
        AccplayerDetail2 game=accplayerDetailService.findByGameName(gameName);
        return game;
    }*/

    //根据游戏名查询(异步)信息
    @RequestMapping("/gameName/{gName}")
    @ResponseBody
    public Game gameName(@PathVariable("gameName")String gameName){
        Game byGameName1 = accplayerDetailService.findByGameName1(gameName);
        return byGameName1;
    }

    //根据游戏名查询(异步)对应游戏名历史接单数量
    @RequestMapping("/countGname/{gameName}")
    @ResponseBody
    public Order count(@PathVariable("gameName")String gameName){
        Order byGameName2 = accplayerDetailService.findByGameName2(gameName);
            return byGameName2;
    }

    //关注新增
    @RequestMapping("/saveAttention")
    @ResponseBody
    public String saveAttention(@RequestBody Attention attention){
        Integer uid = attention.getUid();
        Integer apid = attention.getApid();
        Integer integer = accplayerDetailService.saveAttention(uid, apid);
        return integer>0?"0":"1";
    }
    //取消关注
    @RequestMapping("/findAttention")
    @ResponseBody
    public String findAttention(@RequestBody Attention attention){
        Integer uid = attention.getUid();
        Integer apid = attention.getApid();
        Integer update = accplayerDetailService.update(uid, apid);
       if(update>0){
           return "0";
       }
       return "1";
    }
    //陪玩被关注的总数量(pid,aStatus)
    @RequestMapping("/findNum")
    @ResponseBody
    public int findNum(@RequestParam("apid")Integer apid,
                             @RequestParam("aStatus")Integer aStatus){
        int num = accplayerDetailService.findNum(apid, aStatus);
        return num;
    }



    //根据pid查询陪玩的个人详情
    /*@RequestMapping("/findPlayer")
    @ResponseBody
    public AccpalyerDetail3 find(@RequestParam("pid")Integer pid){
        AccpalyerDetail3 byId = accplayerDetailService.findById(pid);
        return byId;
    }*/
    //根据pid查询陪玩的个人详情
    /*@RequestMapping("/findImages")
    @ResponseBody
    public ImagesDetail findImages(@RequestParam("pid")Integer pid){
        ImagesDetail byPidToImages = accplayerDetailService.findByPidToImages(pid);
        return byPidToImages;
    }*/

    //陪玩有无被用户关注
    @RequestMapping("/findUp")
    @ResponseBody
    public Integer findUp(@RequestParam("apid")Integer apid,
                          @RequestParam("uid")Integer uid){
        Attention up = accplayerDetailService.findUp(apid, uid);
        if(up!=null) {
            Integer aStatus = up.getAStatus();
            return aStatus;
        }
        return 0;
    }

    //陪玩有无被用户关注
    @RequestMapping("/find")
    @ResponseBody
    public List<Attention> find(@RequestParam("apid")Integer apid,
                          @RequestParam("uid")Integer uid){
        List<Attention> byApidAndUid = accplayerDetailService.findByApidAndUid(apid, uid);
        return byApidAndUid;
    }
}