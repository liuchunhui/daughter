<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>学生信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				学生信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button"
					   href="<%=path %>/admin/stu/stuAdd.jsp?banjiId=<s:property value="#request.banjiId"/>">添加</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>身份证号</th>
						<th>登录账号</th>
						<th>登录密码</th>
						<th style="min-width: 70px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.stuList" id="stu">
						<tr>
							<td>
								<s:property value="#stu.stuXuehao"/>
							</td>
							<td>
								<s:property value="#stu.stuRealname"/>
							</td>
							<td>
								<s:property value="#stu.stuSex"/>
							</td>
							<td>
								<s:property value="#stu.stuAge"/>
							</td>
							<td>
								<s:property value="#stu.stuCard"/>
							</td>
							<td>
								<s:property value="#stu.loginName"/>
							</td>
							<td>
								<s:property value="#stu.loginPw"/>
							</td>
							<td>
								<a href="<%=path %>/stuEditPre.action?stuId=<s:property value="#stu.stuId"/>"><i class="blue edit icon" title="编辑"></i></a>
								<a href="<%=path %>/stuDel.action?stuId=<s:property value="#stu.stuId"/>"><i class="red remove icon" title="删除"></i></a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<button class="mini ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
