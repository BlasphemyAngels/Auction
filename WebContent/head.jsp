<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#head {
	height: 50px;
	background-color: #f8f8f8;
}

#head-left, #head-right {
	list-style: none;
}

#head-left li {
	font-size: 20px;
	float: left;
	margin-left: 10px;
	margin-top: 15px;
}

#head-left li a, #head-right li a {
	text-decoration: none;
	color: #C5C1AA;
}

#head-right li {
	font-size: 18px;
	float: right;
	margin-right: 20px;
	margin-top: 15px;
}
</style>
</head>
<body>
<div id="head">
		<ul id="head-left">
			<li><a href="${pageContext.request.contextPath }/index.jsp" style="font-weight: bold;">竞拍网</a></li>
			<li><a href="${pageContext.request.contextPath }/index.jsp" style="font-size: 18px">主页</a></li>
			<li><a href="${pageContext.request.contextPath }/ListAllCommodityServlet?page=1" style="font-size: 18px">竞拍列表</a></li>
		</ul>
		<ul id="head-right">
			<li><c:choose>
					<c:when test="${user!=null }">
						<a href="${pageContext.request.contextPath }/index.jsp">${user.username }</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath }/LoginUIServlet">登录</a>
					</c:otherwise>
				</c:choose></li>
			<li><c:choose>
					<c:when test="${user!=null }">
						<a
							href="${pageContext.request.contextPath }/LoginServlet?method=logout">注销</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath }/RegisterUIServlet">注册</a>
					</c:otherwise>
				</c:choose></li>
			<c:if test="${user != null&&user.username=='admin' }">
				<li><a href="">网站管理</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>