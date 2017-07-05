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
			function deleteUser(id){
				if(confirm("您是否真的要删除该记录？")){
					location.href="/pinghong/showProductsListServlet?adc=bed&action=delete&productID="+id;
				}
			}
		</script>
</head>
<body>
		<table cellspacing="1" cellpadding="4" width="100%"
			class="tableborder" id="table3">
			<form name="form1" action="manageProduct.jsp" method="post">
			<tr>
				<td colspan="15" class="header">
					商品管理
				</td>
			</tr>
			<tr>
			<td align="center">
			serialnunber
			</td>
			<td align="center">
			name
			</td>
			<td align="center">
			brand
			</td>
			<td align="center">
			model
			</td>
			<td align="center">
			price
			</td>
			<td align="center">
			picture
			</td>
			<td align="center">
			description
			</td>
			<td align="center">操作</td>
			</tr>
			
			<c:forEach items="${list}" var="pro">
			
				<tr>
				<td class="altbg2" rowspan="2" align="center">
						   ${pro.serialNumber}
					</td>
					<td rowspan="2" align="center" class="altbg2">
						  ${pro.name}
					</td>
					<td class="altbg2" rowspan="2" align="center">
						   ${pro.brand}
					</td>
					<td class="altbg2" rowspan="2" align="center">
						   ${pro.model}
					</td>
					
					<td class="altbg2" rowspan="2" align="center">
						   ${pro.price}
					</td>
					<td class="altbg2" rowspan="2" align="center">
						   ${pro.picture}
					</td>
					<td class="altbg2" rowspan="2" align="center">
						   ${pro.description}
					</td>
					
					<td class="altbg2" rowspan="2" align="center">s
						
							<a href="javascript:deleteUser(${pro.productId})">删除</a>
							&nbsp;
							<a href="/pinghong/showProductsListServlet?action=update&adc=bed&productID=${pro.productId}">修改</a>
							
					</td>
				</tr>
				<tr></tr>s
			</c:forEach>
			
			
			
			</table>
			<h2><a href="/pinghong/showProductsListServlet?action=queryAll&adc=bed&pageSize=${pageSize }&pageNo=1">首页</a>
			&nbsp;&nbsp;<a href="/pinghong/showProductsListServlet?action=queryAll&adc=bed&pageSize=${pageSize }&pageNo=${pageNo-1 }">上一页</a>
			&nbsp;&nbsp;<a href="/pinghong/showProductsListServlet?action=queryAll&adc=bed&pageSize=${pageSize }&pageNo=${pageNo+1 }">下一页</a>&nbsp;&nbsp;
			<a href="/pinghong/showProductsListServlet?action=queryAll&adc=bed&pageSize=${pageSize }&pageNo=${maxNo }">尾页</a></h2>
</body>
</html>