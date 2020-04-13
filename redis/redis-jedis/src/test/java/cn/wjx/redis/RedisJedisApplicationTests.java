package cn.wjx.redis;

import cn.wjx.redis.entity.User;
import cn.wjx.redis.service.UserService;
import cn.wjx.redis.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class RedisJedisApplicationTests {

	@Autowired
	private JedisPool jedisPool;

	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {
		System.out.println(jedisPool);
	}

	@Test
	void t1(){
		String name = userService.getString("name");
		System.out.println(name);
	}

	@Test
	void t2(){
		User user = userService.getUserInfo("0001");
		System.out.println(user);
	}

}
