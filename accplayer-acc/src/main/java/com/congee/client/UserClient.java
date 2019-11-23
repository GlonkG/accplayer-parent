package com.congee.client;

import com.congee.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 小米粥
 * @description: com.congee.client
 * @date: 2019/11/20
 * @time: 20:09
 */
@FeignClient(value = "accplayer-user",fallback = UserMessage.class)
public interface UserClient {

    //根据用户id进行原有信息查询
    @GetMapping("/findByUid/{uid}")
    public User findByUid(@PathVariable("uid")Integer uid);

    //修改用户信息
    @PostMapping(value = "/updUser")
    public String updUser(@RequestBody User user);
}
