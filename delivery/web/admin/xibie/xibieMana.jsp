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
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				院系信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button"
					   href="<%=path %>/admin/xibie/xibieAdd.jsp?xuyuanId=<s:property value="#request.xuyuanId"/>">添加</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
				<tr>
					<th>系编号</th>
					<th>系名称</th>
					<th>系简介</th>
					<th>专业管理</th>
					<th>老师管理</th>
					<th style="min-width: 70px;">操作</th>
				</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.xibieList" id="xibie">
						<tr>
							<td>
								<s:property value="#xibie.xibieBianhao"/>
							</td>
							<td>
								<s:property value="#xibie.xibieName"/>
							</td>
							<td>
								<s:property value="#xibie.xibieJianjie"/>
							</td>
							<td>
								<a href="<%=path %>/zhuanyeMana.action?xibieId=<s:property value="#xibie.xibieId"/>">专业管理</a>
							</td>
							<td>
								<a href="<%=path %>/teaMana.action?xibieId=<s:property value="#xibie.xibieId"/>">老师管理</a>
							</td>
							<td>
								<a href="<%=path %>/xibieEditPre.action?xibieId=<s:property value="#xibie.xibieId"/>"><i class="blue edit icon" title="编辑"></i></a>
								<a href="<%=path %>/xibieDel.action?xibieId=<s:property value="#xibie.xibieId"/>"><i class="red remove icon" title="删除"></i></a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<button class="mini ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
