<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<title>修改班级信息</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>修改班级信息</h1>
			<form  class="ui form" action="<%=path %>/banjiEdit.action" name="form1" method="post">
				<div class="field">
					<label>班级编号：</label>
					<input name="banjiBianhao" type="text" value="<s:property value="#request.banji.banjiBianhao"/>"/>
				</div>
				<div class="field">
					<label>班级名称：</label>
					<input type="text" name="banjiName" value="<s:property value="#request.banji.banjiName"/>"/>
				</div>
				<div class="field">
					<label>入学年份：</label>
					<input type="date" name="banjiRuxuenianfen" value="<s:property value="#request.banji.banjiRuxuenianfen"/>" />
				</div>
				<div>
					<input type="hidden" name="banjiId" value="<s:property value="#request.banji.banjiId"/>">
					<button class="mini ui primary button" type="submit">确定</button>
					<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
				</div>
			</form>
		</div>
	</body>
</html>
