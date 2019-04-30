package com.model;
 
/**
 * 留言实体封装类
 * 
 */
public class Message implements java.io.Serializable{
	
    private int id;
    private String name;
    private String title;
    private String content;
    private String time;
    private int nameId;
 
    public Message() {
		super();
	}

	public Message(int id, String name, String title, String content,
			String time, int nameId) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.time = time;
		this.nameId = nameId;
	}

	public int getNameId() {
		return nameId;
	}

	public void setNameId(int nameId) {
		this.nameId = nameId;
	}

	public String getTime() {
        return time;
    }
 
    public void setTime(String time) {
        this.time = time;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }

	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", title=" + title
				+ ", content=" + content + ", time=" + time + ", nameId="
				+ nameId + "]";
	}
    
}