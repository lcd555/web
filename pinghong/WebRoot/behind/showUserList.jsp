<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<base href="<%=basePath%>">
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>管理人员-管理</title>
		<link rel="stylesheet" type="text/css" href="behind/image/style_admin.css">
		<script type="text/javascript">
			function deleteUser(uid){
				if(confirm("您是否真的要删除该记录？")){
					location.href="/pinghong/showUserListServlet?action=delete&userID="+uid;
				}
			}
		</script>
</head>
<body>
		<table cellspacing="1" cellpadding="4" width="100%"
			class="tableborder" id="table3">
			<form name="form1" action="showUserList.jsp" method="post">
			<tr>
				<td colspan="15" class="header"> 
					用户管理 
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>用户名</b>
				</td>
				<td align="center" class="altbg1">
					<b>身份代码</b>
				</td>
				<td align="center" class="altbg1">
					<b>操作</b>
				</td>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td rowspan="2" align="center" class="altbg2">
						${user.userName }
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<c:if test="${user.status ==1}">
							管理员
						</c:if>
						<c:if test="${user.status ==0}">
							普通用户
						</c:if>
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<c:if test="${user.status ==0}">
							<a href="javascript:deleteUser(${user.userId })">删除</a>
						</c:if>
						<c:if test="${user.status ==0}">
							<a href="/pinghong/showUserListServlet?action=preupdate&userID=${user.userId }">修改</a>
						</c:if>
					</td>
				</tr>
				<tr>
				</tr>
			</c:forEach>
		
			
			</table>
			每页显示<input type="text"  onblur="jump(this.value)" value="${pageSize }"/>条
			<h2>当前显示的是第${ pageNo}页总共有${ maxNo}页</h2>
			<h2><a href="/pinghong/showUserListServlet?action=queryAll&pageSize=${pageSize }&pageNo=1">首页</a>&nbsp;&nbsp;<a href="/pinghong/showUserListServlet?action=queryAll&pageSize=${pageSize }&pageNo=${pageNo-1 }">上一页</a>&nbsp;&nbsp;<a href="/pinghong/showUserListServlet?action=queryAll&pageSize=${pageSize }&pageNo=${pageNo+1 }">下一页</a>&nbsp;&nbsp;<a href="/pinghong/showUserListServlet?action=queryAll&pageSize=${pageSize }&pageNo=${maxNo }">尾页</a></h2>
</body>
</html>