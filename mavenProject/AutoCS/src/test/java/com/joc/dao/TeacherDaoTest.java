package com.joc.dao;

import com.joc.domain.Teacher;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;


public class TeacherDaoTest extends BaseDaoTest {
    @SpringBean("teacherDao")
    private TeacherDao teacherDao;

//    @Test
    public void findUserByUserName() {
        Teacher teacher = teacherDao.getUserByUserName("test");
        assertNull(teacher,"不存在用户名为test的用户!");
        teacher = teacherDao.getUserByUserName("12345");
        assertNotNull(teacher,"12345用户存在！");
        assertEquals("12345", teacher.getTeacherUserName());
        assertEquals("12345",teacher.getTeacherPassword());
    }

//    @Test
    public void save(){
        Teacher teacher = new Teacher();
        teacher.setTeacherUserName("11111");
        teacher.setTeacherPassword("11111");
        teacherDao.save(teacher);

    }

    @Test
    public void findByMore(){
        String[] param1 = {"1","1"};
        List<Teacher> list = teacherDao.getUserByMoreConditions(param1);
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).toString();
            System.out.println(str);
        }
    }
}
