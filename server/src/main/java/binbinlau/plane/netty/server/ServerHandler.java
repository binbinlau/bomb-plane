package binbinlau.plane.netty.server;

import binbinlau.plane.netty.protocol.Packet;
import binbinlau.plane.netty.protocol.PacketCodeC;
import binbinlau.plane.netty.protocol.request.LoginRequestPacket;
import binbinlau.plane.netty.protocol.response.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 *  ServerHandler
 * @Author LiuBin
 * @Date 2019/5/17  18:48
 * @Param
 * @return
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter {
    protected final static Log logger = LogFactory.getLog(NettyServer.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info(new Date() + ": 客户端开始登录……");
        ByteBuf requestByteBuf = (ByteBuf) msg;
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
            // 登录响应
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
