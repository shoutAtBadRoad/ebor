package com.hu.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hu.mapper.MenuMapper;
import com.hu.mapper.UserMapper;
import com.hu.model.Menu;
import com.hu.model.User;
import com.hu.security.model.LoginUser;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", username));
        if(Objects.isNull(user)) {
            throw new RuntimeException("用戶名或密碼錯誤");
        }

        //TODO 檢查權限信息
        List<String> list = menuMapper.selectPermsByUserId(user.getUserid());
        LoginUser loginUser = new LoginUser(user, list);
        // 把數據封裝成userDetails返回
        return loginUser;
    }
}
