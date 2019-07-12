package binbinlau.plane.xo.serviceimpl;

import binbinlau.plane.xo.dao.MessageMapper;
import binbinlau.plane.xo.entity.Message;
import binbinlau.plane.xo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author LiuBin
 * @Date 2019/7/12 15:29
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    @Cacheable("messageInfo")
    public Message get(String uid) {
        return messageMapper.selectByPrimaryKey(uid);
    }

    @Override
    @CachePut(value = "messageInfo", key = "#message.uid")
    public boolean update(Message message) {
        return messageMapper.updateByPrimaryKeySelective(message) > 0;
    }

    @Override
    @CachePut(value = "messageInfo", key = "#message.uid")
    public boolean insert(Message message) {
        return messageMapper.insertSelective(message) > 0;
    }

    @Override
    @CacheEvict(value = "messageInfo", beforeInvocation = true)
    public boolean delete(String uid) {
        return messageMapper.deleteByPrimaryKey(uid) > 0;
    }
}
