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
			<h1>录入系信息</h1>
			<form  class="ui form" action="<%=path %>/xibieAdd.action" name="form1" method="post">
				<div class="field">
					<label>系编号：</label>
					<input name="xibieBianhao" type="text"/>
				</div>
				<div class="field">
					<label>系名称：</label>
					<input type="text" name="xibieName"/>
				</div>
				<div class="field">
					<label>系简介：</label>
					<textarea rows="7" cols="50" name="xibieJianjie"></textarea>
				</div>
				<div>
					<input type="hidden" name="xuyuanId" value="<%=request.getParameter("xuyuanId") %>">
					<button class="mini ui primary button" type="submit">确定</button>
					<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
				</div>
			</form>
		</div>
	</body>
</html>
