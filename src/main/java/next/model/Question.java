package next.model;

import java.util.Date;

public class Question {
	private int questionId;
	private String writer;
	private String title;
	private String contents;
	private Date createdDate;
	private int countOfAnswer;
	
	public Question(String writer, String title, String contents) {
		this(0, writer, title, contents, new Date(), 0);
	}	
	
	public Question(int questionId, String writer, String title, String contents,
			Date createdDate, int countOfAnswer) {
		this.questionId = questionId;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.countOfAnswer = countOfAnswer;
	}

	public long getQuestionId() {
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

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public long getTimeFromCreateDate() {
		return this.createdDate.getTime();
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (questionId != other.questionId)
			return false;
		return true;
	}
}
