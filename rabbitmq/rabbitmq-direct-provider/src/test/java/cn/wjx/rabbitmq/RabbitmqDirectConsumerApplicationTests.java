package cn.wjx.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDirectConsumerApplicationTests {

    @Autowired
    private Sender sender;
    @Test
    void contextLoads() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            sender.sendQueue("我能说啥呢");
        }
    }

}
