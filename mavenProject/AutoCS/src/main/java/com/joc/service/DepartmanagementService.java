package com.joc.service;

import com.joc.dao.DepartmanagementDao;
import com.joc.dao.TeacherDao;
import com.joc.domain.Departmanagement;
import com.joc.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmanagementService {
    @Autowired
    private DepartmanagementDao departmanagementDao;
    @Autowired
    private TeacherDao teacherDao;

    public Departmanagement queryUserByUserName(String userName) {
        return departmanagementDao.getUserByUserName(userName);
    }

    public List<Teacher> queryTeacherUserByMoreConditions(String[] conditions){
        return teacherDao.getUserByMoreConditions(conditions);
    }

}
