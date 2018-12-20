package org.linlinjava.litemall.core.rabbit.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.rabbit.AdminMSConsumer;
import org.linlinjava.litemall.core.rabbit.AdminMSProvider;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.ShortMessage;
import org.linlinjava.litemall.db.service.ShortMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author: xiaohoo
 * @date: 2018/12/19 17:37
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/shortMessage")
@Api(tags = "短消息服务")
public class ShortMessageController {
    @Autowired
    private AdminMSConsumer consumer;
    @Autowired
    private AdminMSProvider provider;
    @Autowired
    private ShortMessageService shortMessageService;

    @PostMapping("/admin/createMessage")
    @ApiOperation("消息：管理员创建消息")
    public Object createMessage(ShortMessage shortMessage){
        shortMessage.setCreatedate(LocalDateTime.now());
        provider.send(shortMessage);    // 发送消息
        shortMessageService.add(shortMessage);
        return ResponseUtil.ok();
    }

    @GetMapping("/user/getMessage")
    @ApiOperation("消息(rabbit)：会员获取消息详情")
    public Object receiveMessage(){
        ShortMessage shortMessage = null;
        try {
            shortMessage = consumer.getShortMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.serious();
        }
        return ResponseUtil.ok(shortMessage);
    }

    @GetMapping("/getAllMessageList")
    @ApiOperation("获取所有消息列表")
    public Object getAllMessageList(){
        return ResponseUtil.ok(shortMessageService.getAllShortMessage());
    }

    @GetMapping("/getMessageById")
    @ApiOperation("根据消息id获取消息")
    public Object getMessageById(Integer shortMessageId){
        if (StringUtils.isEmpty(shortMessageId)){
            return ResponseUtil.badArgument();
        }
        ShortMessage shortMessage = shortMessageService.getShortMessage(shortMessageId);
        return ResponseUtil.ok(shortMessage);
    }
}
