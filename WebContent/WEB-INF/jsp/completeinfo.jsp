<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="qdu.ccl.tag" prefix="q" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/userdetail.css">

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
	<q:CheckLoginTag/>
	<div id="complete-info-container">
		<div style="margin: 20px 0;"></div>
		<div class="easyui-panel" title="完善信息" style="width: 450px">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" method="post">
					<table cellpadding="5">
						<tr>
							<td>姓名:</td>
							<td><input class="easyui-textbox" type="text" id="personname" name="personname"
								data-options="required:true" /></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input class="easyui-textbox" type="text" id="email" name="email"
								data-options="required:true,validType:'email'"></input></td>
						</tr>
						<tr>
							<td>身份证号:</td>
							<td><input class="easyui-textbox" type="text" id="ID" name="ID"
								data-options="required:true, validType:['integer', 'length[18, 18]']"></input></td>
						</tr>
						<tr>
							<td>电话:</td>
							<td><input class="easyui-textbox" type="text" id="tel" name="tel"
								data-options="required:true, validType:['integer', 'length[11, 11]']"></input></td>
						</tr>
						<tr>
							<td>地址:</td>
							<td><input class="easyui-textbox" id="addr" name="addr"
								data-options="multiline:true, required:true" style="height: 60px"></input></td>
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
					url: '${pageContext.request.contextPath }/CompleteInfoServlet',
					success: function(){
						window.location.replace("${pageContext.request.contextPath}/CompleteInfoUIServlet");
					}
				});
			}
			function clearForm() {
				$('#ff').form('clear');
			}
		</script>
	</div>
</body>
</html>