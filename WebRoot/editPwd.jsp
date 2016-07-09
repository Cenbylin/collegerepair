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
	<script src="js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
					//校验注册
					$("#form2").validate({
						submitHandler: function(form) {
							// 执行提交
							var postUrl = "EditUserPassword" ;
							var param = $("#form2").serialize();
							// 提交异步请求
							$.post(postUrl,param,function(data){
								if(data.state){
									//执行跳转
									layer.msg("修改成功~");
								}else{
									layer.msg(data.msg);
								}
							},"json");
						}
					});
				});
	</script>
</head>
<body>
	<div class="container">
		<!-- 菜单 -->
	 	<%@include file="menu.jsp" %>
		<div class="contain float-right">
			<h2 class="title">密码修改</h2>
			<form id="form2" method="post" class="form-auto login">
				<div class="form-group">
					<div class="label">
						<label for="oldPsw"> 旧密码</label>
					</div>
					<div class="field">
						<input type="password" class="input" id="oldPassword" name="oldPassword" size="30" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="newPsw"> 新密码</label>
					</div>
					<div class="field">
						<input type="password" class="input" id="newPassword" name="newPassword" size="30" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="newPswRe"> 再次输入新密码</label>
					</div>
					<div class="field">
						<input type="password" class="input" id="newPswRe" name="newPswRe" size="30" data-validate="repeat#newPassword:两次输入的密码不一致" />
					</div>
				</div>
				<br>
				<div class="form-button ">
					<button class="button border-main" style="width:100%;" type="submit"> 提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>