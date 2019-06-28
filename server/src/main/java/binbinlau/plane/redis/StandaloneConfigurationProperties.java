package binbinlau.plane.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author LiuBin
 * @Date 2019/6/28 17:50
 **/
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class StandaloneConfigurationProperties {

    String host; // 主机名
    int port; // 端口号
    String password; // 密码
    String database; // 选择数据库

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

}
