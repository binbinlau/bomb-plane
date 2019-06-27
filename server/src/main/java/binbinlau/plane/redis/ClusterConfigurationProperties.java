package binbinlau.plane.redis;

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
public class ClusterConfigurationProperties {
    List<String> nodes;

    public List<String> getNodes() {
        return nodes;
    }
    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
