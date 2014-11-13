package cn.gordon.mybatis.dao;

import java.util.List;

public interface BaseMapper<T> {
    
    public T get(String id);
    
    public List<T> getAll();
    
    public int delete(String id);
    
    public int insert(T obj);
    
    public int insertSelective(T obj);
    
    public int update(T obj);
    
    public int updateSelective(T obj);

}
