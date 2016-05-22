<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>课程信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>
				课程信息列表
				<span style="font-size: 15px">
					<a class="mini ui green button"
					   href="<%=path %>/admin/kecheng/kechengAdd.jsp">添加</a>
				</span>
			</h1>

			<table class="ui celled table">
				<thead>
				<tr>
					<th>课程编号</th>
					<th style="min-width: 100px;">课程名称</th>
					<th>学时</th>
					<th>课程类型</th>
					<th style="min-width: 70px;">操作</th>
				</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.kechengList" id="kecheng">
						<tr>
							<td>
								<s:property value="#kecheng.kechengBianhao"/>
							</td>
							<td>
								<s:property value="#kecheng.kechengName"/>
							</td>
							<td>
								<s:property value="#kecheng.kechengXueshi"/>
							</td>
							<td>
								<s:if test="#kecheng.kechengLeixing==1">
									校级公共课
								</s:if>
								<s:if test="#kecheng.kechengLeixing==2">
									校级基础课
								</s:if>
								<s:if test="#kecheng.kechengLeixing==3">
									校级必修课
								</s:if>
								<s:if test="#kecheng.kechengLeixing==4">
									校级选修课
								</s:if>
								<s:if test="#kecheng.kechengLeixing==5">
									院级公共课
								</s:if>
								<s:if test="#kecheng.kechengLeixing==6">
									院级必修课
								</s:if>
								<s:if test="#kecheng.kechengLeixing==7">
									院级选修课
								</s:if>
							</td>
							<td>
								<a href="<%=path %>/kechengEditPre.action?kechengId=<s:property value="#kecheng.kechengId"/>"><i class="blue edit icon" title="编辑"></i></a>
								<a href="<%=path %>/kechengDel.action?kechengId=<s:property value="#kecheng.kechengId"/>"><i class="red remove icon" title="删除"></i></a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>
