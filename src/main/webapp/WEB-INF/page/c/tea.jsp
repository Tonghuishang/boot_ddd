<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<table align="center">
		<tr>
			<th>编号</th>
			<th>教师名</th>
			<th>使用时间</th>
			<th>是否结束</th>
		</tr>
		<tbody id="tb"></tbody>
	</table>


</body>
	<script type="text/javascript">
		var htmls = "";
		htmls +="<tr>";
			<c:forEach items="${tea}"  var="t" >
				htmls+="<td>${t.id}</td>";
				htmls+="<td>${t.teacherName}</td>";
				htmls+="<td>${t.foTime}</td>";
				htmls+="<td>${t.isDel}</td>";
			</c:forEach>
		htmls +="</tr>";
		$("#tb").html(htmls);
	</script>
</html>