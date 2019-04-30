package com.interceptor;

import java.util.Map;

import javax.faces.application.Application;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		ActionContext ctx = ActionContext.getContext();
		Map session=ctx.getSession(); 
		TUser tUser = (TUser) session.get("user");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String uri = request.getRequestURI();
		System.out.println(uri);
		
//		if(!uri.contains("jieshaoShow") 
//				&& !uri.contains("index") 
//				&& !uri.contains("messageAll") 
//				&& !uri.contains("zhuanjiaAll") 
//				&& !uri.contains("keshiSuoyou") 
//				&& !uri.contains("zhuanjiaDetailQian") 
//				&& tUser == null){
//			request.setAttribute("msg", "Äú»¹Î´µÇÂ¼£¡");
//			return "msg";
//		}
		
		return invocation.invoke();
	}
}
