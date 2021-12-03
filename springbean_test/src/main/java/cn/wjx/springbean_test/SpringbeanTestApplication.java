package cn.wjx.springbean_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbeanTestApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(SpringbeanTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> strings = Arrays.asList(beanDefinitionNames);
        System.out.println(strings.parallelStream().collect(Collectors.joining(",")));
        System.out.println(environment.getProperty("spring.application.name"));
    }
}
