/*
 * @(#)JsonUtil.java   1.0  2020年09月22日
 *
 * Copyright (c)	2014-2020. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type;

import com.canton.excpetion.more.SystemException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.*;


/**
 * jackson JSON处理
 *
 * @author 宇文
 * @version 1.0  2020年09月22日
 */
public class JsonUtil {

    public static final String NULL_JSON = "{}";

    private static final Logger log = Logger.getLogger(JsonUtil.class);


    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static boolean isNull(String json){
        if(CanUtil.isNull(json)) return true;
        if(NULL_JSON.equals(json)) return true;
        return false;
    }

    public static <T> T toBean(String json,Class<T> clz){
        try{
            if(CanUtil.isNull(json)) return null;
            return mapper.readValue(json,clz);
        }catch (Exception e){
            log.error("转json异常",e);
            throw new SystemException(e);
        }
    }

    public static String toJson(Object obj){
        try{
            if(obj==null) return "{}";
            return mapper.writeValueAsString(obj);
        }catch (Exception e){
            log.error("json转对象异常",e);
            throw new SystemException(e);
        }
    }

    public static <T> List<T> toList(String json, Class<T> clz){
        try{
            if(CanUtil.isNull(json)) return null;
            JavaType javaType = getCollectionType(ArrayList.class, clz);
            return mapper.readValue(json,javaType);
        }catch (Exception e){
            log.error("json转List异常",e);
            throw new SystemException(e);
        }
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> T beanToBean(Object obj,Class<T> clz){
        String json = toJson(obj);
        return toBean(json,clz);
    }

    public static <T> List<T> listToList(Object obj,Class<T> clz){
        if(obj==null) return null;
        String json = null;
        if(!(obj instanceof Collection)&&!(obj instanceof Object[])){
            json = toJson(Arrays.asList(obj));
        }else{
            json = toJson(obj);
        }
        return toList(json,clz);
    }

    public static void main(String[] args){
//        Map<String,Object> map = toBean("{\"dsadas\":3}", Map.class);
//        System.out.println(map.get("dsadas"));
//        System.out.println(toJson(map));



//        System.out.println(toJson(ss));

    }


}
