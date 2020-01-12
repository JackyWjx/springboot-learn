package cn.wjx.redis.service;

import cn.wjx.redis.entity.User;

public interface UserService {

    public String getString(String key);

    public User getUserInfo(String key);


}
