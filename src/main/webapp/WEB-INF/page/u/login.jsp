<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>\jq\jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>\layer-v3.5.1\layer\layer.js" ></script>
</head>
<body align="center" >
	<form id="fm" align="center" >
		<table bgcolor="yellow" border="1px" cellspacing="0" align="center">
			<tr>
				<th width="120">用户名:</th>
				<td width="140" align="center">
					<input type="text" name="userName"  />
				</td>
			</tr>
			<tr>
				<th>密码:</th>
				<td align="center">
					<input type="password"  name="userPwd"  />
				</td>
			</tr>
			<tr align="center">
				<td>
					<input type="button" value="登录" onclick="login()"  />
				</td>
				<td>
					<input type="button" value="还没有账号？点我注册" onclick="register()" >
				</td>
			</tr>
		</table>
	</form>
</body>
	<script type="text/javascript">

	function login(){
		$.post(
			"<%=request.getContextPath() %>/u/login",
			$("#fm").serialize(),
			function (result){
				layer.msg(result.msg)
				if(result.code==200){
					location.href="<%=request.getContextPath()%>/u/index";

				}
			}
		)
	}

	function register() {
		 layer.open({
	         type: 2,
	         shadeClose: true,
	         shade: [0.8, '#393049'],
	         area: ['700px', '500px'],
	         skin: 'layui-layer-rim',
	         maxmin: true,
	         content: "<%=request.getContextPath()%>/u/toRegister",
	         end: function () {
	             location.reload();
	         }
	     });
	}

	</script>
	
</html>