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
		// 用户注册
		/* $.ajax({
			type : 'post',
			url : 'userMgr/userRegister',
			dataType : 'json',
			data : {
				'mobile':'13567114719',
				'password' : '123456',
				'repeatPassword' : '123456',
				'invitation' : ''
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		// 用户收货地址新增
		 $.ajax({
			type : 'post',
			url : 'userMgr/userAddressAdd',
			dataType : 'json',
			data : {
				'userId' : 20,
				'theConsignee' : '泰日天',
				'phone' : '13567114718',
				'areaId' : 0571,
				'address' : '临平银泰城地下停车场',
				'isChoice' : 1,
				'token':'da730012de841dd5d6b9f606a6339485'
			},
			success : function(result) {
				alert(result);
			}
		}); 
		
		// 查询手机号是否可用
		/*  $.ajax({
			type : 'post',
			url : 'userMgr/userCheck',
			dataType : 'json',
			data : {
				'mobile' : '13567114724',
				"token":""
			},
			success : function(result) {
				alert(result);
			}
		});   */
		
		// 用户登录
		/* $.ajax({
			type : 'post',
			url : 'userMgr/userLogin',
			dataType : 'json',
			data : {
				'mobile' : '13567114710',
				'password' : '123456',
				'repeatPassword' : '123456',
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		// 查询收货地址
/* 		$.ajax({
			type : 'post',
			url : 'userMgr/userAddressQuery',
			dataType : 'json',
			data : {
				'userId' : 1,
				'token':"406b22fb0959869c44776266805dea7e"
			},
			success : function(result) {
				alert(result);
			}
		}); */
		
		// 修改默认收货地址
		 /* $.ajax({
			type : 'post',
			url : 'userMgr/userAddressChangeDefault',
			dataType : 'json',
			data : {
				'id' : 28,
				'userId' : 16,
				'token':"1fbdc10149f8595ad4f2117803fbba05"
			},
			success : function(result) {
				alert(result);
			}
		});  */
		
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
		
		//验证码校验
/* 		$.ajax({
			type : 'post',
			url : 'userMgr/checkCode',
			dataType : 'json',
			data : {
				'params' : "appkey=26b7f00c86630&amp;phone=13989891987&amp;zone=86&amp;&amp;code=7563"
			},
			success : function(result) {
				alert(result);
			}
		});*/
	}; 
</script>
</head>
<body>

</body>
</html>