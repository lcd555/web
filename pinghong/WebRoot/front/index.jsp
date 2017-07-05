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
<TITLE>品红公司</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="front/image/css.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="include/js/jquery.min.js"></script>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>

<META content="MSHTML 6.00.2900.5726" name=GENERATOR>
</HEAD>
<BODY style="background:url(front/image/xue.jpg); background-repeat:no-repeat;background-size:cover;">
	<SCRIPT type=text/javascript>
		function openChat() {
			alert("打开");
			window.open("chat/index.jsp", "",
					"left=250   top=200   width=500   height=400");
		}
	function g(){
		alert("1223");
		location.href="/pinghong/showNewsListServlet?action=queryIndexNews";
		}
	</SCRIPT>

	<TABLE cellSpacing=0 cellPadding=0 width=799 align=center border=0>
		<TBODY>
			<TR>
				<TD background=front/image/d.jpg height=3></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width=799 align=center border=0>
		<TBODY>
			<TR>
				<TD><OBJECT title=pinhong
						codeBase=http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0
						height=161 width=799
						classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000>
						<PARAM NAME="movie" VALUE="front/image/2.swf">
						<PARAM NAME="quality" VALUE="high">
						<embed src="front/image/2.swf" quality="high"
							pluginspage="http://www.macromedia.com/go/getflashplayer"
							type="application/x-shockwave-flash" width="799" height="161"></embed>
					</OBJECT></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width=799 align=center border=0>
		<TBODY>
			<TR>
				<TD background=front/image/d.jpg height=3></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width=799 align=center border=0>
		<TBODY>
			<TR>
				<TD><IMG height=40 src="front/image/d_r3_c1.jpg" width=60><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><A
					href="index.jsp"><IMG height=40
						src="front/image/d_r3_c5.jpg" width=64 border=0></A><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><A
					href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG id=image1 height=40
						src="front/image/d_r3_c7.jpg" width=94 border=0 name=image1></A><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><A
					href="front/showNewsList.jsp"><IMG height=40
						src="front/image/d_r3_c8.jpg" width=93 border=0></A><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><A
					onclick=openChat() href="#"><IMG height=40
						src="front/image/d_r3_c9.jpg" width=95 border=0></A><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><A
					href="/pinghong/showMessageListServlet?action=queryAll&adc=front" target=_blank><IMG height=40
						src="front/image/d_r3_c10.jpg" width=93 border=0></A><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><A
					href="front/login.jsp"><IMG height=40 src="front/image/d_r3_c13.jpg"
						width=85 border=0></A><IMG height=40
					src="front/image/top_red.jpg" width=20 border=0><IMG
					height=40 src="front/image/top_red.jpg" width=20 border=0><IMG
					height=40 src="front/image/d_r3_c25.jpg" width=36></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width=799 align=center border=0>
		<TBODY>
			<TR>
				<TD background=front/image/d.jpg height=3></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width=799 align=center border=0>
		<TBODY>
			<TR>
				<TD vAlign=top>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD width=352>
									<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
										<TBODY>
											<TR>
												<TD background=front/image/d02.jpg><IMG height=35
													src="front/image/d_r7_c1.jpg" width=101></TD>
												<TD align=right background=front/image/d02.jpg><IMG
													height=35 src="front/image/d_r7_c14.jpg" width=94></TD>
											</TR>
											<c:forEach items="${n}" var="n">
											<TR>
												<TD colSpan=2 height=26>&nbsp;<A class=dong06
													href="showNewsListServlet?action=queryaNew&newsID=${n.newsID}"> ${n.title} &nbsp;&nbsp;&nbsp;<FONT
														color=#ff0000>[2007-10-07]</FONT></A></TD>
											</TR>
											<TR>
												<TD colSpan=2><IMG height=1 src="front/image/d03.jpg"
													width=352></TD>
											</TR>
											
											</c:forEach>
										
											
											
											<TR>
												<TD align=right colSpan=2><A href="#"><IMG
														height=33 src="front/image/d_r11_c15.jpg" width=51
														border=0></A></TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
								<TD vAlign=top align=right>
									<TABLE cellSpacing=0 cellPadding=0 width=268 border=0>
										<TBODY>
											<TR>
												<TD><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG height=63
														src="front/image/d_r11_5_r1_c1.jpg" width=268 border=0></A></TD>
											</TR>
											<TR>
												<TD><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG height=59
														src="front/image/d_r11_5_r3_c1.jpg" width=268 border=0></A></TD>
											</TR>
											<TR>
												<TD><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG height=61
														src="front/image/d_r11_5_r4_c1.jpg" width=268 border=0></A></TD>
											</TR>
											<TR>
												<TD><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG height=64
														src="front/image/d_r11_5_r5_c1.jpg" width=268 border=0></A></TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD background=front/image/d_r11_8.jpg><IMG height=27
									src="front/image/d_r13_c1.jpg" width=160></TD>
								<TD align=right background=front/image/d_r11_8.jpg><A
									href="#"><IMG height=27 src="front/image/d_r13_c21.jpg"
										width=66 border=0></A></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c1.jpg" width=143
										border=0></A></TD>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c8.jpg" width=142
										border=0></A></TD>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c16.jpg" width=141
										border=0></A></TD>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c22.jpg" width=142
										border=0></A></TD>
							</TR>
							<TR>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c2.jpg" width=143
										border=0></A></TD>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c81.jpg" width=142
										border=0></A></TD>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c116.jpg" width=141
										border=0></A></TD>
								<TD align=middle width="25%"><A href="/pinghong/showProductsListServlet?action=queryAll&adc=front"><IMG
										height=112 src="front/image/d_r11_10_r1_c221.jpg" width=142
										border=0></A></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD width="25%" background=front/image/d_r11_11_r1_c15.jpg><IMG
									height=27 src="front/image/d_r11_11_r1_c1.jpg" width=185></TD>
								<TD width="25%" background=front/image/d_r11_11_r1_c15.jpg>&nbsp;</TD>
								<TD width="25%" background=front/image/d_r11_11_r1_c15.jpg><IMG
									height=27 src="front/image/d_r11_11_r1_c21.jpg" width=160></TD>
								<TD align=right width="25%"
									background=front/image/d_r11_11_r1_c15.jpg><A href="#"><IMG
										height=27 src="front/image/d_r11_11_r1_c30.jpg" width=63
										border=0></A></TD>
							</TR>
							<TR>
								<TD width="50%" bgColor=#fcfcfc colSpan=2>
									<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
										<TBODY>
											<TR>
												<TD width=28 height=29><IMG height=32
													src="front/image/d_r11_12_r1_c1.jpg" width=28></TD>
												<TD class=d06 style="FONT-WEIGHT: bold" align=middle
													width=100>&nbsp;业务专线：</TD>
												<TD class=d06 style="FONT-WEIGHT: bold">010-88888888</TD>
											</TR>
											<TR>
												<TD width=28 height=29><IMG height=32
													src="front/image/d_r11_12_r1_c1.jpg" width=28></TD>
												<TD class=d06 align=middle width=100>&nbsp;<SPAN
													style="FONT-WEIGHT: bold">售后服务：</SPAN></TD>
												<TD class=d06 style="FONT-WEIGHT: bold">010-66666666</TD>
											</TR>
											<TR>
												<TD width=28 height=29><IMG height=32
													src="front/image/d_r11_12_r1_c1.jpg" width=28></TD>
												<TD class=bold align=middle width=100>&nbsp;<SPAN
													class=d06 style="FONT-WEIGHT: bold">传&nbsp;&nbsp;&nbsp;&nbsp;真：</SPAN></TD>
												<TD class=d06 style="FONT-WEIGHT: bold">010-88888888</TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
								<TD width="50%" bgColor=#fcfcfc colSpan=3>
									<TABLE cellSpacing=0 cellPadding=0 width=287 align=center
										border=0>
										<TBODY>
											<TR>
												<TD align=middle width=97 height=47><IMG height=33
													src="front/image/f1.gif" width=90></TD>
												<TD align=middle width=97 height=47><IMG height=33
													src="front/image/f2.gif" width=88></TD>
												<TD align=middle width=97 height=47><IMG height=33
													src="front/image/f3.gif" width=90></TD>
											</TR>
											<TR>
												<TD align=middle width=97 height=47><IMG height=33
													src="front/image/d_r11_13_r6_c13.jpg" width=90></TD>
												<TD align=middle width=97 height=47><IMG height=33
													src="front/image/d_r11_13_r1_c1.jpg" width=90></TD>
												<TD align=middle width=97 height=47><IMG height=33
													src="front/image/d_r11_13_r1_c7.jpg" width=88></TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
				<TD vAlign=top width=175 bgColor=#fcfcfc>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD vAlign=top><A href="cgal.asp"><IMG height=42
										src="front/image/d_r11_6.jpg" width=175 border=0></A></TD>
							</TR>
							<TR>
								<TD height=590>
									<!-- 指向链接图片url -->
									<DIV id=demo
										style="BACKGROUND: #214984; OVERFLOW: hidden; WIDTH: 180px; COLOR: #ffffff; HEIGHT: 600px">
										<DIV id=demo1>
											<!-- 定义图片 -->
											<IMG height=107 src="front/image/d_r11_10_r1_c1.jpg"
												width="100%" align=middle border=0> <IMG height=107
												src="front/image/d_r11_10_r1_c8.jpg" width="100%"
												align=middle border=0> <IMG height=107
												src="front/image/d_r11_10_r1_c16.jpg" width="100%"
												align=middle border=0> <IMG height=107
												src="front/image/d_r11_10_r1_c22.jpg" width="100%"
												align=middle border=0> <IMG height=107
												src="front/image/d_r11_10_r1_c2.jpg" width="100%"
												align=middle border=0> <IMG height=107
												src="front/image/d_r11_10_r1_c81.jpg" width="100%"
												align=middle border=0> <IMG height=107
												src="front/image/d_r11_10_r1_c116.jpg" width="100%"
												align=middle border=0> <IMG height=107
												src="front/image/d_r11_10_r1_c221.jpg" width="100%"
												align=middle border=0>
										</DIV>
										<DIV id=demo2></DIV>
									</DIV> <SCRIPT>
										var speed = 30;
										demo2.innerHTML = demo1.innerHTML;
										demo.scrollTop = demo.scrollHeight;
										function Marquee() {
											if (demo1.offsetTop
													- demo.scrollTop >= 0)
												demo.scrollTop += demo2.offsetHeight;
											else {
												demo.scrollTop--;
											}
										}
										var MyMar = setInterval(Marquee, speed);
										demo.onmouseover = function() {
											clearInterval(MyMar)
										}
										demo.onmouseout = function() {
											MyMar = setInterval(Marquee, speed);
										}
									</SCRIPT>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<LINK href="front/image/css.css" type=text/css rel=stylesheet>
	<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>

	<TABLE cellSpacing=0 cellPadding=0 width=800 align=center border=0>
		<TBODY>
			<TR>
				<TD align=middle width=800 background=front/image/d_r11_15.jpg
					height=29></TD>
			</TR>
		</TBODY>
	</TABLE>
</BODY>
</HTML>

