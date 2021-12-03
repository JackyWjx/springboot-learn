package cn.wjx.springcirculardependency.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @author: Mr.Wang
 * @createTime: 2021-10-27 17:25
 **/
public class DemoTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBean.class);
        MyBean bean = applicationContext.getBean(MyBean.class);
        bean.test();
    }
}
