<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	//录入成绩的时候。显示选择学院-->选择系别-->选择专业-->选择班级-->选择学生
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>学院信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>学院信息列表</h1>
			<table class="ui celled table">
				<thead>
				<tr>
					<th>学院编号</th>
					<th style="min-width: 100px;">学院名称</th>
					<th>学院简介</th>
					<th style="min-width: 100px">系</th>
				</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.xuyuanList" id="xuyuan">
						<tr>
							<td>
								<s:property value="#xuyuan.xuyuanBianhao"/>
							</td>
							<td>
								<s:property value="#xuyuan.xuyuanName"/>
							</td>
							<td>
								<s:property value="#xuyuan.xuyuanJianjie"/>
							</td>
							<td>
								<a href="<%=path %>/selectXibie.action?xuyuanId=<s:property value="#xuyuan.xuyuanId"/>">选择系别</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<button class="ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
