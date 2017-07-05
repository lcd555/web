<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>回复留言</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META content=留言本 name=description>
		<LINK href="image/jd100.css" type=text/css rel=stylesheet>
		<META content="MSHTML 6.00.2900.5726" name=GENERATOR>
	</HEAD>
	<BODY leftMargin=0 background=image/bookbg.gif topMargin=3>
		<DIV align=center>
			<IMG src="image/welcome.jpg">
		</DIV>
		<!--   留言信息显示    开始 -->
		<DIV align=center>
			<DIV style="WIDTH: 750px" align=center>
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
				<DIV align=left>
					<TABLE height=20 cellSpacing=0 cellPadding=0 width=% border=0>
						<TBODY>
							<TR>
								<TD width=11 background=image/titlemu_1.gif></TD>
								<TD width=* background=image/titlemu_2.gif>
									<DIV align=center>
										<A class=jdmenu
											href="messageBoard.jsp"><B>留言</B>
										</A>
									</DIV>
								</TD>
								<TD width=12 background=image/titlemu_3.gif></TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>
			</DIV>
			<TABLE class=jd_tab style="BORDER-COLLAPSE: collapse" height=0
				cellSpacing=0 cellPadding=0 width=750 align=center border=1>
				<TBODY>
					<TR>
						<TD class=jd_titlemu height=25>
							<DIV align=center>
								<STRONG>新 留 言 </STRONG>
							</DIV>
						</TD>
					</TR>
					<TR>
						<TD vAlign=top align=middle>
							<FORM name=form onsubmit="" action="/pinghong/showMessageListServlet?action=addMessage&yn=message" method=post>
								<TABLE class=unnamed1 cellSpacing=1 cellPadding=1 width="100%"
									align=center border=0>
									<TBODY>
										<TR>
											<TD align=right width=86>
												姓名：
											</TD>
											<TD width=577>
												<INPUT class=input1 maxLength=10 name=writer>
												<FONT color=#ff0000>*</FONT>
											</TD>
										</TR>
										<TR>
											<TD align=right>
												标题：
											</TD>
											<TD>
												<INPUT class=input1 maxLength=50 size=30 name=title>
											</TD>
										</TR>
										<TR>
											<TD vAlign=top align=right>
												内容：
											</TD>
											<TD>
												<TEXTAREA class=input1 name=content rows=6 cols=80></TEXTAREA>
												<BR>
												&nbsp;&nbsp;
												<INPUT type=submit value=" 提 交 " name=Submit>
												&nbsp;
												<BR>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</FORM>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</DIV>
	</BODY>
</HTML>
