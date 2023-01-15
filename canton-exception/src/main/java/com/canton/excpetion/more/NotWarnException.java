/*
 * @(#)NotWarnException.java   1.0  2022年03月16日
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
public class NotWarnException extends ServiceException {

    private static final long serialVersionUID = 5689351739849578424L;

    public NotWarnException(int code) {
        super(code);
    }

    public NotWarnException(String msg) {
        super(ExceptionCode.UNKNOWN,msg);
    }

    public NotWarnException(int code, String msg) {
        super(code, msg);
    }
}
