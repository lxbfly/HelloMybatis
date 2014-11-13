package cn.gordon.mybatis.service.impl;

import java.util.List;
import cn.gordon.mybatis.dao.BaseMapper;
import cn.gordon.mybatis.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseMapper<T> baseMapper;
    
    public BaseMapper<T> getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public T get(String id) {
        return baseMapper.get(id);
    }

    @Override
    public List<T> getAll() {
        return baseMapper.getAll();
    }

    @Override
    public String delete(String id) {
        if (baseMapper.delete(id) == 1) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public String insert(T obj) {
        if (baseMapper.insert(obj) == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String insertSelective(T obj) {
        if (baseMapper.insertSelective(obj) == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String update(T obj) {
        if (baseMapper.update(obj) == 1) {
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public String updateSelective(T obj) {
        if (baseMapper.updateSelective(obj) == 1) {
            return "更新成功";
        }
        return "更新失败";
    }

}
