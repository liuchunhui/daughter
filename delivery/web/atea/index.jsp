<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title></title>
	<meta charset="utf-8" />
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
</head>
<frameset rows="50,*,11" frameborder="no" border="0" framespacing="0">
	<frame src="<%=path %>/atea/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame"
		   style="background-color: #0D1F44;"/>
	<frame src="<%=path %>/atea/center.jsp" name="mainFrame" id="mainFrame" scrolling="no"
		   style="background-color: #f2f2f2;"/>
	<frame src="<%=path %>/atea/down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
</html>