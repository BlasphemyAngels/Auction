<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/head.jsp"></jsp:include>
<%@ taglib uri="qdu.ccl.tag" prefix="q" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网站管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" />
</head>
<body>
	<q:CheckAdminTag/>
	<div id="admin-container">
		<div id="admin-container-menu">
			<ul id="admin-container-menu-ul">
				<li class="admin-container-menu-ul-li"><a href="${pageContext.request.contextPath }/UserManagerUIServlet" target="bottomframe">用户管理</a></li>
				<li class="admin-container-menu-ul-li"><a href="${pageContext.request.contextPath }/CommodityManagerUIServlet" target="bottomframe">商品管理</a></li>
				<li class="admin-container-menu-ul-li"><a href="${pageContext.request.contextPath }/BidManagerUIServlet" target="bottomframe">竞价管理</a></li>
			</ul>
		</div>
		<div id="bottom">
			<iframe id="bottomframe" name="bottomframe" src="${pageContext.request.contextPath }/UserManagerUIServlet"
					height="400px" width="1000px" frameborder="0"></iframe>
		</div>	
	</div>
</body>
</html>