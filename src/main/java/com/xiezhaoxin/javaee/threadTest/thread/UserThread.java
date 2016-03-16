package com.xiezhaoxin.javaee.threadTest.thread;

import com.xiezhaoxin.javaee.threadTest.entity.User;

/**
 * 用户线程
 * 
 * @Title: UserThread.java
 * @Package cn.telezone.study.threadTest.thread
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XZX
 * @date 2016年3月15日 下午5:29:12
 * @version V1.0
 */
public class UserThread extends Thread {

	private User user;

	private volatile boolean shutdownRequested = false;

	@Override
	public void run() {
		while (!shutdownRequested) {
			while (user.getStatus() == 0) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println(this.user.getName());
			}
			try {
				sleep(1000);
				System.err.println("线程暂停中......");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.err.println("线程结束！");
	}

	public UserThread() {
		super();
	}

	public UserThread(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isShutdownRequested() {
		return shutdownRequested;
	}

	public void setShutdownRequested(boolean shutdownRequested) {
		this.shutdownRequested = shutdownRequested;
	}

}
