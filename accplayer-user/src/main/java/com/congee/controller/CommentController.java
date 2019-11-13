package com.congee.controller;

import com.congee.service.CommentService;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/11
 * @time: 16:27
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //后台管理用户评价
    @RequestMapping("/manage/{page}/{size}")
    public Result manage(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Result result = commentService.showComment(page, size);
        return result;
    }
    //根据陪玩id匹配用户评价展示
    @RequestMapping("/show/{apid}")
    public Result show(@PathVariable("apid")Integer apid){
        Result comment = commentService.findCommentByApid(apid);
        return comment;
    }


}
