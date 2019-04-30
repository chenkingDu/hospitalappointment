<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.model.TJiuzhen"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %> 
<%
    String path = request.getContextPath();
    String binglihao="";
    List jiuzhenList=(List)request.getAttribute("jiuzhenList");
    for(int i=0;i<jiuzhenList.size();i++)
    {
        TJiuzhen jiuzhen=(TJiuzhen)jiuzhenList.get(i);
        binglihao=jiuzhen.getBinglihao();
    }
    
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
		
        <script language="javascript">
           function jiuzhenDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/jiuzhenDel.action?id="+id;
               }
           }
           
           
           function yongyaoAdd(jiuzhenId)
           {
               var strUrl = "<%=path %>/admin/yongyao/yongyaoAdd.jsp?jiuzhenId="+jiuzhenId;
               //window.location.href=strUrl;
               var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
               window.location.reload(true);
           }
       </script>
	</head>

	<body leftmargin="8" topmargin="8" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="10%">病历号</td>
					<td width="10%">病情</td>
					<td width="10%">诊断</td>
					
					<td width="10%">时间</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.jiuzhenList" id="jiuzhen" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiuzhen.binglihao"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiuzhen.bingqing"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiuzhen.zhenduan"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiuzhen.shijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" style="width: 70px;" onclick="jiuzhenDel(<s:property value="#jiuzhen.id"/>)"/>
						<input type="button" value="开药" style="width: 70px;" onclick="yongyaoAdd(<s:property value="#jiuzhen.id"/>)" />
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<br/>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="<%=path %>/img/tbg.gif" style="color: red">&nbsp;开药列表&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="19%">药品名称</td>
					<td width="10%">数量</td>
					<td width="10%">单价</td>
					
					<td width="10%">总价</td>
		        </tr>	
				<c:forEach items="${requestScope.jiuzhen.yongyaoList}" var="yongyao" varStatus="ssss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ssss.index+1 }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yongyao.yaopin.mingcheng }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yongyao.shuliang }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yongyao.danjia }
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
						${yongyao.zongjia }
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
