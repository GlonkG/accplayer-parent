package com.congee.controller;

import com.congee.client.UserClient;
import com.congee.domain.Accplayer;
import com.congee.domain.Game;
/*import com.congee.domain.User;*/
import com.congee.service.AccplayerService;
import com.congee.service.GameService;
/*import com.congee.service.MailService;*/
import com.congee.utils.Result;
import com.congee.utils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

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

    @Autowired
    private UserClient userClient;
    /*@Autowired
    private MailService mailService;*/
    //后台专员审核陪玩入驻资质
    @RequestMapping("/checkAccplayer/{apid}")
    public String checkAccplayers(@PathVariable("apid")Integer apid){
        Accplayer accplayer = accplayerService.findByApid(apid);
        accplayer.setAAudit(1);//审核通过更改为1
        accplayer.setUserBecometime(new Date());
        Accplayer accplayer1 = accplayerService.updAccplayer(accplayer);
       /* User user1 = userClient.findByUid(accplayer1.getUid());
        mailService.send(user1);//发送邮件审核成功*/
        //更改用户身份
        /*User user1 = userClient.findByUid(accplayer.getUid());
        if(user1.getUserIdentify()==0){
            user1.setUserStatus(1);//更改为陪玩
        }
        String s = userClient.updUser(user1);*/
        /*if(accplayer1!=null&&"updUser success".equals(s)){
            return "check success";
        }*/
        if(accplayer1!=null){
            return "check success";
        }
        return "check failure";
    }

    //后台专员审核陪玩入驻资质：不通过，驳回
    @RequestMapping("/dismissalAccplayer/{apid}")
    public String dismissalAccplayer(@PathVariable("apid")Integer apid){
        Accplayer accplayer = accplayerService.findByApid(apid);
        accplayer.setAAudit(0);//审核不通过更改为0
        Accplayer accplayer1 = accplayerService.updAccplayer(accplayer);
        if(accplayer1!=null){
            return "dismissalAccplayer success";
        }
        return "dismissalAccplayer failure";
    }

    //测试后台专员审核陪玩入驻资质
    @RequestMapping("/check/{apid}")
    public Accplayer checkAccplayer(@PathVariable("apid")Integer apid){
        Accplayer accplayer = accplayerService.findByApid(apid);
        accplayer.setAAudit(0);//审核通过更改为0
        Accplayer accplayer1 = accplayerService.updAccplayer(accplayer);
        //return "check success";
        return accplayer1;
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

    //后台删除陪玩信息
    @RequestMapping("/delAccplayer/{apid}")
    public String delAccplayer(@PathVariable("apid")Integer apid){
        accplayerService.delAccplayer(apid);
        return "delAccplayer success";
    }

    //后台修改陪玩信息
    @RequestMapping("/findAccplayerByApid/{apid}")
    public Accplayer findAccplayerByApid(@PathVariable("apid")Integer apid){
        Accplayer byApid = accplayerService.findByApid(apid);
        return byApid;
    }

    @RequestMapping("/updAccplayer")
    public String updAccplayer(@RequestBody Accplayer accplayer){
        accplayerService.updAccplayer(accplayer);
        return "updAccplayer success";
    }

    //根据板块名称查询陪玩--by yhf
    @RequestMapping("/searchByGName/{gamename}")
    public List<Accplayer> searchByGName(@PathVariable("gamename") String gName){
        List<Accplayer> byGName = accplayerService.findByGName(gName);
        return byGName;
    }

    //批量删除陪玩
    @RequestMapping(value = "/deleteAccplayers")
    public String deleteAccplayers(@RequestBody String[] apid){
        log.info("前端传输的数组为==============="+apid.toString());
        boolean b = accplayerService.deleteAccplayers(apid);
        if(b){
            return "deleteAccplayers success";
        }
        return "deleteAccplayers failure";
    }

    @Autowired
    private UploadUtils uploadUtils;
    //陪玩上传认证资料图
    @RequestMapping(value = "/loadingAccplayerPic",method = RequestMethod.POST)
    public String uploadAccplayerPic(MultipartFile file){
        String upload = uploadUtils.upload(file);
        return upload;
    }

    @Autowired
    private GameService gameService;
    //陪玩申请入驻服务
    @RequestMapping("/addAccplayer")
    public String addAccplayer(@RequestBody Accplayer accplayer){
        log.info("要申请的陪玩信息为============="+accplayer.toString());
        List<Game> byGName = gameService.findByGName(accplayer.getGName());
        log.info("================="+byGName.get(0).getGid());
        accplayer.setGid(byGName.get(0).getGid());
        if(accplayer!=null){
            accplayer.setAAudit(-1);//审核中
            accplayerService.addAccplayer(accplayer);
            return "addAccplayer success";
        }
        return "addAccplayer failure";
    }

    //根据游戏类型查找陪玩小姐姐--by sml
    @RequestMapping(value = "/findAccplayerBygName/{gName}")
    public  List<Accplayer> findAccplayerBygName(@PathVariable("gName")String gName){
        List<Accplayer> accpclayerByGames = accplayerService.findAccplayerBygName(gName);
        System.out.println(accpclayerByGames);
        return accpclayerByGames;
    }
    //根据游戏类型和陪玩性别查找小姐姐
    @RequestMapping(value = "/findAccplayerBySexAndgName/{gName}/{usergender}")
    public  List<Accplayer> findAccplayerBySexAndGame(@PathVariable("gName")String gName,@PathVariable("usergender")String usergender){
        List<Accplayer> accplayers = accplayerService.findAccplayerBygNameAndUserGender(gName, usergender);
        System.out.println(accplayers);
        return accplayers;
    }
    //根据性别查找陪玩
    @RequestMapping(value = "/findAccplayerByUserGender/{Gender}")
    public List<Accplayer> findAccplayerByUserGender(@PathVariable("Gender")String usergender){
        List<Accplayer> accplayerList=accplayerService.findAccplayerByUserGender(usergender);
        return accplayerList;
    }
    //根据陪玩昵称和id查询
    @RequestMapping(value = "/search/{gname}/{apid}")
    public List<Accplayer> search(@PathVariable("gname")String gname,@PathVariable("apid")Integer apid){
        List<Accplayer> accplayerByGNameContainingAndApid = accplayerService.findAccplayerByGNameContainingAndApid(gname,apid);
        System.out.println(accplayerByGNameContainingAndApid);
        return accplayerByGNameContainingAndApid;
    }
    @RequestMapping("/findAccplayerByuserNickname")
    public  List<Accplayer> findAccplayerByuserNickname(@RequestParam("userNickname")String userNicknamer){
        List<Accplayer> accplayerByuserNicknamer = accplayerService.findAccplayerByuserNicknamer(userNicknamer);
        if(accplayerByuserNicknamer!=null){
            return accplayerByuserNicknamer;
        }
        return null;

    }
    //最新入驻
    @RequestMapping("/findUserBecometime")
    public List<Accplayer> findUserBecometiem(){
        List<Accplayer> userBecometiem = accplayerService.findUserBecometime();
        return userBecometiem;
    }

    //最新入驻
    @RequestMapping("/findUserPrice")
    public List<Accplayer> findUserPrice(){
        List<Accplayer> userBecometiem = accplayerService.findUserPrice();
        return userBecometiem;
    }
    //测试详情
    @RequestMapping("/findByApids/{apid}")
    public List<Accplayer> findByApids(@PathVariable("apid")Integer apid){
        List<Accplayer> byApids = accplayerService.findByApids(apid);
        return byApids;
    }

    //根据关注数量查询进行排序（人气榜）
    @RequestMapping("/findAccplayerByAnum")
    public List<Accplayer> findAccplayerByAnum(){
        List<Accplayer> accplayerByAnum = accplayerService.findANum();
        return accplayerByAnum;
    }

    //测试根据用户ID查询
    @RequestMapping("/findByUid/{uid}")
    public Accplayer findByUid(@PathVariable("uid")Integer uid){
        Accplayer accplayer = accplayerService.findByUid(uid);
        return accplayer;
    }

    //八元专区
    @RequestMapping("/searchEight")
    public  List<Accplayer> findAccplayerByGpricr(){
        List<Accplayer> accplayerByGprice = accplayerService.findAccplayerByGPrice(8d);
        return  accplayerByGprice;

    }






}
