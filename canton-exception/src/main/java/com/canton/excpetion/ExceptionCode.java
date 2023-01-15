/*
 * @(#)ExceptionCode.java   1.0  2022年03月16日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.excpetion;

/**
 * 描述
 *
 * @author 宇文
 * @version 1.0  2022年03月16日
 */
public class ExceptionCode {

    // 成功
    public static final int SUCCESS = 0;
    // 未知
    public static final int UNKNOWN = -1;
    // 不告警业务的异常
    public static final int NOT_WARN = 200;
    // 没有到服务
    public static final int NO_METHOD = 300;
    // 未登录
    public static final int NOT_LOGON = 304;
    // 非法参数
    public static final int ILLEGAL_PARAM  = 305;
    // 系统异常
    public static final int SYS_ERROR = 400;
    // 协议异常
    public static final int PROTOCOL_ERROR = 401;
    // 无权限
    public static final int AUTH_ERROR = 402;
    // 外部系统异常
    public static final int OTHER_SYS_ERROR = 500;
    // 超时
    public static final int TIMEOUT = 502;


}
