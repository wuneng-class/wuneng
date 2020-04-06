package edu.nf.wuneng.admin.entity;

import lombok.Data;

/**
 * @author YXD
 * @date 2020/4/4
 */
@Data
public class HotCourse {
    private Integer id;
    private String context;
    private String name;
    private String text;
    private String img;
    private String addr;
}