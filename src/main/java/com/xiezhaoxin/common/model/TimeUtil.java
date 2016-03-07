package com.xiezhaoxin.common.model;

/**
 * 时间处理工具类
 * 
 * @ClassName: TimeUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XZX
 * @date 2015年12月24日 下午1:54:44
 *
 */
public class TimeUtil {
	
	/**
	 * 将秒数转化为对应时间的字符串
	 * 
	 * @Title: convertSecondsToString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param seconds
	 * @param @return    设定文件 
	 * @return String    返回类型
	 */
	public static String convertSecondsToString(Integer seconds){

		Integer mm = 60;
		Integer hh = 3600;
		Integer dd = 86400;
		
		String timeString = "输入错误！";
		if(seconds == null){
			timeString = "0" + "秒";
		}else if(seconds < 0){

		}else if(seconds < mm){
			timeString = seconds + "秒";
		}else if(seconds < hh) {
			timeString = seconds / mm + "分" + seconds % mm + "秒";
		}else if(seconds < dd) {
			timeString = seconds / hh + "小时" + seconds % hh / mm + "分" + seconds % hh % mm + "秒";
		}else {
			timeString = seconds / dd + "天" + seconds % dd / hh + "小时" + seconds % dd % hh / mm + "分" + seconds % dd % hh % mm + "秒";
		}
		
		return timeString;
	}

}
