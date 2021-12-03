package cn.wjx.spring_bean_demo;

import cn.wjx.spring_bean_demo.config.SampleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringBeanDemoApplicationTests {

    @Test
    void contextLoads() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SampleConfig.class);
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
