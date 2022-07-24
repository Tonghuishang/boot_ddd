<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: lavender;">

	<center>
		<h1>来了菜逼</h1>
		<marquee  style="color:pink " >欢迎登录学生宿舍管理系统 &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp 
		 &nbsp  &nbsp    &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp
		 欢迎登录学生宿舍管理系统   &nbsp  &nbsp    &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp 
		 &nbsp  &nbsp    &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp 欢迎登录学生宿舍管理系统 </marquee>
		 <!--  <marquee>欢迎登录学生宿舍管理系统</marquee> -->
		城市：${city}&nbsp  &nbsp    &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp
		温度：${tempeRature}&nbsp  &nbsp    &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp
		天气：${weather}&nbsp  &nbsp    &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp  &nbsp  &nbsp   &nbsp  &nbsp<br>
		每日语录：#{text}
	</center>
	<div style="text-align: right; margin-top: 20px;margin-right: 20px;">

<h3><label id="time" style="color: #AC2925; "></label></h3>

</div>
<script>

function mytime(){

var a = new Date();

var b = a.toLocaleTimeString();

var c = a.toLocaleDateString();

document.getElementById("time").innerHTML = c+"&nbsp"+b;

}

setInterval(function() {mytime()},1000);

</script>
</body>
</html>