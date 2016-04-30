<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="qdu.ccl.tag" prefix="q" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/userdetail.css">
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<q:CheckLoginTag/>
	<div id="up-psw-container">
		<form action="${pageContext.request.contextPath }/UpdatePswServlet"
			target="rightframe">
			<ul id="up-psw-container-ul">
				<li class="up-psw-container-ul-li">原&nbsp;密&nbsp;码：<input
					id="oldpassword" name="oldpassword" type="password"
					value="${form.oldpassword }" /><span class="up-psw-container-ul-li-text"><c:if test="${form!=null }">
									${form.errors.oldpassword }
								</c:if></span></li>
				<li class="up-psw-container-ul-li">新&nbsp;密&nbsp;码：<input
					id="newPassword" name="newPassword" type="password"
					value="${from.newPassword }" /><span class="up-psw-container-ul-li-text"><c:if test="${form!=null }">
									${form.errors.newPassword }
								</c:if></span></li>
				<li class="up-psw-container-ul-li">确&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;认：<input
					id="repeatPassword" name="repeatPassword" type="password"
					value="${form.repeatPassword }" /><span class="up-psw-container-ul-li-text"><c:if test="${form!=null }">
									${form.errors.repeatPassword }
								</c:if></span>
				</li>
				<li class="up-psw-container-ul-li">验&nbsp;证&nbsp;码：<input type="text"
					id="ranomdWord" name="ranomdWord"><img alt="换一张"
					src="${pageContext.request.contextPath }/GenerateRandomImage"
					onclick="changeImage(this)" style="cursor: hand" /><span class="up-psw-container-ul-li-text"><c:if
						test="${empty form }">
									${form.errors.ranomdWord }
								</c:if>
								</span>
				</li>
				<li class="up-psw-container-ul-li"><div
						id="up-psw-container-reset">
						<input type="reset">
					</div></li>
				<li class="up-psw-container-ul-li"><div
						id="up-psw-container-submit">
						<input type="submit">
					</div></li>
			</ul>
		</form>
	</div>
</body>
</html>