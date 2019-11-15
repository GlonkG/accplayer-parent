package com.congee.service;

import com.congee.domain.User;
import com.congee.utils.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.service
 * @date: 2019/11/11
 * @time: 13:40
 */
public interface UserService {
    //用户新增==注册

    //根据用户id进行用户删除
    public void delUser(Integer uid);
    //用户修改
    //1.根据用户id进行原有信息查询
    public User findByUid(Integer uid);
    //2.修改用户信息
    public void updUser(User user);

    //后台管理分页查询展示全部用户
    public Result findUserByPage(Integer page,Integer size);

    //测试简单注册
    public void addUser(User user);

    //批量删除用户
    public boolean deleteUsers(String[] uid);

    //根据手机号查询对象
    public User findByUserTel(String userTel);

    //根据用户名查询用户--by wgb
    public List<User> findByUserNickname(String username);

}
