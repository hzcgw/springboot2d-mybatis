package ga.hzcgw.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ga.hzcgw.springboot.dao.UserMapper;
import ga.hzcgw.springboot.exception.BusinessException;
import ga.hzcgw.springboot.po.User;
import ga.hzcgw.springboot.query.UserQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

//    @CacheEvict(value = "users", allEntries = true)
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @CachePut(value = "users", key = "#user.id")
//    @CacheEvict(value = "users", key = "#user.id")
    @Transactional(propagation = Propagation.REQUIRED)
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return user;
    }

    @Cacheable(value = "users", key = "#userName")
    public User queryUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }

    @Cacheable(value = "users", key = "#id")
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    public List<User> queryUserAll() throws Exception {

        if (true) {
            throw new BusinessException("业务异常测试。。。");
        }

        return userMapper.queryUserAll();
    }

    @Cacheable(value = "users", key = "#userQuery.userName + '-' + #userQuery.pageNum + '-' + #userQuery.pageSize")
    public PageInfo<User> queryUserByParams(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        return new PageInfo<User>(userMapper.queryUserByParams(userQuery));
    }

}
