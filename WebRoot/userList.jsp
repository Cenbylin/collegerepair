<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	//判断用户是否登陆
	if(request.getSession().getAttribute("loginUser")==null){
		//重定向到登录页
		response.sendRedirect("login.html");
	}
%>
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href=" <%=basePath%>"> 
	<title>用户列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
	<script type="text/javascript" src="js/pintuer.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript" src="js/layer.js"></script>
</head>
<body>
	<div class="container">
		<!-- 菜单 -->
	 	<%@include file="menu.jsp" %>
		<div class="contain float-right">
			<h2 style="color: green;">用户列表</h2>
			<table style="text-align:center;" class="table">
				<tr>
					<th style="width:62%;text-align:center;">用户名</th>
					<th style="width:30%;text-align:center;">操作</th>
				</tr>
				<tr>
					<td style="width:62%;vertical-align: middle;">无吊成</td>
					<td style="width:30%;vertical-align: middle;">
						<div class="button-group border-red">
							<button type="button" class="button active rec-btn" id="btn" onclick="attFob()" > 升级</button>
						</div>
					</td>
				</tr>
				<tr>
					<td style="width:62%;vertical-align: middle;">有吊成</td>
					<td style="width:30%;vertical-align: middle;">
						<div class="button-group border-red">
							<button type="button" class="button active rec-btn" id="btn" onclick="attFob()" > 升级</button>
						</div>
					</td>
				</tr>
				<tr>
					<td style="width:62%;vertical-align: middle;">吊成</td>
					<td style="width:30%;vertical-align: middle;">
						<div class="button-group border-red">
							<button type="button" class="button active rec-btn" id="btn" onclick="attFob()" > 升级</button>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		function attFob() {
			var stamp = document.getElementById('btn');
			if (stamp.style.backgroundColor != "rgb(52, 152, 219)") {
				alert("升级成功！");
				stamp.style.backgroundColor = "rgb(52, 152, 219)";
				stamp.innerText = "取消";
			}
			else if (stamp.style.backgroundColor == "rgb(52, 152, 219)") {
				alert("取消成功！");
				stamp.style.backgroundColor = "#EE3333"
				stamp.innerText = "升级";
			}
		}
	</script>
</body>
</html>