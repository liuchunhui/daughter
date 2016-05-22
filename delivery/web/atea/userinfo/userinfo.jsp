<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>个人信息</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.info {
				margin-top: 30px;
			}
			.info h4 {
				display: inline-block;
				min-width: 50px;
			}
			.info p {
				display: inline-block;
			}
		</style>
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>个人信息</h1>
			<div class="info">
				<div>
					<h4>教师编号：</h4>
					<p>${sessionScope.tea.teaBianhao}</p>
				</div>
				<div>
					<h4>姓名：</h4>
					<p>${sessionScope.tea.teaRealname }</p>
				</div>
				<div>
					<h4>性别：</h4>
					<p>${sessionScope.tea.teaSex }</p>
				</div>
				<div>
					<h4>年龄：</h4>
					<p>${sessionScope.tea.teaAge }</p>
				</div>
				<div>
					<h4>联系：</h4>
					<p>${sessionScope.tea.teaTel }</p>
				</div>
				<div>
					<h4>住址：</h4>
					<p>${sessionScope.tea.teaAddress }</p>
				</div>
				<div>
					<h4>登录账号：</h4>
					<p>${sessionScope.tea.loginName }</p>
				</div>
				<div>
					<h4>登录密码：</h4>
					<p>${sessionScope.tea.loginPw }</p>
				</div>
			</div>
		</div>
	</body>
</html>
