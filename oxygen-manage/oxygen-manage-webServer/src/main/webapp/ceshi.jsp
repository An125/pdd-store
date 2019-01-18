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
			url : 'manage/systemCreate',
			dataType : 'json',
			data : {
				"icon":'蘑菇头图标',
				"banner":'黑色背景',
				"theme":'什么主题',
				"basepath":'e盘',
				"status":1,
				"name":'啊啊啊',
				"title":'嘤嘤嘤',
				"description":'我特么一拳一个嘤嘤怪',
				"createBy":'尼古拉斯赵四',
				"updateBy":'尼古拉斯赵四',
				"remarks":'哈哈哈这个逼贼菜',
				"delFlag":'从不立弗莱格'
				
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