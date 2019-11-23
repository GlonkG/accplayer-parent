package com.congee.controller;

import com.congee.service.AttentionService;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attention")
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

    @RequestMapping("/findByUidAndApid/{uid}/{apid}")
    public Result findByUidAndApid(@PathVariable("uid")Integer uid,@PathVariable("apid")Integer apid){
        int i = attentionService.countByUidAndApid(uid, apid);
        Result result = new Result();
        result.setTotal((long)i);
        return result;
    }
}
