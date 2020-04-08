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
        PayCourse payCourseById = userService.getPayCourseById(1011);
        System.out.println(payCourseById.getName());
        System.out.println(payCourseById.getPrice());
    }


}