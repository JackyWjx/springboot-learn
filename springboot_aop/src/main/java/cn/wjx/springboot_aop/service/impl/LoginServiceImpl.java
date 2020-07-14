package cn.wjx.springboot_aop.service.impl;

import cn.wjx.springboot_aop.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author wjx
 * @date 2020/7/8 16:45
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(String username, String password) {
        return "登录成功";
    }
}
