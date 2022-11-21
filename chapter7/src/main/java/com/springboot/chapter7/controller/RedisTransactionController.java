package com.springboot.chapter7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.controller
 * @className : RedisTransactionController
 * @description : TODO
 * @date : 2022/11/21 19:59
 */
@RequestMapping("/redisTransaction")
@Controller
public class RedisTransactionController {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @RequestMapping("/multi")
    @ResponseBody
    public Map<String, Object> testMulti () {

        redisTemplate.opsForValue().set("key1", "value1");

        List list = (List)redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.watch("key1");
                operations.multi();
                operations.opsForValue().set("key2", "value2");
                operations.opsForValue().increment("key1", 1);
                Object value2 = operations.opsForValue().get("key2");
                System.out .println ("命令在队列, 所以 value 为 null [ "+ value2 +" ]");
                operations.opsForValue().set("key3", "value3");
                Object value3 = operations.opsForValue().get("key3");
                System.out .println ("命令在队列, 所以 value 为 null [ "+ value3 +" ]");
                return operations.exec();
            }
        });

        System.out.println(list);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/pipeline")
    @ResponseBody
    public Map<String, Object> testPipeline () {
        Long start = System.currentTimeMillis();
        List list = (List) redisTemplate.executePipelined(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                for (int i = 1; i < 10000; i++) {
                    operations.opsForValue().set("pipeline_" + i, "value_" + i);
                    String value = (String) operations.opsForValue().get("pipeline_" + i);
                    if (i == 10000) {
                        System.out.println("命令只是进入队列, 所以值为空 [ " + value + " ]");
                    }

                }
                return null;
            }
        });
        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "毫秒");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

}
