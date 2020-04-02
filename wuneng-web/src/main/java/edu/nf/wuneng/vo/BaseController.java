package edu.nf.wuneng.vo;

import org.springframework.http.HttpStatus;

/**
 * @author YXD
 * @date 2020/3/6
 */
public class BaseController {
    protected <T> ResultVO<T> success(T data){
        ResultVO<T> vo=new ResultVO<>();
        vo.setCode(200);;
        vo.setData(data);
        return vo;
    }

    protected ResultVO success(Integer code){
        ResultVO vo=new ResultVO();
        vo.setCode(code);
        return vo;
    }

    public ResultVO success(String message){
        ResultVO vo=new ResultVO<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setMessage(message);
        return vo;
    }

    public ResultVO fail(Integer code,String message){
        ResultVO vo=new ResultVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }

    public ResultVO fail(Integer code){
        ResultVO vo=new ResultVO();
        vo.setCode(code);
        return vo;
    }

}