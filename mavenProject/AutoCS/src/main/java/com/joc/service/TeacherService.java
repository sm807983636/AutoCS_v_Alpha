package com.joc.service;

import com.joc.dao.CourseDao;
import com.joc.dao.TeacherDao;
import com.joc.domain.Course;
import com.joc.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private CourseDao courseDao;

    public Teacher queryUserByUserName(String userName) {
        return teacherDao.getUserByUserName(userName);
    }

    public List<Course> queryCourseByMajor(String courseMajor){
        return courseDao.getCourseByCourseMajor(courseMajor);
    }
}
