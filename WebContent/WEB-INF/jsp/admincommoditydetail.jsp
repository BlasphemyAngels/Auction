<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="qdu.ccl.tag" prefix="q"%>
<%@ taglib uri="/EL" prefix="el"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/index.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/admincommoditydetail.css" />
</head>
<body>
	<q:CheckAdminTag/>
	<div class="container">
		<q:CommodityDetail />
		<ul>
			<li id="commTitle">物品名称：${commoditydetail.title }</li>
			<li id="owner">物品发布人：${owner.username }</li>
			<li id="pubDate">发布日期：${el:formatDate(commoditydetail.pub_date) }</li>
			<li id="endDate">截止日期：${el:formatDate(commoditydetail.end_date) }</li>
			<li id="closed">状态：${commoditydetail.closed?'成交':'接受竞价' }</li>
			<c:if test="${!empty buyer }">
				<li id="buyer">成交人：${buyer.username }</li>
			</c:if>
			<li id="image">物品图片：<br />
			<img id="commImg" alt=""
				src="${pageContext.request.contextPath }/GetCommodityImageServlet?img=${commoditydetail.image }" /></li>

			<li class="rl" id="price">底价：${commoditydetail.price }</li>
			<c:if test="${!commoditydetail.closed && !empty bid}">
				<li class="rl">目前最高出价:&nbsp;${bid.price }</li>
			</c:if>
			<c:if test="${!empty buyer && commoditydetail.closed }">
				<li id="price2" class="rl">成交价格:${bid.price }</li>
			</c:if>
			<li><c:if
					test="${!commoditydetail.closed && user!=null && userCheck.checkState }">
					<div id="compPrice">
						<a href="${pageContext.request.contextPath }/BidUIServlet"><img
							alt="去竞价"
							src="${pageContext.request.contextPath }/images/comp.jpg"></a>
					</div>
				</c:if></li>
		</ul>
	</div>
</body>
</html>