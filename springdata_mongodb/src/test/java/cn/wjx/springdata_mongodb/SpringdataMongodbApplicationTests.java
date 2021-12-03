package cn.wjx.springdata_mongodb;

import cn.wjx.springdata_mongodb.document.UserDO;
import cn.wjx.springdata_mongodb.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
class SpringdataMongodbApplicationTests {
    @Autowired(required = false)
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        // 创建 UserDO 对象
        UserDO user = new UserDO();
        user.setId(2); // 这里先临时写死一个 ID 编号，后面演示自增 ID 的时候，在修改这块
        user.setUsername("yudaoyuanma");
        user.setPassword("buzhidao");
        user.setCreateTime(LocalDateTime.now());
        // 创建 Profile 对象
        UserDO.Profile profile = new UserDO.Profile();
        profile.setNickname("芋道源码");
        profile.setGender(1);
        user.setProfile(profile);
        // 存储到 DB
        userRepository.insert(user);
    }

    // 这里要注意，如果使用 save 方法来更新的话，必须是全量字段，否则其它字段会被覆盖。
    // 所以，这里仅仅是作为一个示例。
    @Test // 更新一条记录
    public void testUpdate() {
        // 查询用户
        Optional<UserDO> userResult = userRepository.findById(1);
        Assert.isTrue(userResult.isPresent(), "用户一定要存在");
        // 更新
        UserDO updateUser = userResult.get();
        updateUser.setUsername("yutou");
        userRepository.save(updateUser);
    }

    @Test // 根据 ID 编号，删除一条记录
    public void testDelete() {
        userRepository.deleteById(1);
    }

    @Test // 根据 ID 编号，查询一条记录
    public void testSelectById() {
        Optional<UserDO> userDO = userRepository.findById(1);
        System.out.println(userDO.isPresent());
    }
    @Test // 根据 ID 编号数组，查询多条记录
    public void testSelectByIds() {
        Iterable<UserDO> users = userRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }
    @Test // 根据名字获得一条记录
    public void testFindByName() {
        UserDO user = userRepository.findByUsername("yutou");
        System.out.println(user);
    }

    @Test // 使用 username 模糊查询，分页返回结果
    public void testFindByNameLike() {
        // 创建排序条件
        Sort sort = Sort.by(Sort.Direction.DESC, "id"); // ID 倒序
        // 创建分页条件。
        Pageable pageable = PageRequest.of(0, 10, sort);
        // 执行分页操作
        Page<UserDO> page = userRepository.findByUsernameLike("yu", pageable);
        // 打印
        page.get().forEach(System.out::println);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }
}
