<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<frameset rows="25%,75%">
	<frame src="<%=request.getContextPath()%>/u/top"  name="top" />
	<frameset cols="20%,80%"  >
	<frame src="<%=request.getContextPath()%>/u/left"  name="left" >
	<frame src="<%=request.getContextPath()%>/u/right" name="right" >
	</frameset>
	
	</frameset>
</html>