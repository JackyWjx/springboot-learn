package cn.wjx.springcirculardependency.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: B
 * @author: Mr.Wang
 * @createTime: 2021-10-22 15:52
 **/
@Component
public class BService {

  /*  @Autowired
    private AService aService;
*/
    public BService() {
        System.out.println("BService");
    }
/*
    public void getBService(){
        System.out.println(aService);
    }*/
}
