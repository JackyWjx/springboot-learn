package cn.wjx.proxy.dao.impl;

import cn.wjx.proxy.dao.UserDao;

/**
 * @Description: 用户操作实现
 * @author: Mr.Wang
 * @createTime: 2021-11-24 16:10
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存用户");
    }
}
