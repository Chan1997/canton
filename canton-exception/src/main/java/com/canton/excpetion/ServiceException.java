/*
 * @(#)ServiceException.java   1.0  2022年03月16日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.excpetion;

import java.io.Serializable;

/**
 * 描述
 *
 * @author 宇文
 * @version 1.0  2022年03月16日
 */
public class ServiceException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 1276639923680705059L;


    private int code;

    public ServiceException(int code) {
        super("");
        this.code = code;
    }

    public ServiceException(String msg){
        super(msg);
        this.code = ExceptionCode.UNKNOWN;
    }

    public ServiceException(int code,String msg) {
        super(msg);
        this.code = code;
    }

    public ServiceException(String msg,Throwable throwable){
        super(msg,throwable);
        this.code = ExceptionCode.UNKNOWN;
    }

    public ServiceException(int code,String msg,Throwable throwable){
        super(msg,throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
