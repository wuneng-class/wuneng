package edu.nf.wuneng.user.entity;

import lombok.Data;

/**
 * @author YXD
 * @date 2020/3/6
 */
@Data
public class Users {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userHead;
    private String sex;
    private String email;
}