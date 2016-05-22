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
		<script type="text/javascript" src="<%=path %>/js/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=path %>/js/semantic.min.js" ></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.ui.dropdown').dropdown();
			});
		</script>
	</head>
  	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>添加学生信息</h1>
			<form  class="ui form" action="<%=path %>/stuAdd.action" name="form1" method="post">
				<div class="field">
					<label>学号：</label>
					<input name="stuXuehao" type="text"/>
				</div>
				<div class="field">
					<label>姓名：</label>
					<input type="text" name="stuRealname"/>
				</div>
				<div class="field">
					<label>性别：</label>
					<div class="ui dropdown">
						<input type="hidden" name="stuSex">
						<i class="dropdown icon"></i>
						<div class="default text">男</div>
						<div class="menu">
							<div class="item" data-value="男">男</div>
							<div class="item" data-value="女">女</div>
						</div>
					</div>
					<%--<input type="radio" name="stuSex" value="男" checked="checked"/>男--%>
					<%--<input type="radio" name="stuSex" value="女"/>女--%>
				</div>
				<div class="field">
					<label>年龄：</label>
					<input type="text" name="stuAge"/>
				</div>
				<div class="field">
					<label>身份证号：</label>
					<input type="text" name="stuCard"/>
				</div>
				<div class="field">
					<label>登录账号：</label>
					<input type="text" name="loginName"/>
				</div>
				<div class="field">
					<label>登录密码：</label>
					<input type="text" name="loginPw"/>
				</div>
				<div>
					<input type="hidden" name="banjiId" value="<%=request.getParameter("banjiId") %>">
					<button class="mini ui primary button" type="submit">确定</button>
					<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
				</div>
			 </form>
		</div>
	</body>
</html>
