package binbinlau.plane.netty.client;

import binbinlau.plane.netty.protocol.PacketCodeC;
import binbinlau.plane.netty.protocol.request.LoginRequestPacket;
import binbinlau.plane.netty.protocol.response.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.Date;

/**
 *  FirstClientHandler
 * @Author LiuBin
 * @Date 2019/5/17  18:44
 * @Param
 * @return
 **/
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(FirstClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info(new Date() + ": 客户端写出数据");
//        ByteBuf buffer = getByteBuf(ctx); // 1.获取数据
        ByteBuf buffer = PacketCodeC.INSTANCE.encode(ctx.alloc(), getLoginRequestPacket());
        ctx.channel().writeAndFlush(buffer); // 2.写数据
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "hello !".getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        return buffer;
    }

    /**
     *  获得登陆命令数据
     * @Author LiuBin
     * @Date 2019/5/23  20:11
     * @Param [ctx]
     * @return binbinlau.plane.netty.protocol.request.LoginRequestPacket
     **/
    private LoginRequestPacket getLoginRequestPacket() {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUsername("binbin");
        loginRequestPacket.setUserId("binbin");
        loginRequestPacket.setPassword("binbinpwd");
        return loginRequestPacket;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        LoginResponsePacket responsePacket = (LoginResponsePacket) PacketCodeC.INSTANCE.decode(byteBuf);
        logger.info(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
        logger.info(new Date() + " : 客户端读取到response返回值为 -> " + responsePacket.toString());
    }
}
