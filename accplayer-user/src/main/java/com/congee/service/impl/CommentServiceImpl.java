package com.congee.service.impl;

import com.congee.dao.CommentRepository;
import com.congee.domain.Comment;
import com.congee.domain.User;
import com.congee.service.CommentService;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: 小米粥
 * @description: com.congee.service.impl
 * @date: 2019/11/11
 * @time: 16:25
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Result showComment(Integer page, Integer size) {
        Result<Comment> result = new Result<>();
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Comment> all = commentRepository.findAll(pageable);
        result.setCode(200);
        result.setList(all.getContent());
        result.setMessage("评价成功");
        return result;
    }

    @Override
    public Result findCommentByApid(Integer apid) {
        Result<Comment> result = new Result<>();
        List<Comment> comments = commentRepository.findByApid(apid);
        result.setCode(200);
        result.setList(comments);
        result.setMessage("评价成功");
        return result;
    }
}
