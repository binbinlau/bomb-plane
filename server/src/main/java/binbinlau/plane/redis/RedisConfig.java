package binbinlau.plane.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author LiuBin
 * @Date 2019/5/24 14:25
 **/
@Configuration
public class RedisConfig {

    Logger logger = LoggerFactory.getLogger(RedisConfig.class);

//    @Autowired
//    ClusterConfigurationProperties clusterProperties;
//
//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        logger.info(clusterProperties.getNodes().toString());
//        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterProperties.getNodes()));
//    }
    @Autowired
    StandaloneConfigurationProperties standaloneConfigurationProperties;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(standaloneConfigurationProperties.getHost(), standaloneConfigurationProperties.getPort());
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
        template.afterPropertiesSet();
        return template;
    }
}