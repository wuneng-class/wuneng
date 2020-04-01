package edu.nf.wuneng.admin.service.impl;

import edu.nf.wuneng.admin.dao.AdminDao;
import edu.nf.wuneng.admin.entity.Admin;
import edu.nf.wuneng.admin.entity.Course;
import edu.nf.wuneng.admin.entity.CourseAddr;
import edu.nf.wuneng.admin.service.AdminService;
import edu.nf.wuneng.exception.AccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/11
 */
@Service()
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin loginAdmin(String id) {
        try {
            return adminDao.loginAdmin(id);
        } catch (Exception e) {
            throw new AccessException("登录失败");
        }
    }

    @Override
    public void addCourse(Course course) {
        try {
            adminDao.addCourse(course);
        } catch (Exception e) {
            throw new AccessException("添加失败");
        }
    }

    @Override
    public void addCourseAddr(List<CourseAddr> courseAddr) {
        try {
            adminDao.addCourseAddr(courseAddr);
        } catch (Exception e) {
            throw new AccessException("添加失败");
        }
    }
}