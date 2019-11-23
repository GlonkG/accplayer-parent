package com.congee.controller;

import com.congee.dao.CommentRepository;
import com.congee.domain.Comment;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/19
 * @time: 10:37
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    //测试根据陪玩ID查询评论
    @RequestMapping("/findCommentByApid/{apid}")
    public Result findCommentByApid(@PathVariable("apid")Integer apid){
        List<Comment> byApid = commentRepository.findByApid(apid);
        Result result = new Result();
        if(byApid!=null){
            result.setCode(200);
            result.setMessage("查询评论成功");
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
