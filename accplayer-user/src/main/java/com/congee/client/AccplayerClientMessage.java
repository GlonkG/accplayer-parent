package com.congee.client;

import com.congee.domain.Accplayer;
import org.springframework.stereotype.Component;

/**
 * @author: 小米粥
 * @description: com.congee.client
 * @date: 2019/11/16
 * @time: 0:25
 */
@Component
public class AccplayerClientMessage implements AccplayerClient {
    @Override
    public Accplayer checkAccplayer(Integer apid) {
        return new Accplayer();
    }
}
