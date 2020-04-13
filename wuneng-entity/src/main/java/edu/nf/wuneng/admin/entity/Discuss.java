package edu.nf.wuneng.admin.entity;

import edu.nf.wuneng.user.entity.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
    private List<Users> listUsers;
}