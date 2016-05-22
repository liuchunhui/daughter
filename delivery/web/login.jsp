<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <title></title>
    <link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
    <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    <script language="javascript">
	    function login()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 if(document.ThisForm.userType.value=="-1")
			 {
			 	alert("请选择登陆身份");
				document.ThisForm.userType.focus();
				return false;
			 }
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,document.ThisForm.userType.value,callback);
		}
		
		function callback(data)
		{
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
                <%--window.location.href="<%=path %>/admin/index.jsp";--%>
				window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		}
    </script>
	<style type="text/css">
		label {
			color: #ffffff !important;
		}
	</style>
</head>
<body style="background: linear-gradient(45deg,#020031 0,#2E8682 100%); color: #ffffff;">
    <div style="width: 50%; margin: auto; margin-top: 8%;">
        <h1 style="text-align: center">学生信息管理系统</h1>
        <form class="ui form" name="ThisForm" action="<%=path %>/login.action" method="POST" style="margin: auto; margin-top: 100px; width: 60%;">
            <div class="field">
                <label for="userName">用户名</label>
                <input autofocus name="userName" type="text" id="userName" size="15" />
            </div>
            <div class="field">
                <label for="userPw">密码</label>
                <input name="userPw" type="password" id="userPw" size="17" />
            </div>
            <div class="field">
                <label for="userType">类型</label>
                <select class="ui dropdown" name="userType" id="userType">
                    <option value="-1" selected="selected">-请选择登陆身份-</option>
                    <option value="0">管理员</option>
                    <option value="1">老师</option>
                    <option value="2">学生</option>
                </select>
            </div>
            <button class="right floated ui primary button" type="button" onclick="login()">登陆系统</button>
        </form>
    </div>
</body>
