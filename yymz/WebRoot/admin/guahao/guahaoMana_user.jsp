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
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css"></link>
	<style type="text/css">
    </style>
      
      <script type="text/javascript">
           function jiuzhenChaxun(guahaoId)
           {
               var url="<%=path %>/jiuzhenChaxun.action?guahaoId="+guahaoId;
               window.location.href=url;
           }
      </script>
  </head>
  
  <BODY leftMargin=0 topMargin=0 bgColor=#ffffff>
        
		      <TABLE border=0 cellSpacing=0 cellPadding=2 width=590 align=left height=133>
		        <TR>
		          <TD height=129 vAlign=top align=left>
		               <c:forEach items="${requestScope.guahaoList}" var="guahao" varStatus="sta">
		               <fieldset style="width:95%; margin-left:5px;"><legend class="fieldtitle"></legend>
							<form action="<%=path %>/guahaoDel.action" name="111" method="post">
							<table class="bill" width="97%" cellpadding="3" cellspacing="3">
							    <tr>
							        <td>预约专家：${guahao.zhuanjia.xingming}</td>
							    </tr>
							    <tr>
							        <td>预约时间：${guahao.riqi}</td>
							    </tr>
							    <tr>
							        <td>病症：${guahao.jibing}</td>
							    </tr>
							    <tr>
							        <td>你的信息：姓名：${guahao.xingming}   性别：${guahao.sex}   年龄：${guahao.age}</td>
							    </tr>
							    <tr>
							        <td style="color: red">
							                                     状态：${guahao.zt}
							        </td>
							    </tr>
							    <tr>
							        <td>
							                                    回复信息：${guahao.huifu}
							        </td>
							    </tr>
							    <tr>
							        <td>
							            <input type="hidden" name="id" value="${guahao.id}">
							            <!-- <input type="submit" value="取消预约" style="width: 80px;"/> -->
							            <a style="color: red"  onclick="jiuzhenChaxun(${guahao.id})">查看诊断信息</a>
							        </td>
							    </tr>
							</table>
							</form>
					   </fieldset>
					   <br/>
					   </c:forEach>
		          </TD>
		        </TR>
		      </TABLE>
		   
  </BODY>
</html>
