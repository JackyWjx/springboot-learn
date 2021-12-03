package cn.wjx.spring_bean_demo.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-7-1 16:20
 */
public class WinCondition implements Condition {
    /**
     * @param context 判断条件可以使用的上下文（环境）
     * @param metadata 注解信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //能获取到IOC容器正在使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取当前环境变量（包括操作系统的类型）
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if(property.contains("Windows")) return true;
        return false;
    }
}
