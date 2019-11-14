package com.congee;

import com.aliyuncs.exceptions.ClientException;
import com.congee.utils.TelUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/14
 * @time: 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTel {



    @Test
    public void test1(){
        try {
            TelUtils.telUtil("17809163801");
            System.out.println("已调用");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
