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
</style>
</head>

<script type="text/javascript">
    function checkPage(size, nextp) {
	    if(size < 5){
	    	return;
	    }else{
	    	window.location.href('<%=basePath%>/messageAll.action?p=' + nextp);
	    }
    }
	
	function addCheck() {
        var title = document.getElementById("title").value;
        var content = document.getElementById("content").value;

        if (title == "") {
            alert("主题不能为空!")
            document.getElementById("title").focus();
            return false;
        }
        if (content == "") {
            alert("内容不能为空!")
            document.getElementById("content").focus();
            return false;
        }

    }
    
    function reindex()
		{
			window.parent.location="<%=path %>/qiantai/index.jsp";
		}

</script>
 
<body>
	<div id="main">
	  <div align="center">
	    <h1> 留言列表 </h1>
	  </div>
	  <%
	      response.setCharacterEncoding("utf-8");
          int p = 1;
          ArrayList messageList = (ArrayList) request.getAttribute("list");
          int flag = (Integer) request.getAttribute("flag");
          int prep = p; // 上一页
          int nextp = p; // 下一页
	      if (messageList.size() == 5) {
	         nextp = p + 1;
	      }
	      if (p > 1) {
	         prep = p - 1;
	      }
	      if (!messageList.isEmpty()) {
	         for (int i = 0; i < messageList.size(); i++) {
	              Message message = (Message) messageList.get(i);
	  %>
	  <table width="700" border="1" align="center" cellpadding="2"
	                cellspacing="0">
	    <tr>
	      <td width="131" align="right"> 姓名： </td>
	      <td width="555" align="left"><%=message.getName()%></td>
	    </tr>
	    <tr>
	      <td align="right"> 主题： </td>
	      <td colspan="3" align="left"><a href="<%=basePath%>/respondsDetails.action?messageId=<%=message.getId()%>"><%=message.getTitle()%></td>
	    </tr>
        <div> <span style="float: right; clear: both"> <%=message.getTime()%> </span> 
        	  <span><input type="button" value="删除" onclick="<%=basePath%>/messageDel.action?messageId=<%=message.getId()%>"></span> </div>
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
	                    onclick="window.location.href('<%=basePath%>/messageAll.action?p=<%=prep%>')">
	    &nbsp;
	    <input type="button" value="下一页"
	    				onclick="checkPage('<%=messageList.size() %>', '<%=nextp %>')">
	    &nbsp;
	    <input type="button" value="返回主页"
	    				onclick="reindex()">
	  </div>
      <h1> 我要留言 </h1>
      <div>
      <table>
      <form name="form1" id="form1" onSubmit="javascript: return addCheck()" 
      				action="<%=basePath%>/messageAdd.action" method="post">

	    <tr>
	      <th width="100" align="right">主题： </th>&nbsp;
	      <td><input name="title" type="text" class="input1"></td>
	    </tr>
	    <tr>
	      <th width="100" align="right"><span class="STYLE1">留言</span>： </th>&nbsp;
	      <td ><textarea name="content" id="content" cols="100" rows="10"></textarea></td>
	    </tr>
	    <tr>
	      <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="提交留言">
	        &nbsp;

	        &nbsp;
	        <input type="reset" name="reset" id="reset" value="重新填写" class="mybutton">
	        <input name="action" type="hidden" id="check" value="add"></td>
	    </tr>
	  </form>
      </table>
      </div>
	</div>
</body>
</html>