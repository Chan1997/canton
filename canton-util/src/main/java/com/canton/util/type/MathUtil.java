/*
 * @(#)MathUtil.java   1.0  2022年03月16日
 *
 * Copyright (c)	2014-2022. All Rights Reserved.	GuangZhou hhmk Technology Company LTD.
 */
package com.canton.util.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 数学等运算
 *
 * @author 宇文
 * @version 1.0  2022年03月16日
 */
public class MathUtil {




    private static <T> void getArrangeList(List<T> orgList,Stack<T> result, int limit, int curLimit, int index, boolean repeat){

        if(limit==curLimit){
            return;
        }
        for(int i=index;i<orgList.size();i++){
            if(!repeat&&!result.contains(orgList.get(i))){
                result.add(orgList.get(i));
                getArrangeList(orgList,result,limit,curLimit+1,i,repeat);
                result.pop();
            }
        }
    }

    public static <T> List<T> getArrangeList(List<T> orgList,int limit){
        Stack<T> stack = new Stack<>();
        getArrangeList(orgList,stack, limit,0,0,false);
        return new ArrayList<>(stack);
    }





    /*
         *组合数
         *C(n,m) =
     */
    public static long combine(int n,int m){
        return factorial(n,n-m) / factorial(m,0);
    }

    public static long factorial(int n,int limit){
        int r = 1;
        for(int i=n;i>limit;i--){
            r = r * i;
        }
        return r;
    }

    /*
        *排列数
        *A(n,m) = n!/(n-m)!
     */
    public static long arrangement(int n,int m){
        return n>=m ? factorial(n) / factorial(n-m):0;
    }

    /*
        *n阶层数
     */
    public static long factorial(int n){
        return n >1 ? n*factorial(n-1):1;
    }



    public static void main(String[] args){
//        System.out.println(factorial(4));
//        System.out.println(arrangement(4,3));
        System.out.println(combine(4,2));
        System.out.println(JsonUtil.toJson(getArrangeList(Arrays.asList(4,3,2,7),2)));
    }

}
