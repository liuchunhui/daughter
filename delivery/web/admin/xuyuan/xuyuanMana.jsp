<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"  + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path %>/js/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=path %>/js/semantic.min.js" ></script>
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				学院基本信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button" href="<%=path %>/admin/xuyuan/xuyuanAdd.jsp">添加</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
					<tr>
						<th>学院编号</th>
						<th style="min-width: 100px;">学院名称</th>
						<th>学院简介</th>
						<th style="min-width: 100px">系别管理</th>
						<th style="min-width: 70px">操作</th>
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
								<a href="<%=path %>/xibieMana.action?xuyuanId=<s:property value="#xuyuan.xuyuanId"/>">系别管理</a>
							</td>
							<td>
								<a href="<%=path %>/xuyuanEditPre.action?xuyuanId=<s:property value="#xuyuan.xuyuanId"/>"><i class="blue edit icon" title="编辑"></i></a>
								<a href="<%=path %>/xuyuanDel.action?xuyuanId=<s:property value="#xuyuan.xuyuanId"/>"><i class="red remove icon" title="删除"></i></a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>
