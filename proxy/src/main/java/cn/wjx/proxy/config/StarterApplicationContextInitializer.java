package cn.wjx.proxy.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:  用于学习springboot启动流程
 * @author: Mr.Wang
 * @createTime: 2021-11-25 16:13
 **/
public class StarterApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("applicationContext 初始化完成 ... ");
    }
}
