package binbinlau.plane.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author LiuBin
 * @Date 2019/6/28 17:50
 **/
@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class StandaloneConfigurationProperties {

    String host; // 主机名
    int port; // 端口号
    String password; // 密码
    String database; // 选择数据库
    int timeout; // 超时时间
}
