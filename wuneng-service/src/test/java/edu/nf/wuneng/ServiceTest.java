package edu.nf.wuneng;


import edu.nf.wuneng.admin.dao.ESCourseDao;
import edu.nf.wuneng.admin.entity.ESCourse;
import edu.nf.wuneng.admin.service.AdminService;

import edu.nf.wuneng.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

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
        adminService.addDiscuss(4,1001,"安排，支持一波");
    }


}