package binbinlau.plane.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void setTest() {
        redisTemplate.opsForValue().set("binbinlau.plane", "is a good project");
    }
}
