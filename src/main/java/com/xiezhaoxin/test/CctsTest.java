package com.xiezhaoxin.test;

public class CctsTest {
	
	public static void main(String[] args) {
		System.err.println(13612493L * 256);
	}

	private static final String CharSet = "GB2312";// 中文字符加密的时候为GB2312编码

	private static String IntToHex(String hexNum, int length) {
		if (length == hexNum.length())
			return hexNum;
		StringBuffer sb = new StringBuffer();
		if (length > hexNum.length()) {
			for (int i = 0; i < length - hexNum.length(); i++) {
				sb.append('0');
			}
			sb.append(hexNum);
			return sb.toString();
		} else {
			return hexNum.substring(hexNum.length() - length);
		}

	}

	/**
	 * 
	 * @param input 要加密的字符串
	 * @param key 加密字符串的密码
	 * @return
	 */
	public static String encryption(final String input, final String key) {
		if (input == null)
			return null;
		byte[] keyBytes = null;
		byte[] inputBytes = null;
		try {
			if (key == null || key.length() == 0) {
				keyBytes = "63A9B8C19F10D547".getBytes(CharSet);
			} else {
				keyBytes = key.getBytes(CharSet);
			}
			inputBytes = input.getBytes(CharSet);
		} catch (Exception e) {
		}
		long t = 0;
		double nKey = 7788 / 33;
		long t1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keyBytes.length; i++) {
			int c = keyBytes[i] & 0x00ff;// 无符号byte转换为整数数字
			t = (t | c);
			if (i % 4 == 3) {
				t1 = (long) (t / nKey);
				sb.append(IntToHex(Long.toHexString(t1), 8).toUpperCase());
				t = 0x00000000;
			}
			t = t << 8;
		}
		// 加密修改 为适应 CS加密问题
		// if(keyBytes.length< 4){
		// t1 = (long) (t/nKey);
		// sb.append(IntToHex(Long.toHexString(t1),8).toUpperCase());
		// }
		if (keyBytes.length <= 4) {
			// mark:keyBytes.length<4改成keyBytes.length<=4
			t1 = (long) (t / nKey);
			sb.setLength(0);
			// mark:增加sb.setlength(0);
			sb.append(IntToHex(Long.toHexString(t1), 8).toUpperCase());
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < inputBytes.length; i++) {
			int first = (2 * i) % sb.length();
			int second = (2 * i + 1) % sb.length();
			int v2 = Integer.parseInt(sb.charAt(first) + "" + sb.charAt(second), 16);
			int v = (v2 ^ inputBytes[i]) & 0xff;
			result.append(IntToHex(Integer.toHexString(v), 2));
		}
		return result.toString().toUpperCase();
	}

}
