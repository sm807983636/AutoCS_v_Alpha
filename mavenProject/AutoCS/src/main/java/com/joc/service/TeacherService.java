package com.joc.service;

import com.joc.dao.TeacherDao;
import com.joc.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public Teacher queryUserByUserName(String userName) {
        return teacherDao.getUserByUserName(userName);
    }

}
