package org.linlinjava.litemall.core.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xiaohoo
 * @date: 2018/12/19 15:45
 * @email: 1126457667@qq.com
 */
@Configuration
public class RabbitConfigruation {

    @Bean
    public Queue adminMessageQueue(){
        return new Queue("adminMSQueue");
    }
}
