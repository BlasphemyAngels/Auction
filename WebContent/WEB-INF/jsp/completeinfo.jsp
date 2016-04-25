<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/userdetail.css">
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div id="complete-info-container">
		<form action="${pageContext.request.contextPath }/CompleteInfoServlet"
			target="rightframe">
			<ul id="complete-info-container-ul">
				<li class="complete-info-container-ul-li">姓名：<input
					id="personname" name="personname" type="text"
					value="${form.personname }" /><span class="complete-info-container-ul-li-text">
					<c:if test="${form!=null }">
									${form.errors.personname }
					</c:if></span>
				</li>
				<li class="complete-info-container-ul-li">email：<input id="email" name="email" type="text" value="${form.email }" />
					<span class="complete-info-container-ul-li-text">
						<c:if test="${form!=null }">
										${form.errors.email }
						</c:if>
					</span>
				</li>
				<li class="complete-info-container-ul-li">身份证号：<input id="ID" name="ID" type="text" value="${form.ID }" />
					<span class="complete-info-container-ul-li-text">
						<c:if test="${form!=null }">
										${form.errors.ID }
						</c:if>
					</span>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>