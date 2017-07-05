<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>管理人员-管理</title>
		<link rel="stylesheet" type="text/css" href="behind/image/style_admin.css">
		<script type="text/javascript">
			function deleteUser(uid){
				if(confirm("您是否真的要删除该记录？")){
					location.href="/pinghong/showNewsListServlet?action=delete&newsID="+uid;
				}
			}
		</script>
</head>
<body >
		<table cellspacing="1" cellpadding="4" width="100%"
			class="tableborder" id="table3">
			<form name="form1" action="manageNews.jsp" method="post">
			<tr>
				<td colspan="15" class="header">
					新闻管理
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>新闻标题</b>
				</td>
				<td align="center" class="altbg1">
					<b>新闻发布时间</b>
				</td>
				<td align="center" class="altbg1">
					<b>删除</b>
				</td>
			</tr>
			
			<c:forEach items="${news}" var="news">
			
				<tr>
					<td rowspan="2" align="center" class="altbg2">
						  ${news.title}
					</td>
					<td class="altbg2" rowspan="2" align="center">
						   12
					</td>
					<td class="altbg2" rowspan="2" align="center">
						
							<a href="javascript:deleteUser(${news.newsID} )">删除</a>
							<a href="/pinghong/showNewsListServlet?action=update&newsID=${news.newsID }">修改</a>
					</td>
				</tr>
				<tr></tr>
			</c:forEach>
			
			
			
			
			</table>
			<h2><a href="/pinghong/showNewsListServlet?action=queryAll&pageSize=${pageSize }&pageNo=1">首页</a>
			&nbsp;&nbsp;<a href="/pinghong/showNewsListServlet?action=queryAll&pageSize=${pageSize }&pageNo=${pageNo-1 }">上一页</a>
			&nbsp;&nbsp;<a href="/pinghong/showNewsListServlet?action=queryAll&pageSize=${pageSize }&pageNo=${pageNo+1 }">下一页</a>&nbsp;&nbsp;
			<a href="/pinghong/showNewsListServlet?action=queryAll&pageSize=${pageSize }&pageNo=${maxNo }">尾页</a></h2>
</body>
</html>