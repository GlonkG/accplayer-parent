package com.congee.service.impl;

import com.alibaba.fastjson.JSON;
import com.congee.dao.UserRepository;
import com.congee.domain.User;
import com.congee.service.UserService;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import java.util.List;
import java.util.Optional;

/**
 * @author: 小米粥
 * @description: com.congee.service.impl
 * @date: 2019/11/11
 * @time: 13:52
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void delUser(Integer uid) {
        userRepository.deleteById(uid);
    }

    @Override
    public User findByUid(Integer uid) {
        Optional<User> byId = userRepository.findById(uid);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public void updUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public Result findUserByPage(Integer page, Integer size) {
        Result<User> result = new Result<>();
        Pageable pageable = PageRequest.of(page-1,size);
        Page<User> all = userRepository.findAll(pageable);
        result.setCode(200);
        result.setList(all.getContent());
        result.setMessage("查询成功");
        result.setTotal(all.getTotalElements());
        return result;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * 批量删除用户
     * @param uid
     */
    @Override
    public boolean deleteUsers(String[] uid) {
        int count = 0;
        for (String uid1 : uid) {
            Integer id = Integer.valueOf(uid1);
            userRepository.deleteById(id);
            count ++;
        }
        if(count==uid.length){
            return true;
        }
        return false;
    }

    @Override
    public User findByUserTel(String userTel) {
        return userRepository.findByUserTel(userTel);
    }

    @Override
    public List<User> findByUserNickname(String username) {
        List<User> byUserNickname = userRepository.findByUserNickname(username);
        return byUserNickname;
    }

}
