package com.congee.dao;

import com.congee.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/19
 * @time: 10:35
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    //测试根据陪玩ID查询评论
    public List<Comment> findByApid(Integer apid);
}
