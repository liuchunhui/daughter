<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path %>/js/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=path %>/js/semantic.min.js" ></script>

		<script type='text/javascript' src='<%=path %>/dwr/interface/kechengService.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>

		<script language="javascript">
			function init()
			{
				kechengService.findKechengName(<s:property value="#session.tea.kechengId"/>,callbackKecheng);
			}

			function callbackKecheng(data)
			{
				document.getElementById("kechengName").value=data;
			}
		</script>
	</head>
	<body onload="init()">
	<div style="width: 95%; margin: auto; margin-top: 25px;">
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
					<td align="center">
						<s:property value="#chengji.chengjiOne1"/><!-- //课程名称 -->
					</td>
					<td align="center">
						<s:property value="#chengji.kaoshifenshu"/>
					</td>
					<td align="center">
						<s:property value="#chengji.kaoshishijian"/>
					</td>
					<td align="center">
						<s:property value="#chengji.kaoshileixing"/>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		<form class="ui form" action="<%=path %>/chengjiAdd.action" method="post" style="width: 500px; margin: auto;">
			<div class="field">
				<label for="kechengName">课程</label>
				<input type="text" readonly="readonly" name="kechengName" id="kechengName" value=""/>
				<input type="hidden" name="kechengId" id="kechengId" value="<s:property value="#session.tea.kechengId"/>"/>
			</div>
			<div class="field">
				<label for="kaoshifenshu">分数</label>
				<input type="text" name="kaoshifenshu" id="kaoshifenshu" size="22" onkeyup="this.value=this.value.replace(/\D/g,'')"
					   onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
			</div>
			<div class="field">
				<label for="kaoshishijian">考试时间</label>
				<input type="date" id="kaoshishijian" name="kaoshishijian"/>
			</div>
			<div class="field">
				<label for="kaoshileixing">考试类型</label>
				<input type="text" name="kaoshileixing" id="kaoshileixing" size="22"/>
			</div>
			<div class="field">
				<input type="hidden" name="stuId" value="${requestScope.stuId}"/>
				<input class="mini ui green button" type="submit" value="提交" onclick="submitChengji()"/>
			</div>
		</form>
		<button class="mini ui primary button" type="button" onclick="javascript:history.go(-1);">返回</button>
	</div>
	</body>
</html>
