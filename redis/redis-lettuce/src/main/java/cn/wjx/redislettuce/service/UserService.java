package cn.wjx.redislettuce.service;


import cn.wjx.redislettuce.entity.User;

public interface UserService {

    public String getString(String key);

    public void exprieStr(String key,String value);

    public User getUserInfo(String id);

}
