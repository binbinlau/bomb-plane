package binbinlau.plane.netty.protocol.request;

import binbinlau.plane.netty.protocol.Packet;
import lombok.Data;

import static binbinlau.plane.netty.protocol.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private String userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
