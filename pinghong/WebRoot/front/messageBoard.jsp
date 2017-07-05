<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>留言本</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META content=留言本 name=description>
		<LINK href="image/jd100.css" type=text/css rel=stylesheet>
		<META content="MSHTML 6.00.2900.5726" name=GENERATOR>
	</HEAD>
	<BODY leftMargin=0 background=image/bookbg.gif topMargin=3
		marginheight="0" marginwidth="0">
		<DIV align=center>
			<IMG src="image/welcome.jpg">
		</DIV>
		<DIV align=center>
			<TABLE cellSpacing=1 cellPadding=4 width=750 align=center border=0>
				<TBODY>
					<TR>
						<TD class=unnamed2 align=right colSpan=2 height=20>
							<MARQUEE onmouseover=stop(); onmouseout=start(); scrollAmount=3>
								<B><FONT color=#000099>欢迎您使用&nbsp;留言本&nbsp;</FONT> </B>
							</MARQUEE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<DIV style="WIDTH: 750px" align=center>
				<DIV align=left>
					<TABLE height=20 cellSpacing=0 cellPadding=0 width=% border=0>
						<TBODY>
							<TR>
								<TD width=11 background=image/titlemu_1.gif></TD>
								<TD width=* background=image/titlemu_2.gif>
									<DIV align=center>
										<A class=jdmenu
											href="newMessage.jsp"><B>新留言</B>
										</A>
									</DIV>
								</TD>
								<TD width=12 background=image/titlemu_3.gif></TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>
			</DIV>
			<FORM name=form onsubmit=submitonce(this) action=index.asp
				method=post>
				<TABLE style="BORDER-COLLAPSE: collapse" borderColor=#111111
					cellSpacing=0 cellPadding=0 width=750 align=center border=0>
					<TBODY>
						<TR>
							<TD width="2%">
								<IMG src="image/T_left.gif" border=0>
							</TD>
							<TD width="96%" background=image/Tt_bg.gif></TD>
							<TD width="2%">
								<IMG src="image/T_right.gif" border=0>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<TABLE class=jd_tab
					style="BORDER-COLLAPSE: collapse; WORD-WRAP: break-word" height=51
					cellSpacing=0 cellPadding=3 width=750 align=center border=1>
					<TBODY>
						<TR class=jd_titlemu>
							<TD class=jd_tab width="5%">
								<DIV align=center>
									回复
								</DIV>
							</TD>
							<TD class=jd_tab width="50%">
								<DIV align=center>
									标题
								</DIV>
							</TD>
							<TD class=jd_tab width="20%">
								<DIV align=center>
									作者
								</DIV>
							</TD>
							<TD class=jd_tab width="25%">
								<DIV align=center>
									时间
								</DIV>
							</TD>
						</TR>
						<c:forEach items="${messageList}" var="ml">
						<TR class=unnamed1>
							<TD class=jd_tab vAlign=top align=middle width="6%" height=25>
								1
							</TD>
							<TD class=jd_tab vAlign=top align=left width="53%" height=25>
								<A
									href="/pinghong/showMessageListServlet?action=queryaMessage&messageID=${ml.messageID }"><IMG
										src="image/jd-to.gif" border=0>&nbsp;  ${ml.title }</A>
							</TD>
							<TD class=jd_tab vAlign=top align=middle width="20%" height=25>
								<FONT color=#666666> ${ml.writer }</FONT>
							</TD>
							<TD class=jd_tab vAlign=top align=left width="14%" height=25>
								<FONT color=#666666> ${ml.writerDate } </FONT>
							</TD>
						</TR>
						</c:forEach>
					</TBODY>
				</TABLE>
				<TABLE style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0
					width=750 align=center border=0>
					<TBODY>
						<TR>
							<TD>
								<IMG src="image/T_bottomleft.gif" border=0>
							</TD>
							<TD width="100%" background=image/T_bottombg.gif></TD>
							<TD>
								<IMG src="image/T_bottomright.gif" border=0>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=10 align=center border=0>
					<TBODY>
						<TR>
							<TD height=5></TD>
						</TR>
					</TBODY>
				</TABLE>
			</FORM>
		</DIV>
		</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
		</br></br></br></br></br></br></br></br></br></br></br></br>
		</br></br></br></br></br>
		</br></br></br>
		</br></br>
		</br></br>
		</br>
		</br></br></br>
		</br>
	</BODY>
</HTML>
