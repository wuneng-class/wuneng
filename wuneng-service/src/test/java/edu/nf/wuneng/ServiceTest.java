package edu.nf.wuneng;

import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.admin.service.AdminService;
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

    @Test
    void testAdminService(){

    }


}