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
	<title>我要报修</title>
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
					//校验登陆
					$("#form1").validate({
						submitHandler: function(form) {
							// 执行提交
							var postUrl = "AddRepairItem" ;
							var param = $("#form1").serialize();
							// 提交异步请求
							$.post(postUrl,param,function(data){
								if(data.state){
									//执行跳转
									layer.msg("报修成功~");
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
			<h2 class="title">报修信息填写</h2>
			<form id="form1" action="" method="post">
				<div class="form-group">
					<div class="label">
						<label for="name"> 姓名</label>
					</div>
					<div class="field">
						<input type="text" value="${loginUser.userName}" class="input" id="name" name="name" size="40" data-validate="required:必填" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="itemPhone"> 手机号码</label>
					</div>
					<div class="field">
						<input type="text" value="${loginUser.userPhone}" class="input" id="itemPhone" name="itemPhone" size="30" data-validate="required:必填,mobile:请输入正确手机号码" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="itemAddress"> 地址</label>
					</div>
					<div class="field">
						<textarea rows="2" class="input" id="itemAddress" name="itemAddress" data-validate="required:必填">${loginUser.userAddress}</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label class="label"> 报修类型：</label>
					</div>
					<div class="field">
						<select class="input" name="itemType">
							<option value="1">电路</option>
							<option value="2">水路</option>
							<option value="3">移动网络</option>
							<option value="4">电信网络</option>
							<option value="5">门窗</option>
							<option value="6">空调</option>
							<option value="7">电脑</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="itemDesc"> 问题描述</label>
					</div>
					<div class="field">
						<textarea rows="4" class="input" id="itemDesc" name="itemDesc" data-validate="required:必填"></textarea>
					</div>
				</div>
				<div class="form-button">
					<button class="button border-main" style="width:100%;" type="submit"> 提交</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>