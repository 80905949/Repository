<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
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
	
	function check() {
	     var start = document.getElementById("start").value;
	    var end = document.getElementById("end").value;
	    var d1 =start.replace(/\-/g, "");
		var d2 = end.replace(/\-/g, "");
	    if(start>end){alert("开始时间不能大于结束时间");
	     return false;
	    }else if(d1==""||d2==""){
	    	alert("时间不能为空");
	    	 return false;
	    }
	     return true;
	}

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
</head>
<body>
	<div id="pageAll">

		<div class="page">
			<div class="connoisseur">
				<div class="conform">
						<div class="cfD">
							<s:a action="info_addUI" cssClass="addA addA1">添加通知</s:a>
						</div>
				</div>
				<div class="conShow">
					<table cellpadding="0" cellspacing="0" border="0" id="table" >
						<thead>
							<tr>
								<td width="32%" style="height:40px;background-color:#f2f2f2;"><h3>标题</h3></td>
								<td width="64%" style="height:40px;background-color:#f2f2f2;"><h3>内容</h3></td>
								<td width="200px" style="height:40px;background-color:#f2f2f2;"><h3>操作</h3></td>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="recordList">
							<tr>
								<td >${title}</td>
								<td>${infos}</td>
								<td><s:a action="info_editUI?id=%{id}"><img class="operation" src="img/update.png" /></s:a>
									<s:a action="info_delete?id=%{id}" onclick="return confirm('确定要删除吗？')"><img class="operation delban" src="img/delete.png" /></s:a></td>
							</tr>
							</s:iterator>
						</tbody>
				  </table>
						<div class="paging">
					<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
					<s:form action="infos_list"></s:form>			
					</div>
			</div>
		</div>

	</div>
	
	<script type="text/javascript" src="script.js"></script>
	<script type="text/javascript">
  var sorter = new TINY.table.sorter("sorter");
	sorter.head = "head";
	sorter.asc = "asc";
	sorter.desc = "desc";
	sorter.even = "evenrow";
	sorter.odd = "oddrow";
	sorter.evensel = "evenselected";
	sorter.oddsel = "oddselected";
	sorter.paginate = true;
	sorter.currentid = "currentpage";
	sorter.limitid = "pagelimit";
	sorter.init("table",1);
  </script>
</body>
</html>