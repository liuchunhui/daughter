<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>添加公告信息</title>
	  	<meta charset="utf-8" />
	  	<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
  	</head>
  	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
	  		<h1>添加公告信息</h1>
			<form  class="ui form" action="<%=path %>/gonggaoAdd.action" name="form1" method="post">
		  		<div class="field">
			  		<label>标题：</label>
					<input type="text" name="gonggaoTitle"/>
				</div>
		  		<div class="field">
			  		<label>内容：</label>
			  		<textarea type="text" name="gonggaoContent"></textarea>
		  		</div>
		  		<div>
					<button class="mini ui primary button" type="submit">确定</button>
			  		<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
		  		</div>
	  		</form>
  		</div>
  	</body>
</html>
