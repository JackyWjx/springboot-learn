package cn.wjx.redislettuce.service.impl;


import cn.wjx.redislettuce.entity.User;
import cn.wjx.redislettuce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.OBJ_ADAPTER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Resource(name = "redisTemplate")
    ValueOperations<String, String> opsForValue;

    @Resource(name = "redisTemplate")
    HashOperations<String, String, User> hashOperations;



    @Override
    public String getString(String key) {
        if(redisTemplate.hasKey(key)){
            log.info("redis...");
            return opsForValue.get(key);
            //return (String) redisTemplate.opsForValue().get(key);
        }else {
            log.info("mysql...");
            String val = "我是这么说的";
            opsForValue.set(key,val);
            //redisTemplate.opsForValue().set(key,val);
            return val;
        }
    }

    @Override
    public void exprieStr(String key,String value) {
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,2, TimeUnit.HOURS);
        log.info("存入数据已设置有效期");
    }

    @Override
    public User getUserInfo(String id) {
        if(hashOperations.hasKey("user",id)){
            log.info("redis...");
            //Object user = redisTemplate.opsForHash().get("user", id);
            Object user = hashOperations.get("user", id);
            return (User) user;
        }else {
            log.info("mysql...");
            User u =new User(id,"tony",0,19);
            //redisTemplate.opsForHash().put("user",id,u);
            hashOperations.put("user",id,u);
            return  u;
        }
    }
}
