package cn.xiezhaoxin.javaee.jmx;

/**
 * Created by fish on 6/21/16.
 */
public interface HelloMBean {
	public String getName();

	public void setName(String name);

	public void printHello();

	public void printHello(String whoName);
}