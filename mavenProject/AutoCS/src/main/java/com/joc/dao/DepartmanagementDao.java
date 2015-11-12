package com.joc.dao;

import com.joc.domain.Departmanagement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmanagementDao extends BaseDao<Departmanagement> {
    private final String GET_USER_BY_USERNAME = "from Departmanagement d where d.departUserName = ?";

    /**
     * 根据用户名查询User对象
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null。
     */
    public Departmanagement getUserByUserName(String userName){
        List<Departmanagement> users = (List<Departmanagement>)find(GET_USER_BY_USERNAME,userName);
        if (users.size() == 0) {
            return null;
        }else{
            return users.get(0);
        }
    }
}
