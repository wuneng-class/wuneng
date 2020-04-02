package edu.nf.wuneng.admin.dao;

import edu.nf.wuneng.admin.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/9
 */
@Mapper
public interface AdminDao {
    Admin loginAdmin(String id);

    void addCourse(Course course);

    void addCourseAddr(List<CourseAddr> courseAddr);

    List<CourseCation> listCourseCation();

    List<CourseInfo> listCourseInfo();
}