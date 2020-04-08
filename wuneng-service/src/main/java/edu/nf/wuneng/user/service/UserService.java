package edu.nf.wuneng.user.service;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.admin.entity.PayCourse;
import edu.nf.wuneng.user.entity.Code;
import edu.nf.wuneng.user.entity.Orders;
import edu.nf.wuneng.user.entity.Users;
import org.apache.ibatis.annotations.Param;


/**
 * @author YXD
 * @date 2020/3/6
 */
public interface UserService {
    PageInfo<Users> listUsers(Integer pageNum,Integer pageSize);

    Users login(Users users);
    void register(Users users, Code code);

    PayCourse getPayCourseById(Integer id);

    void addOrders(Orders orders);

    void updateOrders(String id);

}