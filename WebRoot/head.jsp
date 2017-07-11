<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>头部-有点</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<img class="headLogo" src="img/meitu_1.png" />
		</div>
		<div class="headR">
			<p class="p1">
				欢迎，
				${lname}
			</p>
			<p class="p2">
			<span id="localtime">2013-10-30 12:33:02  星期三</span><span><font color="white">|</font></span>  <a
					href="login_logout.action" target="_top" class="goOut">退出</a>
			</p>
		</div>
		<!-- onclick="{if(confirm(&quot;确定退出吗&quot;)){return true;}return false;}" -->
	</div>

	<div class="closeOut">
		<div class="coDiv">
			<p class="p1">
				<span>X</span>
			</p>
			<p class="p2">确定退出当前用户？</p>
			<P class="p3">
				<a class="ok yes" href="#">确定</a><a class="ok no" href="#">取消</a>
			</p>
		</div>
	</div>

<script type="text/javascript">  
function showLocale(objD)  
{  
    var str,colorhead,colorfoot;  
    var yy = objD.getYear();  
    if(yy<1900) yy = yy+1900;  
    var MM = objD.getMonth()+1;  
    if(MM<10) MM = '0' + MM;  
    var dd = objD.getDate();  
    if(dd<10) dd = '0' + dd;  
    var hh = objD.getHours();  
    if(hh<10) hh = '0' + hh;  
    var mm = objD.getMinutes();  
    if(mm<10) mm = '0' + mm;  
    var ss = objD.getSeconds();  
    if(ss<10) ss = '0' + ss;  
    var ww = objD.getDay();  
    if  ( ww==0 )  colorhead="<font color=\"white\">";  
    if  ( ww > 0 && ww < 6 )  colorhead="<font color=\"white\">";  
    if  ( ww==6 )  colorhead="<font color=\"white\">";  
    if  (ww==0)  ww="星期日";  
    if  (ww==1)  ww="星期一";  
    if  (ww==2)  ww="星期二";  
    if  (ww==3)  ww="星期三";  
    if  (ww==4)  ww="星期四";  
    if  (ww==5)  ww="星期五";  
    if  (ww==6)  ww="星期六";  
    tt="第二学期";
    if (MM<8) {tt="第一学期";}
    colorfoot="</font>";  
    str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + "  " + ww ;  
    return(str);  
};  
function tick()  
{  
    var today;  
    today = new Date();  
    document.getElementById("localtime").innerHTML = showLocale(today);  
    window.setTimeout("tick()", 1000);  
};  
tick();  
</script>  

</body>
</html>