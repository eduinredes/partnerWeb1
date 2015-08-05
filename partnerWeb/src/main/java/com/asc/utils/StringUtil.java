package com.asc.utils;

public class StringUtil {
	
	public static final String EMPTY = " ";
	
	public static boolean isEmpty(String string) {
		return string == null || string.length() < 1
				|| string.trim().equals("");
	}

	public static boolean isNull(String string) {
		return string == null;
	}

	public static boolean isEmptyOrNullValue(String string) {
		return (StringUtil.isEmpty(string) || (string.trim()
				.equalsIgnoreCase("null")));
	}

}
