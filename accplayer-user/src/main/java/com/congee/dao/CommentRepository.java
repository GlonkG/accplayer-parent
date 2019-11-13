package com.congee.dao;

import com.congee.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/11
 * @time: 16:22
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    //根据陪玩id匹配用户评价展示
    public List<Comment> findByApid(Integer apid);
}
