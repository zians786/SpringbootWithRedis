package com.techprimers.cache.springredisexample;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class OTPValidateImp {
	
	private RedisTemplate<String, String> redisTemplate;
	
	private ValueOperations valueOperations;
	
public OTPValidateImp(RedisTemplate<String, String> redisTemplate) {
	this.redisTemplate=redisTemplate;
	valueOperations=redisTemplate.opsForValue();
}
	
	
	
	public String getValue(String id) {
		Random random=new Random();
		String value=String.valueOf(random.nextInt(100000));
		valueOperations.set(id, value);	
		return value;
	}
	
	public Boolean validate(String id,String value) {
		if(value.equals(valueOperations.get(id))) {
				return true;
		}else {
			return false;
		}
	}

}
