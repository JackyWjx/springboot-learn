package demo.test;

import org.springframework.stereotype.Component;

/**
 * @Description: 测试bean
 * @author: Mr.Wang
 * @createTime: 2021-12-02 11:44
 **/
@Component
public class MyBean {
    public MyBean() {
        System.out.println("我是测试bean！！！");
    }
}
