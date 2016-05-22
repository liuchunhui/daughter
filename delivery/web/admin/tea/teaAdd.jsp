<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<title>添加教师信息</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
		<script type='text/javascript' src='<%=path %>/dwr/interface/kechengService.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
		<script type="text/javascript">
			function init()
			{
				kechengService.findAllKecheng(callback);
			}
			function callback(data)
			{
				DWRUtil.addOptions("kechengId",data,"kechengId","kechengName");
			}
		</script>
	</head>
	<body onload="init()">
		<div style="width: 95%; margin: auto; margin-top: 25px;">
			<h1>添加教师信息</h1>
			<form  class="ui form" action="<%=path %>/teaAdd.action" name="form1" method="post">
				<div class="field">
					<label>编号：</label>
					<input name="teaBianhao" type="text"/>
				</div>
				<div class="field">
					<label>姓名：</label>
					<input type="text" name="teaRealname"/>
				</div>
				<div class="field">
					<label>性别：</label>
					<input type="radio" name="teaSex" value="男" checked="checked"/>男
					<input type="radio" name="teaSex" value="女"/>女
				</div>
				<div class="field">
					<label>年龄：</label>
					<input type="text" name="teaAge"/>
				</div>
				<div class="field">
					<label>联系方式：</label>
					<input type="text" name="teaTel"/>
				</div>
				<div class="field">
					<label>住址：</label>
					<input type="text" name="teaAddress"/>
				</div>
				<div class="field">
					<label>简历：</label>
					<textarea rows="7" cols="50" name="teaJianli"></textarea>
				</div>
				<div class="field">
					<label>所授课程：</label>
					<select name="kechengId" id="kechengId"></select>
					<em color="red" style="font-size: 10px;">如果没有课程。先录入课程信息</em>
				</div>
				<div class="field">
					<label>登录账号：</label>
					<input type="text" name="loginName"/>
				</div>
				<div class="field">
					<label>登录密码：</label>
					<input type="text" name="loginPw"/>
				</div>
				<div>
					<input type="hidden" name="xibieId" value="<%=request.getParameter("xibieId") %>">
					<button class="mini ui primary button" type="submit">确定</button>
					<button class="mini ui button" type="button" onclick="javascript:history.go(-1);">返回</button>
				</div>
			</form>
		</div>
	</body>
</html>
