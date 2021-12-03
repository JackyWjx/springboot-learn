package cn.wjx.springcirculardependency;

import cn.wjx.springcirculardependency.bean.AService;
import cn.wjx.springcirculardependency.bean.BService;
import cn.wjx.springcirculardependency.config.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCircularDependencyApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        applicationContext.getBean(AService.class);
    }

}
