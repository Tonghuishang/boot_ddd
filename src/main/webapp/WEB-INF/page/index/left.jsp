<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>\jq\jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>\zTree_v3-master\js\jquery.ztree.core.js"></script>
</head>
<body>
	<h1>总控制台</h1>
	<h3><a href="<%=request.getContextPath()%>/u/toShow" target="right" >用户展示</a></h3>
	<h3><a href="<%=request.getContextPath()%>/c/toShow" target="right" >课程展示</a></h3>
</body>
<%--<script type="text/javascript">
	var setting = {
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pId"
			},
			key: {
				name: "name",
				url: "resource"
			}
		},
		callback: {
			onClick: function (event, treeId, treeNode) {
				if (!treeNode.isParent) {
					parent.right.location.href = "<%=request.getContextPath()%>" + treeNode.url;
				}
			}
		}
	};

	//展示
	$(function(){
		$.post(
				"<%=request.getContextPath()%>/z/ztreeBaseData",
				{},
				function (result) {
					$.fn.zTree.init($("#treeDemo"), setting, result.data);
				}
		);
	});

	var setting = {
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pId"
			},
			key: {
				name: "name",
			}
		},
		callback: {
			onClick: function (event, treeId, treeNode) {
				if (!treeNode.isParent) {
					parent.right.location.href = "<%=request.getContextPath()%>" + treeNode.urlResource;
				}
			}
		}
	};

	//展示
	$(function(){
		$.post(
				"<%=request.getContextPath()%>/u/ztreeBaseData",
				{},
				function (result) {
					$.fn.zTree.init($("#treeDemo"), setting, result.data);
				}
		);
	});

</script>--%>
</html>