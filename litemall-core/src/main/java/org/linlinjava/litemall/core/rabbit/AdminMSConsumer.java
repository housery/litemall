package org.linlinjava.litemall.core.rabbit;

import org.linlinjava.litemall.db.domain.ShortMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 管理员消息消费者
 *
 * @author: xiaohoo
 * @date: 2018/12/19 15:53
 * @email: 1126457667@qq.com
 */
@Component
@RabbitListener(queues = "adminMSQueue")
public class AdminMSConsumer {
    private ShortMessage shortMessage;
    Logger logger = LoggerFactory.getLogger(AdminMSConsumer.class);

    @RabbitHandler
    public void process(ShortMessage shortMessage){
        logger.info("消息消费者 consumer:" + shortMessage.getTitle());
        this.shortMessage = shortMessage;
    }

    public ShortMessage getShortMessage(){
        return shortMessage;
    }
}
