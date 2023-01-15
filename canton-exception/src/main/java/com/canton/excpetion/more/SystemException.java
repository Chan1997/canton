/*
 * @(#)SystemException.java   1.0  2022年03月16日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.excpetion.more;

import com.canton.excpetion.ExceptionCode;
import com.canton.excpetion.ServiceException;

/**
 * 描述
 *
 * @author 宇文
 * @version 1.0  2022年03月16日
 */
public class SystemException extends ServiceException {

    private static final long serialVersionUID = -8346761108251734483L;

    public SystemException(String msg) {
        super(ExceptionCode.SYS_ERROR,msg);
    }

    public SystemException(String msg, Throwable throwable) {
        super(ExceptionCode.SYS_ERROR,msg, throwable);
    }

    public SystemException(Throwable e){
        super(ExceptionCode.SYS_ERROR,e.getMessage(),e);
    }

}
