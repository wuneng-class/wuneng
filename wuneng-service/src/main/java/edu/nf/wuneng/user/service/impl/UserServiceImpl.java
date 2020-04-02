package edu.nf.wuneng.user.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.exception.AccessException;
import edu.nf.wuneng.user.dao.UserDao;
import edu.nf.wuneng.user.entity.Code;
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
@Service
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

    @Override
    public Users login(Users users) {
        Users u=userDao.login(users.getEmail());
        try {
            if (u == null || !u.getUserPassword().equals(users.getUserPassword())) {
                throw new AccessException("邮箱或密码错误");
            }
            return u;
        } catch (RuntimeException e) {
            throw new AccessException(e.getMessage());
        }
    }

    @Override
    public void register(Users users, Code code) {
        try {
            Users u=userDao.login(users.getEmail());
            if (u == null){
                if (!code.getCode().equals(code.getCode2()) || code.getValidTime() > code.getFailureTime()) {
                    throw new AccessException("验证码错误或超时");
                }
                userDao.register(users);
            }
            else {
                System.out.println(1);
                throw new AccessException("账号已存在");
            }
        } catch (Exception e) {
            throw new AccessException(e.getMessage());
        }
    }
}