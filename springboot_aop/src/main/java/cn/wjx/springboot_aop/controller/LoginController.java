package cn.wjx.springboot_aop.controller;

import cn.wjx.springboot_aop.service.HelloService;
import cn.wjx.springboot_aop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjx
 * @date 2020/7/8 16:17
 * @description:
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(String username,String password){
        throw new RuntimeException();
//        return loginService.login(username,password);
    }
}
