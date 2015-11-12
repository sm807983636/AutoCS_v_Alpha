package com.joc.dao;

import com.joc.domain.Yardmanagement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YardmanagementDao extends BaseDao<Yardmanagement> {
    private final String GET_USER_BY_USERNAME = "from Yardmanagement y where y.yardUserName = ?";

    /**
     * 根据用户名查询User对象
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null。
     */
    public Yardmanagement getUserByUserName(String userName){
        List<Yardmanagement> users = (List<Yardmanagement>)find(GET_USER_BY_USERNAME,userName);
        if (users.size() == 0) {
            return null;
        }else{
            return users.get(0);
        }
    }
}
