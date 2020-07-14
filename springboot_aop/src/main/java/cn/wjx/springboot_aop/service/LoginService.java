package cn.wjx.springboot_aop.service;

/**
 * @author wjx
 * @date 2020/7/8 16:44
 * @description:
 */
public interface LoginService {
    /**
     * 虚假的登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);
}
