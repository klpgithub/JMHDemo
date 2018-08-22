package com.sys.jsonTest.utils;

import com.alibaba.fastjson.JSON;

public class FastJsonUtil {

	public static String bean2Json(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static <T> T json2Bean(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

}
