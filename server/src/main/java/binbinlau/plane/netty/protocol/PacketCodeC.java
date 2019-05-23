package binbinlau.plane.netty.protocol;

import binbinlau.plane.netty.protocol.request.LoginRequestPacket;
import binbinlau.plane.netty.protocol.response.LoginResponsePacket;
import binbinlau.plane.netty.serialize.Serializer;
import binbinlau.plane.netty.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static binbinlau.plane.netty.protocol.command.Command.LOGIN_REQUEST;
import static binbinlau.plane.netty.protocol.command.Command.LOGIN_RESPONSE;

public class PacketCodeC {

    Logger logger = LoggerFactory.getLogger(PacketCodeC.class);
    private final static int MAGIC_NUMBER = 0x12345678; //魔数，在被协议中该数字不变，用来区别自定义协议类型
    public final static PacketCodeC INSTANCE = new PacketCodeC();//此处可以修改为单例模式
    private final Map<Byte, Class<? extends Packet>> packetTypeMap;//协议类型
    private final Map<Byte, Serializer> serializerMap;

    private PacketCodeC() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put((byte)0, Packet.class);
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlogrithm(), serializer);
    }

    /**
     *  编码
     * @Author LiuBin
     * @Date 2019/5/20  19:38
     * @Param [byteBufAllocator, packet]
     * @return io.netty.buffer.ByteBuf
     **/
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, Packet packet) {
        ByteBuf byteBuf = byteBufAllocator.ioBuffer(); // 1. 创建 ByteBuf 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet); // 2. 序列化 java 对象
        byteBuf.writeInt(MAGIC_NUMBER); // 3. 实际编码过程
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlogrithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    /**
     *  解码
     * @Author LiuBin
     * @Date 2019/5/20  19:38
     * @Param [byteBuf]
     * @return binbinlau.plane.netty.protocol.Packet
     **/
    public Packet decode(ByteBuf byteBuf) {
        byteBuf.skipBytes(4); // 跳过 magic number
        byteBuf.skipBytes(1); // 跳过版本号
        byte serializeAlgorithm = byteBuf.readByte(); // 序列化算法
        byte command = byteBuf.readByte(); // 指令
        int length = byteBuf.readInt(); // 数据包长度
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);
        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }
        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }
}
