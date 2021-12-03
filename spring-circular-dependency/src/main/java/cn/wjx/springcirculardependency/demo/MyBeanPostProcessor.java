package cn.wjx.springcirculardependency.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Description:
 * @author: Mr.Wang
 * @createTime: 2021-10-27 17:28
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        for (Field field : aClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Wjx.class)) {
                Wjx annotation = field.getAnnotation(Wjx.class);
                String value = annotation.value();
                field.setAccessible(true);
                try {
                    field.set(bean,value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
