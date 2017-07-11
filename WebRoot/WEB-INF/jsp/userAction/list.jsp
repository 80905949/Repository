<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管算</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
		<script type="text/javascript">
	    function chk_dl(){
		    if (confirm('确定要删除这条数据吗？')) {
				return true;
			}else {
				return false;
	        }
		}
	</script>
</head>

<body>
	<div id="pageAll">

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
						<div class="cfD">
							<s:a action="user_saveUI" cssClass="addA addA1">用户</s:a>
						</div>
				</div>
				<!-- banner 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="23.5%" class="tdColor">登录名</td>
							<td width="23.5%" class="tdColor">密码</td>
							<td width="23.5%" class="tdColor">真实姓名</td>
							<td width="23.5%" class="tdColor">电话号码</td>
							<td width="300px" class="tdColor">操作</td>
						</tr>
						<s:iterator value="recordList">
						<tr>
							<td>${no}</td>
							<td>${pwd}</td>
							<td>${name}</td>
							<td>${tel}</td>
							<td>
								<s:a action="user_editUI?id=%{id}"><img class="operation" src="img/update.png" /></s:a>
								<s:a action="user_delete?id=%{id}" onclick="return confirm('确定要修好了吗？')"><img class="operation delban" src="img/delete.png" /></s:a>				
							</td>
						</tr>
						</s:iterator>
					</table>
										<div class="paging">
					<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
					<s:form action="user_list"></s:form>										
					</div>
					
				</div>
				<!-- banner 表格 显示 end-->
			</div>
			<!-- banner页面样式end -->
		</div>

	</div>
<!-- 分页信息 -->


	<!-- 删除弹出框  end-->
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