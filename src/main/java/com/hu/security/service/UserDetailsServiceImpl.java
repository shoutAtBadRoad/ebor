package com.hu.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hu.mapper.UserMapper;
import com.hu.model.User;
import com.hu.security.model.LoginUser;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if(Objects.isNull(user)) {
            throw new RuntimeException("用戶名或密碼錯誤");
        }
        LoginUser loginUser = new LoginUser(user);
        // 檢查權限信息

        // 把數據封裝成userDetails返回
        return loginUser;
    }
}
