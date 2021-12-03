package cn.wjx.proxy.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description: 自定义条件构造
 * @author: Mr.Wang
 * @createTime: 2021-12-03 15:53
 **/
public class MyCondition implements Condition {

    /**
     * 监测程序中是否存在MyFactoryBean
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            Class<?> aClass = Class.forName("cn.wjx.proxy.config.MyFactoryBean");
            if(aClass!=null){
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
