package com.yijiankang.redisdemo;

import com.yijiankang.redisdemo.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisdemoApplicationTests {

    @Autowired
    private RedisUtils redisUtils;
    @Test
    public void contextLoads() {
        redisUtils.set("aa","111");
        List<String> all = redisUtils.getAll();
        for (String key :
                all) {
            System.out.println(key);
        }
    }

}
