package com.congee.controller;


import com.congee.dao.ImagesRepository;
import com.congee.domain.Comment;
import com.congee.domain.Images;
import com.congee.utils.Result;
import com.congee.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/18
 * @time: 23:14
 */
@RestController
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    private UploadUtils uploadUtils;

    //上传相册管理
    @RequestMapping(value = "/uploadImages",method = RequestMethod.POST)
    public String uploadImages(MultipartFile file){
        String upload = uploadUtils.upload(file);
        return upload;
    }

    @Autowired
    private ImagesRepository imagesRepository;

    //测试陪玩新增相册入库
    @RequestMapping("/save")
    public String saveImages(@RequestBody Images images){
        Images save = imagesRepository.save(images);
        if(save!=null){
            return "save success";
        }
        return "save failure";
    }

    //测试根据陪玩ID--apid查询详情图片
    @RequestMapping("/findImagesByApid/{apid}")
    public Result findImagesByApid(@PathVariable("apid")Integer apid){
        List<Images> byApid = imagesRepository.findByApid(apid);
        Result result = new Result();
        if(byApid!=null){
            result.setCode(200);
            result.setMessage("查询相册成功");
            result.setList(byApid);
            result.setTotal(byApid.size());
            return result;
        }
        result.setCode(404);
        result.setMessage("查询评论失败");
        result.setList(new ArrayList());
        result.setTotal(new ArrayList().size());
        return result;
    }


}
