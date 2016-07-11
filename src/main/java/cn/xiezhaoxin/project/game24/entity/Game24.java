package cn.xiezhaoxin.project.game24.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.xiezhaoxin.common.util.BaseBean;

@Entity
@Table(name = "GAME_TWENTYFOUR")
public class Game24 extends BaseBean{

	private static final long serialVersionUID = 1L;

	@Column(name = "GAME_A")
	private Integer a; 

	@Column(name = "GAME_B")
	private Integer b; 
	
	@Column(name = "GAME_C")
	private Integer c; 
	
	@Column(name = "GAME_D")
	private Integer d;
	
	@Column(name = "GAME_QUESTION")
	private String question;
	
	@Column(name = "GAME_LEVEL")
	private char level;
	
	@OneToMany(mappedBy = "game", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Set<Answer> answers = new HashSet<Answer>();
	
	public Game24() {
		super();
	}
	
	public Game24(Integer a, Integer b, Integer c, Integer d, String question) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.question = question;
	}
	
	public Game24(Integer a, Integer b, Integer c, Integer d, String question, Set<Answer> answers) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.question = question;
		this.answers = answers;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public Integer getC() {
		return c;
	}

	public void setC(Integer c) {
		this.c = c;
	}

	public Integer getD() {
		return d;
	}

	public void setD(Integer d) {
		this.d = d;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Game24 [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", question=" + question + ", level=" + level
				+ "]";
	}
	
}
