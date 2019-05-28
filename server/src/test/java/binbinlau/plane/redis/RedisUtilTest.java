package binbinlau.plane.redis;

import binbinlau.plane.constkey.BaseConstKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * redis测试类
 * @Author LiuBin
 * @Date 2019/5/24  14:18
 * @Param
 * @return
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

    Logger logger = LoggerFactory.getLogger(RedisUtilTest.class);
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void setTest() {
        logger.info("start install one record!");
//        redisTemplate.opsForValue().set("binbinlau.plane", "is a good project1");
        redisUtil.setValue(BaseConstKey.REDISKEY, "springboot");
    }

    @Test
    public void getTest() {
        String valueStr = (String) redisUtil.getValue(BaseConstKey.REDISKEY);
        logger.info("valueStr : " + valueStr);
    }

    @Test
    public void expireTest() {
        redisUtil.expire(BaseConstKey.REDISKEY, 1000);
        long time = redisUtil.getExpire(BaseConstKey.REDISKEY);
        logger.info(String.valueOf(time));
    }

    @Test
    public void hasKeyTest() {
        boolean flag = redisUtil.hasKey(BaseConstKey.REDISKEY);
        logger.info(String.valueOf(flag));
    }
}
