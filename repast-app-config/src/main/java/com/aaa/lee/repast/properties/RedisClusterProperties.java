package com.aaa.lee.repast.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/9 20:45
 * @Description
 **/
@Component
@PropertySource("classpath:properties/redis_cluster.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisClusterProperties {

    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;

}
