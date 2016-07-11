package cn.xiezhaoxin.project.game24.view;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "view_answer")
@IdClass(AnswerViewCPK.class)
public class AnswerView implements Serializable{

	private static final long serialVersionUID = -4574867018002822898L;
	
	private String question;
	
	private String answer;

	@Id
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Id
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
