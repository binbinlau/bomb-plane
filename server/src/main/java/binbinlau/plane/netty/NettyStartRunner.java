package binbinlau.plane.netty;

import binbinlau.plane.netty.server.NettyServer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author LiuBin
 * @Date 2019/5/17 16:35
 **/
@Component
@Order(value = 2)
public class NettyStartRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());
    public static int PORT = 8888;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        logger.debug("开始启动netty服务！");
        System.out.println("开始启动netty项目");
        NettyServer.run(PORT);
    }
}
