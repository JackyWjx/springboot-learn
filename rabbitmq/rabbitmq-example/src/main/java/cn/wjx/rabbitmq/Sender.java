package cn.wjx.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息的方法
     * @param msg
     */
    public void sendQueue(String msg){
        //两个参数：1.队列名称2.消息
        this.amqpTemplate.convertAndSend("hello-queue",msg);
    }
}
