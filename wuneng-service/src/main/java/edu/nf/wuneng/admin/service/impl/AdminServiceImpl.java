package edu.nf.wuneng.admin.service.impl;

import edu.nf.wuneng.admin.dao.AdminDao;
import edu.nf.wuneng.admin.entity.Admin;
import edu.nf.wuneng.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YXD
 * @date 2020/3/11
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin loginAdmin(String id) {
        return adminDao.loginAdmin(id);
    }
}