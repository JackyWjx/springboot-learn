package cn.wjx.proxy.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Description: 学习springboot使用
 * @author: Mr.Wang
 * @createTime: 2021-11-25 16:14
 **/
public class StarterApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.toString());
        System.out.println("ApplicationListener .... " + System.currentTimeMillis());
    }
}
