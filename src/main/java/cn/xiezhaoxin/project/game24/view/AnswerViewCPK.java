package cn.xiezhaoxin.project.game24.view;

import java.io.Serializable;

/**
 * 视图联合主键
 * 
 * @ClassName: AnswerViewCPK
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XZX
 * @date 2016年1月19日 上午10:44:16
 * 
 */
public class AnswerViewCPK implements Serializable {

	private static final long serialVersionUID = 2232563712964275357L;

	private String question;

	private String answer;

	public AnswerViewCPK() {
		super();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		final AnswerViewCPK other = (AnswerViewCPK) obj;
		if (question == null) {
			if (other.question != null) {
				return false;
			}
		} else if (!question.equals(other.question)) {
			return false;
		}
		if (answer == null) {
			if (other.answer != null) {
				return false;
			}
		} else if (!answer.equals(other.answer)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((question == null) ? 0 : question.hashCode());
		result = PRIME * result + ((answer == null) ? 0 : answer.hashCode());
		return result;
	}

}
