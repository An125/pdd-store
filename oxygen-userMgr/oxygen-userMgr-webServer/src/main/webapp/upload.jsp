<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/userMgr/upload" enctype="multipart/form-data" method="post">
  	  手机号：<input type="text" class="required" name="mobile"> 
  	<br><br>   
        上传文件：<input type="file" name="file"><br/>
        <br><br>
         <input type="submit" value="提交">
     </form>
</body>
</html>