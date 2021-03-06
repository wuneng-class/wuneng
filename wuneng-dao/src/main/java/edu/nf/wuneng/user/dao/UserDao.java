package edu.nf.wuneng.user.dao;

import edu.nf.wuneng.admin.entity.PayCourse;
import edu.nf.wuneng.user.entity.Coupons;
import edu.nf.wuneng.user.entity.Orders;
import edu.nf.wuneng.user.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/6
 */
@Mapper
public interface UserDao {
    List<Users> listUsers(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    Users login(String email);

    void register(Users users);

    PayCourse getPayCourseById(Integer id);

    void addOrders(Orders orders);

    void updateOrders(String id);

    List<Coupons> listCoupons(Integer id);

    void updateCoupons(@Param("cid") String cid,@Param("uid") Integer uid);
}