<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="qdu.ccl.tag" prefix="q" %>
<jsp:include page="/head.jsp"></jsp:include>
<html>
<head>
<title>竞拍网</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/index.css" />
</head>
<body>
	<div class="container">
		<div class="col-md-9">
			<h1 id="title">欢迎来到我们的网站</h1>
			<br />
			<div id="content"></div>
			<hr>
			<h3>部分商品</h3>
			<table border="0" cellspacing="0" cellpadding="0"
				class="table-striped" style="border-collapse: collapse;">
				<tr class="ttr">
					<th>#</th>
					<th>拍品名称</th>
					<th>发布时间</th>
					<th>截止时间</th>
					<th>发布人</th>
				</tr>
				<q:GetOneCommodity/>
				<c:if test="${comm!=null }">
					<tr class="ttt">
						<td>${comm.comm_id }</td>
						<td><a href="${pageContext.request.contextPath }/CommodityDetailUIServlet?commId=${comm.comm_id }">${comm.title }</a></td>
						<td>${comm.pub_date }</td>
						<td>${comm.end_date }</td>
						<td>${comm_user.username }</td>
					</tr>
				</c:if>
			</table>
			<br /> <a class="link" href="${pageContext.request.contextPath }/ListAllCommodityServlet?page=1">查看全部商品</a>
		</div>
	</div>

</body>
</html>