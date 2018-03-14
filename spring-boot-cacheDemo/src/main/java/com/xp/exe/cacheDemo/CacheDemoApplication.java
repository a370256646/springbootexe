package com.xp.exe.cacheDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


//开启缓存
//默认采用ConcurrentMapCacheManager作为缓存管理器,但因为项目中已经配置好了redis
//spring boot的自动配置特性和允许逐步取代特性帮我们自动配置了redis作为底层缓存实现
@SpringBootApplication
@EnableCaching
public class CacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheDemoApplication.class, args);
	}
}
