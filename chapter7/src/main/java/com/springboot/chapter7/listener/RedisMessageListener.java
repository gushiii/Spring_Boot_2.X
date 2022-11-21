package com.springboot.chapter7.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.listener
 * @className : RedisMessageListenner
 * @description : TODO
 * @date : 2022/11/21 20:54
 */
@Component
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String body = new String(message.getBody());
        String topic = new String(pattern);
        System.out.println(body);
        System.out.println(topic);
    }
}
