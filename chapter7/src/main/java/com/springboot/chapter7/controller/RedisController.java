package com.springboot.chapter7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.controller
 * @className : RedisController
 * @description : TODO
 * @date : 2022/11/21 18:30
 */
@RequestMapping("/redis")
@Controller
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash () {
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().set("int_key", "1");

        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int", 1);

        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory()
                                                 .getConnection()
                                                 .getNativeConnection();
        jedis.decr("int");
        Map<String, String> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");

        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1", "field2");
        hashOps.put("field4", "value5");

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> testList () {
        stringRedisTemplate.opsForList().leftPushAll(
                "list1", "v2", "v4", "v6", "v8", "v10"
        );

        stringRedisTemplate.opsForList().rightPushAll(
                "list1", "v1", "v2", "v3", "v4", "v5"
        );

        BoundListOperations<String, String> listOps = stringRedisTemplate.boundListOps("list2");
        Object result1 = listOps.rightPop();
        Object result2 = listOps.index(1);
        listOps.leftPush("v0");
        Long size = listOps.size();
        List elements = listOps.range(0, size - 2);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/set")
    @ResponseBody
    public Map<String, Object> testSet () {
        stringRedisTemplate.opsForSet().add(
                "set1",
                "v1", "v1", "v2", "v3", "v4", "v5"
        );

        stringRedisTemplate.opsForSet().add(
                "set2",
                "v2", "v4", "v6", "v8"
        );

        BoundSetOperations<String, String> setOps = stringRedisTemplate.boundSetOps("set1");
        setOps.add("v6", "v7");
        setOps.remove("v1", "v7");
        Set set1 = setOps.members();
        Long size = setOps.size();
        Set inter = setOps.intersect("set2");
        setOps.intersectAndStore("set2", "inter");
        Set diff = setOps.diff("set2");
        setOps.diffAndStore("set2", "diff");
        Set union = setOps.union("set2");
        setOps.unionAndStore("set2", "union");

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/zset")
    @ResponseBody
    public Map<String, Object> testZset () {

        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            double score = i * 0.1;
            ZSetOperations.TypedTuple<String> typedTuple =
                    new DefaultTypedTuple<String>("value" + 1, score);
            typedTupleSet.add(typedTuple);
        }

        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);


        BoundZSetOperations<String, String> zsetOps = stringRedisTemplate.boundZSetOps("zset1");
        zsetOps.add("value10", 0.26);
        Set<String> setRange = zsetOps.range(1, 6);
        Set<String> setScore = zsetOps.rangeByScore(0.2, 0.6);
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        range.gt("value3");
//        range.gte("value3");
//        range.lt("value8");
        range.lte("value8");
        Set<String> setLex = zsetOps.rangeByLex(range);
        zsetOps.remove("value9", "value2");
        Double score = zsetOps.score("value8");
        Set<ZSetOperations.TypedTuple<String>> rangeSet = zsetOps.rangeWithScores(1, 6);
        Set<ZSetOperations.TypedTuple<String>> scoreSet = zsetOps.rangeByScoreWithScores(1, 6);
        Set<String> reverseSet = zsetOps.reverseRange(2, 8);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

}
