<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML><HEAD><TITLE>控制面板</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<STYLE type=text/css>.menutitle {
	PADDING-RIGHT: 0px; PADDING-LEFT: 0px; FONT-WEIGHT: bold; BACKGROUND-IMAGE: url(images/menu_1.gif); MARGIN-BOTTOM: 0px; PADDING-BOTTOM: 2px; WIDTH: 158px; CURSOR: pointer; COLOR: #ffffff; PADDING-TOP: 2px; BACKGROUND-COLOR: #698cc3; TEXT-ALIGN: center
}
.submenu {
	MARGIN-BOTTOM: 0em
}
.cn {
	FONT-SIZE: 9pt; COLOR: #006599; FONT-FAMILY: 宋体
}
</STYLE>

<SCRIPT language=javascript type=text/javascript>
if (document.getElementById){ 
document.write('<style type="text/css">\n')
document.write('.submenu{display: none;}\n')
document.write('</style>\n')
}

function SwitchMenu(obj){
	if(document.getElementById){
	var el = document.getElementById(obj);
	var ar = document.getElementById("masterdiv").getElementsByTagName("span"); 
		if(el.style.display != "block"){ 
			for (var i=0; i<ar.length; i++){
				if (ar[i].className=="submenu") 
				ar[i].style.display = "none";
			}
			el.style.display = "block";
		}else{
			el.style.display = "none";
		}
	}
}

function killErrors() {
return true;
}

window.onerror = killErrors;
</SCRIPT>
<LINK href="left.files/style_admin.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY style="BACKGROUND-COLOR: #698cc3" bottomMargin=2 leftMargin=2 topMargin=0 
rightMargin=2>
<DIV id=masterdiv>
<TABLE id=table1 style="BORDER-COLLAPSE: collapse" cellPadding=4 width=158 
border=0>
  <TBODY>
  <TR>
    <TD><FONT color=#ffffff><B>系统后台管理面板</B> </FONT></TD></TR>
  <TR>
  <tr><h1 color="red">当前登陆用户| ${loginName.userName }</h1></tr>
    <TD>
      <P align=center><FONT color=#ffffff>[<A 
      href="adminOut.jsp" 
      target=_parent><FONT color=#ffffff>安全退出</FONT> </A>] [<A 
      href="/pinghong" target=_parent><FONT 
      color=#ffffff>返回首页</FONT> </A>]</FONT> </P></TD></TR></TBODY></TABLE>
<DIV class=menutitle onclick="SwitchMenu('sub1')">.系统管理 
<TABLE cellSpacing=0 cellPadding=0 width=158 border=0>
  <TBODY>
  <TR>
    <TD height=3></TD></TR>
  <TR>
    <TD bgColor=#ffffff height=1></TD></TR></TBODY></TABLE></DIV><SPAN class=submenu 
id=sub1>
<TABLE class=tableborder cellSpacing=1 cellPadding=4 width=158>
  <TBODY>
  <TR class=altbg1>
    <TD align=middle width="100%" bgColor=#d6e0ef height=25>&nbsp;&nbsp; <IMG 
      height=13 src="left.files/icon_arrow_r.gif" width=13 border=0> <A 
      class=menu href="../addManager.jsp" 
      target=main>添加管理员</A> </TD></TR>
  <TR class=altbg1>
    <TD align=middle width="100%" bgColor=#d6e0ef height=25>&nbsp;&nbsp; <IMG 
      height=13 src="left.files/icon_arrow_r.gif" width=13 border=0> <A 
      class=menu href="/pinghong/showUserListServlet?action=queryAll" 
      target=main>用户管理&nbsp;&nbsp;</A> </TD></TR></TBODY></TABLE></SPAN>
<DIV class=menutitle onclick="SwitchMenu('sub8')">.新闻管理 
<TABLE cellSpacing=0 cellPadding=0 width=158 border=0>
  <TBODY>
  <TR>
    <TD height=3></TD></TR>
  <TR>
    <TD bgColor=#ffffff height=1></TD></TR></TBODY></TABLE></DIV><SPAN class=submenu 
id=sub8>
<TABLE cellSpacing=0 cellPadding=0 width=158 background="" border=0>
  <TBODY>
  <TR>
    <TD align=middle width="100%" bgColor=#d6e0ef height=25><IMG height=13 
      src="left.files/icon_arrow_r.gif" width=13 border=0> <A class=menu 
      href="../addNews.jsp" 
      target=main>添加新闻</A> </TD></TR>
  <TR>
    <TD align=middle width="100%" bgColor=#d6e0ef height=25><IMG height=13 
      src="left.files/icon_arrow_r.gif" width=13 border=0> <A class=menu 
      href="/pinghong/showNewsListServlet?action=queryAll" 
      target=main>管理新闻</A> </TD></TR></TBODY></TABLE></SPAN>
<DIV class=menutitle onclick="SwitchMenu('sub3')">.商品管理 
<TABLE cellSpacing=0 cellPadding=0 width=158 border=0>
  <TBODY>
  <TR>
    <TD height=3></TD></TR>
  <TR>
    <TD bgColor=#ffffff height=1></TD></TR></TBODY></TABLE></DIV><SPAN class=submenu 
id=sub3>
<TABLE cellSpacing=0 cellPadding=0 width=158 background="" border=0>
  <TBODY>
  <TR>
    <TD align=middle width="100%" bgColor=#d6e0ef height=25><IMG height=13 
      src="left.files/icon_arrow_r.gif" width=13 border=0> <A class=menu 
      href="../addProduct.jsp" 
      target=main>添加商品</A> </TD></TR>
  <TR>
    <TD align=middle width="100%" bgColor=#d6e0ef height=25><IMG height=13 
      src="left.files/icon_arrow_r.gif" width=13 border=0> <A class=menu 
      href="/pinghong/showProductsListServlet?action=queryAll&adc=bed" 
      target=main>管理商品</A> </TD></TR></TBODY></TABLE></SPAN></DIV></BODY></HTML>
