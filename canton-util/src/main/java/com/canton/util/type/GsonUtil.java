/*
 * @(#)GsonUtil.java   1.0  2022年02月25日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * google json
 *
 * @author 宇文
 * @version 1.0  2022年02月25日
 */
public class GsonUtil {

    public static String toJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> T toBean(String json,Class<T> clz){
        return new Gson().fromJson(json,clz);
    }

    public static <T> List<T> toList(String json,Class<T> clz){
        Type collectionType = getCollectionType();
        List<Object> list = new GsonBuilder().create().fromJson(json,collectionType);
        if(CanUtil.isNull(list)) return null;
        List<T> resList = new ArrayList<>();
        for(Object obj:list){
            resList.add(toBean(obj.toString(),clz));
        }
        return resList;
    }

    private static Type getCollectionType(){
        return new TypeToken<Collection<?>>(){}.getType();
    }


    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(321);
        list.add(342);

        List<Integer> newlisd = toList(toJson(list),Integer.class);
        System.out.println(newlisd.get(1));

    }

}
