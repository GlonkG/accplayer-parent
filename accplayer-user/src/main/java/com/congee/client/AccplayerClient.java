package com.congee.client;


import com.congee.domain.Accplayer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: 小米粥
 * @description: com.congee.client
 * @date: 2019/11/16
 * @time: 0:24
 */
@FeignClient(name = "accplayer-acc",fallback = AccplayerClientMessage.class)
public interface AccplayerClient {
    //后台专员审核陪玩入驻资质
    @GetMapping("/check/{apid}")
    public Accplayer checkAccplayer(@PathVariable("apid")Integer apid);
}
