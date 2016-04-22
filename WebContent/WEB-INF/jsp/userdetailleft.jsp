<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/userdetail.css">
<style type="text/css">
	#left-body-ul{
		list-style: none;
		font-weight: bolder;
	}
	.left-body-ul-li{
		margin-top: 10px;
	}
	.left-body-ul-li a{
		color: black;
		text-decoration: none;
	}
</style>
</head>
<body>
	<div id="left-body">
		<ul id="left-body-ul">
			<li class="left-body-ul-li"><a href="${pageContext.request.contextPath }/UpdatePasswordUIServlet" target="rightframe">修改密码 </a></li>
			<li class="left-body-ul-li"><a href="">完善信息</a></li>
			<li class="left-body-ul-li"><a href="">买到的物品</a></li>
			<li class="left-body-ul-li"><a href="">最近交易</a></li>
			<li class="left-body-ul-li"><a href="">联系我们</a></li>
		</ul>
	</div>
</body>
</html>