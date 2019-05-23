package binbinlau.plane.protocol;

import binbinlau.plane.netty.protocol.PacketCodeC;
import binbinlau.plane.netty.protocol.request.LoginRequestPacket;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author LiuBin
 * @Date 2019/5/20 19:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacketTest {

    Logger logger = LoggerFactory.getLogger(PacketTest.class);

    @Test
    @Ignore
    public void testSerializerPacket() {
        ByteBufAllocator byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId("1");
        loginRequestPacket.setPassword("1111");
        loginRequestPacket.setUsername("binbin");
        LoginRequestPacket loginRequestPacket1 = (LoginRequestPacket) PacketCodeC.INSTANCE.decode(PacketCodeC.INSTANCE.encode(byteBufAllocator, loginRequestPacket));
        logger.info(loginRequestPacket1.toString());
    }
}
