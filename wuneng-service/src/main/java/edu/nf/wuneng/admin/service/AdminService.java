package edu.nf.wuneng.admin.service;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.user.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author YXD
 * @date 2020/3/11
 */
public interface AdminService {
    Admin loginAdmin(String id);

    void addCourse(Course course);

    void addCourseAddr(List<CourseAddr> courseAddr);

    List<CourseCation> listCourseCation();

    List<CourseInfo> listCourseInfo();

    HotCourse showHotCourse(Integer id);

    List<PayCourse> listPayCourse();

    PayCourse getPayCourseById(Integer id);

    CourseInfo getCourseByNum(Integer num);

    void updateCourseInfo(CourseInfo courseInfo);

    void addPayCourse(PayCourse payCourse);

    void addPayCourseAddr(List<PayCourseAddr> payCourseAddr);

    BigDecimal sumToday();
    BigDecimal sumYesterday();
    Integer countOrdersToday();
    Integer countPayedToday();
    Integer countNotPayToday();
    Integer countOrdersYesterday();
    Integer countPayedYesterday();
    Integer countNotPayedYesterday();

    PageInfo<Orders> listOrders(Integer pageNum,Integer pageSize);
    PageInfo<Discuss> listDiscuss(Integer pageNum,Integer pageSize);
    List<Discuss> listDiscussByNum(Integer num);
    List<Discuss> listDiscussByIt(Integer id);

    void addDiscuss(Integer pid,Integer uid,String text);
    void addCollection(Integer uid,Integer cid);

    List<ESCourse> listESCourse(String type);
}