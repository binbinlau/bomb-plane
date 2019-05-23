package binbinlau.plane.netty;

import binbinlau.plane.netty.server.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 启动spring容器之后启动该应用
 * @Author LiuBin
 * @Date 2019/5/21  16:31
 * @Param
 * @return
 **/
@Component
@Order(value = 2)
public class NettyStartRunner implements CommandLineRunner {

    protected final static Logger logger = LoggerFactory.getLogger(NettyServer.class);
    @Value("${netty.port}")
    private int port;
    @Autowired
    private NettyServer nettyServer;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("开始启动netty服务！");
        nettyServer.run(port);
    }
}
