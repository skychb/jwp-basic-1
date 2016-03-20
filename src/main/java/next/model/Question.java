package next.model;

import java.sql.Timestamp;


public class Question {
	private int questionId;
	private String writer;
	private String title;
	private String contents;
	private Timestamp createdDate;
	private int countOfAnswer;
	
	
	public Question(int questionId, String writer, String title, String contents,
			Timestamp createdDate, int countOfAnswer) {
		this.questionId = questionId;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.countOfAnswer = countOfAnswer;
	}

	public int getQuestionId() {
		return questionId;
	}
	
	public String getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public int getcountOfAnswer() {
		return countOfAnswer;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", writer=" + writer
				+ ", title=" + title + ", contents=" + contents
				+ ", createdDate=" + createdDate + ", countOfAnswer="
				+ countOfAnswer + "]";
	}

}
