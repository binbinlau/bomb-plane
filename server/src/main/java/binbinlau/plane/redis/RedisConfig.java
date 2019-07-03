package binbinlau.plane.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @Author LiuBin
 * @Date 2019/5/24 14:25
 **/
@Configuration
public class RedisConfig {

    Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    @Autowired
    ClusterConfigurationProperties clusterProperties;
    @Autowired
    PoolConfigurationProperties poolConfigurationProperties;
//    @Autowired
//    StandaloneConfigurationProperties standaloneConfigurationProperties;

//    @Bean
    public LettucePoolingClientConfiguration getLettucPoolConfig() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(poolConfigurationProperties.getMaxActive());
        config.setMaxWaitMillis(poolConfigurationProperties.getMaxWait());
        config.setMaxIdle(poolConfigurationProperties.getMaxIdle());
        config.setMinIdle(poolConfigurationProperties.getMinIdle());
        LettucePoolingClientConfiguration lettucePool = LettucePoolingClientConfiguration.builder()
                .poolConfig(config)
                .commandTimeout(Duration.ofMillis(poolConfigurationProperties.getTimeout()))
                .shutdownTimeout(Duration.ofMillis(poolConfigurationProperties.getShutdownTimeout()))
                .build();
        return lettucePool;
    }

//    @Bean
//    public JedisPoolConfig getJedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(poolConfigurationProperties.getMaxActive());
//        jedisPoolConfig.setMaxWaitMillis(poolConfigurationProperties.getMaxWait());
//        jedisPoolConfig.setMaxIdle(poolConfigurationProperties.getMaxIdle());
//        jedisPoolConfig.setMinIdle(poolConfigurationProperties.getMinIdle());
//        return jedisPoolConfig;
//    }

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(standaloneConfigurationProperties.getHost(),
//                standaloneConfigurationProperties.getPort());
////        return new JedisConnectionFactory(redisStandaloneConfiguration); // 使用 jedis
//        return new LettuceConnectionFactory(redisStandaloneConfiguration); // 使用 lettuce
//    }

    @Bean
    public RedisConnectionFactory connectionFactory() {
        logger.info(clusterProperties.getNodes().toString());
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(clusterProperties.getNodes());
        redisClusterConfiguration.setMaxRedirects(clusterProperties.getMaxRedirects());
//        return new JedisConnectionFactory(redisClusterConfiguration, getJedisPoolConfig()); // 使用 jedis
        return new LettuceConnectionFactory(redisClusterConfiguration, getLettucPoolConfig()); // 使用 lettuce
    }

    /**
     * 配置序列化方式
     *
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String , java.lang.Object>
     * @Author LiuBin
     * @Date 2019/5/28  18:06
     * @Param [factory]
     **/
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer); // key采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer); // hash的key也采用String的序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer); // value序列化方式采用jackson2JsonRedisSerializer
        template.setHashValueSerializer(jackson2JsonRedisSerializer); // hash的value序列化方式采用jackson2JsonRedisSerializer
        //template.setEnableTransactionSupport(true);//是否启用事务
        template.afterPropertiesSet();
        return template;
    }
}