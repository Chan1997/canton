/*
 * @(#)DateUtil.java   1.0  2022年03月17日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type;

import com.canton.excpetion.more.SystemException;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间处理
 *
 * @author 宇文
 * @version 1.0  2022年03月17日
 */
public class DateUtil extends DateUtils {

    public static final String[] PATTERNS = {"yyyyMM","yyyy-MM","yyyy/MM","yyyyMMdd","yyyy-MM-dd","yyyy/MM/dd","yyyyMMddHHmmss"
    ,"yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS"};

    public static final String DEF_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date parseDate(String dateStr){
        try{
            return parseDate(dateStr,PATTERNS);
        }catch (Exception e){
            throw new SystemException(e);
        }
    }

    public static String formatDate(Date date,String format){
        if(date==null) return null;
        if(CanUtil.isNull(format)) format = DEF_PATTERN;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String formatDate(Date date){
        return formatDate(date,null);
    }

}
