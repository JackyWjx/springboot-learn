package cn.wjx.springbean_test.config;

import cn.wjx.springbean_test.bean.HelloBean;
import cn.wjx.springbean_test.registrar.CustomizedBeanRegistrar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration

@EnableConfigurationProperties(HelloBean.class)
public class ApplicationConfig {

    @Bean
    public HelloBean getHelloBean(HelloBean helloBean){
      log.info("姓名：{},性别：{},年龄：{}",helloBean.getName(),helloBean.getSex(),helloBean.getAge());
      return new HelloBean(helloBean.getName(),helloBean.getSex(),helloBean.getAge());
    }
}
