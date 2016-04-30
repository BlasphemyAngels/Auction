<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		data-options="prompt:'请输入用户名',menu:'#mm',searcher:doSearch"
		style="width: 300px"></input>
	<div id="mm">
		<div data-options="name:'all',iconCls:'icon-ok'">所有用户</div>
		<div data-options="name:'admin',iconCls:'icon-ok'">管理员</div>
	</div>
	<script>
		function doSearch(value, name) {
			var u = "search=" + name + "&part=" + value;
			$('#userlist').datagrid({
				url : "${pageContext.request.contextPath }/ListAllUsersJson?" + u
			})
			$('#userlist').datagrid('reload');
		}
	</script>


	<div style="margin: 20px 0;"></div>
	<table id="userlist" class="easyui-datagrid" title="用户列表"
		style="width: 990px; height: 250px"
		data-options="singleSelect:true,collapsible:true,url:'${pageContext.request.contextPath }/ListAllUsersJson',method:'get',rownumbers:true,pagination:true,pageSize:10">
		<thead>
			<tr>
				<th data-options="field:'userId',width:50">用户ID</th>
				<th data-options="field:'username',width:80">用户名</th>
				<th data-options="field:'usertype',width:80">用户类型</th>
				<th data-options="field:'name',width:80">姓名</th>
				<th data-options="field:'email',width:100">email</th>
				<th data-options="field:'ID',width:95">身份证号</th>
				<th data-options="field:'tel',width:80">电话</th>
				<th data-options="field:'addr',width:150">地址</th>
				<th data-options="field:'userstate',width:80">信息完善</th>
				<th data-options="field:'admin',width:80">类型升级</th>
				<th data-options="field:'status',width:80,align:'center'">审查信息</th>
			</tr>
		</thead>
	</table>
</body>
</html>