package edu.nf.wuneng.advice;

import edu.nf.wuneng.exception.AccessException;
import edu.nf.wuneng.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YXD
 * @date 2020/3/11
 */
@RestControllerAdvice({"edu.nf.wuneng.admin.web","edu.nf.wuneng.user.web"})
public class ControllerAspect {
    @ExceptionHandler(AccessException.class)
    public ResultVO handlerDataAccessException(AccessException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}