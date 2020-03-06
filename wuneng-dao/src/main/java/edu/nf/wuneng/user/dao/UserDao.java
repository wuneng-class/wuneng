package edu.nf.wuneng.user.dao;

import edu.nf.wuneng.user.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/6
 */
public interface UserDao {
    List<Users> listUsers(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

}