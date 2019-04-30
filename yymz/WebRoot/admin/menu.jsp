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
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   

	<STYLE type=text/css>
		BODY {PADDING-RIGHT: 0px; PADDING-LEFT: 5px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px; BACKGROUND-COLOR: #2a8dc8}
		BODY {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		TD {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		DIV {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		P {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		.mainMenu {FONT-WEIGHT: bold; FONT-SIZE: 18px; CURSOR: hand; COLOR: #000000;font-weight: 700;font-family: 楷体;}
		A.style2:link {PADDING-LEFT: 4px; COLOR: #0055bb; TEXT-DECORATION: none;font-family: 楷体;font-size: 14px;}
		A.style2:visited {PADDING-LEFT: 4px; COLOR: #0055bb; TEXT-DECORATION: none;font-family: 楷体;font-size: 14px;}
		A.style2:hover {PADDING-LEFT: 4px; COLOR: #ff0000; TEXT-DECORATION: none;font-family: 楷体;font-size: 14px;}
		A.active {PADDING-LEFT: 4px; COLOR: #ff0000; TEXT-DECORATION: none;font-family: 楷体;font-size: 14px;}
		.span {COLOR: #ff0000;font-family:"宋体";font-size: 15px;}
	</STYLE>

    <script type="text/javascript">
	    function logout()
		{
		   if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path %>/qiantai/index.action";
		   }
		}
		function tomain()
		{
			window.parent.location="<%=path %>/qiantai/index.action";
		}
		function reindex()
		{
			window.parent.location="<%=path %>/qiantai/index.jsp";
		}

	</script>
  </head>
  
  
  
<body>
 
<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
  <TR>
    <TD width=15><IMG src="<%=path %>/img/new_005.jpg" border=0></TD>
    <TD align=middle width=180 background=<%=path %>/img/new_006.jpg height=35><B></B> </TD>
    <TD width=15><IMG src="<%=path %>/img/new_007.jpg" border=0></TD>
  </TR>
</TABLE>





<c:if test="${sessionScope.userType==0}">
<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
  <TR>
    <TD width=15 background=<%=path %>/img/new_008.jpg></TD>
    <TD vAlign=top width=180 bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=3 width=165 align=center border=0>
        <!--  -->
        <!-- <TR><TD class=mainMenu>系统导航菜单</TD></TR> -->
        <TR>
          <TD>
            <TABLE cellSpacing=5 cellPadding=5 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/admin/userinfo/userPw.jsp" target=dmMain>－ 修改个人密码</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/jieshaoMana.action" target=dmMain>－ 医院介绍管理</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/keshiMana.action" target=dmMain>－ 科室信息管理</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/admin/keshi/keshiAdd.jsp" target=dmMain>－ 添加科室信息</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/zhuanjiaMana.action" target=dmMain>－ 专家信息管理</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/admin/zhuanjia/zhuanjiaAdd.jsp" target=dmMain>－ 添加专家信息</A></TD></TR>
			  <TR><TD class=menuSmall><A class=style2 href="<%=path %>/userMana.action" target=dmMain>－ 会员信息管理</A></TD></TR>
			  <TR><TD class=menuSmall><A class=style2 href="<%=path %>/yaopinMana.action" target=dmMain>－ 药品信息管理</A></TD></TR>
			  <TR><TD class=menuSmall><A class=style2 href="<%=path %>/admin/yaopin/yaopinAdd.jsp" target=dmMain>－ 添加药品信息</A></TD></TR>
			  <TR><TD class=menuSmall><A class=style2 href="<%=path %>/qiantai/liuyan/messageAll.action" target=dmMain>－ 留言板管理</A></TD></TR>
			  <TR><TD class=menuSmall><A class=style2 href="#" onclick="tomain()">－ 返回主页面</A></TD></TR>
			  <TR><TD class=menuSmall><A class=style2 onclick="logout()" style="font-family: 楷体;font-size: 14px;margin-left: 4px;"> －  安全退出系统</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
        
        
       
        
         
        
      </TABLE>
    </TD>
    <TD width=15 background=<%=path %>/img/new_009.jpg></TD></TR>
</TABLE>
</c:if>





<c:if test="${sessionScope.userType==1}">
<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
  <TR>
    <TD width=15 background=<%=path %>/img/new_008.jpg></TD>
    <TD vAlign=top width=180 bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=3 width=165 align=center border=0>
        <!--  -->
        <!-- <TR><TD class=mainMenu>系统导航菜单</TD></TR> -->
        <TR>
          <TD>
            <TABLE cellSpacing=5 cellPadding=5 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/myMessage.action?nameId=${sessionScope.user.userId}" target=dmMain>－ 我的留言贴</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/guahaoMana_user.action" target=dmMain>－ 我的预约信息</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/admin/userinfo/userXinxi.jsp" target=dmMain>－ 修改我的信息</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
      </TABLE>
    </TD>
    <TD width=15 background=<%=path %>/img/new_009.jpg></TD></TR>
</TABLE>
</c:if>











<c:if test="${sessionScope.userType==2}">
<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
  <TR>
    <TD width=15 background=<%=path %>/img/new_008.jpg></TD>
    <TD vAlign=top width=180 bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=3 width=165 align=center border=0>
        <!--  -->
        <!-- <TR><TD class=mainMenu>系统导航菜单</TD></TR> -->
        <TR>
          <TD>
            <TABLE cellSpacing=5 cellPadding=5 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/guahaoMana_zhuanjia.action" target=dmMain>－ 我的预约信息</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/myMessage.action?nameId=${sessionScope.zhuanjia.userId}" target=dmMain>－ 我的留言帖</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="#" onclick="reindex()">－ 返回主页面</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 onclick="logout()" style="font-family: 楷体;font-size: 14px;margin-left: 4px;"> －  安全退出系统</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
       
      </TABLE>
    </TD>
    <TD width=15 background=<%=path %>/img/new_009.jpg></TD></TR>
</TABLE>
</c:if>
<script type='text/javascript' src='<%=path %>/jquery/jquery-1.2.6.js'></script>

</body>
</html>
