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
			<a href="<%=path %>/admin/right.jsp" class="item active" target="rightF">
				<span style="margin-left: 7px;">
					<i class="home icon"></i>
					首页
				</span>
			</a>
			<a href="<%=path %>/xuyuanMana.action" class="item" target="rightF">
				<span style="margin-left: 7px;">
					<i class="asterisk icon"></i>
					基础信息管理
				</span>
			</a>
			<a href="<%=path %>/kechengManage.action" class="item" target="rightF">
				<span style="margin-left: 7px;">
					<i class="table icon"></i>
					课程信息管理
				</span>
			</a>
			<a href="<%=path %>/admin/chengji/chengjiChakan.jsp" class="item" target="rightF">
				<span style="margin-left: 7px;">
					<i class="bars icon"></i>
					学生成绩浏览
				</span>
			</a>
			<a href="<%=path %>/gonggaoMana.action" class="item" target="rightF">
				<span style="margin-left: 7px;">
					 <i class="announcement icon"></i>
					公告信息管理
				</span>
			</a>
			<a href="<%=path %>/admin/userinfo/userinfo.jsp" class="item" target="rightF">
				<span style="margin-left: 7px;">
					<i class="setting icon"></i>
					修改个人密码
				</span>
			</a>
			<a href="#" onclick="javascript:parent.parent.location='<%=path %>/login.jsp';" class="item" target="rightF">
				<span style="margin-left: 7px;">
					<i class="power icon"></i>
					安全退出
				</span>
			</a>
		</div>
	</body>
</html>
