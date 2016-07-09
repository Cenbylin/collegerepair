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
	<title>报修详情</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
	<script type="text/javascript" src="js/pintuer.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript" src="js/layer.js"></script>
	<script type="text/javascript">
		function doneRepair(id) {
			// 提交异步请求
			var postUrl = "DoneRepair" ;
			$.post(postUrl,{"itemId":id},function(data){
				if(data.state){
					layer.msg("处理完成");
					//按钮变化
					$("#btn").attr("disabled", true);
					$("#btn").html("处理完成");
					location.reload();
				}else{
					layer.msg(data.msg);
				}
			},"json");
		}
	</script>
</head>
<body>
	<div class="container">
		<!-- 菜单 -->
	 	<%@include file="menu.jsp" %>
		<div class="contain float-right">
			<div class="repIfo">
				<h2 class="title">报修信息</h2>
				<table class="table">
					<tr>
						<td>姓名</td>
						<td>${repairItem.user.userName}</td>
					</tr>
					<tr>
						<td>手机号码</td>
						<td>${repairItem.user.userPhone}</td>
					</tr>
					<tr>
						<td>地址</td>
						<td>${repairItem.itemAddress}</td>
					</tr>
					<tr>
						<td>报修类型</td>
						<td>${repairItem.itemTypeString}</td>
					</tr>
					<tr>
						<td>问题描述</td>
						<td>${repairItem.itemDesc}</td>
					</tr>
				</table>
			</div>
			<br>
			<div class="ItemLogList">
				<h2 class="title">报修日志</h2>
				<ul class="list-unstyle list-striped">
					<c:forEach items="${repairLogs}" var="item">
						<li>
							<div class="date">${item.logTime}</div>
							<div class="prog">${item.logMsg}</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<br>
			<c:if test="${loginUser.userManager==1}">
				<div class="form-button">
				<c:choose>
					<c:when test="${repairItem.itemState==0}">
						<button class="button" id="btn" style="width:100%;background-color:#E74C3C" type="submit" onClick="doneRepair('${repairItem.itemId}');"> 完成处理</button>
					</c:when>
					<c:when test="${repairItem.itemState==1}">
						<button class="button" id="btn" style="width:100%;background-color:#E74C3C" type="submit" onClick="doneRepair('${repairItem.itemId}');"> 完成处理</button>
					</c:when>
					<c:when test="${repairItem.itemState==2}">
						<button class="button" id="btn" disabled style="width:100%;background-color:#E74C3C" type="submit" onClick="doneRepair('${repairItem.itemId}');"> 完成处理</button>
					</c:when>
				</c:choose>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>