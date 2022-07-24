 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/jq/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/layer-v3.5.1/layer/layer.js" ></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<%--<script type="text/javascript">
	var userRank=${user.userRank}
	if(userRank !=2){
		$.post(
			"<%=request.getContextPath()%>/exp/commission",	
			{},
			function (result){
				 var msg = "你有"+result.data+"条待处理"; 
				 if (confirm(msg)==true){ 
					 location.href="<%=request.getContextPath()%>/exp/toShow"
				 }else{ 
				  return ;
				 }
			}
		)
	}
</script>--%>
</html>