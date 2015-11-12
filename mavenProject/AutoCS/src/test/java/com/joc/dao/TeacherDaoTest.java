package com.joc.dao;

import com.joc.domain.Teacher;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBean;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;


public class TeacherDaoTest extends BaseDaoTest {
    @SpringBean("teacherDao")
    private TeacherDao teacherDao;

    @Test
    public void findUserByUserName() {
        Teacher teacher = teacherDao.getUserByUserName("test");
        assertNull(teacher,"不存在用户名为test的用户!");
        teacher = teacherDao.getUserByUserName("12345");
        assertNotNull(teacher,"12345用户存在！");
        assertEquals("12345", teacher.getTeacherUserName());
        assertEquals("12345",teacher.getTeacherPassword());
    }
}
