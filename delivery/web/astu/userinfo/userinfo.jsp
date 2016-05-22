<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
					<h4>学院：</h4>
					<p>${sessionScope.stu.stuOne1 }</p>
				</div>
				<div>
					<h4>系别：</h4>
					<p>${sessionScope.stu.stuOne2 }</p>
				</div>
				<div>
					<h4>专业：</h4>
					<p>${sessionScope.stu.stuOne3 }</p>
				</div>
				<div>
					<h4>班级：</h4>
					<p>${sessionScope.stu.stuOne4 }</p>
				</div>
				<div>
					<h4>学号：</h4>
					<p>${sessionScope.stu.stuXuehao }</p>
				</div>
				<div>
					<h4>姓名：</h4>
					<p>${sessionScope.stu.stuRealname }</p>
				</div>
				<div>
					<h4>性别：</h4>
					<p>${sessionScope.stu.stuSex }</p>
				</div>
				<div>
					<h4>年龄：</h4>
					<p>${sessionScope.stu.stuAge }</p>
				</div>
				<div>
					<h4>身份证号：</h4>
					<p>${sessionScope.stu.stuCard }</p>
				</div>
				<div>
					<h4>登录账号：</h4>
					<p>${sessionScope.stu.loginName }</p>
				</div>
				<div>
					<h4>登录密码：</h4>
					<p>${sessionScope.stu.loginPw }</p>
				</div>
			</div>
		</div>
	</body>
</html>
