package edu.nf.wuneng.admin.entity;

import lombok.Data;

import java.util.List;

/**
 * @author YXD
 * @date 2020/4/1
 */
@Data
public class CourseCation {
    private Integer id;
    private String name;
    private List<CourseInfo> courseInfo;
}