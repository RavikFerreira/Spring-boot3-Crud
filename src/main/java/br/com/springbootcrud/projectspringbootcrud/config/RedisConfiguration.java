package br.com.springbootcrud.projectspringbootcrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisConfiguration {
    
    @Autowired
    private RedisProperties properties;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        var config = new RedisStandaloneConfiguration();
        config.setPassword(properties.getPassword());
        config.setHostName(properties.getHost());
        config.setPort(properties.getPort());
        return new JedisConnectionFactory();
    }
    
    @Bean
    public RedisTemplate<String, String> redisTemplate(){
        var template = new RedisTemplate<String, String>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }


}
