package org.linlinjava.litemall.core.rabbit;

import org.linlinjava.litemall.db.domain.ShortMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MS 消息简称
 * 管理员消息生产者
 *
 * @author: xiaohoo
 * @date: 2018/12/19 15:48
 * @email: 1126457667@qq.com
 */
@Component
public class AdminMSProvider {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(ShortMessage shortMessage){
        amqpTemplate.convertAndSend("adminMSQueue",shortMessage);
    }
}
