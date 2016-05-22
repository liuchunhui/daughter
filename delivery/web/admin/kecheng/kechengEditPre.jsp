<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
  	<head>
	  	<title>修改课程信息</title>
	  	<meta charset="utf-8" />
	  	<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
  	</head>
  	<body>
  	<div style="width: 95%; margin: auto; margin-top: 25px;">
	  	<h1>修改课程信息</h1>
		<form  class="ui form" action="<%=path %>/kechengEdit.action" name="form1" method="post">
			<div class="field">
				<label>课程编号：</label>
				<input type="text" name="kechengBianhao" value="<s:property value="#request.kecheng.kechengBianhao"/>"/>
		  	</div>
		  	<div class="field">
			  	<label>课程名称：</label>
				<input type="text" name="kechengName" value="<s:property value="#request.kecheng.kechengName"/>"/>
		  	</div>
		  <div class="field">
			  <label>学时：</label>
			  <input type="number" name="kechengXueshi" value="<s:property value="#request.kecheng.kechengXueshi"/>" />
		  </div>
			<div class="field">
				<label>类型：</label>
				<select name="kechengLeixing">
					<option value="1">校级公共课</option>
					<option value="2">校级基础课</option>
					<option value="3">校级必修课</option>
					<option value="4">校级选修课</option>
					<option value="5">院级公共课</option>
					<option value="6">院级必修课</option>
					<option value="7">院级选修课</option>
				</select>
			</div>
		  <div>
			  <input type="hidden" name="kechengId" value="<s:property value="#request.kecheng.kechengId"/>">
			  <button class="mini ui primary button" type="submit">确定</button>
			  <button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
		  </div>
	  </form>
  </div>
  </body>
</html>
