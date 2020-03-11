package com.demofeng.demo.service.impl;

import com.demofeng.demo.biz.UserInfoBiz;
import com.demofeng.demo.entity.UserInfo;
import com.demofeng.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoBiz userInfoBiz;
    @Override
    public UserInfo select(Integer id) {
        return userInfoBiz.selectUser(id);
    }
}
