package com.xiezhaoxin.common.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContextUtil implements ApplicationContextAware {
	private ApplicationContext context;// 声明一个静态变量保存

	public void setApplicationContext(ApplicationContext contex)
			throws BeansException {
		this.context = contex;
	}

	public ApplicationContext getContext() {
		return context;
	}
}
