package binbinlau.plane.mybatis;

import binbinlau.plane.xo.dao.MessageMapper;
import binbinlau.plane.xo.entity.Message;
import binbinlau.plane.xo.entity.MessageExample;
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
 * @Date 2019/7/5 15:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MariadbTest {
    Logger logger = LoggerFactory.getLogger(MariadbTest.class);

    @Autowired
    MessageMapper messageMapper;

    @Test
    public void testGet() {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria();
        long count = messageMapper.countByExample(messageExample);
        logger.info("message's count is : " + count);
    }

    @Test
    public void testInsert() {
        Message message = new Message();
        logger.info("uid : " + UUID.randomUUID().toString().replace("-", ""));
        message.setUid(UUID.randomUUID().toString().replace("-", ""));
        message.setContent("222222222222222222222222222222222");
        message.setFromuseruid("uid11111111111111111111111111111");
        message.setFromusername("mingming");
        message.setStatus(true);
        messageMapper.insert(message);
        logger.info("message's count is : " + messageMapper.countByExample(new MessageExample()));
    }

}
