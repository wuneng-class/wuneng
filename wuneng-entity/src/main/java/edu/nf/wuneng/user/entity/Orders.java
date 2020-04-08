package edu.nf.wuneng.user.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author YXD
 * @date 2020/4/8
 */
@Data
public class Orders {
    private String id;
    private Integer uid;
    private Date time;
    private String status;
    private BigDecimal total;
    private String couponId;
}