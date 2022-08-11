package com.hu.service;

public interface LoginService {
    String loginReturnToken(String username, String password);

    String logtout();
}
