<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/head.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>详细信息</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/index.css" />
	<style type="text/css">
		ul{
			list-style: none;
		}
		li{
			font-size: 30px;
			font-weight: bolder;
			font-family: 'Microsoft YaHei', arial, tahoma, \5b8b\4f53, sans-serif;
			margin-top: 10px;
		}
		#image{
			height: 250px;
		}
		#compPrice{
			font-size: 30px;
			font-weight: bolder;
			color: red;
			font-family: 'Microsoft YaHei', arial, tahoma, \5b8b\4f53, sans-serif;
			font-weight: bolder;
		}
	</style>
</head>
<body>
	<div class="container">
		<ul>
			<li id="commTitle">物品名称：</li>
			<li id="owner">物品发布人：</li>
			<li id="pubDate">发布日期：</li>
			<li id="endDate">截止日期：</li>
			<li id="closed">状态：</li>
			<li id="buyer">成交人：</li>
			<li id="image">物品图片：</li>
			<li id="price">底价：</li>
			<li id="price2">成交价格</li>
		</ul>
		<c:if test="true">
			<a href=""><div id="compPrice">去竞价</div></a>
		</c:if>
	</div>
</body>
</html>