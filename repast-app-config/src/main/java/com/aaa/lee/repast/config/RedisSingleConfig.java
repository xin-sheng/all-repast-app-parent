package com.aaa.lee.repast.config;

import com.aaa.lee.repast.properties.RedisSingleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/13 11:00
 * @Description
 **/
@Configuration
public class RedisSingleConfig {

    @Autowired
    private RedisSingleProperties redisSingleProperties;

    @Bean
    public Jedis getJedis() {
        String[] hostAndPort = redisSingleProperties.getNode().split(":");
        return new Jedis(hostAndPort[0], Integer.parseInt(hostAndPort[1]), redisSingleProperties.getCommandTimeout(), false);
    }
}
