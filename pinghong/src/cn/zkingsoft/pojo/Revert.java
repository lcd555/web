package cn.zkingsoft.pojo;

import java.io.Serializable;

public class Revert implements Serializable,Cloneable {
	private int revertID;
	private int messageID;
	private String content;
	private String writer;
	private String writerDate;
	public int getRevertID() {
		return revertID;
	}
	public void setRevertID(int revertID) {
		this.revertID = revertID;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriterDate() {
		return writerDate;
	}
	public void setWriterDate(String writerDate) {
		this.writerDate = writerDate;
	}
	
	
	
	
}
