package com.xiezhaoxin.common.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String convertStringToTimeStamp(String sdate){
		return convertStringToTimeStamp(sdate,"yyyy-MM-dd");
	}
	
	public static String convertStringToTimeStamp(String sdate,String formatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Date dateTime=null;
		String str="";
		try {
			dateTime=sdf.parse(sdate);
			str=String.valueOf(dateTime.getTime());
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		return str;
	}
	
	
	public static Date convertStringToDate(String sdate){
		return convertStringToDate(sdate,"yyyy-MM-dd");
	}
	
	public static Date convertStringToDate(String sdate,String formatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Date dateTime=null;
		try {
			dateTime=sdf.parse(sdate);
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		return dateTime;
	}
	
	public static String convertorTimeStampToString(String sdate){
		return convertorTimeStampToString(sdate,"yyyy-MM-dd");
	}
	
	public static String convertorTimeStampToString(String sdate,String formatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(new Date(Long.parseLong(sdate)));
	}
	

}
