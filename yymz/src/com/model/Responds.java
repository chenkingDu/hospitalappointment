package com.model;

public class Responds implements java.io.Serializable{
	
	private int id;
	private int messageId;
	private String respond;
    private String time;
	private int renameId;
	
	public Responds() {
	}
	public Responds(int messageId, String respond, String time, int renameId) {
		this.messageId = messageId;
		this.respond = respond;
		this.time = time;
		this.renameId = renameId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getRespond() {
		return respond;
	}
	public void setRespond(String respond) {
		this.respond = respond;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRenameId() {
		return renameId;
	}
	public void setRenameId(int renameId) {
		this.renameId = renameId;
	}
}
