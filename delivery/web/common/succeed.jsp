<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
  <head>
       <script type="text/javascript">
           <s:if test="message!=null">
               alert("<s:property value='message'/>");
           </s:if>
           
           <s:if test="path!=null">
              document.location.href="<%=path%>/<s:property value='path'/>";
           </s:if>
       </script>
  </head>
  <body>
  </body>
</html>
