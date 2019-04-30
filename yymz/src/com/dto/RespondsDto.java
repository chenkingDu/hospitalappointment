package com.dto;

public class RespondsDto {
	
	private int id;
	private int messageId;
	private String respond;
    private String time;
	private int renameId;
	private String userName;
	
	public RespondsDto(int id, int messageId, String respond, String time,
			int renameId, String userName) {
		super();
		this.id = id;
		this.messageId = messageId;
		this.respond = respond;
		this.time = time;
		this.renameId = renameId;
		this.userName = userName;
	}
	
	public RespondsDto() {
		super();
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "RespondsDto [id=" + id + ", messageId=" + messageId
				+ ", respond=" + respond + ", time=" + time + ", renameId="
				+ renameId + ", userName=" + userName + "]";
	}
}
