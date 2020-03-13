package com.aaa.lee.repast.config;

import com.aaa.lee.repast.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/9 20:47
 * @Description
 **/
@Configuration
public class RdisClusterConfig {

    @Autowired
    private RedisClusterProperties redisProperties;

    @Bean
    public JedisCluster getJedisCluster() {
        String nodes = redisProperties.getNodes();
        String[] split = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        for(String hostPort : split) {
            String[] split1 = hostPort.split(":");
            HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.parseInt(split1[1]));
            hostAndPortSet.add(hostAndPort);
        }
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, redisProperties.getCommandTimeout(), redisProperties.getMaxAttempts());
        return jedisCluster;
    }

}
