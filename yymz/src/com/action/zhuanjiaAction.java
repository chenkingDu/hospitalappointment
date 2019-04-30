package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TKeshiDAO;
import com.dao.TUserDAO;
import com.dao.TZhuanjiaDAO;
import com.model.TUser;
import com.model.TZhuanjia;
import com.opensymphony.xwork2.ActionSupport;

public class zhuanjiaAction extends ActionSupport
{
	private Integer id;

	private String xingming;
	private String xingbie;
	private Integer nianling;
	private Integer keshiId;
	
	private String shanchang;
	private String fujian;
	private String loginname;
	private String loginpw;
	
	private String del;
	private Integer userId;
	
	private TZhuanjiaDAO zhuanjiaDAO;
	private TKeshiDAO keshiDAO;
	private TUserDAO userDAO;
	
	public String zhuanjiaAdd()
	{
		TZhuanjia zhuanjia=new TZhuanjia();
		TUser zjuser=new TUser();
		
		zhuanjia.setXingming(xingming);
		zhuanjia.setXingbie(xingbie);
		zhuanjia.setNianling(nianling);
		zhuanjia.setKeshiId(keshiId);		
		zhuanjia.setShanchang(shanchang);
		zhuanjia.setFujian(fujian);
		zhuanjia.setLoginname(loginname);
		zhuanjia.setLoginpw(loginpw);		
		zhuanjia.setDel("no");
		
		zjuser.setUserName(loginname);
		zjuser.setUserAddress("药到病除医院");
		zjuser.setUserAge(nianling);
		zjuser.setUserDel("no");
		zjuser.setUserPw(loginpw);
		zjuser.setUserRealname(xingming);
		zjuser.setUserSex(xingbie);
		zjuser.setUserTel("82438888");

		
		userDAO.save(zjuser);
		
		zhuanjia.setUserId(zjuser.getUserId());
		zhuanjiaDAO.save(zhuanjia);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加完毕");
		return "msg";
	}
	
	
	public String zhuanjiaMana()
	{
		String sql="from TZhuanjia where del='no'";
		List zhuanjiaList =zhuanjiaDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<zhuanjiaList.size();i++)
		{
			TZhuanjia zhuanjia=(TZhuanjia)zhuanjiaList.get(i);
			zhuanjia.setKeshi(keshiDAO.findById(zhuanjia.getKeshiId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanjiaList", zhuanjiaList);
		return ActionSupport.SUCCESS;
	}
	
	public String zhuanjiaDel()
	{   
		String sql="update TZhuanjia set del='yes' where id="+id;
		zhuanjiaDAO.getHibernateTemplate().bulkUpdate(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除完毕");
		return "msg";
	}
	
	
	
	public String zhuanjiaPre()
	{   
		TZhuanjia zhuanjia=zhuanjiaDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanjia", zhuanjia);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String zhuanjiaEdit()
	{   
		TZhuanjia zhuanjia=zhuanjiaDAO.findById(id);
		
		zhuanjia.setXingming(xingming);
		zhuanjia.setXingbie(xingbie);
		zhuanjia.setNianling(nianling);
		zhuanjia.setKeshiId(keshiId);
		
		zhuanjia.setShanchang(shanchang);
		zhuanjia.setFujian(fujian);
		zhuanjia.setLoginname(loginname);
		zhuanjia.setLoginpw(loginpw);
		
		zhuanjia.setDel("no");
		
		zhuanjiaDAO.attachDirty(zhuanjia);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息修改完毕");
		return "msg";
	}
	
	
	
	
	
	public String zhuanjiaAll()
	{
		String sql="";
		
		HttpServletRequest request=ServletActionContext.getRequest();
		if(request.getParameter("keshiId")==null)
		{
			sql="from TZhuanjia where del='no'";
		}
		if(request.getParameter("keshiId")!=null)
		{
			String keshiId=request.getParameter("keshiId");
			sql="from TZhuanjia where del='no' and keshiId="+Integer.parseInt(keshiId);
		}
		
		List zhuanjiaList =zhuanjiaDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<zhuanjiaList.size();i++)
		{
			TZhuanjia zhuanjia=(TZhuanjia)zhuanjiaList.get(i);
			zhuanjia.setKeshi(keshiDAO.findById(zhuanjia.getKeshiId()));
		}
		request.setAttribute("zhuanjiaList", zhuanjiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhuanjiaDetailQian()
	{
		TZhuanjia zhuanjia=zhuanjiaDAO.findById(id);
		zhuanjia.setKeshi(keshiDAO.findById(zhuanjia.getKeshiId()));
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanjia", zhuanjia);
		return ActionSupport.SUCCESS;
	}

	
	public String zhuanjiaRes()
	{
		StringBuffer sql=new StringBuffer("from TZhuanjia where del='no' and xingming like '%"+xingming.trim()+"%'");
		if(keshiId !=null && String.valueOf(keshiId) !="")
		{
			sql.append(" and keshiId="+keshiId);
		}
		List zhuanjiaList =zhuanjiaDAO.getHibernateTemplate().find(sql.toString());
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanjiaList", zhuanjiaList);
		return ActionSupport.SUCCESS;
	}

	public String getDel()
	{
		return del;
	}


	public void setDel(String del)
	{
		this.del = del;
	}


	public String getFujian()
	{
		return fujian;
	}


	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}



	public TKeshiDAO getKeshiDAO() {
		return keshiDAO;
	}


	public void setKeshiDAO(TKeshiDAO keshiDAO) {
		this.keshiDAO = keshiDAO;
	}


	public Integer getKeshiId() {
		return keshiId;
	}


	public void setKeshiId(Integer keshiId) {
		this.keshiId = keshiId;
	}


	public Integer getNianling()
	{
		return nianling;
	}


	public String getLoginname()
	{
		return loginname;
	}


	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}


	public String getLoginpw()
	{
		return loginpw;
	}


	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}


	public void setNianling(Integer nianling)
	{
		this.nianling = nianling;
	}


	public String getShanchang()
	{
		return shanchang;
	}


	public void setShanchang(String shanchang)
	{
		this.shanchang = shanchang;
	}


	public String getXingbie()
	{
		return xingbie;
	}


	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}


	public String getXingming()
	{
		return xingming;
	}


	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}


	public TZhuanjiaDAO getZhuanjiaDAO()
	{
		return zhuanjiaDAO;
	}


	public void setZhuanjiaDAO(TZhuanjiaDAO zhuanjiaDAO)
	{
		this.zhuanjiaDAO = zhuanjiaDAO;
	}


	public TUserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
