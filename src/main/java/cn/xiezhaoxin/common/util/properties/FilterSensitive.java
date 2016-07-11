package cn.xiezhaoxin.common.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterSensitive {
	private static Node tree = new Node();

	static {
		InputStream is = FilterSensitive.class.getClassLoader().getResourceAsStream("words.dict");
		try {
			InputStreamReader reader = new InputStreamReader(is, "UTF-8");
			Properties prop = new Properties();
			prop.load(reader);
			@SuppressWarnings("rawtypes")
			Enumeration en = prop.propertyNames();
			while (en.hasMoreElements()) {
				String word = (String) en.nextElement();
				insertWord(word, Integer.valueOf(prop.getProperty(word)).intValue());
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			if (is != null)
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		} catch (IOException e) {
			e.printStackTrace();
			if (is != null)
				try {
					is.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private static void insertWord(String word, int level) {
		Node node = tree;
		for (int i = 0; i < word.length(); i++) {
			node = node.addChar(word.charAt(i));
		}
		node.setEnd(true);
		node.setLevel(level);
	}

	private static boolean isPunctuationChar(String c) {
		String regex = "[\\pP\\pZ\\pS\\pM\\pC]";
		Pattern p = Pattern.compile(regex, 2);
		Matcher m = p.matcher(c);
		return m.find();
	}

	@SuppressWarnings("unchecked")
	private static FilterResult filterPunctation(String originalString) {
		StringBuffer filteredString = new StringBuffer();
		@SuppressWarnings("rawtypes")
		ArrayList charOffsets = new ArrayList();
		for (int i = 0; i < originalString.length(); i++) {
			String c = String.valueOf(originalString.charAt(i));
			if (!isPunctuationChar(c)) {
				filteredString.append(c);
				charOffsets.add(Integer.valueOf(i));
			}
		}
		FilterResult result = new FilterResult();
		result.setOriginalString(originalString);
		result.setFilteredString(filteredString);
		result.setCharOffsets(charOffsets);
		return result;
	}

	@SuppressWarnings("unchecked")
	private static FilterResult filterPunctationAndHtml(String originalString) {
		StringBuffer filteredString = new StringBuffer();
		@SuppressWarnings("rawtypes")
		ArrayList charOffsets = new ArrayList();
		int i = 0;
		for (int k = 0; i < originalString.length(); i++) {
			String c = String.valueOf(originalString.charAt(i));
			if (originalString.charAt(i) == '<') {
				for (k = i + 1; k < originalString.length(); k++) {
					if (originalString.charAt(k) == '<') {
						k = i;
						break;
					}
					if (originalString.charAt(k) == '>') {
						break;
					}
				}
				i = k;
			} else if (!isPunctuationChar(c)) {
				filteredString.append(c);
				charOffsets.add(Integer.valueOf(i));
			}
		}

		FilterResult result = new FilterResult();
		result.setOriginalString(originalString);
		result.setFilteredString(filteredString);
		result.setCharOffsets(charOffsets);
		return result;
	}

	private static BasicFilterResult filter(FilterResult pohResult,
			char replacement) {
		StringBuffer sentence = pohResult.getFilteredString();
		@SuppressWarnings("rawtypes")
		ArrayList charOffsets = pohResult.getCharOffsets();
		StringBuffer resultString = new StringBuffer(
				pohResult.getOriginalString());
		StringBuffer badWords = new StringBuffer();
		int level = 0;
		Node node = tree;
		int start = 0;
		int end = 0;
		for (int i = 0; i < sentence.length(); i++) {
			start = i;
			end = i;
			node = tree;
			for (int j = i; j < sentence.length(); j++) {
				node = node.findChar(sentence.charAt(j));
				if (node == null) {
					break;
				}
				if (node.isEnd()) {
					end = j;
					level = node.getLevel();
				}
			}
			if (end > start) {
				for (int k = start; k <= end; k++) {
					resultString.setCharAt(
							((Integer) charOffsets.get(k)).intValue(),
							replacement);
				}
				if (badWords.length() > 0)
					badWords.append(",");
				badWords.append(sentence.substring(start, end + 1));
				i = end;
			}
		}
		BasicFilterResult result = new BasicFilterResult();
		result.setOriginalContent(pohResult.getOriginalString());
		result.setFilteredContent(resultString.toString());
		result.setBadWords(badWords.toString());
		result.setLevel(Integer.valueOf(level));
		return result;
	}

	public static String simpleFilter(String sentence, char replacement) {
		StringBuffer sb = new StringBuffer();
		Node node = tree;
		int start = 0;
		int end = 0;
		for (int i = 0; i < sentence.length(); i++) {
			start = i;
			end = i;
			node = tree;
			for (int j = i; j < sentence.length(); j++) {
				node = node.findChar(sentence.charAt(j));
				if (node == null) {
					break;
				}
				if (node.isEnd()) {
					end = j;
				}
			}
			if (end > start) {
				for (int k = start; k <= end; k++) {
					sb.append(replacement);
				}
				i = end;
			} else {
				sb.append(sentence.charAt(i));
			}
		}
		return sb.toString();
	}

	public static BasicFilterResult filterText(String originalString,
			char replacement) {
		return filter(filterPunctation(originalString), replacement);
	}

	public static BasicFilterResult filterHtml(String originalString,
			char replacement) {
		return filter(filterPunctationAndHtml(originalString), replacement);
	}

//	public static void main(String[] args) {
//		System.out.println(simpleFilter("网站陈---显----宇网站", '?'));
//		BasicFilterResult result = filterText("网站陈.显,宇,画,网站", '?');
//		System.out.println(result.getFilteredContent());
//		System.out.println(result.getBadWords());
//		System.out.println(result.getLevel());
//		result = filterHtml("网站<font>黄</font>.<色<script>,漫,画,网站", '*');
//		System.out.println(result.getFilteredContent());
//		System.out.println(result.getBadWords());
//		System.out.println(result.getLevel());
//        String str = "我是陈显宇，你是谁，好像你喜欢上黄色网站等等";
//
//		long start = System.currentTimeMillis();
//		result = filterHtml(str, '*');
//		long end = System.currentTimeMillis();
//		System.out.println("====Time====" + (end - start));
//		System.out.println("original:" + result.getOriginalContent());
//		System.out.println("result:" + result.getFilteredContent());
//		System.out.println("badWords:" + result.getBadWords());
//		System.out.println("level:" + result.getLevel());
//		start = System.currentTimeMillis();
//		result = filterText(str, '*');
//		end = System.currentTimeMillis();
//		System.out.println("====Time====" + (end - start));
//		System.out.println("original:" + result.getOriginalContent());
//		System.out.println("result:" + result.getFilteredContent());
//		System.out.println("badWords:" + result.getBadWords());
//		System.out.println("level:" + result.getLevel());
//	}
}