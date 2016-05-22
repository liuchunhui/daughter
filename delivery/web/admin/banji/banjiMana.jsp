<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>班级信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				班级信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button"
					   href="<%=path %>/admin/banji/banjiAdd.jsp?zhuanyeId=<s:property value="#request.zhuanyeId"/>">添加</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
				<tr>
					<th>班级编号</th>
					<th style="min-width: 100px;">班级名称</th>
					<th>入学年份</th>
					<th style="min-width: 100px;">学生管理</th>
					<th style="min-width: 70px">操作</th>
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
							<a href="<%=path %>/stuMana.action?banjiId=<s:property value="#banji.banjiId"/>">学生管理</a>
						</td>
						<td>
							<a href="<%=path %>/banjiEditPre.action?banjiId=<s:property value="#banji.banjiId"/>"><i class="blue edit icon" title="编辑"></i></a>
							<a href="<%=path %>/banjiDel.action?banjiId=<s:property value="#banji.banjiId"/>"><i class="red remove icon" title="删除"></i></a>
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
			<button class="mini ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
