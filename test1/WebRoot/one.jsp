<%@ page language="java" import="java.util.*" pageEncoding="UTf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
   <form action="getphoto.action" method="post" enctype="multipart/form-data">
    <input type="file" name="image">
    <input type="submit" value="提交">
    </form>
  </body>
</html>
