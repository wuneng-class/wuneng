package edu.nf.wuneng.vo;

import lombok.Data;

/**
 * @author YXD
 * @date 2020/3/6
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private Object message;
    private T data;
}