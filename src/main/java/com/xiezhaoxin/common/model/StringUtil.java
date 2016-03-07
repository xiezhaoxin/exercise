package com.xiezhaoxin.common.model;

import java.io.UnsupportedEncodingException;

public class StringUtil {
	private static final String charset = "UTF-8";

	public static byte[] toByte(String string) {
		try {
			return string.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public static String fromByte(byte[] bytes) {
		try {
			if(bytes != null){				
				return new String(bytes, charset);
			}
			return "";
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
