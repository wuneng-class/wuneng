package edu.nf.wuneng.admin.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author YXD
 * @date 2020/4/12
 */
@Data
public class AdminIndex {
    private BigDecimal sumToday;
    private BigDecimal sumYesterday;
    private Integer countOrdersToday;
    private Integer countPayedToday;
    private Integer countNotPayToday;
    private Integer countOrdersYesterday;
    private Integer countPayedYesterday;
    private Integer countNotPayedYesterday;
}