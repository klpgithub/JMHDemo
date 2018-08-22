package com.sys.jsonTest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GsonUtil {

	private static Gson gson = new GsonBuilder().create();

	public static String bean2Json(Object obj) {
		return gson.toJson(obj);
	}

	public static <T> T json2Bean(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	public static String jsonFormatter(String uglyJsonStr) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJsonStr);
		return gson.toJson(je);
	}

}
