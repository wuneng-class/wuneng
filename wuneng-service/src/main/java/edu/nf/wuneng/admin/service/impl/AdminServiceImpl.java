package edu.nf.wuneng.admin.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.admin.dao.AdminDao;
import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.admin.service.AdminService;
import edu.nf.wuneng.exception.AccessException;
import edu.nf.wuneng.user.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public void addPayCourse(PayCourse payCourse) {
        try {
            adminDao.addPayCourse(payCourse);
        } catch (Exception e) {
            throw new AccessException("添加失败");
        }
    }

    @Override
    public void addPayCourseAddr(List<PayCourseAddr> payCourseAddr) {
        try {
            adminDao.addPayCourseAddr(payCourseAddr);
        } catch (Exception e) {
            throw new AccessException("添加失败");
        }
    }

    @Override
    public BigDecimal sumToday() {
        try {
            return adminDao.sumToday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public BigDecimal sumYesterday() {
        try {
            return adminDao.sumYesterday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public Integer countOrdersToday() {
        try {
            return adminDao.countOrdersToday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public Integer countPayedToday() {
        try {
            return adminDao.countPayedToday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public Integer countNotPayToday() {
        try {
            return adminDao.countNotPayToday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public Integer countOrdersYesterday() {
        try {
            return adminDao.countOrdersYesterday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public Integer countPayedYesterday() {
        try {
            return adminDao.countPayedYesterday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public Integer countNotPayedYesterday() {
        try {
            return adminDao.countNotPayedYesterday();
        } catch (Exception e) {
            throw new AccessException("服务器异常");
        }
    }

    @Override
    public PageInfo<Orders> listOrders(Integer pageNum, Integer pageSize) {
        try {
            List<Orders> orders = adminDao.listOrders(pageNum, pageSize);
            return new PageInfo<>(orders);
        } catch (Exception e) {
            throw new AccessException("查询错误");
        }
    }

    @Override
    public PageInfo<Discuss> listDiscuss(Integer pageNum, Integer pageSize) {
        try {
            List<Discuss> list=adminDao.listDiscuss(pageNum,pageSize);
            return new PageInfo<>(list);
        } catch (Exception e) {
            throw new AccessException("查询失败");
        }
    }

    @Override
    public List<Discuss> listDiscussByNum(Integer num) {
        try {
            return adminDao.listDiscussByNum(num);
        } catch (Exception e) {
            throw new AccessException("查询错误");
        }
    }

    @Override
    public void addDiscuss(Integer pid, Integer uid, String text) {
        try {
            adminDao.addDiscuss(pid,uid,text);
        } catch (Exception e) {
            throw new AccessException("添加失败");
        }
    }
}