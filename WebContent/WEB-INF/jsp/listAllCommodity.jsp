<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/head.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>物品列表</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/index.css" />
</head>
<body>
	<div class="container">
		<div class="col-md-9">
			<h3>商品列表</h3>
			<div id="pageSize">每页5条&nbsp;</div>
			<br />
			<table border="0" cellspacing="0" cellpadding="0"
				class="table-striped" style="border-collapse: collapse;">
				<tr class="ttr">
					<th>#</th>
					<th>拍品名称</th>
					<th>发布时间</th>
					<th>截止时间</th>
					<th>发布人</th>
					<th>状态</th>
				</tr>
				<c:forEach items="${commodities }" var="comm" varStatus="status">
						<tr class="ttt">
						<td>${status.count }</td>
						<td><a href="${pageContext.request.contextPath }/CommodityDetailUIServlet?commId=${comm.comm_id }">${comm.title }</a></td>
						<td>${comm.pub_date }</td>
						<td>${comm.end_date }</td>
						<td>${comm_user.username }</td>
						<td>${comm.closed?'成交':'接受竞价' }</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${isPage }">
				<div id="page-link">
					<div id="totPage">共${pageSize }页</div>
					<div id="firstPage">
						<a
							href="${pageContext.request.contextPath }/ListAllCommodityServlet?page=1">第一页</a>
					</div>
					<div id="endPage">
						<a
							href="${pageContext.request.contextPath }/ListAllCommodityServlet?page=${pageSize }">最尾页</a>
					</div>
					<div id="nextPage">
						<a
							href="${pageContext.request.contextPath }/ListAllCommodityServlet?page=${page+1 }">下一页</a>
					</div>
					<div id="upPage">
						<a
							href="${pageContext.request.contextPath }/ListAllCommodityServlet?page=${page-1 }">上一页</a>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>