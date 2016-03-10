package com.xiezhaoxin.project.game24.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiezhaoxin.common.model.PageableVO;
import com.xiezhaoxin.common.util.ReturnMessage;
import com.xiezhaoxin.project.game24.entity.Game24;
import com.xiezhaoxin.project.game24.repository.AnswerViewRepository;
import com.xiezhaoxin.project.game24.repository.Game24Repository;
import com.xiezhaoxin.project.game24.util.Game24Factory;
import com.xiezhaoxin.project.game24.view.AnswerView;
import com.xiezhaoxin.project.game24.vo.Game24VO;
import com.xiezhaoxin.project.game24.vo.ReturnGame24VO;

/**
 * 24点Controller
 * 
 * @ClassName: Game24Controller
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XZX
 * @date 2016年1月16日 下午5:51:54
 *
 */
@Controller
@RequestMapping("/game24")
public class Game24Controller {
	
	@Resource
	private Game24Factory factory;
	@Autowired
	private Game24Repository game24Rep;
	@Autowired
	private AnswerViewRepository answerViewRep;
	
	/**
	 * 更新24点题目的级别
	 * 
	 * @Title: saveLevel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param game24VO
	 * @param @return    设定文件 
	 * @return ReturnMessage    返回类型
	 */
	@RequestMapping(value = "/question/update/level")
	public @ResponseBody ReturnMessage saveLevel(@RequestBody Game24VO game24VO) {
		Game24 game24 = game24Rep.findOne(game24VO.getId());
		game24.setLevel(game24VO.getLevel());
		game24Rep.save(game24);
		return new ReturnMessage();
	}
	
	/**
	 * 随机获取一个题目 包含其所有的结果 和 剩余无级别信息
	 * 
	 * @Title: getOneQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件 
	 * @return ReturnMessage    返回类型
	 */
	@RequestMapping(value = "/get/question")
	public @ResponseBody ReturnMessage getOneQuestion() {
		ReturnGame24VO game24vo = new ReturnGame24VO();
		Pageable pageable = PageableVO.getPageable(1, 1, new Sort(Direction.DESC, "createDate"));
		Page<Game24> page = game24Rep.findOne0Leve(pageable);
		for (Game24 game24 : page) {
			game24vo.setGame24(game24);
		}
		System.err.println(page.getSize());
		Integer countLevelIsNull = game24Rep.countLevelIsNull();
		game24vo.setInfo("共1346道题目，还有" + countLevelIsNull + "道题未分配级别。");
		return new ReturnMessage(game24vo);
	}
	
	/**
	 * 查询所有题目
	 * 
	 * @Title: getAllQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件 
	 * @return ReturnMessage    返回类型
	 */
	@RequestMapping(value = "/get/question/all")
	public @ResponseBody ReturnMessage getAllQuestion() {
		long time = new Date().getTime();
		List<Game24> all = game24Rep.findAll();
		System.err.println("********" + (new Date().getTime() - time));
		return new ReturnMessage(all);
	}
	
	/**
	 * 保存所有题目
	 * 
	 * @Title: saveAllGame24
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件 
	 * @return ReturnMessage    返回类型
	 */
	@RequestMapping(value = "/save/all", method = RequestMethod.POST)
	public @ResponseBody ReturnMessage saveAllGame24() {
		long time = new Date().getTime();
		factory.saveAllGame24();
		System.err.println("-------" + (new Date().getTime() - time));
		return new ReturnMessage();
	}

	/**
	 * 查询所有的AnswerView
	 * 
	 * @Title: findAllAnswerView
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件 
	 * @return ReturnMessage    返回类型
	 */
	@RequestMapping(value = "/answerViews")
	public @ResponseBody ReturnMessage findAllAnswerView() {
		Iterable<AnswerView> findAll = answerViewRep.findAll();
		return new ReturnMessage(findAll);
	}
	
}
