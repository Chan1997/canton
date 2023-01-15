/*
 * @(#)CanUtil.java   1.0  2022年03月16日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type;


import java.util.Collection;
import java.util.Map;

/**
 * 常用工具类
 *
 * @author 宇文
 * @version 1.0  2020年03月16日
 */
public class CanUtil {

//    private static final Logger log = Logger.getLogger(CanUtil.class);

    public static boolean isNull(Object obj){
        if(obj==null) return true;
        if(obj instanceof String ){
            if(((String) obj).equalsIgnoreCase("null") ) return true;
            if(((String) obj).equalsIgnoreCase("undefined") ) return true;
        }
        if(obj instanceof Collection){
            return ((Collection) obj).isEmpty();
        }
        if(obj instanceof Map){
            return ((Map)obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            if (((Object[])obj).length<=0) return true;
        }
        return String.valueOf(obj).trim().isEmpty();
    }

    public static boolean isNotNull(Object obj){
        return !isNull(obj);
    }

    public static String toString(Object obj){
        if(obj==null) return null;
        String valueOf = String.valueOf(obj);
        if(valueOf.trim().length()<=0) return "";
        return valueOf;
    }

    public static Integer toInt(Object obj){
        if(obj==null) return null;
        if( obj instanceof Number){
            return ((Number)obj).intValue();
        }
        if(obj instanceof Boolean){
            return ((Boolean)obj) ? 1:0;
        }
        return Integer.valueOf(String.valueOf(obj));
    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if(s==null) return null;
        if (Character.isLowerCase(s.charAt(0))) return s;
        else return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    // 首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if(s==null) return null;
        if (Character.isUpperCase(s.charAt(0))) return s;
        else return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    public static void main(String[] args){

    }





}
