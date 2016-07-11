package cn.xiezhaoxin.project.game24.vo;

import cn.xiezhaoxin.project.game24.entity.Game24;

public class ReturnGame24VO {

	private Game24 game24;
	
	private String info;

	public Game24 getGame24() {
		return game24;
	}

	public void setGame24(Game24 game24) {
		this.game24 = game24;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ReturnGame24VO [game24=" + game24 + ", info=" + info + "]";
	}

}
