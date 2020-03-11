package com.demofeng.demo.dao;

import com.demofeng.demo.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    UserInfo select(Integer id);
}
