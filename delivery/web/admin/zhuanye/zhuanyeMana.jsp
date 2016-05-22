<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>专业信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				专业信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button" href="<%=path %>/admin/zhuanye/zhuanyeAdd.jsp?xibieId=<s:property value="#request.xibieId"/>"> 添加 &nbsp;</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
				<tr>
					<th>专业编号</th>
					<th style="min-width: 100px;">专业名称</th>
					<th>专业简介</th>
					<th style="min-width: 100px;">班级管理</th>
					<th style="min-width: 70px;">操作</th>
				</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.zhuanyeList" id="zhuanye">
						<tr>
							<td>
								<s:property value="#zhuanye.zhuanyeBianhao"/>
							</td>
							<td>
								<s:property value="#zhuanye.zhuanyeName"/>
							</td>
							<td>
								<s:property value="#zhuanye.zhuanyeJieshao"/>
							</td>
							<td>
								<a href="<%=path %>/banjiMana.action?zhuanyeId=<s:property value="#zhuanye.zhuanyeId"/>">班级管理</a>
							</td>
							<td>
								<a href="<%=path %>/zhuanyeEditPre.action?zhuanyeId=<s:property value="#zhuanye.zhuanyeId"/>"><i class="blue edit icon" title="编辑"></i></a>
								<a href="<%=path %>/zhuanyeDel.action?zhuanyeId=<s:property value="#zhuanye.zhuanyeId"/>"><i class="red remove icon" title="删除"></i></a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<button class="ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
