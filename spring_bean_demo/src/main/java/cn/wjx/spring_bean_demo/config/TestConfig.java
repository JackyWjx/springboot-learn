package cn.wjx.spring_bean_demo.config;

import cn.wjx.spring_bean_demo.util.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-01-06 14:12
 */
@Configuration
public class TestConfig {
    public TestConfig(){
        System.out.println("spring容器启动初始化。。。");
    }

    @Bean
    //@Bean注解注册bean,同时可以指定初始化和销毁方法
    @Scope("prototype")
    //@Bean(name="testNean",initMethod="start",destroyMethod="cleanUp")
    //默认是单例模式，即scope="singleton"。另外scope还有prototype、request、session、global session作用域。scope="prototype"多例
    //每次获取Bean的时候会有一个新的实例
    public TestBean testBean() {
        return new TestBean();
    }
}
