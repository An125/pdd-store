<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	document.getElementsByTagName("html")[0].onclick = function() {
		//删除购物车
/* 		$.ajax({
			type : 'post',
			url : 'shoppingCart/cartDelete',
			dataType : 'json',
			data : {
				"userId":1,
				"goodsId":"0123456789",
				"token":"b99eaab3b881aa13674fb5bdc0401f09"
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
	//添加购物车
	/* $.ajax({
			type : 'post',
			url : 'shoppingCart/cartAdd',
			dataType : 'json',
			data : {
				"userId" : 1,
				"goodsId" : "55555",
				"quantity" : 15,
				"token" : "c2ad9bfc0f7f73abfc57133243f2d8bb"
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		//修改购物车
		/* $.ajax({
			type : 'post',
			url : 'shoppingCart/cartUpdate',
			dataType : 'json',
			data : {
				"userId" : 1,
				"goodsId" : "55555",
				"quantity" : 20,
				"token" : "3f687e15895cf416924ce772c717746f"
			},
			success : function(result) {
				alert(result);
			}
		}); */

		//查询购物车（分页）
		 $.ajax({
		 type : 'post',
		 url : 'shoppingCart/cartQuery',
		 dataType : 'json',
		 data : {
		 "userId":1,
		 "pageNo":1,
		 "pageSize":10,
		 "token":"3d7e112f8facf860c497107b2f1042bf"
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