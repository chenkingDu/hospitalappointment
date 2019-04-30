package com.model;

/**
 * TYongyao entity. @author MyEclipse Persistence Tools
 */

public class TYongyao implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer yaopinId;
	private Integer shuliang;
	private Integer danjia;
	
	private Integer zongjia;
	private Integer jiuzhenId;
	
	private TYaopin yaopin;

	// Constructors

	/** default constructor */
	public TYongyao() {
	}

	/** full constructor */
	public TYongyao(Integer yaopinId, Integer shuliang, Integer danjia,
			Integer zongjia, Integer jiuzhenId) {
		this.yaopinId = yaopinId;
		this.shuliang = shuliang;
		this.danjia = danjia;
		this.zongjia = zongjia;
		this.jiuzhenId = jiuzhenId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYaopinId() {
		return this.yaopinId;
	}

	public void setYaopinId(Integer yaopinId) {
		this.yaopinId = yaopinId;
	}

	public TYaopin getYaopin() {
		return yaopin;
	}

	public void setYaopin(TYaopin yaopin) {
		this.yaopin = yaopin;
	}

	public Integer getShuliang() {
		return this.shuliang;
	}

	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}

	public Integer getDanjia() {
		return this.danjia;
	}

	public void setDanjia(Integer danjia) {
		this.danjia = danjia;
	}

	public Integer getZongjia() {
		return this.zongjia;
	}

	public void setZongjia(Integer zongjia) {
		this.zongjia = zongjia;
	}

	public Integer getJiuzhenId() {
		return this.jiuzhenId;
	}

	public void setJiuzhenId(Integer jiuzhenId) {
		this.jiuzhenId = jiuzhenId;
	}

}