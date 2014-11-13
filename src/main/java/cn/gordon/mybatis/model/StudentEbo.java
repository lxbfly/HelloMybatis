package cn.gordon.mybatis.model;

import java.util.Date;

public class StudentEbo {

    private Integer id;
    private String stuId;
    private String name;
    private Integer sex;
    private Date birthday;
    private String clsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getClsId() {
        return clsId;
    }

    public void setClsId(String clsId) {
        this.clsId = clsId;
    }

    @Override
    public String toString() {
        return "StudentEbo [id=" + id + ", stuId=" + stuId + ", name=" + name + ", sex=" + sex + ", birthday="
            + birthday + ", clsId=" + clsId + "]";
    }

}
