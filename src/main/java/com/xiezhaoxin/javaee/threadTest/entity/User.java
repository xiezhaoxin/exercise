package com.xiezhaoxin.javaee.threadTest.entity;

/**
 * 用户实体
 * 
 * @Title: User.java
 * @Package cn.telezone.study.threadTest.entity
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XZX
 * @date 2016年3月15日 下午5:29:40
 * @version V1.0
 */
public class User {
	
	public String name;
	
	public Integer age;
	
	public int status;
	
	public int stop;
	
	public User() {
		super();
	}

	public User(String name, Integer age, int status, int stop) {
		super();
		this.name = name;
		this.age = age;
		this.status = status;
		this.stop = stop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStop() {
		return stop;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", status=" + status + ", stop=" + stop + "]";
	}
	
}
