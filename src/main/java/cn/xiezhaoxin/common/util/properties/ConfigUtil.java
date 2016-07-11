package cn.xiezhaoxin.common.util.properties;
import java.io.IOException;
import java.util.Properties;

/**
 * 解析properties
* @ClassName: ConfigUtil
* @Description: TODO
* @author dup
* @date 2015年1月19日 下午4:28:51
 */
public class ConfigUtil {
	/**问答链接**/
	public static String ASKS = "jdbc.imageUrl3";
	/**作业链接**/
	public static String HOMEWORKS = "jdbc.imageUrl2";
	/**教师头像链接**/
	public static String TEACHERHEADPIC = "jdbc.imageUrl1";
	/**圈子链接**/
	public static String CLASSCIRCLE = "jdbc.imageUrl0";
	
	/**问答保存**/
	public static String ASKSAVE = "jdbc.imageserver3";
	/**作业保存**/
	public static String HOMEWORKSAVE = "jdbc.imageserver2";
	/**教师头像保存**/
	public static String TEACHERHEADPICSAVE = "jdbc.imageserver1";
	/**圈子保存**/
	public static String CLASSCIRCLESAVE = "jdbc.imageserver0";
	
	
	private static Properties properties = new Properties();
	
	static {
		try {
			properties.load(ConfigUtil.class.getClassLoader().getResourceAsStream("config/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUrl(String key) {
		return (String) properties.get(key);
	}
}
