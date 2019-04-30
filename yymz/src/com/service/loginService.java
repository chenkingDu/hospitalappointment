package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TKeshiDAO;
import com.dao.TUserDAO;
import com.dao.TZhuanjiaDAO;
import com.model.TAdmin;
import com.model.TKeshi;
import com.model.TUser;
import com.model.TZhuanjia;

public class loginService
{
	private TAdminDAO adminDAO;
	private TUserDAO userDAO;
	private TZhuanjiaDAO zhuanjiaDAO;
	private TKeshiDAO keshiDAO;
	
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public TZhuanjiaDAO getZhuanjiaDAO()
	{
		return zhuanjiaDAO;
	}
	public void setZhuanjiaDAO(TZhuanjiaDAO zhuanjiaDAO)
	{
		this.zhuanjiaDAO = zhuanjiaDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	public TKeshiDAO getKeshiDAO() {
		return keshiDAO;
	}
	public void setKeshiDAO(TKeshiDAO keshiDAO) {
		this.keshiDAO = keshiDAO;
	}
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//系统管理员登陆
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				return "no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             return "yes";
			}
		}
		if(userType==1)
		{
			String sql="from TUser where userName=? and userPw=? and userDel ='no'";
			Object[] con={userName, userPw};
			List userList=userDAO.getHibernateTemplate().find(sql,con);
			
			if(userList.size()==0)
			{
				return "no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TUser user=(TUser)userList.get(0);
				 
				 session.setAttribute("userType", 1);
	             session.setAttribute("user", user);
	             session.setAttribute("rname", user.getUserRealname());
	             
	             return "yes";
			}
		}
		if(userType==2)
		{
			String sql="from TZhuanjia where del='no' and loginname=? and loginpw=?";
			Object[] con={userName,userPw};
			List zhuanjiaList=zhuanjiaDAO.getHibernateTemplate().find(sql,con);
			
			if(zhuanjiaList.size()==0)
			{
				return "no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TZhuanjia zhuanjia=(TZhuanjia)zhuanjiaList.get(0);
				 
				 TUser tUser = userDAO.findById(zhuanjia.getUserId());
				 
				 session.setAttribute("userType", 2);
				 session.setAttribute("zhuanjia", zhuanjia);
	             session.setAttribute("user", tUser);
	             session.setAttribute("rname", zhuanjia.getXingming());
	             return "yes";
			}
		}
		return result;
	}
	
	
	public String userLogout()
	{
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebContext ctx = WebContextFactory.get(); 
		 HttpSession session=ctx.getSession(); 
		 
		 session.setAttribute("userType", null);
	     session.setAttribute("user", null);
	     session.setAttribute("zhuanjia", null);
	     
	     return "yes";
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
    
    public List keshiAll()
    {
    	String sql="from TKeshi where del='no'";
		List keshiList=keshiDAO.getHibernateTemplate().find(sql);
		return keshiList;
    }
}
