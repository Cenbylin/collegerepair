<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<div class="meun float-left">
	<ul class="nav nav-main">
		<a href="addRepair.jsp"><li>我要报修</li></a>
		<a href="QueryUserItem"><li>我的报修</li></a>
		<c:if test="${loginUser.userManager==1}">
			<a href="QueryRepairItem"><li>报修列表</li></a>
		</c:if>
		<a href="userInfo.jsp" style="border-bottom: 1px solid #ccc;"><li>我的信息</li></a>
	</ul>
</div>