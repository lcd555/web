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
		<title>管理员-添加</title>
		<link rel="stylesheet" type="text/css" href="image/style_admin.css">
		<script type="text/javascript">
			function check_form(){
				var name = document.getElementById("userName").value;
				var pass = document.getElementById("password").value;
				var repass = document.getElementById("confirmpassword").value;
				if(pass==repass){
					return true;
				}else{
					document.getElementById("message").innerHTML="<font color='red' size='4'>两次密码不一致</font>";
					return false;
				}
			}
			
			//Ajax核心对象叫XMLHttpRequest
			//1.死活把XMLHttpRequest对象弄出来
			var xmlHttp;
			function createXmlHttpRequest(){
				if(window.XMLHttpRequest){//火狐内核的
					xmlHttp = new XMLHttpRequest();
				}else{//ie
					if(window.ActiveXObject){
						try{
							xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
						}catch(e){
							xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						}
					}
				}				
			}
			//第二部准备利用对象操作
			function checkUserName(name){
			//获得核心对象
				createXmlHttpRequest();
			//使用该对象定位xmlHttp.open(方式，路径，是否是异步)
				xmlHttp.open("GET","/pinghong/showUserListServlet?action=test&username="+name,true);
			//设置回调
			    xmlHttp.onreadystatechange=callback;	
			//发送
				xmlHttp.send(null);
			}
			//设置接收回调方法
			function callback(){
				if(xmlHttp.readyState==4){
					if(xmlHttp.status==200){
						if(xmlHttp.responseText=="true"){
							document.getElementById("uname").innerHTML="<font color='red' size='4'>用户名被占用</font>";
							//document.getElementById("form1").onsubmit=function(){return true};
							document.getElementById("mysub").disabled="disabled";
						}else{
							document.getElementById("uname").innerHTML="<font color='green' size='4'>用户名可以使用</font>";
							//document.getElementById("form1").onsubmit=function(){return false};
							document.getElementById("mysub").disabled="";
						}
					}
				}
			}
		</script>
	</head>

	<body>
		<form name="form1" action="/pinghong/showUserListServlet" method="post" onsubmit="return check_form()" id="form1">
			<table cellspacing="1" cellpadding="4" width="100%"
				class="tableborder" id="table3">

				<input type="hidden" name="action" value="save" />
				<tr>
					<td colspan="12" class="header">
						管理员-添加
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						管理员名称：
					</td>
					<td class="altbg2" colspan="11">
						<input type="text" name="userName" size="34" id="userName" onblur="checkUserName(this.value)"><div id="uname" style="display:inline"></div>
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						密&nbsp; 码：
					</td>
					<td class="altbg2" colspan="11">
						<input type="password" name="password" size="34" id="password">
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						确认密码：
					</td>
					<td class="altbg2" colspan="11">
						<input name="confirmpassword" size="34" type="password" id="confirmpassword"><div style="display:inline" id="message"></div>
					</td>
				</tr>


				<tr>
					<td class="altbg1">
					</td>
					<td class="altbg2" colspan="11">
						<input type="submit" value="提交" name="B1" id="mysub">
						&nbsp;
						<input type="reset" value="重置" name="B2">
					</td>
				</tr>

			</table>
		</form>
	</body>

</html>
