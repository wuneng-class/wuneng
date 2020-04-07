package edu.nf.wuneng.admin.service.impl;

import edu.nf.wuneng.admin.dao.AdminDao;
import edu.nf.wuneng.admin.entity.*;
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

    @Override
    public List<CourseCation> listCourseCation() {
        try {
            return adminDao.listCourseCation();
        } catch (Exception e) {
            throw new AccessException("服务器错误");
        }
    }

    @Override
    public List<CourseInfo> listCourseInfo() {
        try {
            return adminDao.listCourseInfo();
        } catch (Exception e) {
            throw new AccessException("服务器错误");
        }
    }

    @Override
    public HotCourse showHotCourse(Integer id) {
        try {
            return adminDao.showHotCourse(id);
        } catch (Exception e) {
            throw new AccessException("服务器错误");
        }
    }

    @Override
    public List<PayCourse> listPayCourse() {
        try {
            return adminDao.listPayCourse();
        } catch (Exception e) {
            throw new AccessException("服务器错误");
        }
    }

    @Override
    public PayCourse getPayCourseById(Integer id) {
        try {
            return adminDao.getPayCourseById(id);
        } catch (Exception e) {
            throw new AccessException("查询错误");
        }
    }

    @Override
    public CourseInfo getCourseByNum(Integer num) {
        try {
            return adminDao.getCourseByNum(num);
        } catch (Exception e) {
            throw new AccessException("服务器错误");
        }
    }

    @Override
    public void updateCourseInfo(CourseInfo courseInfo) {
        try {
            adminDao.updateCourseInfo(courseInfo);
        } catch (Exception e) {
            throw new AccessException("修改失败");
        }
    }
}