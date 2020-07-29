package com.wang.search.utils;


import com.google.gson.Gson;

/**
 * json工具
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/27 16:56
 * @since JDK 1.8
 */
public class JsonUtil {
    public static String data2Json(Object t) {
        Gson gson = new Gson();
        return gson.toJson(t);
    }

    public static <T> T json2Object(String json, T type) {
        Gson gson = new Gson();
        return (T) gson.fromJson(json, type.getClass());
    }

}
