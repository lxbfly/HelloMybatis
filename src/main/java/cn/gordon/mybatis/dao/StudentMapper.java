package cn.gordon.mybatis.dao;

import java.util.List;
import java.util.Map;
import cn.gordon.mybatis.model.StudentEbo;

public interface StudentMapper {

    public List<StudentEbo> getAllStudent();
    
    public StudentEbo getStudentById(Integer id);
    
    public StudentEbo getStudentByStuId(String stuId);
    
    public Integer insertStudent(StudentEbo student);
    
    public Integer deleteStudentById(Integer id);
    
    public Integer updateStudentById(Map<String,Integer> map);
    
}
