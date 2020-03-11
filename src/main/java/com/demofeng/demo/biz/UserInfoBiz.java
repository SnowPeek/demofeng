package com.demofeng.demo.biz;

import com.demofeng.demo.dao.UserInfoMapper;
import com.demofeng.demo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoBiz {
    @Autowired
    private UserInfoMapper userInfoMapper ;
    public UserInfo selectUser(Integer id){
        return userInfoMapper.select(id);
    }
}
