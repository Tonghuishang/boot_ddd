<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>\jq\jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>\layer-v3.5.1\layer\layer.js" ></script>
</head>
<body>
	<form id="fm" >
				
		用户名：	<input type="text" name="userName" > <br>
		
		密码：	<input type="password" name="userPwd" > <br>
		
		性别：	<input type="radio" name="sex" value="42" checked >男
				<input type="radio" name="sex" value="43" >女<br>

		年龄：	<input type="text" name="age" ><br>

		昵称：	<input type="text" name="nickName"  ><br>
				<input type="button" value="注册" onclick="add()" > <br>
	</form>

</body>
	<script type="text/javascript">
	function add(){
		$.post(
			"<%=request.getContextPath()%>/u/add",
			$("#fm").serialize(),
			function (result){
				layer.msg(result.msg);
				if(result.code==200){
					location.href="<%=request.getContextPath()%>/u/toLogin"
				}	
			}
		)
		
	}
	
	</script>
	
</html>