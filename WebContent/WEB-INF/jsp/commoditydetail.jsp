<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/head.jsp"></jsp:include>
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
	href="href=${pageContext.request.contextPath }/css/commoditydetail.css" />
<style type="text/css">
#container {
	width: 600px;
}

#bid-right {
	margin-top: -400px;
	margin-right: 180px;
	float: right;
}

ul {
	list-style: none;
}

li {
	font-size: 16px;
	font-weight: bolder;
	font-family: 'Microsoft YaHei', arial, tahoma, \5b8b\4f53, sans-serif;
	margin-top: 10px;
}

#image {
	height: 150px;
}

#compPrice {
	margin-top: 150px;
}

#compPrice a {
	font-size: 30px;
	font-weight: bolder;
	color: red;
	font-family: 'Microsoft YaHei', arial, tahoma, \5b8b\4f53, sans-serif;
	font-weight: bolder;
	float: right;
	margin-top: -500px;
}

#commImg {
	width: 300px;
	height: 140px;
}
</style>
</head>
<body>
	<div class="container">
		<q:CommodityDetail />
		<ul id="ul">
			<li id="commTitle">物品名称：${commoditydetail.title }</li>
			<li id="owner">物品发布人：${owner.username }</li>
			<li id="pubDate">发布日期：${el:formatDate(commoditydetail.pub_date) }</li>
			<li id="endDate">截止日期：${el:formatDate(commoditydetail.end_date) }</li>
			<li id="closed">状态：${commoditydetail.closed?'成交':'接受竞价' }</li>
			<c:if test="${!empty buyer }">
				<li id="buyer">成交人：${buyer.username }</li>
			</c:if>
			<li id="image">物品图片：<br /> <img id="commImg" alt="去竞价"
				src="${pageContext.request.contextPath }/GetCommodityImageServlet?img=${commoditydetail.image }" /></li>

			<li id="price">底价：${commoditydetail.price }</li>
			<c:choose>
				<c:when test="${bid==null }">
					<li>目前最高出价:&nbsp;${commoditydetail.price }</li>
				</c:when>
				<c:otherwise>
					<li>目前最高出价:&nbsp;${bid.price }</li>
				</c:otherwise>
			</c:choose>
			<c:if test="${!empty buyer && commoditydetail.closed }">
				<li id="price2">成交价格:${bid.price }</li>
			</c:if>
		</ul>
		<%-- 
		<c:if
			test="${!commoditydetail.closed && user!=null && userCheck.checkState && !empty isBid && isBid }">
			<div id="compPrice">
				<a href="${pageContext.request.contextPath }/BidUIServlet"><img
					alt="去竞价" src="${pageContext.request.contextPath }/images/comp.jpg"></a>
			</div>
		</c:if> --%>
	</div>
	<c:if
		test="${!commoditydetail.closed && user!=null && userCheck.checkState && !empty isBid && isBid }">

		<div id="bid-right">
			<iframe id="leftframe" name="leftframe"
				src="${pageContext.request.contextPath }/BidUIServlet"
				height="400px" width="500px" frameborder="0"></iframe>
		</div>
	</c:if>
</body>
</html>