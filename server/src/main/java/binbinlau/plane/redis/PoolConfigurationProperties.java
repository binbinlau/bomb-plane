package binbinlau.plane.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  连接池配置
 * @Author LiuBin
 * @Date 2019/7/3  17:27
 * @Param
 * @return
 **/
@Component
@ConfigurationProperties(prefix = "spring.redis.pool")
@Data
public class PoolConfigurationProperties {

    int maxActive; // 连接池最大连接数（使用负值表示没有限制）
    int maxWait; // 连接池最大阻塞等待时间（使用负值表示没有限制）
    int maxIdle; // 连接池中的最大空闲连接
    int minIdle; // 连接池中的最小空闲连接
    int timeout; // 超时时间
    int shutdownTimeout; // 关闭超时时间
}
