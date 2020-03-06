package edu.nf.wuneng.vo;

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

}