package edu.nf.wuneng.exception;

/**
 * @author YXD
 * @date 2020/3/11
 */
public class AccessException extends RuntimeException{
    public AccessException(String message) {
        super(message);
    }

    public AccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessException(Throwable cause) {
        super(cause);
    }
}