package cn.wjx.proxy.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @Description: 导入外部bean
 * @author: Mr.Wang
 * @createTime: 2021-12-02 11:48
 **/
@Component
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"demo.test.MyBean"};
    }
}
