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
		<TITLE>回复留言</TITLE>
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
		<!--   留言信息显示    开始 -->
		<DIV align=center>
			<TABLE cellSpacing=1 cellPadding=4 width=750 align=center border=0>
				<TBODY>
					<TR>
						<TD class=unnamed2 colSpan=2 height=20>
							<MARQUEE onmouseover=stop(); onmouseout=start(); scrollAmount=3>
								<B><FONT color=#000099>欢迎您使用&nbsp;留言本&nbsp;</FONT> </B>
							</MARQUEE>
						</TD>
					</TR>
					<TR>
						<TD class=unnamed1 height=20>
							主题: ${amessage.title }
						</TD>
						<TD class=unnamed1 align=right height=20></TD>
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
			<TABLE class=jd_tab style="BORDER-COLLAPSE: collapse" cellSpacing=0
				cellPadding=0 width=750 align=center border=1>
				<TBODY>
					<TR>
						<TD class=jd_tab vAlign=top height=150>
							<TABLE
								style="TABLE-LAYOUT: fixed; WORD-BREAK: break-all; WORD-WRAP: break-word"
								height=20 cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TBODY>
									<TR>
										<TD class=jd_title style="WORD-BREAK: break-all">
											&nbsp; ※&nbsp;
											<B> ${amessage.title } </B>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<TABLE
								style="TABLE-LAYOUT: fixed; WORD-BREAK: break-all; WORD-WRAP: break-word"
								cellPadding=3 width="100%" border=0>
								<TBODY>
									<TR>
										<TD style="WORD-BREAK: break-all">
											<DIV class=unnamed2>
												 ${amessage.content }
											</DIV>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD class=jd_tab style="FONT-SIZE: 12px" vAlign=bottom height=18>
							<FONT color=#666666> ${amessage.writer }写于&nbsp; ${amessage.writerDate }&nbsp; &nbsp;</FONT>
						</TD>
					</TR>
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
			<TABLE cellSpacing=1 cellPadding=4 width=750 align=center border=0>
				<TBODY>
					<TR>
						<TD class=unnamed1 align=right height=20></TD>
					</TR>
				</TBODY>
			</TABLE>
			<!-- 留言显示  结束 -->
			<!-- 回复   开始 -->
			<c:forEach items="${revert }" var="re">
			<TABLE cellSpacing=0 cellPadding=0 width=750 align=center border=0>
				<TBODY>
					<TR>
						<TD class=unnamed1 align=left height=5>
							回复内容：
						</TD>
					</TR>
				</TBODY>
			</TABLE>
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
			
			
			
			<TABLE class=jd_tab style="BORDER-COLLAPSE: collapse" cellSpacing=0
				cellPadding=0 width=750 align=center border=1>
				<TBODY>
					<TR>
						<TD class=jd_tab vAlign=top height=150>
						
							<TABLE
								style="TABLE-LAYOUT: fixed; WORD-BREAK: break-all; WORD-WRAP: break-word"
								cellPadding=3 width="100%" border=0>
								<TBODY>
									<TR>
										<TD style="WORD-BREAK: break-all">
											<DIV class=unnamed2>
											 ${re.content }&nbsp;
											</DIV>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD class=jd_tab style="FONT-SIZE: 12px" vAlign=bottom height=18>
							<FONT color=#666666>&nbsp; &nbsp; ${re.writer }写于   2017-7-3 &nbsp;</FONT>
						</TD>
					</TR>
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
			</c:forEach>
			
		
			
			<!-- 回复  结束    -->
			<TABLE cellSpacing=1 cellPadding=4 width=750 align=center border=0>
				<TBODY>
					<TR>
						<TD class=unnamed1 align=right height=20></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE class=jd_tab style="BORDER-COLLAPSE: collapse" height=0
				cellSpacing=0 cellPadding=0 width=750 align=center border=1>
				<TBODY>
					<TR>
						<TD class=jd_titlemu height=25>
							<DIV align=center>
								<STRONG>快 速 回 复 </STRONG>
							</DIV>
						</TD>
					</TR>
					<TR>
						<TD vAlign=top align=middle>
							<FORM name=form onsubmit="" action="/pinghong/showMessageListServlet?action=addMessage&yn=revert&messageID=${amessage.messageID }" method=post>
								<TABLE class=unnamed1 cellSpacing=1 cellPadding=1 width="100%"
									align=center border=0>
									<INPUT type=hidden value=1 name=messageID>
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
		<BR>
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
