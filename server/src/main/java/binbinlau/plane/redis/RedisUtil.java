package binbinlau.plane.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis 基础操作
 * @Author  LiuBin
 * @date  2019/5/28  22:18
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
            redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
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

    /**
     *  删除缓存
     * @Author LiuBin
     * @Date 2019/5/31  17:50
     * @Param [key]
     * @return void
     **/
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     *  普通缓存获取
     * @Author LiuBin
     * @Date 2019/5/31  17:51
     * @Param [key]
     * @return java.lang.Object
     **/
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     *  按照delta递增
     * @Author LiuBin
     * @Date 2019/5/31  17:54
     * @Param [key, delta]
     * @return long
     **/
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     *  按照delta递减
     * @Author LiuBin
     * @Date 2019/5/31  17:55
     * @Param [key, delta]
     * @return long
     **/
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     *  HashGet
     * @Author LiuBin
     * @Date 2019/5/31  17:56
     * @Param [key, item]
     * @return java.lang.Object
     **/
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     *  获取hashKey对应的所有键值
     * @Author LiuBin
     * @Date 2019/5/31  17:56
     * @Param [key]
     * @return java.util.Map<java.lang.Object,java.lang.Object>
     **/
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     *  HashSet
     * @Author LiuBin
     * @Date 2019/5/31  17:58
     * @Param [key, map]
     * @return boolean
     **/
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  HashSet 并设置时间
     * @Author LiuBin
     * @Date 2019/5/31  17:59 
     * @Param [key, map, time]
     * @return boolean
     **/
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  向一张hash表中放入数据,如果不存在将创建
     * @Author LiuBin
     * @Date 2019/5/31  18:00
     * @Param [key, item, value]
     * @return boolean
     **/
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  向一张hash表中放入数据,如果不存在将创建,并设置过期时间
     * @Author LiuBin
     * @Date 2019/5/31  18:03
     * @Param [key, item, value, time]
     * @return boolean
     **/
    public boolean hset(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  删除hash
     * @Author LiuBin
     * @Date 2019/5/31  18:04
     * @Param [key, item]
     * @return void
     **/
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     *  是否有某值
     * @Author LiuBin
     * @Date 2019/5/31  18:04
     * @Param [key, item]
     * @return boolean
     **/
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     *  hash递增 如果不存在,就会创建一个 并把新增后的值返回
     * @Author LiuBin
     * @Date 2019/5/31  18:05 
     * @Param [key, item, by]
     * @return double
     **/
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     *  hash递减，如果该值不存在直接返回0
     * @Author LiuBin
     * @Date 2019/5/31  18:07
     * @Param [key, item, by]
     * @return double
     **/
    public double hdecr(String key, String item, double by) {
        if (hHasKey(key, item)) {
            return redisTemplate.opsForHash().increment(key, item, -by);
        } else {
            return 0;
        }
    }

    /**
     *  根据key获取Set中的所有值
     * @Author LiuBin
     * @Date 2019/5/31  18:08
     * @Param [key]
     * @return java.util.Set<java.lang.Object>
     **/
    public Set<Object> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  根据value从一个set中查询,是否存在
     * @Author LiuBin
     * @Date 2019/5/31  18:09
     * @Param [key, value]
     * @return boolean
     **/
    public boolean sHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  将数据放入set缓存
     * @Author LiuBin
     * @Date 2019/5/31  18:10
     * @Param [key, values]
     * @return long
     **/
    public long sSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  将数据放入set缓存,并添加过期时间
     * @Author LiuBin
     * @Date 2019/5/31  18:12
     * @Param [key, time, values]
     * @return long
     **/
    public long sSet(String key, long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  获取set缓存的长度
     * @Author LiuBin
     * @Date 2019/5/31  18:13 
     * @Param [key]
     * @return long
     **/
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  移除值为value的
     * @Author LiuBin
     * @Date 2019/5/31  18:14
     * @Param [key, values]
     * @return long
     **/
    public long setRemove(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  获取list缓存的内容
     * @Author LiuBin
     * @Date 2019/5/31  18:15
     * @Param [key, start, end]
     * @return java.util.List<java.lang.Object>
     **/
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  获取list缓存的长度
     * @Author LiuBin
     * @Date 2019/5/31  18:16
     * @Param [key]
     * @return long
     **/
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  通过索引 获取list中的值
     * @Author LiuBin
     * @Date 2019/5/31  18:17
     * @Param [key, index]
     * @return java.lang.Object
     **/
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  将值放入list的头
     * @ Author LiuBin
     * @Date 2019/5/31  18:18
     * @Param [key, value]
     * @return boolean
     **/
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  将值放入list的头,并设置过期时间
     * @Author LiuBin
     * @Date 2019/5/31  19:14
     * @Param [key, value, time]
     * @return boolean
     **/
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  将值放入list的尾部
     * @Author LiuBin
     * @Date 2019/5/31  19:12
     * @Param [key, value]
     * @return boolean
     **/
    public boolean rSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  将值放入list的尾部,并设置过期时间
     * @Author LiuBin
     * @Date 2019/5/31  19:14
     * @Param [key, value, time]
     * @return boolean
     **/
    public boolean rSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  修改某个值
     * @Author LiuBin
     * @Date 2019/5/31  19:16
     * @Param [key, index, value]
     * @return boolean
     **/
    public boolean lUpdateIndex(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
