package edu.nf.wuneng.admin.service;

import edu.nf.wuneng.admin.entity.*;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/11
 */
public interface AdminService {
    Admin loginAdmin(String id);

    void addCourse(Course course);

    void addCourseAddr(List<CourseAddr> courseAddr);

    List<CourseCation> listCourseCation();

    List<CourseInfo> listCourseInfo();

}