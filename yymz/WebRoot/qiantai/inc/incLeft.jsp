<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
   String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
	  <meta http-equiv="expires" content="0">    
	  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	  <meta http-equiv="description" content="This is my page">
      
      
      <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
     
      <script type="text/javascript">
            function check()
			{                                                                                         
			     if(document.ThisForm.loginname.value=="")
				 {
				 	alert("请输入账号");
					return false;
				 }
				 if(document.ThisForm.loginpw.value=="")
				 {
				 	alert("请输入密码");
					return false;
				 }
				 document.getElementById("indicator").style.display="block";
				 loginService.login(document.ThisForm.loginname.value,document.ThisForm.loginpw.value,1,callback);
			}
		
			function callback(data)
			{
			    document.getElementById("indicator").style.display="none";
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			    }
			    if(data=="yes")
			    {   
			        alert("登陆成功");
			        var url="<%=path %>/qiantai/default.jsp";
			        window.location.href=url;
			    }
			}
	        
	        
	        
	        function userLogout()
	        {
	            document.getElementById("indicator1").style.display="block";
	            loginService.userLogout(callback1);
	        }
	        function callback1(data)
			{
			    document.getElementById("indicator1").style.display="none";
			    if(data=="no")
			    {
			        alert("系统错误，请联系管理员");
			    }
			    if(data=="yes")
			    {   
			        alert("安全退出系统");
			        var url="<%=path %>/qiantai/default.jsp";
			        window.location.href=url;
			    }
			    
			}
			
			
			function c()
	        {
	           document.form1.submit();
	        }
	        
	        
	        
	       var i=0;
           function keshiAll()
           {
               if(i==0)
               {
                   document.getElementById("indicator1").style.display="block";
                   loginService.keshiAll(callback111);
                   i=1;
               }
               
           }
           function callback111(data)
           {
               document.getElementById("indicator1").style.display="none";
               DWRUtil.addOptions("keshiId",data,"keshiId","keshiAnme");
           }
           
           
           function gerenzhuye()
			{
			    var targetWinUrl="<%=path %>/admin/index.jsp";
				var targetWinName="newWin";
				var features="width="+screen.width+" ,height="+screen.height+" ,toolbar=yes, top=0, left=0, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes";
				var new_win=window.open(targetWinUrl,targetWinName,features);
			}
      </script>
  </head>
  
  <body>
        <TABLE border=0 cellSpacing=0 cellPadding=0>
		        <!--  -->
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>系统公告</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178 align=center height=100%>
		              <TR>
		                <TD width=178 align=center>
		                    <MARQUEE onmouseover=this.stop() onmouseout=this.start() direction=up height=90 width=160 scrollAmount=3 scrollDelay=166 border="0">欢迎大家使用网络预约平台！</MARQUEE>
		                </TD>
		              </TR>
		            </TABLE>
		         </TD>
		        </TR>
		        <tr><td height="20"></td></tr>
		        <!-- -->
		        
		        
		        <!--  -->
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>专家查询</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178 align=center height=100%>
		              <TR>
		                <TD width=178 align=center>
		                     <form action="<%=path %>/zhuanjiaRes.action" name="form1" method="post">
						        <table width="98%" border="0">
									<tr align='center'>
									    <td width="25%" bgcolor="#FFFFFF" align="right">
									               科室：<img id="indicator1" src="<%=path %>/img/loading.gif" style="display:none"/>
									    </td>
									    <td width="75%" bgcolor="#FFFFFF" align="left">
									        <select name="keshiId" id="keshiId" onclick="keshiAll()" style="width: 100px;">
								                
								            </select>
									    </td>
									</tr>
									<tr align='center'>
									    <td width="25%" bgcolor="#FFFFFF" align="right">
									                姓名：
									    </td>
									    <td width="75%" bgcolor="#FFFFFF" align="left">
									        <input type="text" name="xingming" style="width: 100px;"/>
									    </td>
									</tr>
									<tr align='center'>
									    <td width="25%" bgcolor="#FFFFFF" align="right">
									        &nbsp;
									    </td>
									    <td width="75%" bgcolor="#FFFFFF" align="left">
									       <input type="submit" value="提交" />&nbsp; 
									       <input type="reset" value="重置"/>&nbsp;
									    </td>
									</tr>
								 </table>
						     </form>
		                </TD>
		              </TR>
		            </TABLE>
		         </TD>
		        </TR>
		        <tr><td height="1"></td></tr>
		        <!-- -->
		        

		  
		        <TR>
		          <TD class=b vAlign=top>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178>
		              <TR>
				          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
				             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>登录窗口</font>
				          </TD>
				      </TR>
		            </TABLE>
		            <TABLE border=0 cellSpacing=3 cellPadding=3 width=178 height=22>
		              <TR>
		                <TD height=22 vAlign=middle width="100%">
		                    <c:if test="${sessionScope.user==null&&sessionScope.zhuanjia==null}">
		                    <form action="<%=path %>/user?type=userLogin" name="ThisForm" method="post">
							      <table cellspacing="0" cellpadding="0" width="98%" align="center" border="0" height="60">
							          <tr>
							            <td align="center" colspan="2" height="10"></td>
							          </tr>
							          <tr>
							            <td align="right" width="31%" height="30" style="font-size: 11px;">账号：</td>
							            <td align="left" width="69%"><input name="loginname" type="text" style="width: 100px;"/></td>
							          </tr>
							          <tr>
							            <td align="right" height="30" style="font-size: 11px;">密码：</td>
							            <td align="left"><input type="password" style="width: 100px;" name="loginpw"/></td>
							          </tr>
							          <tr>
							            <td align="center" colspan="2" height="10"></td>
							          </tr>
							          <tr>
							            <td align="center" colspan="2" height="30">
							               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							               <input type="button" value="登  录" onclick="check()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
										   &nbsp;
										   <input type="button" value="注  册" onclick="userReg()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
							               &nbsp;
							               <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
							            </td>
							          </tr>
							      </table>
						    </form>
						    </c:if>
						    <c:if test="${sessionScope.user!=null||sessionScope.zhuanjia!=null}">
						        <br/>
						        &nbsp;&nbsp;&nbsp;&nbsp;欢迎您：${sessionScope.rname } &nbsp;&nbsp;&nbsp;&nbsp;
							    <a href="#" onclick="userLogout()" style="color: red">安全退出</a> &nbsp;&nbsp;&nbsp;&nbsp;
							    <img id="indicator1" src="<%=path %>/img/loading.gif" style="display:none"/>
							    <a href="#" onclick="gerenzhuye()" style="color: red">个人中心</a> &nbsp;&nbsp;&nbsp;&nbsp;
							    <br/><br/><br/>
							</c:if>
		                </TD>
		              </TR>
		            </TABLE>
		          </TD>
		        </TR>
		</TABLE> 
		<br/><br/><br/><br/><br/><br/><br/><br/>
  </body>
</html>
