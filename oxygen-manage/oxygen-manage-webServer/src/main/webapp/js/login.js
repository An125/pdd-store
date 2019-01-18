$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 输入框获取焦点后出现下划线
	$('.form-control').focus(function() {
		$(this).parent().addClass('fg-toggled');
	}).blur(function() {
		$(this).parent().removeClass('fg-toggled');
	});
});
Checkbix.init();
$(function() {
	// 点击登录按钮
	$('#login-bt').click(function() {
		login();
	});
	// 回车事件
	$('#username, #password').keypress(function (event) {
		if (13 == event.keyCode) {
			login();
		}
	});
});
// 登录
function login() {
	$.ajax({
		type: 'POST',
		url:'manage/login',
		dataType : 'json',
		data: {
			"username": $('#username').val().trim(),
			"password": $('#password').val(),
			"rememberMe": $('#rememberMe').is(':checked')
			
		},
		success : function(result) {
			if(result.reflag==true){
			window.location.href="index.html";
			}else {
				alert("账号或密码错误,请确认")
			}
		},

	});
}