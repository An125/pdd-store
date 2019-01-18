<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="${pageContext.request.contextPath}/guo_js/themes/icon.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/guo_js/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/guo_js/demo/demo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/guo_js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/guo_js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/guo_js/easyui-lang-zh_CN.js"></script>
<style type="text/css">
boby,div {
	padding: 0px;
	margin: 0pc;
}

.onMouse { /* 背景- */
	color: red;
	cursor: pointer;
}

.onrMouse {
	
}
</style>
</head>
<body>
	<!-- 设置宽高 行高 指定背景色 -->
	<div>
		<div style="width:100%;height:30px;line-height:30px;background-color: #D1EADA;">
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
	</div>
	<br>
</body> 
<script type="text/javascript">
var width = $(window).width()-80;  
	var height = $(window).height()-120;  
	$(function() {
	$("#tabDiv1").datagrid({
			url : "",
			title : "用户信息",
			width : width,
			height : 550,
 			pagination:true, 
 			pageSize:25,
 			pageList : [25,50,75,100],
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
			onDblClickRow : onDblClickRowCpxx

		});
		$("#tabDiv2").datagrid({
			/* url : "",
			title : "用户信息",
			width : 1100,
			height : 450,
			loadMsg : "正在加载,请稍后...",
			rownumbers : true,
			striped : true,
			singleSelect : true, */
			width : width,
			height : 550,
			url : "",
			title : "商户信息",
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
			onDblClickRow : onDblClickRowGetZb
		});
		document.getElementById('tt1').style.display = "none";
		document.getElementById('tt2').style.display = "none";
	});
	function onDblClickRowGetZb() {

	}
	function onDblClickRowCpxx() {
	}
	//加载商户信息
	function admin() {
		//alert("11111111");
		document.getElementById('tt1').style.display = "block";
		document.getElementById('tt2').style.display = "none";
		lx = 'cp';

		//获取所有商户信息
		//var year = $("#begintime").datebox("getValue");
		$('#tabDiv1').datagrid({
		
			url : "Adminxx"

		});
		
		alert(url);

	}
	//用户信息
	function user() {
		document.getElementById('tt1').style.display = "none";
		document.getElementById('tt2').style.display = "block";
		//var year = $("#begintime").datebox("getValue");
		lx = 'yh';

		$('#tabDiv2').datagrid({
			url : "Userxx"
		});
		
	}
	/* function sous() {
		var name= document.getElementsByName('name1');
		alert(name);
	} */
</script>
</html>
