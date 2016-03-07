package com.xiezhaoxin.project.game24.vo;

public class Game24VO {
	
	private String id;
	
	private char level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Game24VO [id=" + id + ", level=" + level + "]";
	}

}
