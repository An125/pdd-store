<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>产品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;height: 180px;
		text-align: center;
		float: left; 
	} 
</style>
  </head>
  
  <body>
<c:forEach items="${select_quotation }" var="Quotation">
  <div class="icon" font-size="10">                                                              <!-- book_img/9317290-1_l.jpg -->
    <%-- <a href="<c:url value='/lookPhotograph?method=load&bid=${book.bid }'/>"><img src="<c:url value='/${book.image }'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/lookPhotograph?method=load&bid=${book.bid }'/>">${book.bname }</a> --%>
   	<%-- <a href="<c:url value='/select_quotation'/>"><img src="<c:url value='/${Quotation.path }'/>" border="0"/></a> --%>
   <%-- 	<img src="<c:url value='/${Quotation.path }' height="200" width="200"/>" border="0"/> --%>
   <img src="<c:url value='/${Quotation.path }'/>" width="160" height="180" border="0"/>
  ${Quotation.product }
  </div>
</c:forEach>
  </body>
 
</html>

