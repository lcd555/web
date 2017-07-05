<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML><HEAD><TITLE>管理首页</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8"><LINK 
href="behind/image/style_admin.css" type=text/css rel=stylesheet>
<SCRIPT>
function mfk()
{
   if(shang.style.display=='none')
    {
     shang.style.display='';
    }
   else
   {
     shang.style.display='none';
   }
}
</SCRIPT>

 
<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY leftMargin=0 topMargin=0 scroll=no>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" align=center 
border=0>
  <TBODY>
  <TR>
    <TD id=shang width=162 height="100%"><IFRAME id=left name=left 
      src="<%=basePath%>behind/image/left.jsp" frameBorder=0 width=162 height="100%" 
      target="main">
					</IFRAME></TD>
    <TD class=unnamed1 onclick=mfk(); align=middle height="100%">
      <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD bgColor=#3a5f94><FONT color=#ffffff>点此切换</FONT> 
      </TD></TR></TBODY></TABLE></TD>
    <TD width="100%" height="100%"><IFRAME id=main name=main 
      src="<%=basePath%>behind/image/right.jsp" frameBorder=0 width="100%" scrolling=yes 
      height="100%"></IFRAME></TD></TR></TBODY></TABLE></BODY></HTML>