package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
    	
	private Integer userId;
	private String userName;
	private String userPw;
	private String userRealname;

	private String userSex;
	private int userAge;
	private String userAddress;
	private String userTel;

	private Integer userYue;
	private String userDel;//no-yes
	
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	
	
	//会员注册
	public String userReg()
	{
		TUser user=new TUser();
		
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		
		user.setUserAge(userAge);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserYue(0);
		user.setUserDel("no");
		
		userDAO.save(user);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "注册成功，请登录");
		return "msg";
	}
	
	
	
	//会员修改个人资料
	public String userEdit()
	{
		TUser user=userDAO.findById(userId);
		
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		
		user.setUserAge(userAge);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		userDAO.attachDirty(user);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功。重新登录后生效");
		return "msg";
	}
	
	
		
	
	//会员管理

	public String userMana()
	{
		String sql="from TUser where userDel ='no'";
		
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	//管理员删除会员
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	public String chongzhi()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		Integer jine=Integer.parseInt(req.getParameter("jine"));
		
		TUser user=userDAO.findById(userId);
		user.setUserYue(user.getUserYue()+jine);
		
		userDAO.attachDirty(user);
		
		req.setAttribute("msg", "重置成功");
		return "msg";
	}
	
	
	
	
	public String userXinxi()
	{
        String sql="from TUser where userId="+userId;
		
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getUserAddress()
	{
		return userAddress;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
	public int getUserAge()
	{
		return userAge;
	}
	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
	public String getUserDel()
	{
		return userDel;
	}



	public void setUserDel(String userDel)
	{
		this.userDel = userDel;
	}



	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPw()
	{
		return userPw;
	}
	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	public String getUserRealname()
	{
		return userRealname;
	}
	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}
	public String getUserSex()
	{
		return userSex;
	}
	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}
	public String getUserTel()
	{
		return userTel;
	}
	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}
	
}
