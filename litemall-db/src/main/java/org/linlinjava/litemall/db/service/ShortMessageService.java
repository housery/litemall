package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.ShortMessageMapper;
import org.linlinjava.litemall.db.domain.ShortMessage;
import org.linlinjava.litemall.db.domain.ShortMessageExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/19 18:36
 * @email: 1126457667@qq.com
 */
@Service
public class ShortMessageService {
    @Resource
    private ShortMessageMapper messageMapper;

    public int add(ShortMessage shortMessage){
        return messageMapper.insertSelective(shortMessage);
    }

    public int delete(Integer id){
        return messageMapper.deleteByPrimaryKey(id);
    }

    public ShortMessage getShortMessage(Integer id){
        return messageMapper.selectByPrimaryKey(id);
    }

    public List<ShortMessage> getAllShortMessage(){
        ShortMessageExample example = new ShortMessageExample();
        return messageMapper.selectByExample(example);
    }
}
