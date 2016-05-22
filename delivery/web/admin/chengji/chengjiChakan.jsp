<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
	  <title>学生成绩浏览</title>
	  <meta charset="utf-8" />
	  <link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
	  <script type='text/javascript' src='<%=path %>/dwr/interface/tongyongService.js'></script>
	  <script type='text/javascript' src='<%=path %>/dwr/interface/kechengService.js'></script>
	  <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
	  <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
	  <script type="text/javascript">
		  function check() {
			  if(document.from1.xuyuanId.value==0) {
				  alert("请选择学院");
				  return;
			  }
			  if(document.from1.kechengId.value==0) {
				  alert("请选择课程");
				  return;
			  }
			  else {
				  document.from1.submit();
			  }
		  }

		  function init() {
			  tongyongService.findAllXuyuan(callBackXueyuan);
			  kechengService.findAllKecheng(callBackKecheng)
		  }
		  function callBackXueyuan(data) {
			  DWRUtil.addOptions("xuyuanId",data,"xuyuanId","xuyuanName");
		  }
		  function callBackKecheng(data) {
			  DWRUtil.addOptions("kechengId",data,"kechengId","kechengName");
		  }

		  /**
		   * 学院选项
		   */
		  function xuyuanChange() {
			  var xuyuanId=document.getElementById("xuyuanId").value;
			  if(xuyuanId!=0) {
				  tongyongService.findAllXibei(xuyuanId,callBackXibie);
			  }
			  if(xuyuanId==0) {
				  DWRUtil.removeAllOptions("xibieId");
				  DWRUtil.addOptions("xibieId",{0:'--请选择系别--'});
			  }
		  }
		  function callBackXibie(data) {
			  DWRUtil.removeAllOptions("xibieId");
			  DWRUtil.addOptions( "xibieId",{0:'--请选择系别--'});
			  DWRUtil.addOptions("xibieId",data,"xibieId","xibieName");
		  }

		  function xibieChange() {
			  var xibieId=document.getElementById("xibieId").value;
			  if(xibieId!=0) {
				  tongyongService.findAllZhuanye(xibieId,callBackZhuanye);
			  }
			  if(xibieId==0) {
				  DWRUtil.removeAllOptions("zhuanyeId");
				  DWRUtil.addOptions("zhuanyeId",{0:'--请选择专业--'});
			  }
		  }
		  function callBackZhuanye(data) {
			  DWRUtil.removeAllOptions("zhuanyeId");
			  DWRUtil.addOptions( "zhuanyeId",{0:'--请选择专业--'});
			  DWRUtil.addOptions("zhuanyeId",data,"zhuanyeId","zhuanyeName");
		  }
		  function zhuanyeChange() {
			  var zhuanyeId=document.getElementById("zhuanyeId").value;
			  if(zhuanyeId!=0) {
				  tongyongService.findAllBanji(zhuanyeId,callBackBanji);
			  }
			  if(zhuanyeId==0) {
				  DWRUtil.removeAllOptions("banjiId");
				  DWRUtil.addOptions("banjiId",{0:'--请选择班级--'});
			  }
		  }
		  function callBackBanji(data) {
			  DWRUtil.removeAllOptions("banjiId");
			  DWRUtil.addOptions( "banjiId",{0:'--请选择班级--'});
			  DWRUtil.addOptions("banjiId",data,"banjiId","banjiName");
		  }
	  </script>
  </head>
  <body onload="init()">
	  <div style="width: 95%; margin: auto; margin-top: 25px;">
		  <form  class="ui form" action="<%=path %>/chengjiChakan.action" name="from1" method="post">
			  <div class="sixteen fields">
				  <div class="field">
					  <label>选择学院</label>
					  <select name="xuyuanId" id="xuyuanId" onchange="xuyuanChange()">
						  <option value="0">---请选择学院---</option>
					  </select>
				  </div>
				  <div class="field">
					  <label>选择系别</label>
					  <select name="xibieId" id="xibieId" onchange="xibieChange()">
						  <option value="0">---请选择系别---</option>
					  </select>
				  </div>
				  <div class="field">
					  <label>选择专业</label>
					  <select name="zhuanyeId" id="zhuanyeId" onchange="zhuanyeChange()">
						  <option value="0">---请选择专业---</option>
					  </select>
				  </div>
				  <div class="field">
					  <label>选择班级</label>
					  <select name="banjiId" id="banjiId">
						  <option value="0">---请选择班级---</option>
					  </select>
				  </div>
			  </div>
			  <div class="sixteen fields">
				  <div class="field">
					  <label>选择课程</label>
					  <select name="kechengId" id="kechengId">
						  <option value="0">---请选择课程---</option>
					  </select>
				  </div>
			  </div>
			  <button class="ui submit primary button" type="button" onclick="check()">确定</button>
		  </form>
	  </div>
  </body>
</html>

