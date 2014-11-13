package cn.gordon.mybatis.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import cn.gordon.mybatis.model.StudentEbo;


public class StudentTest {
    
    private static SqlSessionFactory ssf = null;
    private static SqlSession session = null;
    private static Reader reader = null;
    private String stuId = "Test-S2014111202";
    
    @Ignore
//    @BeforeClass
    public static void beforeClass() throws IOException {
        String resource = "mybatis.cfg.xml";
        reader = Resources.getResourceAsReader(resource);
        ssf = new SqlSessionFactoryBuilder().build(reader);
        session = ssf.openSession(); 
    };

    @Ignore
//    @AfterClass
    public static void afterClass() throws IOException {
        if(reader != null) {
            reader.close();
        }
        if(session != null) {
            session.close();
        }
    };
    
    @Ignore
//    @Before
    public void setUp() throws Exception {
        System.out.println("######## 测试方法开始 ##########");
    }
    
    @Ignore
//    @After
    public void tearDown() throws Exception {
        System.out.println("######## 测试方法结束 ##########");
    }
    
    @Ignore
//    @Test
    public void testInsertStudent() {
        try {
            StudentEbo student = new StudentEbo();
            student.setStuId(stuId);
            student.setName("小红");
            student.setSex(1);
            student.setBirthday(new Date());
            student.setClsId("C032");
            
            int result = session.insert("insertStudent", student);
            session.commit();
            System.out.println("testInsertStudent = " + result);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
    }
    
    @Ignore
//    @Test
    public void testGetAllStudent() {
        try {
            List<StudentEbo> stuList = session.selectList("getAllStudent");
            for (StudentEbo student : stuList) {
                System.out.println(student);
            }
            assertEquals(stuList.size() > 0, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Ignore
//    @Test
    public void testGetStudentByStuId() throws IOException {
        try {
            StudentEbo student = session.selectOne("getStudentByStuId", this.stuId);
            System.out.println("testGetStudentByStuId = " + student);
            assertEquals(student != null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Ignore
//    @Test
    public void testGetStudentById() {
        try {
            StudentEbo queryStudent = session.selectOne("getStudentByStuId", this.stuId);
            StudentEbo student = session.selectOne("getStudentById", queryStudent.getId());
            System.out.println("testGetStudentById = " + student);
            assertEquals(student != null, true);            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Ignore
//    @Test
    public void testUpdateStudentById() {
        try {
            StudentEbo queryStudent = session.selectOne("getStudentByStuId", this.stuId);
            Map<String, Object> param=new HashMap<String, Object>();
            param.put("id", queryStudent.getId());
            param.put("name", "Test小李");
            
            int result = session.update("updateStudentById", param);
            System.out.println("testUpdateStudentById = " + result);
            session.commit();
            assertEquals(result > 0, true);
        } catch(Exception e) {
            session.rollback();
            e.printStackTrace();
        }
    }
    
    @Ignore
//    @Test
    public void testDeleteStudentById() {
        try {
            StudentEbo queryStudent = session.selectOne("getStudentByStuId", this.stuId);
            int result = session.delete("deleteStudentById", queryStudent.getId());
            session.commit();
            System.out.println("testDeleteStudentById = " + result);
            assertEquals(result > 0, true);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
    }
    
}
