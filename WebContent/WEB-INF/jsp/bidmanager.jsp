<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/themes/default/easyui1.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/themes/default/easyui2.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/themes/default/easyui3.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/themes/icon.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/login.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div style="margin: 20px 0;"></div>
	<input class="easyui-searchbox"
		data-options="prompt:'请输入',menu:'#mm',searcher:doSearch"
		style="width: 300px"></input>
	<div id="mm">
		<div data-options="name:'commtitle',iconCls:'icon-ok'">商品名称</div>
		<div data-options="name:'buyer',iconCls:'icon-ok'">购买者</div>
		<div data-options="name:'owner',iconCls:'icon-ok'">发布者</div>
	</div>
	<script>
		function doSearch(value, name) {
			var u = "method="+name+"&value="+value;
			$('#bidlist').datagrid({
				url : "${pageContext.request.contextPath }/ListAllBidsJson?" + u
			})
			$('#bidlist').datagrid('reload');
		}
	</script>


	<div style="margin: 20px 0;"></div>
	<table id="bidlist" class="easyui-datagrid" title="用户列表"
		style="width: 990px; height: 250px"
		data-options="singleSelect:true,collapsible:true,url:'${pageContext.request.contextPath }/ListAllBidsJson',method:'get',rownumbers:true,pagination:true,pageSize:10">
		<thead>
			<tr>
				<th data-options="field:'commId',width:50">商品ID</th>
				<th data-options="field:'title',width:100">商品名称</th>
				<th data-options="field:'buyer',width:100">叫价者</th>
				<th data-options="field:'cdate',width:150">交易时间</th>
				<th data-options="field:'price',width:80">出价</th>
				<th data-options="field:'buyertel',width:100">购买者电话</th>
				<th data-options="field:'ownertel',width:100">拍卖者电话</th>
				<th data-options="field:'addr',width:120">购买者地址</th>
				<th data-options="field:'note',width:130">备注</th>
			</tr>
		</thead>
	</table>
</body>
</html>