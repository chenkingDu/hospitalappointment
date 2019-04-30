<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
            function jiuzhenMana(guahaoId)
            {
                var url="<%=path %>/jiuzhenMana.action?guahaoId="+guahaoId;
                window.location.href=url;
                
            }
            function jiuzhenAdd(guahaoId)
            {
                //var url="<%=path %>/admin/jiuzhen/jiuzhenAdd.jsp?guahaoId="+guahaoId;
                //window.location.href=url;
                
                var strUrl = "<%=path %>/admin/jiuzhen/jiuzhenAdd.jsp?guahaoId="+guahaoId;
                var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
            }
            
            
            function guahaoChuli(id)
            {
                var url="<%=path %>/admin/guahao/guahaoChuli.jsp?id="+id;
                window.location.href=url;
            }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<c:forEach items="${requestScope.guahaoList}" var="guahao" varStatus="sta">
		               <fieldset style="width:95%; margin-left:5px;"><legend class="fieldtitle"></legend>
							<form action="<%=path %>/guahaoDel.action" name="111" method="post">
							<table class="bill" width="97%" cellpadding="3" cellspacing="3">
							    <tr>
							        <td>预约时间：${guahao.riqi}</td>
							    </tr>
							    <tr>
							        <td>疾病描述：${guahao.jibing}</td>
							    </tr>
							    <tr>
							        <td>患者信息：姓名：${guahao.xingming}       性别：${guahao.sex}       年龄：${guahao.age}</td>
							    </tr>
							    <tr>
							        <td>联系方式：${guahao.lianxi}</td>
							    </tr>
							    <tr>
							        <td>
							                              状态：${guahao.zt}
							          &nbsp;
							          <c:if test="${guahao.zt=='待处理'}">
							          <a style="color: red" href="#" onclick="guahaoChuli(${guahao.id})">预约设置</a>
							          </c:if>
							          
							          <c:if test="${guahao.zt=='预约成功'}">
							          <a style="color: red" href="#" onclick="jiuzhenAdd(${guahao.id})">添加就诊</a>
							          <a style="color: red" href="#" onclick="jiuzhenMana(${guahao.id})">就诊管理</a>
							          </c:if>
							          
							        </td>
							    </tr>
							    <tr>
							        <td>回复信息：${guahao.huifu}</td>
							    </tr>
							</table>
							</form>
					   </fieldset>
					   <br/>
					   </c:forEach>
	</body>
</html>
