package edu.nf.wuneng.user.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author YXD
 * @date 2020/4/11
 */
@Data
public class Coupons {
    private String cid;
    private Integer uid;
    private String name;
    private BigDecimal price;
    private Date time;
    private Integer status;
}