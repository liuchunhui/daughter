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
	  		<h1>修改学生信息</h1>
	  		<form  class="ui form" action="<%=path %>/stuEdit.action" name="form1" method="post">
		  		<div class="field">
			  		<label>学号：</label>
					<input name="stuXuehao" type="text" value="${request.stu.stuXuehao}"/>
		  		</div>
				<div class="field">
					<label>姓名：</label>
					<input type="text" name="stuRealname" value="${request.stu.stuRealname}"/>
				</div>
				<div class="field">
					<label>性别：</label>
					<input type="radio" name="stuSex" value="男" checked="checked"/>男
					<input type="radio" name="stuSex" value="女"/>女
				</div>
				<div class="field">
					<label>年龄：</label>
					<input type="text" name="stuAge" value="${request.stu.stuCard}"/>
				</div>
				<div class="field">
					<label>身份证号：</label>
					<input type="text" name="stuCard" value="${request.stu.stuCard}"/>
				</div>
				<div class="field">
					<label>登录账号：</label>
					<input type="text" readonly="readonly" name="loginName" value="${request.stu.loginName}"/>
				</div>
				<div class="field">
					<label>登录密码：</label>
					<input type="text" readonly="readonly" name="loginPw" value="${request.stu.loginPw}"/>
				</div>
		  		<div>
					<input type="hidden" name="stuId" value="${request.stu.stuId}"/>
			  		<button class="mini ui primary button" type="submit">确定</button>
			  		<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
		  		</div>
	  		</form>
  		</div>
  	</body>
</html>
