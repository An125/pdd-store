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
		// 分页查询产品接口测试
		$.ajax({
			type : 'post',
			url : 'shopMgr/goodsQuery',
			dataType : 'json',
			data : {
				"shopId" : "4cfef95eef7a4ff598b725c774c8e45b",
				"pageNo" : 1,
				"pageSize" : 10
			},
			success : function(result) {
				alert(result);
			}
		});

		// 登录
		/* $.ajax({
			type : 'post',
			url : 'shopMgr/shopLogin',
			dataType : 'json',
			data : {
				"phoneNumber" : "13567114714",
				"password" : "123456"
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		// 商户注册
		/* $.ajax({
			type : 'post',
			url : 'shopMgr/shopRegister',
			dataType : 'json',
			data : {
				"shopName" : "商铺注册测试01",
				"password" : "123456",
				"repeatPassword" : "123456",
				"identityCard" : "330184198511181814",
				"phoneNumber" : "13567114713"
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		// 查询商品详情
	/* 	$.ajax({
			type : 'post',
			url : 'shopMgr/goodsQueryOne',
			dataType : 'json',
			data : {
				"shopId" : "000000000",
				"goodId":'45643254'
			},
			success : function(result) {
				alert(result);
			}
		}); */
	};
</script>
</head>

<body>

</body>
</html>