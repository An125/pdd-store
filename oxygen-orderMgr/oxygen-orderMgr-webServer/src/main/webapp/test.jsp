<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车多件商品生成一条订单</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script language="JavaScript"
	src="https://cdn.bootcss.com/jquery-json/2.6.0/jquery.json.min.js"></script>
<script type="text/javascript">
	
	//购物车多件商品生成一条订单
	function submitUserList_3() {
		alert("ok");
		//定义一个数组
		 var arr = [];
		//将json格式的对象加入到数组中
		 arr.push({"userId": 21,"shopId": "hzpddylypyxgs","userAddressId": 35});
		 arr.push({"goodId":"xiaomi","quantity":6});
		 arr.push({"goodId":"999999","quantity":13});
		 arr.push({"goodId":"88888","quantity":777});
		/* var orderData = {
				"userId": 21,
				"shopId": "hzpddylypyxgs",
				"userAddressId": 35,
				"goods":[{"goodId":"xiaomi","quantity":6},{"goodId":"999999","quantity":13},{"goodId":"88888","quantity":777}]
		}; */
		
		$.ajax({
			url : "orderMgr/orderBatchCreate",
			type : "POST",
			contentType : 'application/json;charset=utf-8', //设置请求头信息（不可少，@RequestBody需要根据这个来确定需要使用HttpMessageConverter<T>来处理json）
			dataType : "json",  //后台返回的数据类型
			data:JSON.stringify(arr),       //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
			
			success : function(data) {
				alert(data);
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
	}
</script>
</head>

<body>
	<h1>批量商品生成一条订单</h1>
	<input id="submit" type="button" value="Submit"
		onclick="submitUserList_3();">
</body>
</html>