<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>班级信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>班级信息列表</h1>
			<table class="ui celled table">
				<thead>
					<tr>
						<th>班级编号</th>
						<th>班级名称</th>
						<th>入学年份</th>
						<th>学生管理</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.banjiList" id="banji">
						<tr>
							<td>
								<s:property value="#banji.banjiBianhao"/>
							</td>
							<td>
								<s:property value="#banji.banjiName"/>
							</td>
							<td>
								<s:property value="#banji.banjiRuxuenianfen"/>
							</td>
							<td>
								<a href="<%=path %>/selectStu.action?banjiId=<s:property value="#banji.banjiId"/>">选择学生</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<button class="ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
