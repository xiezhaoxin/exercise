package com.xiezhaoxin.javaee.threadTest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiezhaoxin.javaee.threadTest.entity.User;
import com.xiezhaoxin.javaee.threadTest.thread.UserThread;

/**
 * 线程测试Controller
 * 
 * @Title: ThreadTestController.java
 * @Package cn.telezone.study.threadTest.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XZX
 * @date 2016年3月15日 下午5:27:37
 * @version V1.0
 */
@Controller
@RequestMapping("/thread")
public class ThreadTestController {
	
	private Map<Integer, User> map = new HashMap<Integer, User>();
	private Map<Integer, UserThread> mapUserThread = new HashMap<Integer, UserThread>();
	
	/**
	 * 线程启动
	 * 
	 * @Title: testThread
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件 
	 * @return void    返回类型
	 */
	@RequestMapping("/test")
	public void testThread(){
		map.put(1, new User("谢兆鑫" + 1, 25, 0, 0));
		UserThread thread = new UserThread(map.get(1));
		mapUserThread.put(1, thread);
		mapUserThread.get(1).run();
	}
	
	/**
	 * 更新线程
	 * 
	 * @Title: updateThread
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件 
	 * @return void    返回类型
	 */
	@RequestMapping("/update")
	public void updateThread(){
		User user = map.get(1);
		user.setName("唐余");
	}
	
	/**
	 * 暂停线程
	 * 
	 * @Title: stopThread
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件 
	 * @return void    返回类型
	 */
	@RequestMapping("/stop")
	public void stopThread(){
		map.get(1).setStatus(1);
	}
	
	/**
	 * 恢复暂停线程
	 * 
	 * @Title: startThread
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件 
	 * @return void    返回类型
	 */
	@RequestMapping("/start")
	public void startThread(){
		map.get(1).setStatus(0);
	}
	
	/**
	 * 关闭线程，关闭之后不可再启动
	 * 
	 * @Title: shutdownThread
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件 
	 * @return void    返回类型
	 */
	@RequestMapping("/shutdown")
	public void shutdownThread(){
		// 由于后台是两层循环 所以必须把两层循环都打断才可以退出线程 
		map.get(1).setStatus(1);
//		map.get(1).setStop(1); // 用线程里的对象的某个属性关闭
		mapUserThread.get(1).setShutdownRequested(true); 
	}
	
}
