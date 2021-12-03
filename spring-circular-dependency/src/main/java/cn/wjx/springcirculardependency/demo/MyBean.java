package cn.wjx.springcirculardependency.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: Mr.Wang
 * @createTime: 2021-10-27 17:24
 **/
@Component
@ComponentScan("cn.wjx")
public class MyBean {
    @Wjx("王吉祥")
    private String name;

    public void test(){
        System.out.println(name);
    }
}
