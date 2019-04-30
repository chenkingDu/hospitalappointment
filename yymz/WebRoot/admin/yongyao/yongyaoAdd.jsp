<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script language="javascript">
			function check()
			{
				if(document.formAdd.yaopinId.value == "")
				{
					alert("请选择药品");
					return false;
				}
				
				return true;
			}
			
			function yaopinSelect()
	        {
	             var strUrl = "<%=path %>/yaopinSelect.action";
                 var ret = window.showModalDialog(strUrl,"","dialogWidth:900px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
                 
                 document.getElementById("yaopinId").value=ret[0];
                 document.getElementById("xxx").value=ret[1];
	        }
        </script>
	</head>

	<body leftmargin="9" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/yongyaoAdd.action" name="formAdd" method="post">
				     <table width="98%" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>&nbsp;</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						                 药品：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="xxx" id="xxx" size="50" readonly="readonly"/>
						        <input type="hidden" name="yaopinId" id="yaopinId" size="60"/>
						        <input type="button" value="选择" onclick="yaopinSelect()"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						          数量：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="shuliang" size="50" value="1" 
						         onkeyup="value=value.replace(/[^\d]/g,'') " 
						         onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="center">
						        &nbsp;
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="jiuzhenId" value="<%=request.getParameter("jiuzhenId") %>"/>
						       <input type="submit" value="提交" onclick="return check();"/> 
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
