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
		<h1>系信息编辑</h1>
		<form  class="ui form" action="<%=path %>/xibieEdit.action" name="form1" method="post">
			<div class="field">
				<label>系编号：</label>
				<input name="xibieBianhao" type="text" value="<s:property value="#request.xibie.xibieBianhao"/>"/>
			</div>
			<div class="field">
				<label>系名称：</label>
				<input type="text" name="xibieName" value="<s:property value="#request.xibie.xibieName"/>"/>
			</div>
			<div class="field">
				<label>系简介：</label>
				<textarea rows="7" cols="50" name="xibieJianjie"><s:property value="#request.xibie.xibieJianjie"/></textarea>
			</div>
			<div>
				<input type="hidden" name="xibieId" value="<s:property value="#request.xibie.xibieId"/>">
				<button class="mini ui primary button" type="submit">确定</button>
				<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
			</div>
		</form>
	</div>
  </body>
</html>
