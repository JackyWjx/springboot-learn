package cn.wjx.proxy.config;

import demo.test.MyBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: 导入bean
 * @author: Mr.Wang
 * @createTime: 2021-12-02 13:44
 **/
public class MyFactoryBean implements FactoryBean<MyBean> {

    @Override
    public MyBean getObject() throws Exception {
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }
}
