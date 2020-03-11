package com.demofeng.demo.entity;

import lombok.Data;

@Data
public class UserInfo {
    private Integer id ;
    private String name ;
    private String password;
    private Integer sex ;
    private Integer age ;
    private String phone;
    private String address ;
}
