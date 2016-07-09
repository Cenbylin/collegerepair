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
	<title>个人信息</title>
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
							var postUrl = "UpdateUser" ;
							var param = $("#form2").serialize();
							// 提交异步请求
							$.post(postUrl,param,function(data){
								if(data.state){
									//执行跳转
									layer.msg("修改成功~");
									location.reload();
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
			<div class="button-group border-blue float-right psw">
				<button class="button icon-key active" onclick="window.location.href='editPwd.jsp'">修改密码</button>
			</div>
			<h2 class="title">个人信息修改</h2>
			<form id="form2" action="" method="post">
				<div class="form-group">
					<div class="label">
						<label for="account"> 用户名</label>
					</div>
					<div class="field">
						<input type="text" class="input" id="account" name="account" size="30" data-validate="required:必填" value="${loginUser.userAccount}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="name"> 姓名</label>
					</div>
					<div class="field">
						<input type="text" class="input" id="userName" name="userName" size="30" data-validate="required:必填" value="${loginUser.userName}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="mobile"> 手机号码</label>
					</div>
					<div class="field">
						<input type="text" class="input" id="userPhone" name="userPhone" size="30" data-validate="required:必填,mobile:请输入正确手机号码" value="${loginUser.userPhone}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sex"> 性别</label>
					</div>
					<div class="field">
						<div class="button-group radio">
						<label class="button"> <input name="sex" value="1" type="radio"> 男 </label>
						<label class="button"> <input name="sex" value="0" type="radio"> 女 </label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="add"> 地址</label>
					</div>
					<div class="field">
						<textarea rows="2" class="input" id="userAddress" name="userAddress" data-validate="required:必填">${loginUser.userAddress}</textarea>
					</div>
				</div>
				<div class="form-button">
					<button class="button border-main" style="width:100%;" type="submit"> 修改</button>
				</div>
				
			</form>
		</div>
	</div>

</body>
</html>