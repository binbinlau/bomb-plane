package binbinlau.plane.xo.dao;

import binbinlau.plane.xo.entity.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}