<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/EL" prefix="el" %>
<%@ taglib uri="qdu.ccl.tag" prefix="q" %>
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
	<q:CheckAdminTag/>
	<div style="margin: 20px 0;"></div>
	<input class="easyui-searchbox"
		data-options="prompt:'请输入',menu:'#mm',searcher:doSearch"
		style="width: 300px"></input>
	<div id="mm">
		<div data-options="name:'all',iconCls:'icon-ok'">商品名称</div>
		<div data-options="name:'pubpeople',iconCls:'icon-ok'">发布人</div>
		<div data-options="name:'price',iconCls:'icon-ok'">最高价格</div>
	</div>
	<a href="${pageContext.request.contextPath }/AddCommodityUIServlet" target="bottomframe" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
	<script>
		function doSearch(value, name) {
			var u = "";
			if (name == 'all')
			{
				u = "tPart="+value;
			}else if(name == 'pubpeople')
			{
				u = "uPart="+value;
			}else
			{
				u = "price="+value;
			}
			$('#commoditylist').datagrid({
				url : "${pageContext.request.contextPath }/ListAllCommodityJson?" + u
			})
			$('#commoditylist').datagrid('reload');
		}
	</script>


	<div style="margin: 20px 0;"></div>
	<table id="commoditylist" class="easyui-datagrid" title="商品列表"
		style="width: 990px; height: 250px"
		data-options="singleSelect:true,collapsible:true,url:'${pageContext.request.contextPath }/ListAllCommodityJson',method:'get',rownumbers:true,pagination:true,pageSize:10">
		<thead>
			<tr>
				<th data-options="field:'comm_id',width:70">商品ID</th>
				<th data-options="field:'title',width:180">商品标题</th>
				<th data-options="field:'owner',width:80">发布人</th>
				<th data-options="field:'pub_date',width:150">发布日期</th>
				<th data-options="field:'end_date',width:150">截止日期</th>
				<th data-options="field:'closed',width:80">商品状态</th>
				<th data-options="field:'buyer',width:60">成交人</th>
				<th data-options="field:'succ_price',width:80">交易价格</th>
				<th data-options="field:'price',width:100">商品底价</th>
			</tr>
		</thead>
	</table>
</body>
</html>