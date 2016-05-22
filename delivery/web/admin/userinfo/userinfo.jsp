<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<title>添加教师信息</title>
	  	<meta charset="utf-8" />
	  	<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
    	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    	<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    	<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    	<script type="text/javascript">
			function check1() {
				var userPw=document.form1.userPw.value;
			  	var userPwZhengqu='<s:property value="#session.admin.userPw"/>';
			  	if(userPw!=userPwZhengqu) {
				 	alert("旧密码输入不正确");
					return ;
			  	}
			  	var userPwNew=document.form1.userPwNew.value;
			  	if(userPwNew=="") {
					alert("请输入新密码");
				  	return ;
				}
			  	loginService.adminPwEdit(document.form1.userPwNew.value,callback);
		   	}
       		function callback(data) {
           		alert("修改成功");
       		}
    	</script>
  	</head>
  	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>修改密码</h1>
			<form  class="ui form" aaction="" name="form1">
				<div class="field">
					<label>用户名：</label>
					<input type="text" value="${sessionScope.admin.userName }" name="userName" readonly/>
				</div>
				<div class="field">
					<label>原密码：</label>
					<input type="password" name="userPw" id="userPw" size="22"/>
				</div>
				<div class="field">
					<label>新密码：</label>
					<input type="password" id="userPwNew" name="userPwNew" size="22"/>
				</div>
				<div>
					<button class="mini ui primary button" type="button" onclick="check1()">修改</button>
				</div>
			</form>
		</div>
  	</body>
</html>
