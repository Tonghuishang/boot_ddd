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
<body>
	<form id="fm" >
		用户名(昵称)：	<input type="text" name="userName" onchange="show()" ><br>

		性       别：	<input type="radio" name="sex" value="42" onchange="show()" >男
						<input type="radio" name="sex" value="43" onchange="show()" >女<br>
						<input type="hidden" id="pageNo" name="pageNo" value="1"  >

		最 小 年  龄：	<input type="text" name="startAge" onchange="show()" ><br>

		最大年龄：		<input type="text" name="endAge" onchange="show()" ><br>

		最后登录时间：		<input type="text" name="startTime" onchange="show()" >~
						<input type="text" name="endTime" onchange="show()" ><br>
	</form>
	<table align="center" width="75%" border="1px" cellspacing="0px" bordercolor="red">
		<tr>
			<th>用户id</th>
			<th>用户名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>昵称</th>
			<th>最后登陆时间</th>
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
		var i =1
		function limit(aa, pages) {
			if (aa) {
				if(i-1==0){
					layer.msg("首页");
					return;
				}
				i--;
				$("#pageNo").val(i);
				layer.msg("第"+i+"页");
			} else {
				if(i+1 > pages){
					layer.msg("尾页");
					return;
				}
				i++;
				$("#pageNo").val(i);
				layer.msg("第"+i+"页");
			}
			show();
		}
		function show(){
			$.post(
					"<%=request.getContextPath() %>/u/show",
					$("#fm").serialize(),
					function (result){
						var htmls="";
						var htmlPage="";
						for (var i = 0; i < result.data.records.length; i++) {
							var c=result.data.records[i];
							htmls+="<tr align='center' >";
							htmls+="<td>"+c.userId+"</td>"
							htmls+="<td>"+c.userName+"</td>";
							htmls+="<td>"+c.sexShow+"</td>";
							htmls+="<td>"+c.age+"</td>";
							htmls+="<td>"+c.nickName+"</td>";
							htmls+="<td>"+c.loginTimeShow;+"</td>";
							htmls+="<td>";
							htmls+="<input type='button' value='修改' onclick='update("+c.id+")' >"
							htmls+="<input type='button' value='删除' onclick='delete1("+c.id+","+c.userId+")' >"
							htmls+="</td>";
							htmls+="<tr>";
						}
						htmlPage+='<input type="button"   onclick="limit(true, '+result.data.pages+')" value="上一页" >';
						htmlPage+='<input type="button"   onclick="limit(false, '+result.data.pages+')" value="下一页" >';
						$("#tb").html(htmls);
						$("#page").html(htmlPage);
					}
			)
		}

		function delete1(id,userId){
			$.post(
					"<%=request.getContextPath() %>/u/delete1",
					{"userId":userId,"id":id},
					function (result){
						show();
					}
			)
		}

		function update(id){
			layer.open({
				type: 2,
				shadeClose: true,
				shade: [0.8, '#393049'],
				area: ['600px', '400px'],
				skin: 'layui-layer-rim',
				maxmin: true,
				content: "<%=request.getContextPath()%>/u/toUpdate/"+id,
				end: function () {
					location.reload();
				}
			});
		}
	</script>
	
</html>