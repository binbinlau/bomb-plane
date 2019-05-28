package binbinlau.plane.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 *
 * @Author  LiuBin
 * @date  2019/5/28  22:18
 * @params
 * @return
 **/
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     *  指定缓存失效时间
     * @Author  LiuBin
     * @date  2019/5/29  0:25
     * @params [key, time]
     * @return boolean
     **/
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获得缓存失效时间
     * @Author  LiuBin
     * @date  2019/5/29  0:26
     * @params
     * @return
     **/
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     *  判断key值是否存在
     * @Author  LiuBin
     * @date  2019/5/29  0:26
     * @params [key]
     * @return boolean
     **/
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置值
     * @Author  LiuBin
     * @date  2019/5/29  0:48
     * @params [key, value]
     * @return void
     **/
    public void setValue(String key, Object value) {
//        redisTemplate.opsForValue().set(key, value);
        setValue(key, value, 0);
    }

    /**
     * 设置值和有效时间
     * @Author  LiuBin
     * @date  2019/5/29  0:48
     * @params [key, value, expire]
     * @return void
     **/
    public void setValue(String key, Object value, long expire) {
        if (expire == 0) {
            redisTemplate.opsForValue().set(key, value);
        } else {
            redisTemplate.opsForValue().set(key, value, expire);
        }
    }

    /**
     * 根据 key 得到值
     * @Author  LiuBin
     * @date  2019/5/29  0:48
     * @params [key]
     * @return java.lang.Object
     **/
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
