<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>学生信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function chengjiMana(stuId)
			{
				var url="<%=path %>/chengjiMana.action?stuId="+stuId;
				window.location.href=url;
			}
		</script>
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>学生成绩信息管理</h1>
			<table class="ui celled table">
				<thead>
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>身份证号</th>
					<th>操作</th>
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
								<a class="mini ui primary button" href="#" onclick="chengjiMana(<s:property value="#stu.stuId"/>)">编辑</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<button class="ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
