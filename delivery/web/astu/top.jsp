<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生信息管理</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.top-header {
				display: flex;
				justify-content: space-between;
			}
			.top-header .div-1 {
				font-size: 25px;
				color: #fff;
				margin-top: 5px;
			}
			.top-header .div-2 {
				font-size: 15px;
				color: #fff;
			}
		</style>
	</head>
	<body style="line-height: initial; background-color: #0D1F44">
	<div class="top-header">
		<div class="div-1">
			学生信息管理系统
		</div>
		<div class="div-2">
			<br />
			<i class="user icon"></i>
			学生用户
		</div>
	</div>
	</body>
</html>
