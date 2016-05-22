<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>学生信息管理系统</title>
		<meta charset="utf-8" />
		<link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path %>/js/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=path %>/js/semantic.min.js" ></script>
		<script>
			$(document).ready(function() {
				$('.ui.vertical.menu a.item')
						.on('click', function() {
							$(this)
									.addClass('active')
									.siblings()
									.removeClass('active');
						});
			});
		</script>
	</head>
	<body style="background-color: #f2f2f2;">
		<div class="ui vertical menu" style="width: 175px; margin-top: 5px;">
			<a href="<%=path %>/astu/right.jsp" class="item active" target="rightF">
				<span style="margin-left: 7px;"><i class="home icon"></i>首页</span>
			</a>
			<a href="<%=path %>/kechengAllAll.action" class="item" target="rightF">
				<span style="margin-left: 7px;"><i class="asterisk icon"></i>课程信息管理</span>
			</a>
			<a href="<%=path %>/chengjiMine.action" class="item" target="rightF">
				<span style="margin-left: 7px;"><i class="table icon"></i>成绩信息查询</span>
			</a>
			<a href="<%=path %>/gonggaoMana.action" class="item" target="rightF">
				<span style="margin-left: 7px;"><i class="bars icon"></i>系统公告</span>
			</a>
			<a href="<%=path %>/astu/userinfo/userinfo.jsp" class="item" target="rightF">
				<span style="margin-left: 7px;"><i class="announcement icon"></i>个人信息</span>
			</a>
			<a href="#" onclick="javascript:parent.parent.location='<%=path %>/login.jsp';" class="item" target="rightF">
				<span style="margin-left: 7px;"><i class="power icon"></i>安全退出</span>
			</a>
		</div>
	</body>
</html>