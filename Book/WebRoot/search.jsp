<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	  .font1{font-size:13px;}
	</style>
  </head>
  
  <body>
    <s:form action="selectBook" method="post" theme="simple">
      <table border="1" width="200" cellspacing =1 class="font1">
        <tr bgcolor="#E9EDF5">
          <td>内容选择</td>
        </tr>
        <tr>
          <td align="left" valign="top" height="400">
            <br>借书证号：<br><br>
            <s:textfield name="lend.readerId" size="15"></s:textfield>
            <s:submit value="查询"></s:submit>
          </td>
        </tr>
      </table>
    </s:form>
     <br>
  </body>
</html>
