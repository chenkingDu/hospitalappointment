package com.model;

import java.util.List;

/**
 * TJiuzhen entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TJiuzhen implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String binglihao;
	private String bingqing;
	private String zhenduan;
	
	private String shijian;
	private Integer zhuanjiaId;
	private Integer guahaoId;
	
	private TZhuanjia zhuanjia;
	private List yongyaoList;

	// Constructors

	/** default constructor */
	public TJiuzhen()
	{
	}

	/** full constructor */
	public TJiuzhen(String binglihao, String bingqing, String zhenduan,
			String shijian, Integer zhuanjiaId)
	{
		this.binglihao = binglihao;
		this.bingqing = bingqing;
		this.zhenduan = zhenduan;
		this.shijian = shijian;
		this.zhuanjiaId = zhuanjiaId;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public Integer getGuahaoId() {
		return guahaoId;
	}

	public void setGuahaoId(Integer guahaoId) {
		this.guahaoId = guahaoId;
	}

	public List getYongyaoList() {
		return yongyaoList;
	}

	public void setYongyaoList(List yongyaoList) {
		this.yongyaoList = yongyaoList;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getBinglihao()
	{
		return this.binglihao;
	}

	public void setBinglihao(String binglihao)
	{
		this.binglihao = binglihao;
	}

	public String getBingqing()
	{
		return this.bingqing;
	}

	public TZhuanjia getZhuanjia()
	{
		return zhuanjia;
	}

	public void setZhuanjia(TZhuanjia zhuanjia)
	{
		this.zhuanjia = zhuanjia;
	}

	public void setBingqing(String bingqing)
	{
		this.bingqing = bingqing;
	}

	public String getZhenduan()
	{
		return this.zhenduan;
	}

	public void setZhenduan(String zhenduan)
	{
		this.zhenduan = zhenduan;
	}

	public String getShijian()
	{
		return this.shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public Integer getZhuanjiaId()
	{
		return this.zhuanjiaId;
	}

	public void setZhuanjiaId(Integer zhuanjiaId)
	{
		this.zhuanjiaId = zhuanjiaId;
	}

}