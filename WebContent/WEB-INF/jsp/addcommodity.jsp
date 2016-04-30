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
<style type="text/css">
#container {
	margin: 0 auto;
	width: 700px;
	margin-top: -20px;
}
</style>
<script type="text/javascript">
	$(function() {
		$('input[type=text]').validatebox();
	})
</script>
</head>
<body>
	<q:CheckAdminTag/>
	<div id="container">
		<div style="margin: 20px 0;"></div>
		<div class="easyui-panel" title="添加商品" style="width: 600px">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" method="post" enctype="multipart/form-data">
					<table cellpadding="5">
						<tr>
							<td>商品标题:</td>
							<td><input class="easyui-textbox" type="text" name="title"
								data-options="required:true"></input></td>
							<td>商品快照:</td>
							<td><input class="easyui-filebox" name="image"
								data-options="prompt:'Choose file...',required:true"></td>
						</tr>
						<tr>
							<td>开始时间:</td>
							<td><input class="easyui-datetimebox" value=""
								name="pub_date" data-options="required:true" editable="false" /></td>
						</tr>
						<tr>
							<td>结束时间:</td>
							<td><input class="easyui-datetimebox" name="end_date"
								value="" data-options="required:true" editable="false" /></td>
						</tr>
						<tr>
							<td>底价:</td>
							<td><input class="easyui-textbox" name="price" validtype ="integer" type="text"
								data-options="required:true"></input></td>
						</tr>
					</table>
				</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitForm()">提交</a> <a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="clearForm()">重置</a>
				</div>
			</div>
		</div>
		<script>
			function submitForm() {
				$('#ff').form('submit',{
					url: '${pageContext.request.contextPath}/AddCommodityServlet',
					success: function(){
						window.location.replace("${pageContext.request.contextPath}/CommodityManagerUIServlet");
					}
				});
			}
			function clearForm() {
				$('#ff').form('clear');
			}

			$.extend($.fn.validatebox.defaults.rules, {
				integer : {
					validator : function(value, param) {
						return /^[+]?[1-9]\d*$/.test(value);
					},
					message : '请输入最小为1的整数'
				},
			})
		</script>
	</div>
</body>
</html>