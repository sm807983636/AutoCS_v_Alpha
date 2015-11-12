package com.joc.service;

import com.joc.dao.DepartmanagementDao;
import com.joc.domain.Departmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmanagementService {
    @Autowired
    private DepartmanagementDao departmanagementDao;

    public Departmanagement findUserByUserName(String userName) {
        return departmanagementDao.getUserByUserName(userName);
    }

}
