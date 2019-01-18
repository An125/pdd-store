<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="guo_js/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="guo_js/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="guo_js/demo/demo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="guo_js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="guo_js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="guo_js/easyui-lang-zh_CN.js"></script>
<style type="text/css">
boby,div {
	padding: 0px;
	margin: 0px;
}

.onMouse { /* background- */
	color: red;
	cursor: pointer;
}

.onrMouse {
	
}
</style>
</head>

<body>
	<!-- 设置宽 高 行高 指定背景色-->
	<div>
<div
			style="width:100%;height:30px;line-height:30px;background-color: #D1EADA;">
			<div
				style="float:left;height:30px;line-height:30px;margin-left:10px;"
				onmouseover="this.className='onMouse'"
				onmouseout="this,className='outNouse'" onclick="user()">用户信息</div>
			<div
				style="float:left;height:30px;line-height:30px;margin-left:10px;"
				onmouseover="this.className='onMouse'"
				onmouseout="this.className='outMouse'" onclick="admin()">代理商信息</div>
		</div>
		<div id="tt1" style="padding-top:10px">
			<div id="tabDiv1"></div>
		</div>
		<div id="tt2" style="padding-top:10px">
			<div id="tabDiv2"></div>
		</div>
		<div id="tt3" style="padding-top:10px">
			<div id="tabDiv3"></div>
		</div>
	</div>

</body>
<script type="text/javascript">
	var width = $(window).width() - 80;
	var height = $(window).height() - 120;
	$(function() {
		$("#tabDiv1").datagrid({
			url : "",
			title : "用户信息",
			//width : width,
			//height : 550,
			fitColumns:true,//宽度自适应
			pagination : true,
			pageSize : 25,
			pageList : [ 25, 50, 75, 100 ],
			loadMsg : "正在加载，请稍等...",
			rownumbers : true,
			striped : true,
			singleSelect : true,
			columns : [ [ {
				field : 'username',
				title : '账户',
				//width : 200,
				lige : "center"
			}, {
				field : 'mobile',
				title : '手机号',
				//width : 200,
				lige : "center"
			}, {
				field : 'location',
				title : '所在店',
				//width : 100,
				lige : "center"
			}, {
				field : 'superior',
				title : '上级',
				width : 200,
				lige : "center"
			}, {
				field : 'consume',
				title : '总消费',
				//width : 100,
				lige : "center"
			} ] ],
			onDblClickRow : onDblClickRowyh,
			
		});
		
		$("#tabDiv2").datagrid({
			url : "",
			title : "商户信息",
			//width : width,
			//height : 550,
			fitColumns:true,//宽度自适应
			pagination : true,
			pageSize : 25,
			pageList : [ 25, 50, 75, 100 ],
			loadMsg : "正在加载，请稍等...",
			rownumbers : true,
			striped : true,
			singleSelect : true,
			columns : [ [ {
				field : 'username',
				title : '账户',
				//width : 200,
				lige : "center"
			}, {
				field : 'mobile',
				title : '手机号',
				//width : 200,
				lige : "center"
			}, {
				field : 'location',
				title : '所在店',
				//width : 100,
				lige : "center"
			}, {
				field : 'superior',
				title : '上级',
				width : 200,
				lige : "center"
			} ] ],
			
			
		});
		$("#tabDiv3").datagrid({
			url : "",
			title : "用户消费情况",
			fitColumns:true,//宽度自适应
			//width : width,
			//height : 550,
			pagination : true,
			pageSize : 25,
			pageList : [ 25, 50, 75, 100 ],
			loadMsg : "正在加载，请稍等...",
			rownumbers : true,
			striped : true,
			singleSelect : true,
			columns : [ [ {
				field : 'product',
				title : '产品',
				//width : 200,
				lige : "center"
			}, {
				field : 'merchants',
				title : '在此商家购买',
				//width : 200,
				lige : "center"
			}, {
				field : 'price',
				title : '价格',
				//width : 100,
				lige : "center"
			}, {
				field : 'quantity',
				title : '数量',
				width : 200,
				lige : "center"
			}, {
				field : 'Method',
				title : '支付方式',
				//width : 100,
				lige : "center"
			} ] ],
		});
		document.getElementById('tt1').style.display = "none";
		document.getElementById('tt2').style.display = "none";
		document.getElementById('tt3').style.display = "none";
	});
	//用户消费情况
	function onDblClickRowGetsf() {
		
	}
	function onDblClickRowyh() {
		document.getElementById('tt1').style.display = "none";
		document.getElementById('tt2').style.display = "none";
		document.getElementById('tt3').style.display = "block";
		var tabDiv3 = $('#tabDiv1').datagrid('getSelected');//返回第一个被选中的行
		var username = tabDiv3.username;
		$('#tabDiv3').datagrid({
			url : "Userxfqx?username=" + username + ""

		});
	}
	//用户信息
	function user() {
		document.getElementById('tt1').style.display = "block";
		document.getElementById('tt2').style.display = "none";
		document.getElementById('tt3').style.display = "none";
		$('#tabDiv1').datagrid({

			url : "Userxx"

		});
		
	}
	//加载商户信息
	function admin() {
		document.getElementById('tt1').style.display = "none";
		document.getElementById('tt2').style.display = "block";
		document.getElementById('tt3').style.display = "none";
		$('#tabDiv2').datagrid({
			url : "Adminxx"
		});

	}

</script>
</html>
