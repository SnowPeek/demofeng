package com.demofeng.demo.controller;

import com.demofeng.demo.entity.UserInfo;
import com.demofeng.demo.service.UserInfoService;
import com.demofeng.demo.util.RespJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping("/selectUser")
    public RespJson selectUser(@RequestParam Integer id){

        return RespJson.buildSuccessResponse(userInfoService.select(id));
    }

}
