package cn.xiezhaoxin.common.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 错误代码解析
 * 
 * @ClassName: ErrorCodeUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XZX
 * @date 2015年9月17日 下午2:54:11
 *
 */
public class ErrorCodeUtil {
    private static Properties prop = new Properties();

    static {
        InputStream in = ErrorCodeUtil.class.getClassLoader().getResourceAsStream("errorCode.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getParam(String errorCode) {
        return prop.getProperty(errorCode).trim();
    } 
}
