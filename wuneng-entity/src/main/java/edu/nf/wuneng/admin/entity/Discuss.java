package edu.nf.wuneng.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author YXD
 * @date 2020/4/8
 */
@Data
public class Discuss {
    private Integer did;
    private Integer pid;
    private Integer uid;
    private String text;
    private Date time;

}