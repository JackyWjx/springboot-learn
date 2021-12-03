package cn.wjx.springbean_test.controller;

import cn.wjx.springbean_test.bean.HelloBean;
import com.sun.jndi.ldap.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;
    @Resource(name = "getHelloBean")
    private HelloBean helloBean;

    @GetMapping("/aaa")
    public String getHello(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> strings = Arrays.asList(beanDefinitionNames);
        System.out.println(strings.parallelStream().collect(Collectors.joining(",")));
        return helloBean.getSex();
    }

    @GetMapping("/b")
    public String aaa(){
        BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition("getHelloBean");
        beanDefinition.setBeanClassName(HelloBean.class.getName());
        defaultListableBeanFactory.registerBeanDefinition("getHelloBean", beanDefinition);
        return true+"";
    }
}
