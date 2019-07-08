package binbinlau.plane.base.handle.xo.base.handle;

import binbinlau.plane.base.handle.xo.base.util.StringUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义枚举 handle
 * @Author  LiuBin
 * @date  2019/7/6  15:38
 * @params
 * @return
 **/
public class BaseEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
    private Class<E> type;

    public BaseEnumTypeHandler() {}

    public BaseEnumTypeHandler(Class<E> type) {
        this.type = type;
    }
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            preparedStatement.setString(i, e.toString());
        } else {
            preparedStatement.setObject(i, e.name(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return get(resultSet.getString(s));
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return get(resultSet.getString(i));
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return get(callableStatement.getString(i));
    }

    private <E extends Enum<E>> E get(String v) {
        if (v == null) return null;
        if (StringUtil.isNumeric(v)) {
            return (E) get(type, Integer.parseInt(v));
        } else {
            return (E) Enum.valueOf(type, v);
        }
    }

    private <E extends Enum<E>> E get(Class<E> type, int v) {
        Method method = null;
        E result = null;
        try {
            method = type.getMethod("get", int.class);
            result = (E) method.invoke(type, v);
        } catch (NoSuchMethodException e) {
            result = Enum.valueOf(type, String.valueOf(v));
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
