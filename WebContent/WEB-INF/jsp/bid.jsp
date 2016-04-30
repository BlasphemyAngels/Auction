<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="qdu.ccl.tag" prefix="q"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>竞价</title>
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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/base.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/login.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
#bid-container {
	overflow: hidden;
}
</style>
<script type="text/javascript">
	$(function() {
		$('input[type=text]').validatebox();
	})
</script>
</head>
<body>
	<q:CheckAddCommTag />
	<div id="bid-container">
		<div style="margin: 20px 0;"></div>
		<div class="easyui-panel" title="报价" style="width: 50s0px">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" method="post">
					<table cellpadding="5">
						<tr>
							<td>出价:</td>
							<td><input class="easyui-textbox" type="text" validtype ="integer" name="price"
								data-options="required:true"></input></td>
						</tr>
						<tr style="width: 150px;">
							<td>备注:</td>
							<td><input class="easyui-textbox" name="note"
								data-options="multiline:true"
								style="height: 60px; width: 150px;"></input></td>
						</tr>
						<tr>
							<td>验证码:</td>
							<td><input class="easyui-textbox" type="text"
								name="randomWord" data-options="required:true"></input><img
								alt="换一张"
								src="${pageContext.request.contextPath }/GenerateRandomImage"
								onclick="changeImage(this)" style="cursor: hand" /></td>
						</tr>
					</table>
					<input type="hidden" name="commId"
						value="${commoditydetail.comm_id }" />
				</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitForm()">提交</a> <a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="clearForm()">重置</a>
				</div>
			</div>
			<a href="#" class="easyui-linkbutton"></a>
		</div>
		<script>
			function submitForm() {
				$('#ff').form('submit', {
					url : '${pageContext.request.contextPath}/AddBidServlet',
					success : function(data) {
						var data = eval('(' + data + ')');
						if (data.randomWord == false) {
							$.messager.confirm('注意', '验证码错误', function(r) {
								if (r) {
								}
							});
						}
						if (data.end == true)
						{
							$.messager.confirm('注意', '很遗憾，拍卖已经结束', function(r) {
								if (r) {
								}
							});
						}
						window.open("${pageContext.request.contextPath}/CommodityDetailUIServlet?commId=${commoditydetail.comm_id }", '_top');
					}
				});
			}
			function clearForm() {
				$('#ff').form('clear');
			}
			$.extend($.fn.validatebox.defaults.rules, {
				integer : {
					validator : function(value, param) {
						if (/^[+]?[1-9]\d*$/.test(value)==false)
							return false;
						return value > ${commoditydetail.price }
					},
					message : '请输入最小为${commoditydetail.price }的整数'
				},
			})
		</script>
	</div>
</body>
</html>