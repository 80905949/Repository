<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员管理-有点</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css"/>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/manhuaDate.1.0.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
	<script type="text/javascript">
	function check(){
		var no = document.getElementById("no").value;
   		if(no ==  null || no == ''){
        alert("账户不能为空");
        return false;
	   }
	      var p1 = document.getElementById("p1").value;
	   if(p1 ==  null || p1 == ''){
	        alert("密码不能为空");
	        return false;
	   }
	    var p2 = document.getElementById("p2").value;
	      if(p2 !==  p1 ){
	        alert("密码请输入一致");
	        return false;
	   }
	   return true;
	}
	$(function (){
	  $("input.mh_date").manhuaDate({
	    Event : "click",//可选               
	    Left : 0,//弹出时间停靠的左边位置
	    Top : -16,//弹出时间停靠的顶部边位置
	    fuhao : "-",//日期连接符默认为-
	    isTime : false,//是否开启时间值默认为false
	    beginY : 1949,//年份的开始默认为1949
	    endY :2100//年份的结束默认为2049
	  });
	});
</script>
</head>

<body>
	<div id="pageAll">
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					<span>用户</span>
				</div>
				<s:form action="user_add" onsubmit="return check()"  enctype="multipart/form-data">
    			<s:hidden name="id"></s:hidden>
				<div class="baBody">
					<div class="bbD">
						账户：<s:textfield name="no" cssClass="input1" />
					</div>
					<div class="bbD">
						姓名：<s:textfield name="name" cssClass="input1" />
					</div>
					<div class="bbD">
						电话：<s:textfield name="tel" cssClass="input1" />
					</div>
					<div class="bbD">
						邮箱：<s:textfield name="email" cssClass="input1" />
					</div>
					
					<div class="bbD">
						性别：<s:select name="gender" list="#{'男':'男','女':'女'}" cssClass="input1"></s:select>
					</div>
					<div class="bbD">
						性别：<s:select name="role" list="#{'teacher':'用户','admin':'admin'}" cssClass="input1"></s:select>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button type="submit" class="btn_ok btn_yes">提交</button>
							<a class="btn_ok btn_no" onclick="window.history.go(-1)" href="#">返回</a>
						</p>
					</div>
				</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
// 广告弹出框
$(".delban").click(function(){
  $(".banDel").show();
});
$(".close").click(function(){
  $(".banDel").hide();
});
$(".no").click(function(){
  $(".banDel").hide();
});
// 广告弹出框 end
</script>
</html>