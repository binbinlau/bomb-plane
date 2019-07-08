package binbinlau.plane.mybatis.handle;

import binbinlau.plane.base.handle.xo.base.handle.BaseEnumTypeHandler;
import binbinlau.plane.xo.enums.EStatus;
import org.apache.ibatis.type.MappedTypes;

/**
 * 枚举处理
 * @Author  LiuBin
 * @date  2019/7/6  16:15
 * @params
 * @return
 **/
@MappedTypes(value = {EStatus.class})
public class EnumTypeHandler<E extends Enum<E>> extends BaseEnumTypeHandler<E> {
    public EnumTypeHandler(Class<E> type) {
        super(type);
    }
}
