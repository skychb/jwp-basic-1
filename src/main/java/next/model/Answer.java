package next.model;

import java.util.Date;

public class Answer {
	private int answerId;
	private String writer;
	private String contents;
	private Date createdDate;
	private int questionId;
	
	public Answer(String writer, String contents){
		this(0, writer, contents, new Date(), 0);
	}

	public Answer(int answerId, String writer, String contents, Date createdDate, int questionId){
		this.answerId = answerId;
		this.writer = writer;
		this.contents = contents;
		this.createdDate = createdDate;
		this.questionId = questionId;
	}

	public int getAnswerId(){
		return answerId;
	}
	public String getWriter(){
		return writer;
	}
	public String getContents(){
		return contents;
	}
	public Date getCreatedDate(){
		return createdDate;
	}
	public long getTimeForNow(){
		return this.createdDate.getTime();
	}
	public int getQuestionId(){
		return questionId;
	}
}