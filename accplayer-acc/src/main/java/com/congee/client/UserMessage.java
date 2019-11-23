package com.congee.client;

import com.congee.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author: 小米粥
 * @description: com.congee.client
 * @date: 2019/11/20
 * @time: 20:11
 */
@Component
public class UserMessage implements UserClient {
    @Override
    public User findByUid(Integer uid) {
        return new User();
    }

    @Override
    public String updUser(User user) {
        return "对陪玩服务进行降级";
    }
}
