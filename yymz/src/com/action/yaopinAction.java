package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TYaopinDAO;
import com.model.TYaopin;
import com.opensymphony.xwork2.ActionSupport;

public class yaopinAction extends ActionSupport
{
	
	private Integer id;
	private String mingcheng;
	private String danwei;
	private String guige;
	
	private String changjia;
	private Integer danjai;
	private String del;	
	
	
	private TYaopinDAO yaopinDAO;
	
	
	public String yaopinAdd()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		
		TYaopin yaopin=new TYaopin();
		
		//yaopin.setId(id);
		yaopin.setMingcheng(mingcheng);
		yaopin.setDanwei(danwei);
		yaopin.setGuige(guige);
		
		yaopin.setChangjia(changjia);
		yaopin.setDanjai(danjai);
		yaopin.setDel("no");
		
		yaopinDAO.save(yaopin);
		
		req.setAttribute("msg", "信息添加成功");
		return "msg";
	}
	
	
	
	public String yaopinMana()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		String sql="from TYaopin where del='no'";
		List yaopinList=yaopinDAO.getHibernateTemplate().find(sql);
		
		req.setAttribute("yaopinList", yaopinList);
		return ActionSupport.SUCCESS;
	}
	
	public String yaopinDel()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		int id=Integer.parseInt(req.getParameter("id"));
		
		TYaopin yaopin=yaopinDAO.findById(id);
		yaopin.setDel("yes");
		yaopinDAO.attachDirty(yaopin);
		
		req.setAttribute("msg", "信息删除成功");
		return "msg";
	}

	
	public String yaopinSelect()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		String sql="from TYaopin where del='no'";
		List yaopinList=yaopinDAO.getHibernateTemplate().find(sql);
		
		req.setAttribute("yaopinList", yaopinList);
		return ActionSupport.SUCCESS;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMingcheng() {
		return mingcheng;
	}



	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}



	public String getDanwei() {
		return danwei;
	}



	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}



	public String getGuige() {
		return guige;
	}



	public void setGuige(String guige) {
		this.guige = guige;
	}



	public String getChangjia() {
		return changjia;
	}



	public void setChangjia(String changjia) {
		this.changjia = changjia;
	}



	public Integer getDanjai() {
		return danjai;
	}



	public void setDanjai(Integer danjai) {
		this.danjai = danjai;
	}



	public String getDel() {
		return del;
	}



	public void setDel(String del) {
		this.del = del;
	}



	public TYaopinDAO getYaopinDAO() {
		return yaopinDAO;
	}



	public void setYaopinDAO(TYaopinDAO yaopinDAO) {
		this.yaopinDAO = yaopinDAO;
	}
	
}
