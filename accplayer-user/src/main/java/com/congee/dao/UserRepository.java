package com.congee.dao;

import com.congee.domain.User;
import com.congee.domain.Wanan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/11
 * @time: 13:39
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    //根据手机号查询对象
    public User findByUserTel(String userTel);
    //根据用户名查询用户--by wgb
    public List<User> findByUserNickname(String username);
}
