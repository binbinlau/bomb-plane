package binbinlau.plane.netty.server;

import binbinlau.plane.util.StringUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NettyServer {
    protected final static Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void run(int port) {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boosGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new ServerHandler()); // 可以添加多个handle
                    }
                });
        if (!StringUtil.isInteger(port)) {
            port = 1000 + (int)(Math.random() * 9000); //设置一个1000-9999的随机端口号
        }
        bind(serverBootstrap, port);
    }

    private void bind(final ServerBootstrap serverBootstrap, final int port) {
            serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                    logger.info(new Date() + ": 端口[" + port + "]绑定成功!");
                } else {
                    logger.info(new Date() + "端口[" + port + "]绑定失败!");
                }
        });
    }
}
