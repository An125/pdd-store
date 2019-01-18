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
		
		// 微信支付生成订单
		$.ajax({
			type : 'post',
			url : 'payMgr/getPayUrl_wechat',
			dataType : 'json',
			data : {
				'outTradeNo' : 'pdd413fadsf134redf123',
				'totalAmount' : 1,
				'subject' : '测试一下支付后端',
				"token":"047301663d00bd26fec7790ad2170db9"
			},
			success : function(result) {
				alert(result);
			}
		});
		
		// 修改默认收货地址
		/* $.ajax({
			type : 'post',
			url : 'userMgr/userAddressChangeDefault',
			dataType : 'json',
			data : {
				'id' : 27,
				'userId' : 16
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		// 收货地址修改
		/* $.ajax({
			type : 'post',
			url : 'userMgr/userAddressUpdate',
			dataType : 'json',
			data : {
				'id' : 27,
				'phone' : '18329188126'
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		// 收货地址删除
		/* $.ajax({
			type : 'post',
			url : 'userMgr/userAddressDelete',
			dataType : 'json',
			data : {
				'id' : 27
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