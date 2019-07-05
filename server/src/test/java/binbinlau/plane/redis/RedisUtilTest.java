package binbinlau.plane.redis;

import binbinlau.plane.constkey.BaseConstKey;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        redisUtil.setValue(BaseConstKey.REDISKEY, "springboot-20190703");
        logger.info("valueStr : " + (String) redisUtil.getValue(BaseConstKey.REDISKEY));
    }

    @Test
    public void getTest() {
        String valueStr = (String) redisUtil.getValue(BaseConstKey.REDISKEY);
        logger.info("valueStr : " + valueStr);
    }

    @Test
    public void expireTest() {
        redisUtil.expire(BaseConstKey.REDISKEY, 10);
        long time = redisUtil.getExpire(BaseConstKey.REDISKEY);
        logger.info(String.valueOf(time));
    }

    @Test
    public void hasKeyTest() {
        boolean flag = redisUtil.hasKey(BaseConstKey.REDISKEY);
        logger.info(String.valueOf(flag));
    }

    @Test
    public void delKeyTest() {
        redisUtil.del(BaseConstKey.REDISKEY);
        Assert.assertTrue(!redisUtil.hasKey(BaseConstKey.REDISKEY));
    }
}