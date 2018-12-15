package com.tango.redis.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private RedisStoreService redisStoreService;

	@Test
	public void testRedisStore(){
		redisStoreService.setValue("a","apple");
	}

	@Test
	public void testRedis2(){
		redisStoreService.setHashMap("FRUIT");
	}

	@Test
	public void testRedis3(){
		redisStoreService.deleteHashMap("FRUIT");
	}

	@Test
	public void testRedis4(){
		redisStoreService.scan();
	}

}

