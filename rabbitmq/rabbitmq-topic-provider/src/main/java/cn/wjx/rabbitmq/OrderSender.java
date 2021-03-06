package cn.wjx.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class OrderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exChange;

    /**
     * 发送消息的方法
     * @param msg
     */
    public void sendQueue(String msg){
        //3个参数：1.交换器名称2.路由键3.消息
        System.out.println(msg+"消息发送了");
        this.amqpTemplate.convertAndSend(exChange,"order.log.debug","order.log.debug"+msg);
        this.amqpTemplate.convertAndSend(exChange,"order.log.info","order.log.info"+msg);
        this.amqpTemplate.convertAndSend(exChange,"order.log.warn","order.log.warn"+msg);
        this.amqpTemplate.convertAndSend(exChange,"order.log.error","order.log.error"+msg);
    }
}
