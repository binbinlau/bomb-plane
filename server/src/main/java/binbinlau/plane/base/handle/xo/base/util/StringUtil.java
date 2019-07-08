package binbinlau.plane.base.handle.xo.base.util;

/**
 * 字符串处理工具类
 * @Author  LiuBin
 * @date  2019/7/6  16:21
 * @params
 * @return
 **/
public class StringUtil {

    /**
     * 判断对象是否为数字
     * @Author  LiuBin
     * @date  2019/7/6  16:21
     * @params [object]
     * @return boolean
     **/
    public static boolean isNumeric(Object object) {
        if (object instanceof Number) {
            return true;
        } else if (object instanceof String){
            try{
                Double.parseDouble((String) object);
                return true;
            }catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
