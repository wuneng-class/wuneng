package edu.nf.wuneng.user.web;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.user.entity.Users;
import edu.nf.wuneng.user.service.UserService;
import edu.nf.wuneng.vo.BaseController;
import edu.nf.wuneng.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YXD
 * @date 2020/3/6
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("listUsers")
    public ResultVO<PageInfo> listUsers(){
        PageInfo<Users> list = userService.listUsers(1, 5);
        return success(list);
    }
}