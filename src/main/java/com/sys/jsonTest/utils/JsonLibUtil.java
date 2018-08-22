package com.sys.jsonTest.utils;

import net.sf.json.JSONObject;

public class JsonLibUtil {

	public static String bean2Json(Object obj) {
		JSONObject object = JSONObject.fromObject(obj);
		return object.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T json2Bean(String json, Class<T> clazz) {
		return (T) JSONObject.toBean(JSONObject.fromObject(json), clazz);
	}

}
