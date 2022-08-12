package com.hu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hu.mapper.MenuMapper;
import com.hu.mapper.UserMapper;
import com.hu.model.User;
import com.hu.security.model.LoginUser;
import com.hu.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Test
    public void test() {
        System.out.println("test");
    }

    @Test
    public void testPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123"));
        System.out.println(bCryptPasswordEncoder.matches("123", "$2a$10$fjH1yvdw6Z6JxoJ.K7drIOK1WQzWqnUEDQr7vyK6nDiQO5ybTQR26"));
    }

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void jwtTest() {
        JSONObject jsonObject = (JSONObject) redisUtil.get("18");
        LoginUser loginUser = JSON.parseObject(jsonObject.toJSONString(), LoginUser.class);
        System.out.println(loginUser.toString());
    }

    @Test
    public void redisDeleteTest() {
        redisUtil.del("18");
    }

    @Resource
    private UserMapper userMapper;

    @Test
    public void mapperTest() {
        List<User> users = userMapper.selectList(null);
        for(User user : users) {
            System.out.println(user.toString());
        }
    }


    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void selectPermsByUserId() {
        List<String> list = menuMapper.selectPermsByUserId(1L);
        list.forEach(System.out::println);
    }
}
