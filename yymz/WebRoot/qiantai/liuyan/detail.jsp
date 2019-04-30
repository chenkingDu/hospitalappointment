<%@page import="com.dto.RespondsDto"%>
<%@page import="com.model.Responds"%>
<%@ page language="java" import="java.util.*,com.model.Message" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看留言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
.line {
    border-bottom-width: 1px;
    border-bottom-style: dashed;
    border-bottom-color: #666;
    height: 10px;
}
body {
    margin-right: auto;
    margin-left: auto;
    text-align: center;
    max-width: 960px;
}
#main {
    border: 3px solid #999;
    background-color: #f5f5f5;
    padding: 1px;
    margin-right: auto;
    margin-left: auto;
    width: 960px;
}
#main table tr td {
    white-space: normal;
}
.footer{
height: 100px;
width: 100%;
position: fixed;
bottom: 0;
}
.dikong{
height: 50px;
}
</style>
</head>

<script type="text/javascript">
    function checkPage(size, nextp, messageId) {
	    if(size < 5){
	    	return;
	    }else{
	    	window.location.href('<%=basePath%>/respondsDetails.action?p=' + nextp + '&messageId=' + messageId);
	    }
    }    

</script>
 
<body>
	<div id="main">
	  <div align="center">
	    <h1> 留言详情 </h1>
	  </div>
	  <%
	  	Message message = (Message) request.getAttribute("message");
	  %>
      <table width="700" border="1" align="center" cellpadding="2"
	                cellspacing="0">
	    <tr>
	      <td width="131" align="right"> 姓名： </td>
	      <td width="555" align="left"><%=message.getName() %></td>
	    </tr>
	    <tr>
	      <td align="right"> 主题： </td>
	      <td colspan="3" align="left"><%=message.getTitle() %></td>
	    </tr>
	    <tr>
	      <td align="right"><span class="STYLE1">内容</span>： </td>
	      <td colspan="3" align="left"><%=message.getContent() %></td>
	    </tr>
	    <div> <span style="float: right; clear: both"> <%=message.getTime()%> </span>
	  </table>
      	  <h1> 回复列表 </h1>
	  <%
	      response.setCharacterEncoding("utf-8");
          int p = 1;
          List<RespondsDto> respondsList = (List) request.getAttribute("list");
          int flag = (Integer) request.getAttribute("flag");
          int prep = p; // 上一页
          int nextp = p; // 下一页
	      if (respondsList.size() == 5) {
	         nextp = p + 1;
	      }
	      if (p > 1) {
	         prep = p - 1;
	      }
	      if (!respondsList.isEmpty()) {
	         for (int i = 0; i < respondsList.size(); i++) {
	              RespondsDto respondsDto = (RespondsDto) respondsList.get(i);
	  %>

	  <table width="700" border="1" align="center" cellpadding="2"
	                cellspacing="0">
	    <tr>
	      <td width="131" align="right"> 姓名： </td>
	      <td width="555" align="left"><%=respondsDto.getUserName()%></td>
	    </tr>
	    <tr>
	      <td align="right"><span class="STYLE1">回复内容</span>： </td>
	      <td colspan="3" align="left"><%=respondsDto.getRespond()%></td>
	    </tr>
        <div> <span style="float: right; clear: both"> <%=respondsDto.getTime()%> </span> <span><%=flag + i + 1%>楼</span> </div>
	  </table>
	  <br>
	  <div class="line"> </div>
	  <br>
	  
 	  <%
 	  				}
                } else {
                    out.print("<br><br>没有了!<br><br>");
                }
	  %> 
	  <div align="center">
	    <input type="button" value="上一页"
	                    onclick="window.location.href('<%=basePath%>/respondsDetails.action?p=<%=prep%>&messageId=<%=message.getId() %>')">
	    &nbsp;
	    <input type="button" value="下一页"
	    				onclick="checkPage('<%=respondsList.size() %>', '<%=nextp %>', '<%=message.getId() %>')">
	    &nbsp;
	    <input type="button" value="返回"
	                    onclick="window.location.href('<%=basePath%>/messageAll.action')">
	  </div>
	  <br>
	  	<div class="line"> </div>
	  <br>
		<form name="form1" method="post" action="<%=basePath%>/respondsAdd.action">
	      <div>
		    <textarea name="respond" id="reply2" cols="100" rows="10"></textarea>
	      </div>
	      <div>
	        <input type="submit" value="回复">
	      </div>
		</form>
	 </div>
    
<div class="dikong">
</div>
</body>
</html>