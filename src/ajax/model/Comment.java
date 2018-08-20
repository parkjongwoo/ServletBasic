package ajax.model;

import java.sql.Date;

public class Comment {
	private int num;
	private String writer;
	private String content;
	private Date datetime;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Comment [num=" + num + ", writer=" + writer + ", content=" + content + ", datetime=" + datetime + "]";
	}	
}
