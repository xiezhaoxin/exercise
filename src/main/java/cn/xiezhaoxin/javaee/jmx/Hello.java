package cn.xiezhaoxin.javaee.jmx;

/**
 * Created by fish on 6/21/16.
 */
public class Hello implements HelloMBean {

	public Hello() {
		super();
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello World, " + name);
	}

	public void printHello(String whoName) {
		System.out.println("Hello , " + whoName);
	}
}