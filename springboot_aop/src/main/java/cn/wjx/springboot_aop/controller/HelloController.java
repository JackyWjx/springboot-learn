package cn.wjx.springboot_aop.controller;

import cn.wjx.springboot_aop.annotation.Token;
import cn.wjx.springboot_aop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjx
 * @date 2020/7/8 16:17
 * @description:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Token
    @RequestMapping("/hello")
    public String hello(String token){
        return helloService.hello(token);
    }
}
