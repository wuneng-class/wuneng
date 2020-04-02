package edu.nf.wuneng.user.entity;

import lombok.Data;

/**
 * @author YXD
 * @date 2020/4/2
 */
@Data
public class Code {
    private  Long failureTime;//过期时间
    private  Long validTime;//有效时间
    private String code;//生成验证码
    private String code2;//前台传来的验证码
}