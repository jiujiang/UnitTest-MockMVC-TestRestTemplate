package com.tango.redis.redis;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class RedisStoreService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setValue(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
        System.out.println("=============================="+stringRedisTemplate.opsForValue().get(key));
    }

    public void setHashMap(String key){
        stringRedisTemplate.opsForHash().put(key,"b","banana");
        stringRedisTemplate.opsForHash().put(key,"c","cabbit");
        stringRedisTemplate.opsForHash().put(key,"cc","cabbit");
        stringRedisTemplate.opsForHash().put(key,"c1","cabbit");
        stringRedisTemplate.opsForHash().put(key,"c2","cabbit");
        stringRedisTemplate.opsForHash().put(key,"l","lemon");
        for (int i = 0; i < 1000; i++) {
            stringRedisTemplate.opsForHash().put(key,"l2"+i,"lemon"+i);
        }
    }

    public void deleteHashMap(String key){
        stringRedisTemplate.opsForHash().delete(key,"b");
    }

    public void scan(){
        long l = System.currentTimeMillis();
        Cursor<Map.Entry<Object, Object>> scan = stringRedisTemplate.opsForHash().scan("FRUIT", ScanOptions.scanOptions().match("l2999").build());
        if(scan.hasNext()){
            Map.Entry<Object, Object> next = scan.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
        long l2=System.currentTimeMillis();
        System.out.println("耗时时间------------------------------"+Long.toString(l2-l));

    }




}
