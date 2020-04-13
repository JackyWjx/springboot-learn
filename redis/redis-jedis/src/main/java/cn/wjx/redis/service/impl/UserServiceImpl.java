package cn.wjx.redis.service.impl;

import cn.wjx.redis.entity.User;
import cn.wjx.redis.service.UserService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.awt.image.Kernel;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JedisPool jedisPool;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    //根据用户输入查询key所对应的值
    @Override
    public String getString(String key) {
        String val = null;
        //得到jedis对象
        Jedis jedis = jedisPool.getResource();
        //检查数据库中是否存在
        if(jedis.exists(key)){
            //查询redis中的数据
            logger.info("redis查询...");
            val=jedis.get(key);
        }else {
            //查询数据库...
            logger.info("数据库查询");
            val="我是谁";
            //将查到的值放到redis
            jedis.set("name",val);
        }
        jedis.close();
        return val;
    }

    @Override
    public User getUserInfo(String id) {
        String key =  "user:"+id;
        User user = new User();
        Jedis jedis = jedisPool.getResource();
        if(jedis.exists(key)){
            Map<String, String> u = jedis.hgetAll(key);
            logger.info("查询redis-------->");
            user.setId(u.get("id"));
            user.setName(u.get("name"));
            user.setSex(Integer.valueOf(u.get("sex")));
            user.setAge(Integer.valueOf(u.get("age")));
        }else {
            logger.info("数据库查询------->");
            user.setId(id);
            user.setName("刘德华");
            user.setAge(12);
            user.setSex(0);
            //存入
            Map<String,String> map = new HashMap<>();
            map.put("id",user.getId());
            map.put("name",user.getName());
            map.put("age",user.getAge()+"");
            map.put("sex",String.valueOf(user.getSex()));
            jedis.hmset(key,map);
            logger.info("存入到redis-------->");
        }
        jedis.close();
        return user;
    }
}
