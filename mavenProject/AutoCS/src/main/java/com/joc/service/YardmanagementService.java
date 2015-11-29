package com.joc.service;

import com.joc.dao.TeacherDao;
import com.joc.dao.YardmanagementDao;
import com.joc.domain.Teacher;
import com.joc.domain.Yardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YardmanagementService {
    @Autowired
    private YardmanagementDao yardmanagementDao;
    @Autowired
    private TeacherDao teacherDao;

    public Yardmanagement queryUserByUserName(String userName) {
        return yardmanagementDao.getUserByUserName(userName);
    }

    public void saveTeacherUser(Teacher teacher){
        teacherDao.save(teacher);
    }

    public Teacher queryTeacherUserByTeacherUserName(String userName){
        return teacherDao.getUserByUserName(userName);
    }

    public List<Teacher> queryTeacherUserByMoreConditions(String[] conditions){
        return teacherDao.getUserByMoreConditions(conditions);
    }

    public Teacher queryTeacherById(int teacherId){
        return teacherDao.get(teacherId);
    }

    public void removeTeacher(int teacherId){
        Teacher teacher = teacherDao.load(teacherId);
        teacherDao.remove(teacher);
    }
}
