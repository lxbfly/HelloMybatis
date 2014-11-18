package cn.gordon.mybatis.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import cn.gordon.mybatis.dao.user.UserMapper;
import cn.gordon.mybatis.model.UserEbo;
import cn.gordon.mybatis.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserEbo> implements UserService {

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserEbo> getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

}
