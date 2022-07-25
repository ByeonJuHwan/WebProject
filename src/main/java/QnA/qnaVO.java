package QnA;

import java.sql.Date;

public class qnaVO {
	private int articleNO;
	private String answer;
	private String way;
	private String content;
	private String details;
	private String id;
	private Date writeDate;
	
	
	public qnaVO() {
		super();
	}

	public qnaVO(int articleNO, String answer, String way, String content,String details, String id, Date writeDate) {
		super();
		this.details = details;
		this.articleNO = articleNO;
		this.answer = answer;
		this.way = way;
		this.content = content;
		this.id = id;
		this.writeDate = writeDate;
	}

	public qnaVO(int articleNO, String answer, String way, String content, String details) {
		super();
		this.articleNO = articleNO;
		this.answer = answer;
		this.way = way;
		this.details=details; 
		this.content = content;
	}

	public int getArticleNO() {
		return articleNO;
	}

	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
