package edu.nf.wuneng;

import edu.nf.wuneng.admin.entity.Admin;
import edu.nf.wuneng.admin.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YXD
 * @date 2020/3/11
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = "edu.nf.wuneng")
public class ServiceTest {
    @Autowired
    private AdminService adminService;

    @Test
    void testLoginAdmin(){
        Admin admin = adminService.loginAdmin("admin");
        System.out.println(admin.getName());
    }
}