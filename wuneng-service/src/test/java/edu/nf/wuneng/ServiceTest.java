package edu.nf.wuneng;

import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.admin.service.AdminService;
import edu.nf.wuneng.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @author YXD
 * @date 2020/3/11
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = "edu.nf.wuneng")
public class ServiceTest {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Test
    void testAdminService(){
        CourseInfo courseInfo=new CourseInfo();
        courseInfo.setId(1);
        courseInfo.setName("java基础11");
        courseInfo.setContext("11Java语言的语法与C语言和C++语言很接近，使得大多数程序员很容易学习和使用.");
        courseInfo.setNum(1);
        adminService.updateCourseInfo(courseInfo);
    }


}