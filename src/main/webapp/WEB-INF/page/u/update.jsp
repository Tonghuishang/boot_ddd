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
				<input type="hidden" name="id" value="${user.id}" >
				<input type="hidden" name="userId" value="${user.userId}" >
		用户名：	<input type="text" name="userName" value="${user.userName}" > <br>
		
		密码：	<input type="password" name="userPwd" value="${user.userName}" > <br>
		
		性别：	<input type="radio" name="sex" value="42" checked >男

				<input type="radio"  name="sex" value="43" >女<br>

		年龄：	<input type="text" name="age" value="${user.age}" ><br>

		昵称：	<input type="text" name="nickName" value="${user.nickName}" ><br>
				<input type="button" value="修改" onclick="update()" > <br>
	</form>

</body>
	<script type="text/javascript">
	function update(){
		$.post(
			"<%=request.getContextPath()%>/u/update",
			$("#fm").serialize(),
			function (result){
				if(result.code==200){
					parent.location.href="<%=request.getContextPath()%>/u/toShow"
				}	
			}
		)
		
	}
	
	</script>
	
</html>