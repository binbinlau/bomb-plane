package binbinlau.plane.util;

/**
 * @Author LiuBin
 * @Date 2019/5/17 17:34
 **/
public class StringUtil {

    /**
     *  判断该对象是否是数字
     * @Author LiuBin
     * @Date 2019/5/17  17:36
     * @Param [obj]
     * @return boolean
     **/
    public static boolean isNumber(Object obj) {
        if (obj instanceof Number) {
            return true;
        } else if (obj instanceof String){
            try {
                Double.parseDouble((String)obj);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     *  判断对象是否为整数
     * @Author LiuBin
     * @Date 2019/5/17  18:00
     * @Param [obj]
     * @return boolean
     **/
    public static boolean isInteger (Object obj) {
        if (obj instanceof Number) {
            if (((Number) obj).doubleValue() % 1 == 0) {
                return true;
            }
        } else if (obj instanceof String) {
            double objDouble;
            try {
                objDouble = Double.parseDouble((String) obj);
            } catch (Exception e) {
                return false;
            }
            if (objDouble % 1 == 0) {
                return true;
            }
        }
        return false;
    }
}
