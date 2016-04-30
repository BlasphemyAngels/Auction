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
	<q:CheckLoginTag/>
	<table id="pg" class="easyui-propertygrid" style="width: 500px"
		data-options="
				url:'${pageContext.request.contextPath }/GetUserDetailJson',
				method:'post',
				showGroup:false,
				showHeader:false,
				scrollbarSize:0
			">
	</table>
</body>
</html>