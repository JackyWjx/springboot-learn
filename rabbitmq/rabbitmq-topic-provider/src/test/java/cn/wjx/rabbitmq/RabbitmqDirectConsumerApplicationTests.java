package cn.wjx.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDirectConsumerApplicationTests {

    @Autowired
    private UserSender userSender;
    @Autowired
    private OrderSender orderSender;
    @Autowired
    private ProductSender productSender;
    @Test
    void contextLoads() throws InterruptedException {

        userSender.sendQueue("用户：我能说啥呢");
        orderSender.sendQueue("订单：我能说啥呢");
        productSender.sendQueue("商品：我能说啥呢");

    }

}
