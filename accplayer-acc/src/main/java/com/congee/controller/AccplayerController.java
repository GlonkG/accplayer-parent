package com.congee.controller;

import com.congee.domain.Accplayer;
import com.congee.service.AccplayerService;
import com.congee.utils.Result;
import com.congee.utils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public Accplayer checkAccplayer(@PathVariable("apid")Integer apid){
        Accplayer accplayer = accplayerService.findByApid(apid);
        accplayer.setAAudit(1);//审核通过更改为1
        accplayerService.updAccplayer(accplayer);
        //return "check success";
        return accplayer;
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

    //陪玩申请入驻服务
    @RequestMapping("/addAccplayer")
    public String addAccplayer(@RequestBody Accplayer accplayer){
        log.info("要申请的陪玩信息为============="+accplayer.toString());
        if(accplayer!=null){
            accplayer.setAAudit(-1);
            accplayerService.addAccplayer(accplayer);
            return "addAccplayer success";
        }
        return "addAccplayer failure";
    }
}
