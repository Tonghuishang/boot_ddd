<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>\jq\jquery-1.12.4.min.js" ></script>
</head>
<body  align='center'>
	<form id="fm"  action="<%=request.getContextPath()%>/users" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		用户名：<input type="text" name="userName"/><br>
		密码 ： <input type="text" name="userPwd"/><br>
		<button type="submit">submit</button>
		<input type="button"  value="ajaxKy" onclick="ajaxKy()">
		<input type="button"  value="ajax" onclick="ajax()">
	</form>
</body>
	<script type="text/javascript">
		function ajaxKy(){
			$.ajax({
				url:"http://localhost:8081/ssm_03/user/show?i=1",
				data:{},
				type:"PUT",
				success:function (result) {
					alert(result.data.pages);
				},
				error:function (result) {

				}
			})
		}

		function ajax(){
			$.ajax({
				url:"<%=request.getContextPath()%>/users",
				contentType:"application/json:charset:utf-8",
				data:JSON.stringify({"userName":"zs","userPwd":"123","id":1}),
				adtaType:"json",
				type:"PUT",
				success:function (result) {
					alert(result.data);
				},
				error:function (result) {

				}
			})
		}
	</script>
</html>