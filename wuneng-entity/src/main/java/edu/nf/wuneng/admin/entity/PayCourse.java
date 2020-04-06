package edu.nf.wuneng.admin.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author YXD
 * @date 2020/4/6
 */
@Data
public class PayCourse {
    private Integer id;
    private String name;
    private String context;
    private BigDecimal price;
    private String cover;
    private String img1;
    private String img2;
}