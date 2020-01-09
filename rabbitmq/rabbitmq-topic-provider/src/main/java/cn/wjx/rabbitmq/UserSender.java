package cn.wjx.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class UserSender {
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
        this.amqpTemplate.convertAndSend(exChange,"user.log.debug","user.log.debug"+msg);
        this.amqpTemplate.convertAndSend(exChange,"user.log.info","user.log.info"+msg);
        this.amqpTemplate.convertAndSend(exChange,"user.log.warn","user.log.warn"+msg);
        this.amqpTemplate.convertAndSend(exChange,"user.log.error","user.log.error"+msg);
    }
}
