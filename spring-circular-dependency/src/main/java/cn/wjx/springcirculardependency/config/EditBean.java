package cn.wjx.springcirculardependency.config;

import cn.wjx.springcirculardependency.bean.AService;
import cn.wjx.springcirculardependency.bean.BService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.reflect.GenericDeclaration;

/**
 * @Description:
 * @author: Mr.Wang
 * @createTime: 2021-10-22 17:29
 **/
//@Component
public class EditBean implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition bService = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("BService");
        bService.setBeanClass(AService.class);
    }
}
