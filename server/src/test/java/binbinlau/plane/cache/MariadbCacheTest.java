package binbinlau.plane.cache;

import binbinlau.plane.redis.RedisUtil;
import binbinlau.plane.xo.entity.Message;
import binbinlau.plane.xo.enums.EStatus;
import binbinlau.plane.xo.serviceimpl.MessageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @Author LiuBin
 * @Date 2019/7/12 15:56
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MariadbCacheTest {

    Logger logger = LoggerFactory.getLogger(MariadbCacheTest.class);

    final static String UID = "uid00000000000000000000000000000";

    @Autowired
    MessageServiceImpl messageServiceImpl;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void insertTest() {
        Message message = new Message();
        message.setUid(UUID.randomUUID().toString().replace("-", ""));
        message.setContent("222222222222222222222222222222222");
        message.setFromuseruid("uid11111111111111111111111111111");
        message.setFromusername("mingming");
        message.setStatus(EStatus.init);
        logger.info("message uid is : " + message.getUid());
        messageServiceImpl.insert(message);
    }

    @Test
    public void getTest() {
        Message message = (Message) redisUtil.hget("messageInfo", "messageInfo::uid00000000000000000000000000000");
        if (message != null) {
            logger.info("message uid is : " + message.getUid());
        } else {
            logger.info("message is null");
        }
        Message message1 = messageServiceImpl.get(UID);
        if (message1 != null) {
            logger.info("message1 uid is : " + message1.getUid());
        } else {
            logger.info("message1 is null");
        }
        Message message2 = (Message) redisUtil.hget("messageInfo", "messageInfo::uid00000000000000000000000000000");
        if (message2 != null) {
            logger.info("message2 uid is : " + message2.getUid());
        } else {
            logger.info("message2 is null");
        }
    }
}
