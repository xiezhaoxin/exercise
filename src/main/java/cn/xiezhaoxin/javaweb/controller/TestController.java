package cn.xiezhaoxin.javaweb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/hello")
	public Object hello() {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 100; i++) {
			map.put(i + "", (i++) + "");
		}
		return map;
	}
	
}
