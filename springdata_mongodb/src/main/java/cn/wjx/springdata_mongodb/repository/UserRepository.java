package cn.wjx.springdata_mongodb.repository;

import cn.wjx.springdata_mongodb.document.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDO, Integer> {
    UserDO findByUsername(String userName);

    Page<UserDO> findByUsernameLike(String username, Pageable pageable);

}