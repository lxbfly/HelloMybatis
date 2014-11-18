package cn.gordon.mybatis.dao.user;

import java.util.List;
import cn.gordon.mybatis.dao.BaseMapper;
import cn.gordon.mybatis.model.UserEbo;

public interface UserMapper extends BaseMapper<UserEbo> {

    public List<UserEbo> getUserByName(String name);
    
}
