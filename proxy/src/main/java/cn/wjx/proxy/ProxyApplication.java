package cn.wjx.proxy;

import cn.wjx.proxy.config.MyImportBeanDefinitionRegistrar;
import cn.wjx.proxy.config.MyImportSelector;
import demo.test.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


/**
 *   导入外部bean的方式：
 *      1.@Import
 *      2.@Import+ImportBeanDefinitionRegistrar.class
 *      3.@Import+ImportSelector
 */
@SpringBootApplication
//@Import(value = {MyImportBeanDefinitionRegistrar.class})
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

}
