package cn.wjx.springcirculardependency.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: A
 * @author: Mr.Wang
 * @createTime: 2021-10-22 15:52
 **/
//@Component
public class AService {
    @Autowired
    private BService bService;

    public AService() {
        System.out.println("AService");
    }

    public void getAService(){
        System.out.println("调用A服务");
    }
}
