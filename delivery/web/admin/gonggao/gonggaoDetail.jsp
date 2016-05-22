<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>--%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
  	<head>
	  	<title>公告信息</title>
	  	<meta charset="utf-8" />
	  	<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
  	</head>
  	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>公告信息</h1>
			<div style="margin-top: 30px; margin-bottom: 30px;">
				<s:property value="#request.gonggao.gonggaoContent" escape="false"/>
			</div>
			<button class="mini ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
