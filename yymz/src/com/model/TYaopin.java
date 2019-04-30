package com.model;

/**
 * TYaopin entity. @author MyEclipse Persistence Tools
 */

public class TYaopin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mingcheng;
	private String danwei;
	private String guige;
	
	private String changjia;
	private Integer danjai;
	private String del;

	// Constructors

	/** default constructor */
	public TYaopin() {
	}

	/** full constructor */
	public TYaopin(String mingcheng, String danwei, String guige,
			String changjia, Integer danjai, String del) {
		this.mingcheng = mingcheng;
		this.danwei = danwei;
		this.guige = guige;
		this.changjia = changjia;
		this.danjai = danjai;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getDanwei() {
		return this.danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public String getGuige() {
		return this.guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getChangjia() {
		return this.changjia;
	}

	public void setChangjia(String changjia) {
		this.changjia = changjia;
	}

	public Integer getDanjai() {
		return this.danjai;
	}

	public void setDanjai(Integer danjai) {
		this.danjai = danjai;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}