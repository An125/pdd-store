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
		/* $.ajax({
			type : 'post',
			url : 'shopMgr/goodsQueryOne',
			dataType : 'json',
			data : {
				"shopId" : "000000000",
				"goodId":'45643254',
				"token":"8b3f5969bfe68d4b7ff1d0481e168399"
			},
			success : function(result) {
				alert(result);
			}
		}); */

		// 登录
		/*  $.ajax({
			type : 'post',
			url : 'shopMgr/shopLogin',
			dataType : 'json',
			data : {
				"phoneNumber" : "13567114713",
				"password" : "123456",
				"token":"d305e1fa8c3f035221e05274f5bf5a7e"
			},
			success : function(result) {
				alert(result);
			}
		}); */ 
		
		// 商户注册
		/*  $.ajax({
			type : 'post',
			url : 'shopMgr/shopRegister',
			dataType : 'json',
			data : {
				"shopName" : "商铺03号",
				"password" : "123456",
				"repeatPassword" : "123456",
				"identityCard" : "330184198511181810",
				"phoneNumber" : "13567114716",
				"token":"6cc7df024ac8a0fb969b146071662b20"
			},
			success : function(result) {
				alert(result);
			}
		});  */
		
		//模糊查询商品
		 /* $.ajax({
				type : 'post',
				url : 'shopMgr/goodsFuzzySearch',
				dataType : 'json',
				data : {
					"shopId" : "000000000",
					"keyWords":"米",
					"token":"3e403ff0cdf3d31a573470360a854c50"
				},
				success : function(result) {
					alert(result);
				}
			});  */
		//收藏和取消收藏	
		/*  $.ajax({
			type : 'post',
			url : 'shopMgr/goodsCollect',
			dataType : 'json',
			data : {
				"userId" : 9,
				"goodId":"0123456789",
				"token":"f98f3fd67f449ff3a7447ee07f558b3c"
			},
			success : function(result) {
				alert(result);
			}
		});  */
		
		//分页查询
		$.ajax({
			type : 'post',
			url : 'shopMgr/collectionPagingQuery',
			dataType : 'json',
			data : {
				"userId" : 9,
				"token":"5d4ad82c18eba64bc5104dd3e8f42a54"
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