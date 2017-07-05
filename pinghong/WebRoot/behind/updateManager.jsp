<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户-修改</title>
		<link rel="stylesheet" type="text/css" href="behind/image/style_admin.css">
		<script type="text/javascript">
			function selectStatus(){
				var v = document.getElementById("userStatus").value;
				var ops = document.getElementById("status").options;
				for(var i=0;i<ops.length;i++){
					if(ops[i].value==v){
						ops[i].selected=true;
						break;
					}
				}
			}
		</script>
	</head>

	<body onload="selectStatus()">
		<form name="form1" action="/pinghong/showUserListServlet" method="post" onsubmit="return check_form()">
			<table cellspacing="1" cellpadding="4" width="100%"
				class="tableborder" id="table3">

				<input type="hidden" name="action" value="update" />
				<input type="hidden" name="userID" value="${users.userId }" />
				<tr>
					<td colspan="12" class="header">
						用户-修改
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						用户名称：
					</td>
					<td class="altbg2" colspan="11">
						<input type="text" name="userName" size="34" id="userName" value="${users.userName }">
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						用户状态
					</td>
					<td class="altbg2" colspan="11">
						<select name="status" id="status">
							<option value="1">管理员</option>
							<option value="0">普通用户</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="altbg1"><br><br></td>
					<td class="altbg2" colspan="11">
						<input type="submit" value="提交" name="B1">
						&nbsp;
						<input type="reset" value="重置" name="B2">
					</td>
				</tr>
			</table>
		</form>
		<input type="hidden" id="userStatus" value="${users.status }">
	</body>

</html>
