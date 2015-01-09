package cn.gordon.mybatis.service;

import java.util.List;
import cn.gordon.mybatis.model.UserEbo;

public interface UserService extends BaseService<UserEbo> {
    public List<UserEbo> getUserByName(String name);
}
