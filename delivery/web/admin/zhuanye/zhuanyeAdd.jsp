<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>录入专业信息</h1>
			<form class="ui form" action="<%=path %>/zhuanyeAdd.action" name="form1" method="post">
				<div class="field">
					<label>专业编号：</label>
					<input name="zhuanyeBianhao" type="text"/>
				</div>
				<div class="field">
					<label>专业名称：</label>
					<input type="text" name="zhuanyeName"/>
				</div>
				<div class="field">
					<label>专业简介：</label>
					<textarea rows="7" cols="50" name="zhuanyeJieshao"></textarea>
				</div>
				<div>
					<input type="hidden" name="xibieId" value="<%=request.getParameter("xibieId") %>">
					<button class="mini ui primary button" type="submit">确定</button>
					<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
				</div>
			</form>
		</div>
	</body>
</html>
