package edu.nf.wuneng;

import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.admin.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
    void testLoginAdmin(){
        Admin admin = adminService.loginAdmin("admin");
        System.out.println(admin.getName());
    }

    @Test
    void testAddCourse(){
        Course course=new Course();
        course.setCid(11);
        course.setCname("html");
        course.setCintroduct("简单");
        course.setCimg1("1");
        course.setCimg2("2");
        course.setCimg3("3");
        adminService.addCourse(course);
    }

    @Test
    void testAddCourseAddr(){
        List<CourseAddr> list=new ArrayList<>();
        CourseAddr c1=new CourseAddr();
        c1.setCaId(1);
        c1.setCaAddr("ww");
        CourseAddr c2=new CourseAddr();
        c2.setCaId(2);
        c2.setCaAddr("qq");
        list.add(c1);
        list.add(c2);
        adminService.addCourseAddr(list);
    }

    @Test
    void testListCourseCation(){
        List<CourseCation> courseCations = adminService.listCourseCation();
        for (CourseCation courseCation : courseCations) {
            System.out.println("1:"+courseCation.getName());
            for (CourseInfo courseInfo : courseCation.getCourseInfo()) {
                System.out.println("2:"+courseInfo.getName());
            }
        }
    }

    @Test
    void testListCourseInfo(){
        List<CourseInfo> courseInfos = adminService.listCourseInfo();
        for (CourseInfo courseInfo : courseInfos) {
            System.out.println(courseInfo.getNum());
        }
    }
}