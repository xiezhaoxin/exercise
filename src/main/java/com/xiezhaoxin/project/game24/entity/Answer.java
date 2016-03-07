package com.xiezhaoxin.project.game24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xiezhaoxin.common.util.BaseBean;

@Entity
@Table(name = "GAME_ANSWER")
public class Answer extends BaseBean{
	
	private static final long serialVersionUID = -6899171693514056118L;

	@Column(name = "GAME_ANSWER")
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "GAME_ID")
	private Game24 game;
	
	public Answer() {
		super();
	}

	public Answer(String answer, Game24 game24) {
		super();
		this.answer = answer;
		this.game = game24;
	}

	public Game24 getGame24() {
		return game;
	}

	public void setGame24(Game24 game24) {
		this.game = game24;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [answer=" + answer + "]";
	}
	
}
