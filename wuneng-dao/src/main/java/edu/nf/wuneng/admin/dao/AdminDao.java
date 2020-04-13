package edu.nf.wuneng.admin.dao;

import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.user.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author YXD
 * @date 2020/3/9
 */
@Mapper
public interface AdminDao {
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

    BigDecimal  sumToday(); //今日收入
    BigDecimal sumYesterday(); //昨日收入
    Integer countOrdersToday(); //今日订单量
    Integer countPayedToday(); //今日已付款
    Integer countNotPayToday(); //今日未付款
    Integer countOrdersYesterday(); //昨日订单量
    Integer countPayedYesterday(); //昨日已付款
    Integer countNotPayedYesterday(); //昨日未付款

    List<Orders> listOrders(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    List<Discuss> listDiscuss(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    List<Discuss> listDiscussByNum(Integer num);

    void addDiscuss(@Param("pid") Integer pid,@Param("uid") Integer uid,@Param("text") String text);
}