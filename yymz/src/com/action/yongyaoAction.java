package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TYaopinDAO;
import com.dao.TYongyaoDAO;
import com.dao.TZhuanjiaDAO;
import com.model.TYaopin;
import com.model.TYongyao;
import com.opensymphony.xwork2.ActionSupport;

public class yongyaoAction extends ActionSupport
{
	private Integer id;
	private Integer yaopinId;
	private Integer shuliang;
	private Integer danjia;
	
	private Integer zongjia;
	private Integer jiuzhenId;
	
	private TYongyaoDAO yongyaoDAO;
	private TYaopinDAO yaopinDAO;
	
	public String yongyaoAdd()
	{
		TYaopin yaopin=yaopinDAO.findById(yaopinId);
		
		TYongyao yongyao=new TYongyao();
		
		//yongyao.setId(id);
		yongyao.setYaopinId(yaopinId);
		yongyao.setShuliang(shuliang);
		yongyao.setDanjia(yaopin.getDanjai());
		
		yongyao.setZongjia(yaopin.getDanjai() * shuliang);
		yongyao.setJiuzhenId(jiuzhenId);
		
		yongyaoDAO.save(yongyao);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	
	public String yongyaoMana()
	{
		String sql="from TYongyao where jiuzhenId="+jiuzhenId;
		List yongyaoList=yongyaoDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yongyaoList", yongyaoList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yongyaoDel()
	{
		TYongyao yongyao=yongyaoDAO.findById(id);
		yongyaoDAO.delete(yongyao);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getYaopinId() {
		return yaopinId;
	}


	public void setYaopinId(Integer yaopinId) {
		this.yaopinId = yaopinId;
	}


	public Integer getShuliang() {
		return shuliang;
	}


	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}


	public Integer getDanjia() {
		return danjia;
	}


	public void setDanjia(Integer danjia) {
		this.danjia = danjia;
	}


	public Integer getZongjia() {
		return zongjia;
	}


	public void setZongjia(Integer zongjia) {
		this.zongjia = zongjia;
	}


	public Integer getJiuzhenId() {
		return jiuzhenId;
	}


	public void setJiuzhenId(Integer jiuzhenId) {
		this.jiuzhenId = jiuzhenId;
	}


	public TYongyaoDAO getYongyaoDAO() {
		return yongyaoDAO;
	}


	public void setYongyaoDAO(TYongyaoDAO yongyaoDAO) {
		this.yongyaoDAO = yongyaoDAO;
	}


	public TYaopinDAO getYaopinDAO() {
		return yaopinDAO;
	}


	public void setYaopinDAO(TYaopinDAO yaopinDAO) {
		this.yaopinDAO = yaopinDAO;
	}
	
	
	
}
