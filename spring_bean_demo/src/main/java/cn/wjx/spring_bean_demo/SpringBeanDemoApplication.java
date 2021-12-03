package cn.wjx.spring_bean_demo;

import cn.wjx.spring_bean_demo.util.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBeanDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBeanDemoApplication.class, args);
        TestBean bean =(TestBean) run.getBean("testBean");
        bean.sayHello();

    }

}
