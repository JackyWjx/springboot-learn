package cn.wjx.proxy.bean;

import cn.wjx.proxy.condition.MyCondition;
import cn.wjx.proxy.dao.UserDao;
import cn.wjx.proxy.dao.impl.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 条件bean
 * @author: Mr.Wang
 * @createTime: 2021-12-03 15:51
 **/
@Configuration
public class ConditionBean {

    @Bean
    @Conditional({MyCondition.class})
    public UserDao userDao(){
        System.out.println("userDao...............");
        return new UserDaoImpl();
    }
}
