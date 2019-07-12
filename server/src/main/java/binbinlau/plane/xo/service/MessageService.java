package binbinlau.plane.xo.service;

import binbinlau.plane.xo.entity.Message;

/**
 *  MessageService
 * @Author LiuBin
 * @Date 2019/7/12  15:19
 * @Param
 * @return
 **/
public interface MessageService {

    /**
     *  根据uid查找
     * @Author LiuBin
     * @Date 2019/7/12  15:28
     * @Param [uid]
     * @return binbinlau.plane.xo.entity.Message
     **/
    public Message get(String uid);

    /**
     *  更新对象
     * @Author LiuBin
     * @Date 2019/7/12  15:28
     * @Param [message]
     * @return boolean
     **/
    public boolean update(Message message);

    /**
     *  插入记录
     * @Author LiuBin
     * @Date 2019/7/12  15:28
     * @Param [message]
     * @return boolean
     **/
    public boolean insert(Message message);

    /**
     *  删除记录
     * @Author LiuBin
     * @Date 2019/7/12  15:49
     * @Param [uid]
     * @return boolean
     **/
    public boolean delete(String uid);
}
