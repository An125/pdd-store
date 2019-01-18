<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	document.getElementsByTagName("html")[0].onclick = function() {
		
		$.ajax({
			type : 'post',
			url : 'appVersion/checkVersion',
			dataType : 'json',
			data : {
				"number":4.0,
				"remarks":"修复bug",
				"token":"f38825ccf455506d581df0755e701bcc"
			},
			success : function(result) {
				alert(result);
			}
		});
	};
</script>
</head>

<body>

</body>
</html>