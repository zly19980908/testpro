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
    
    <title>图书管理系统</title>
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
    <table bgcolor="#71CABF" align="center">
      <%-- <tr>
          <td colspan="2"><jsp:include page="head.jsp"></jsp:include></td>
      </tr> --%>
      <tr>
          <td><jsp:include page="search.jsp"></jsp:include></td>
          <td><jsp:include page="lendbook.jsp"></jsp:include></td>
      </tr>
      <tr>
          <td colspan="2" align="center" class="font1">
          湖南中医药大学：长沙岳麓区含浦佳苑<br>
          湖南中医药大学研究所版权所有</td>
      </tr>
    </table>
  </body>
</html>
