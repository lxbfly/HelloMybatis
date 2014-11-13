package cn.gordon.mybatis.service;

import java.util.List;

public interface BaseService<T> {
	
    public T get(String id);
    
    public List<T> getAll();
    
    public String delete(String id);
    
	public String insert(T obj);
	
	public String insertSelective(T obj);
		
	public String update(T obj);
	
	public String updateSelective(T obj);

}
