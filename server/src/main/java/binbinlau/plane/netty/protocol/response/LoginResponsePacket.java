package binbinlau.plane.netty.protocol.response;

import binbinlau.plane.netty.protocol.Packet;
import lombok.Data;

import static binbinlau.plane.netty.protocol.command.Command.LOGIN_RESPONSE;

@Data
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
