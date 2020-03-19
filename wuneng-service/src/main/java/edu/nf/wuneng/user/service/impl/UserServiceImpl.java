package edu.nf.wuneng.user.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.exception.AccessException;
import edu.nf.wuneng.user.dao.UserDao;
import edu.nf.wuneng.user.entity.Users;
import edu.nf.wuneng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/6
 */
@Service("userService")
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<Users> listUsers(Integer pageNum, Integer pageSize) {
        try {
            List<Users> listUsers=userDao.listUsers(pageNum,pageSize);
            return new PageInfo<>(listUsers);
        } catch (Exception e) {
            throw new AccessException("查询错误");
        }
    }
}