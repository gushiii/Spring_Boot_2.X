package com.springboot.chapter7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.controller
 * @className : RedisLuaController
 * @description : TODO
 * @date : 2022/11/21 21:14
 */
@Controller
@RequestMapping("lua")
public class RedisLuaController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/lua1")
    @ResponseBody
    public Map<String, Object> testLua () {
        DefaultRedisScript<String> rs = new DefaultRedisScript<>();
        rs.setScriptText("return 'Hello Redis'");
        rs.setResultType(String.class);
        RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();
        String str = (String) redisTemplate.execute(
                rs, stringRedisSerializer, stringRedisSerializer, null
        );
        Map<String, Object> map = new HashMap<>();
        map.put("str", str);
        return map;
    }

    public Map<String, Object> testLua2 (String key1, String key2, String value1, String value2) {
        String lua = "redis.call('set', KEYS[1], ARGV[1]) \n"
                + "redis.call('set', KEYS[2], ARGV[2]) \n"
                + "local str1 = redis.call('get', KEYS[1]) \n"
                + "local str2 = redis.call('get', KEYS[2]) \n"
                + "if str1 == str2 then \n"
                + "return 1 \n"
                + "end \n"
                + "return 0";
        System.out.println(lua);
        DefaultRedisScript<Long> rs = new DefaultRedisScript<>();
        rs.setScriptText(lua);
        rs.setResultType(Long.class);
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();

        List<String> keyList = new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);

        Long result = (Long) redisTemplate.execute(rs, stringSerializer, stringSerializer, keyList, value1, value2);

        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        return map;
    }

}
