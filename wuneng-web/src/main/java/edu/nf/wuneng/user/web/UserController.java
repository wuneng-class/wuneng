package edu.nf.wuneng.user.web;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.CodeUtil;
import edu.nf.wuneng.SmsUtil;
import edu.nf.wuneng.admin.entity.PayCourse;
import edu.nf.wuneng.user.entity.Code;
import edu.nf.wuneng.user.entity.Coupons;
import edu.nf.wuneng.user.entity.Orders;
import edu.nf.wuneng.user.entity.Users;
import edu.nf.wuneng.user.service.UserService;
import edu.nf.wuneng.vo.BaseController;
import edu.nf.wuneng.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author YXD
 * @date 2020/3/6
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("listUsers")
    public ResultVO<PageInfo> listUsers(){
        PageInfo<Users> list = userService.listUsers(1, 5);
        return success(list);
    }

    @PostMapping("/login")
    public ResultVO login(Users users, HttpSession session){
        Users u=userService.login(users);
        session.setAttribute("user",u);
        return success("index.html");
    }

    @GetMapping("/auth/get_user")
    public ResultVO getUser(HttpSession session){
        Users users=(Users) session.getAttribute("user");
        return success(users);
    }

    @PostMapping("/register")
    public ResultVO addUser(Users users, Code code2, HttpSession session){
        Code code=(Code) session.getAttribute("code");
        Date now=new Date();
        code.setCode2(code2.getCode2());
        code.setValidTime(now.getTime());
        userService.register(users,code);
        return success("注册成功");
    }

    @GetMapping("/code/{email}")
    public ResultVO getCode(@PathVariable("email")String email , HttpSession session){
        String code= CodeUtil.randomCode(6);
        boolean falg= SmsUtil.sends(code,email,mailSender);

        if (falg==true){
            Code c=new Code();
            c.setCode(code);
            c.setFailureTime(CodeUtil.date(3));//过期时间
            session.setAttribute("code",c);
            return success("发送成功");
        }
        return fail(500);
    }

    @RequestMapping("/userGet_payCourseById")
    public ResultVO userGetPayCourseById(Integer id,HttpSession session){
        session.setAttribute("payid",id);
        return success(200);
    }

    @RequestMapping("/loadPay")
    public ResultVO<PayCourse> loadPay(HttpSession session){
        Integer id=(Integer) session.getAttribute("payid");
        PayCourse payCourseById = userService.getPayCourseById(id);

        return success(payCourseById);
    }

    @RequestMapping("/successOrders")
    public ResultVO<Orders> successOrders(HttpSession session){
        Orders orders=(Orders) session.getAttribute("successOrders");
        return success(orders);
    }

    @RequestMapping("/getCoupons")
    public ResultVO<List<Coupons>> getCoupons(HttpSession session){
        Users user=(Users) session.getAttribute("user");
        List<Coupons> coupons = userService.listCoupons(user.getUserId());
        return success(coupons);
    }
}