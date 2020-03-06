package edu.nf.wuneng.user.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.user.dao.UserDao;
import edu.nf.wuneng.user.entity.Users;
import edu.nf.wuneng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/6
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<Users> listUsers(Integer pageNum, Integer pageSize) {
        List<Users> listUsers=userDao.listUsers(pageNum,pageSize);
        return new PageInfo<>(listUsers);
    }
}