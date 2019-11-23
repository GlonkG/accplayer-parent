package com.congee;

import com.congee.dao.AccplayerRepository;
import com.congee.dao.ImagesRepository;
import com.congee.domain.Accplayer;
import com.congee.domain.Game;
import com.congee.domain.Images;
import com.congee.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/16
 * @time: 16:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAcc {
    @Autowired
    private AccplayerRepository accplayerRepository;

    @Test
    public void test1(){
        //测试最新入驻--首页
        Sort apid = new Sort(Sort.Direction.DESC, "userBecometime");
        List<Accplayer> all = accplayerRepository.findAll(apid);
        for (Accplayer accplayer : all) {
            System.out.println(accplayer+"===================");
        }
    }

    @Autowired
    private ImagesRepository imagesRepository;
    @Test
    public void test2(){
        List<Images> byApid = imagesRepository.findByApid(11);
        for (Images images : byApid) {
            System.out.println(images);
        }
    }

    @Autowired
    private GameService gameService;

    @Test
    public void test3(){
        List<Game> byGName = gameService.findByGName("王者荣耀");
        for (Game game : byGName) {
            System.out.println(game);
        }

    }
}
