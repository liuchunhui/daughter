<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>成绩信息列表</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>成绩信息列表</h1>
			<table class="ui celled table">
				<thead>
					<tr>
						<th>课程</th>
						<th>分数</th>
						<th>考试时间</th>
						<th>考试类型</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.chengjiList" id="chengji">
						<tr>
							<td>
								<s:property value="#chengji.chengjiOne1"/>
							</td>
							<td>
								<s:property value="#chengji.kaoshifenshu"/>
							</td>
							<td>
								<s:property value="#chengji.kaoshishijian"/>
							</td>
							<td>
								<s:property value="#chengji.kaoshileixing"/>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>