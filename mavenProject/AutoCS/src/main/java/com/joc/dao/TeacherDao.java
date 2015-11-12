package com.joc.dao;

import com.joc.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao extends BaseDao<Teacher> {
    private final String GET_USER_BY_USERNAME = "from Teacher t where t.teacherUserName = ?";

    /**
     * 根据用户名查询User对象
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null。
     */
    public Teacher getUserByUserName(String userName){
        List<Teacher> users = (List<Teacher>)find(GET_USER_BY_USERNAME,userName);
        if (users.size() == 0) {
            return null;
        }else{
            return users.get(0);
        }
    }
}
