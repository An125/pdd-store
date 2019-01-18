<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1>上传</h1>
<form action="<c:url value='add_photograph'/>" method="post" enctype="multipart/form-data">
  产	  品:<input type="text" name="product"/><br/>
  报	  价:<input type="text" name="offer"><br/>
  最高价:<input type="text" name="top_Price"><br/>
  最低价:<input type="text" name="floor_Price"><br/>
  进 	  价:<input type="text" name="zhaop"><br/>
  照	  片：<input type="file" name="zhaoPian"/><br/>
  <input type="submit" value="上传"/>
</form>
  </body>
</html>
