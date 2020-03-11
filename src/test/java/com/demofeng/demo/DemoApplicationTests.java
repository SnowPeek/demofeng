package com.demofeng.demo;

import com.demofeng.demo.dao.UserInfoMapper;
import com.demofeng.demo.entity.UserInfo;
import com.demofeng.demo.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void contextLoads() {
		UserInfo userInfo = userInfoService.select(1);
	}

}
