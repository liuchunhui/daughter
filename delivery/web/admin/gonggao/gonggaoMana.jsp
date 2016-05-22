<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>公告信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				公告信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button"
					   href="<%=path %>/admin/gonggao/gonggaoAdd.jsp">添加</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
					<tr>
						<th style="min-width: 100px">标题</th>
						<th>发布时间</th>
						<th>发布人</th>
						<th>内容</th>
						<th style="min-width: 70px;">操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.gonggaoList" id="gonggao">
					<tr>
						<td>
							<s:property value="#gonggao.gonggaoTitle"/>
						</td>
						<td>
							<s:property value="#gonggao.gonggaoData"/>
						</td>
						<td>
							<s:property value="#gonggao.gonggaoFabuzhe"/>
						</td>
						<td>
							<a href="<%=path %>/gonggaoDetail.action?gonggaoId=<s:property value="#gonggao.gonggaoId"/>">查看内容</a>
						</td>
						<td>
							<a class="mini ui red button" href="<%=path %>/gonggaoDel.action?gonggaoId=<s:property value="#gonggao.gonggaoId"/>">删除</a>
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>
