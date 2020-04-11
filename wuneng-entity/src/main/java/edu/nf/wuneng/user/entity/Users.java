package edu.nf.wuneng.user.entity;

import edu.nf.wuneng.admin.entity.PayCourse;
import lombok.Data;

import java.util.List;

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
    private List<PayCourse> listPayCourse;
}