package com.joc.service;

import com.joc.dao.YardmanagementDao;
import com.joc.domain.Yardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YardmanagementService {
    @Autowired
    private YardmanagementDao yardmanagementDao;

    public Yardmanagement findUserByUserName(String userName) {
        return yardmanagementDao.getUserByUserName(userName);
    }

}
