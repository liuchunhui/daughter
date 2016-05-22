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
		<title>教师信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				教师信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button"
					   href="<%=path %>/admin/tea/teaAdd.jsp?xibieId=<s:property value="#request.xibieId"/>">添加</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
					<tr>
						<th>编号</th>
						<th style="min-width:70px;">姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>联系方式</th>
						<th style="min-width: 100px">住址</th>
						<th>简历</th>
						<th style="min-width: 80px">所授课程</th>
						<th>登录账号</th>
						<th>登录密码</th>
						<th style="min-width: 70px;">操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.teaList" id="tea">
					<tr>
						<td>
							<s:property value="#tea.teaBianhao"/>
						</td>
						<td>
							<s:property value="#tea.teaRealname"/>
						</td>
						<td>
							<s:property value="#tea.teaSex"/>
						</td>
						<td>
							<s:property value="#tea.teaAge"/>
						</td>
						<td>
							<s:property value="#tea.teaTel"/>
						</td>
						<td>
							<s:property value="#tea.teaAddress"/>
						</td>
						<td>
							<s:property value="#tea.teaJianli"/>
						</td>
						<td>
							<s:property value="#tea.teaOne1"/>
						</td>
						<td>
							<s:property value="#tea.loginName"/>
						</td>
						<td>
							<s:property value="#tea.loginPw"/>
						</td>
						<td>
							<a href="<%=path %>/teaEditPre.action?teaId=<s:property value="#tea.teaId"/>"><i class="blue edit icon" title="编辑"></i></a>
							<a href="<%=path %>/teaDel.action?teaId=<s:property value="#tea.teaId"/>"><i class="red remove icon" title="删除"></i></a>
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
			<button class="mini ui teal button" onclick="javascript:history.go(-1);">返回</button>
		</div>
	</body>
</html>
