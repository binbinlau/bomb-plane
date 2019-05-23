package binbinlau.plane.netty.server;

import binbinlau.plane.netty.protocol.Packet;
import binbinlau.plane.netty.protocol.PacketCodeC;
import binbinlau.plane.netty.protocol.request.LoginRequestPacket;
import binbinlau.plane.netty.protocol.response.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 *  ServerHandler
 * @Author LiuBin
 * @Date 2019/5/17  18:48
 * @Param
 * @return
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter {
    protected final static Logger logger = LoggerFactory.getLogger(NettyServer.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info(new Date() + "   欢迎连接到我们的netty服务器!!!!!!!");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        logger.info("msg is : " + requestByteBuf.toString());
        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);
        if (packet instanceof LoginRequestPacket) {
            // 登录流程
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)) {
                loginResponsePacket.setSuccess(true);
                logger.info(new Date() + ": 登录成功!");
            } else {
                loginResponsePacket.setReason("账号密码校验失败");
                loginResponsePacket.setSuccess(false);
                logger.info(new Date() + ": 登录失败!");
            }
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    /**
     *  验证密码
     * @Author LiuBin
     * @Date 2019/5/23  20:22
     * @Param [loginRequestPacket]
     * @return boolean
     **/
    private boolean valid(LoginRequestPacket loginRequestPacket) {
        logger.info("服务器端收到的request为： " + loginRequestPacket.toString()); // TODO 此处验证密码，应该从redis数据库中查询得到验证
        return true;
    }

    /**
     *  将 bytebuf 转换为字符串
     * @Author LiuBin
     * @Date 2019/5/21  18:20
     * @Param [byteBuf]
     * @return java.lang.String
     **/
    private String getMessage(ByteBuf byteBuf) {
        byte[] con = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(con);
        try {
            return new String(con, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
