package cn.wjx.redislettuce;

import cn.wjx.redislettuce.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisLettuceApplicationTests {

	@Autowired
	private UserServiceImpl userService;

	@Test
	void contextLoads() {
		System.out.println(userService.getString("01010101"));
	}

	@Test
	void t1(){
		userService.exprieStr("jack","存入数据并为他设置有效期为2h");
	}

	@Test
	void t2(){
		System.out.println(userService.getUserInfo("111"));
	}

}
