package binbinlau.plane.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  redis集群配置
 * @Author LiuBin
 * @Date 2019/6/27  18:21
 * @Param
 * @return
 **/
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
@Data
public class ClusterConfigurationProperties {

    List<String> nodes; // 集群主机列表
    int maxRedirects; // 集群主机数量
}
