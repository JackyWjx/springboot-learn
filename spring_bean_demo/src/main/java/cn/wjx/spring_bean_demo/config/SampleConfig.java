package cn.wjx.spring_bean_demo.config;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-7-1 16:09
 */

import cn.wjx.spring_bean_demo.entity.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value="cn.wjx.spring_bean_demo",includeFilters = {
        //包含的类型，可以是注解，class,正则,自定义,等等
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},
//注意这个属性要改false（是否使用默认过滤器）
        useDefaultFilters = true)
public class SampleConfig {
    @Conditional(WinCondition.class)
    @Bean
    public Person person(){
        return new Person();
    }
}
