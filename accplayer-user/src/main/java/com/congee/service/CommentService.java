package com.congee.service;

import com.congee.domain.Comment;
import com.congee.utils.Result;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.service
 * @date: 2019/11/11
 * @time: 16:24
 */
public interface CommentService {
    //后台管理用户评价
    public Result showComment(Integer page, Integer size);

    //根据陪玩id匹配用户评价展示
    public Result findCommentByApid(Integer apid);
}
