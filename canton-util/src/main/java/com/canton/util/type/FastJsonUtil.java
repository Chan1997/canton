/*
 * @(#)FastJsonUtil.java   1.0  2022年02月23日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * 阿里fast json
 *
 * @author 宇文
 * @version 1.0  2022年02月23日
 */
public class FastJsonUtil {

    private static final SerializerFeature[]  defaultSerialiszerFeatures = {
            SerializerFeature.SkipTransientField// 忽略非持久化字段
            ,SerializerFeature.PrettyFormat// 格式化JSON缩进
    };

    private static final Feature[] defaultFeatures = {

    };


    public static String toJson(Object obj){
        return JSON.toJSONString(obj,defaultSerialiszerFeatures);
    }

    public static String toJson(Object obj,SerializerFeature... features){
        return JSON.toJSONString(obj,features);
    }

    public static <T> T toBean(String json,Class<T> clz){
        return JSON.parseObject(json,clz,defaultFeatures);
    }

    public static <T> T toBean(String json, Class<T> clz, Feature... features){
        return JSON.parseObject(json,clz,features);
    }

    public static <T> List<T> toBeanList(String json, Class<T> clz){
        return JSON.parseArray(json,clz);
    }

}
