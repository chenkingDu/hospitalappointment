<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script type="text/javascript">
         function userReg()
         {
		     var url="<%=path %>/qiantai/userinfo/userReg.jsp";
		     var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
         }
                  
         function admin()
         {
	         var url="<%=path %>/login.jsp";
	         window.location.href=url;
         } 
         
         function checklog()
         {
         	
         	if(session.getName()=null)
         		alert("请先登录！");
         	else{
         		var url="<%=path %>/qiantai/liuyan/message.jsp";
         		window.location.href=url;
         	}
         	
         	var url="<%=path %>/qiantai/liuyan/message.jsp";
         	window.location.href=url;
         }
      </script>
  </head>
  
  <body>
       <TABLE border=0 cellSpacing=0 cellPadding=0 width=772 height=120 bgColor=#ffffff align=center style="background-image: url('<%=path %>/img/logo.jpg'); background-repeat : repeat-xy">
		  <TR>
		    <TD height=80 width=772 align=center>
			     &nbsp;
		    </TD>
		  </TR>
		</TABLE>
       <TABLE  border=0 cellSpacing=0 cellPadding=0 width=772 align=center style="background-image: url('<%=path %>/img/banner.jpg'); background-repeat : repeat-xy">
		  <TR>
		    <TD style="font-size: 15px;font-weight: 700;PADDING-LEFT: 20px;text-decoration: none;font-family: 微软雅黑;color: black ">
		         <a href="<%=path %>/index.action">医院介绍</A>
		         &nbsp;&nbsp;
		         <a href="<%=path %>/keshiSuoyou.action">科室列表</A>
		         &nbsp;&nbsp;
		         <a href="<%=path %>/zhuanjiaAll.action">专家信息</A>
		         &nbsp;&nbsp;
		         <a href="#" onclick="userReg()" >注册会员</A>
		         &nbsp;&nbsp;
		         <a href="<%=path %>/messageAll.action">留言交流</A>
		    </TD>
		  </TR>
	   </TABLE>
  </body>
</html>
