<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试测试测试</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	document.getElementsByTagName("html")[0].onclick = function() {
		
		//生成订单（一种商品对应一条订单）
		    $.ajax({
			type : 'post',
			url : 'orderMgr/orderCreate',
			dataType : 'json',
			data : {
				"goodId":"aw1234",
				"userId":20,
				"shopId":"000000000",
				"userAddressId":30,
				"quantity":55,
				"token":"710dc26e25a8f85017e6f73deb467415"
				
			},
			success : function(result) {
					alert(result);
				}
			});  
		
	//取消订单
	  /* $.ajax({
		type : 'post',
		url : 'orderMgr/orderCancel',
		dataType : 'json',
		data : {
			"id":28,
			"token":"59ea83b15807c6d071dfc174b83ee431"
		},
		success : function(result) {
		alert(result);
		}
		}); */  
			
		//取消退货
		/* $.ajax({
			type : 'post',
			url : 'orderMgr/orderReturnCancel',
			dataType : 'json',
			data : {
				"id":29
		
		},
		success : function(result) {
		alert(result);
		}
		});  */

		//分页查询订单
		/*  $.ajax({
			type : 'post',
			url : 'orderMgr/orderQueryPaging',
			dataType : 'json',
			data : {
			
				"userId":3,
				"state":3,
				"pageNo":1,
				"pageSize":5,
				"token":"438cf706efb86eb26183a761d5dd226e"
			
			},
			success : function(result) {
					alert(result);
				}
			}); */  

		//查询一条订单		
		/* $.ajax({
		type : 'post',
		url : 'orderMgr/orderQueryOne',
		dataType : 'json',
		data : {
		
			"userId":1,
			"id":3,
			"token":"31b6cb2cc5e472f84c5541ac2e4e365a"
		
		},
		success : function(result) {
				alert(result);
			}
		});  */
		
		//删除订单
		/*  $.ajax({
				type : 'post',
				url : 'orderMgr/orderDelete',
				dataType : 'json',
				data : {
					"id":3,
					"token":"b0bdf0e49f66629e37199df236b9c735"
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