<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	<meta charset="utf-8">
	<meta author="zrong.me 曾荣">
	<title>地铁管理系统</title>
	<link rel="stylesheet" type="text/css" href="style/register-login.css">
	<style type="text/css">
		body{background-image:url("img/333.jpg");width:100%; height:100%;}
		</style>
	<style type="text/css">
			.code{
			background-image:url(111.jpg);
			font-family:Arial,宋体;
			font-style:italic;
			color:green;
			border:0;
			padding:2px 3px;
			letter-spacing:3px;
			font-weight:bolder;
			}
			.unchanged {
			border:0;
			}
			</style>
			<script language="javascript" type="text/javascript">
			var code ; //在全局 定义验证码
			function createCode(){ 
			code = new Array();
			var codeLength = 4;//验证码的长度
			var checkCode = document.getElementById("checkCode");
			checkCode.value = "";
			var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
			for(var i=0;i<codeLength;i++) {
			   var charIndex = Math.floor(Math.random()*32);
			   code +=selectChar[charIndex];
			}
			if(code.length != codeLength){
			   createCode();
			}
			checkCode.value = code;
			}
			function validate () {
				var inputCode = document.getElementById("verify").value.toUpperCase();
				if(inputCode.length <=0) {
				$("#check").html(123);
				   return false;
				}
				else if(inputCode == code ){
				   return true;
				}
				else {
					alert("验证码输入不一致");
					createCode();
				   return false;
				}
			}
		</script>
</head>
<body onLoad="createCode();">
<div id="box"></div>
<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">111</h1>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
		</div>
    	<form   action="login_login.action" method="post" onsubmit="return  validate()">

			<div class="login form">
				<div class="group">
					<div class="group-ipt email" id="loginname">
						<input type="text" name="no" id="no" class="ipt" placeholder="用户名" required>
					<!--  	<span id="nod"><font color="red"><s:fielderror/></font></span>-->
					</div>
					<div class="group-ipt password">
						<input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required>
					</div>
					
					<div class="group-ipt verify">
							<input type="text" name="verify" id="verify" class="ipt" placeholder="输入验证码" required><span style="color:#F00" id="check"></span>
										</div>
									<div class="group-ipt verify1">
					
							<input type="button" id="checkCode" class="ipt"  style="width:100px" onClick="createCode()" /> 
							<a href="#" onClick="createCode()"><font color="black">看不清楚</font></a>
					</div>
				</div>
			</div>
			<div class="remember clearfix">
				<label class="remember-me">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  id="type"  name="type" value="admin">管理员</label>
				<label class="remember-me">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="type"  name="type"  value="teacher" checked>用户</label>
			</div>
			<div class="button">
				<button type="submit" class="login-btn register-btn" id="button">登录</button>
			</div>
		</form>
	
	</div>
</div>

<div class="footer">
</div>

<script src='js/particles.js' type="text/javascript"></script>
<script src='js/background.js' type="text/javascript"></script>
<script src='js/jquery.min.js' type="text/javascript"></script>
<script src='js/layer/layer.js' type="text/javascript"></script>
<script src='js/index.js' type="text/javascript"></script>
</body>
</html>