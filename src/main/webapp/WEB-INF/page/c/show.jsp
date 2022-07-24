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
	<form id="fm" >
		<h2>学习课程表</h2>
	</form>
	<table align="center" width="75%" border="1px" cellspacing="0px" bordercolor="red">
		<tr>
			<th>编号</th>
			<th>课程名</th>
			<th>教具数</th>
			<th>使用教师数</th>
			<th>排序</th>
			<th>操作</th>
		</tr>
		<tbody id ="tb" ></tbody>
	</table>
	<div id="page"></div>
</body>
	<script type="text/javascript">
		$(function(){
			show();
		})

		function show(){
			$.post(
					"<%=request.getContextPath() %>/c/show",
					$("#fm").serialize(),
					function (result){
						var htmls="";
						for (var i = 0; i < result.data.length; i++) {
							var c=result.data[i];
							htmls+="<tr align='center' >";
							htmls+="<td>"+c.id;+"</td>"
							htmls+="<td>"+c.courseName+"</td>";
							if(c.traNumber > 0){
								htmls+="<td><input type='button' value='"+c.traNumber+"' onclick='queryTra("+c.id+")'></td>";
							}else{
								htmls+="<td>"+c.traNumber+"</td>";
							}
							if(c.teacherNumber > 0){
								htmls+="<td><input type='button' value='"+c.teacherNumber+"' onclick='queryTeacher("+c.id+")' ></td>";
							}else{
								htmls+="<td>"+c.teacherNumber+"</td>";
							}

							htmls+="<td>"+c.sort+"</td>";
							htmls+="<td>"
							htmls+="<input type='button' value='上移' onclick='orderBy("+c.id+",1)' >"
							htmls+="<input type='button' value='下移' onclick='orderBy("+c.id+",2)' >"
							htmls+="<input type='button' value='置顶' onclick='orderBy("+c.id+",3)' >"
							htmls+="<input type='button' value='置地' onclick='orderBy("+c.id+",4)' >"
							htmls+="</td>"
							htmls+="<tr>";
						}
						$("#tb").html(htmls);
					}
			)
		}

		function queryTra(id){
			layer.open({
				type: 2,
				shadeClose: true,
				shade: [0.8, '#393049'],
				area: ['600px', '400px'],
				skin: 'layui-layer-rim',
				maxmin: true,
				content: "<%=request.getContextPath()%>/c/toTraShow/"+id,
				end: function () {
					location.reload();
				}
			});
		}

		function queryTeacher(id){
			layer.open({
				type: 2,
				shadeClose: true,
				shade: [0.8, '#393049'],
				area: ['600px', '400px'],
				skin: 'layui-layer-rim',
				maxmin: true,
				content: "<%=request.getContextPath()%>/c/toTeacherShow/"+id,
				end: function () {
					location.reload();
				}
			});
		}
		function  orderBy(id,state){
			$.post(
					"<%=request.getContextPath() %>/c/orderBy",
					{"id":id,"state":state},
					function (result){
						show();
					}
			)
		}
	</script>
	
</html>