package com.springboot.chapter7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.Duration;

@SpringBootApplication
@MapperScan(basePackages = "com.springboot.chapter7", annotationClass = Repository.class)
@EnableCaching
public class Chapter7Application {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private RedisConnectionFactory connectionFactory = null;

    @Autowired
    private MessageListener redisMessageListener = null;

    private ThreadPoolTaskScheduler taskScheduler = null;

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler () {
        if (taskScheduler != null) {
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer () {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(initTaskScheduler());
        Topic topic = new ChannelTopic("topic1");
        container.addMessageListener(redisMessageListener, topic);
        return container;
    }

    @Bean(name = "redisCacheManager")
    public RedisCacheManager initRedisCacheManager () {
        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer())
        );

        configuration = configuration.disableKeyPrefix();
        configuration = configuration.entryTtl(Duration.ofMillis(10));
        RedisCacheManager redisCacheManager = new RedisCacheManager(writer, configuration);
        return redisCacheManager;
    }

    @PostConstruct
    public void init () {
        initRedisTemplate();
    }

    private void initRedisTemplate () {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter7Application.class, args);
    }

}
