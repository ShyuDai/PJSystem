package com.pj.util;

import com.alibaba.fastjson.JSON;

public class JSONUtil {

	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

}
