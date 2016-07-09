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
	<title>我的报修</title>
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
			<h2 style="color: green;">保修列表</h2>
			<ul class="nav nav-main list">
				<c:forEach items="${pager.list}" var="item">
					<c:choose>
						<c:when test="${item.itemState==0}">
							<div>
								<a href="ViewRepairItem?itemId=${item.itemId}">
									<li>${item.itemTitle}</li>
								</a>
								<div class="button-group border-red float-right">
									<button type="button" class="button active rec-btn float-right" id="${item.itemId}"> 未受理</button>
								</div>
							</div>
						</c:when>
						<c:when test="${item.itemState==1}">
							<div>
								<a href="ViewRepairItem?itemId=${item.itemId}">
									<li>${item.itemTitle}</li>
								</a>
								<div class="button-group border-red float-right">
									<button type="button" class="button active rec-btn float-right" id="${item.itemId}"> 已受理</button>
								</div>
							</div>
						</c:when>
						<c:when test="${item.itemState==2}">
							<div>
								<a href="ViewRepairItem?itemId=${item.itemId}">
									<li>${item.itemTitle}</li>
								</a>
								<div class="button-group border-red float-right">
									<button type="button" class="button active rec-btn float-right" id="${item.itemId}"> 处理完</button>
								</div>
							</div>
						</c:when>
					</c:choose>
				</c:forEach>
			</ul>
			<ul class="pagination pagination-group" style="float:right">
				<li><a href="javascript:void(0);" onClick="lastpage();">上一页</a> </li>
				<li><a href="javascript:void(0);" onClick="nextpage();">下一页</a> </li>
			</ul>
		</div>
	</div>
	<script>
		//切换上一页
	    function lastpage(){
	    	var pageNum = ${pager.pageNumber} - 1;
	    	window.location.href= "QueryUserItem?pageNum="+pageNum;
	    }
	    //切换下一页
	    function nextpage(){
	    	var pageNum = ${pager.pageNumber} + 1;
	    	window.location.href= "QueryUserItem?pageNum="+pageNum;
	    }
	</script>
</body>
</html>