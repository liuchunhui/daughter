<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生信息管理系统</title>
		<meta charset="utf-8" />
	</head>
	<body>
		<div>
			<div style="position: absolute; width: 200px;">
				<iframe height="100%" scrolling="no" width="100%" border="0" frameborder="0" src="<%=path %>/astu/left.jsp"></iframe>
			</div>
			<div style="margin-left: 200px;">
				<iframe height="100%"  scrolling="auto" width="100%" name="rightF" border="0" frameborder="0" src="<%=path %>/astu/right.jsp"></iframe>
			</div>
		</div>
	</body>
</html>