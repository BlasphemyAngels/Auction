<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.lang.*" %>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/login.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/login.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/register.js"></script>
</head>
<body>
	<div id="container">
		<div id="login">
			<div id="top"></div>
			<div id="mid" style="height: 200px;">
				<form id="loginform" style="padding-top: 0px;" method="post"
					
					action="${pageContext.request.contextPath }/RegisterServlet">
					<div id="inpuser">
						<span id="usernameFont">用&nbsp;户&nbsp;名：</span><input type="text" id="username"
							name="username" value="${form.username }" /><span
							id="usernameSp" style="display: none">用户名不能为空！！！</span>
							<span class="Sp2">
								<c:if test="${form!=null }">
									${form.errors.username }
								</c:if>
							</span>
					</div>
					<div id="inpsw">
						<span id="passwordFont">密&nbsp;&nbsp;&nbsp;码：</span><input
							type="password" id="password" name="password"
							value="${form.password }" /><span id="passwordSp"
							style="display: none">密码不能为空！！！
							</span>
							<span class="Sp2">
								<c:if test="${form!=null }">
									${form.errors.password }
								</c:if>
							</span>
					</div>
					<div id="inpsw2">
						<span id="repeatPasswordFont">确认密码&nbsp;：</span><input type="password" id="password2" name="password2"
							value="${form.password2 }" /><span id="password2Sp"
							style="display: none">密码不能为空！！！</span>
							<span class="Sp2">
								<c:if test="${form!=null }">
									${form.errors.password2 }
								</c:if>
							</span>
					</div>
								<div id="randomword">
								<span id="randomFont">验&nbsp;证&nbsp;码：</span><input type="text" name="ranomdWord"><img alt="换一张" src="${pageContext.request.contextPath }/GenerateRandomImage" onclick="changeImage(this)" style="cursor:hand" />
								<span style="color: red;">${form.errors.ranomdWord }</span>
							</div>
					<div id="submit">
						<input type="submit" value="提交" /> <input type="reset" value="重置" />
						<a href="${pageContext.request.contextPath }/index.jsp"
							target="_self">[返回首页]</a>
					</div>
				</form>

			</div>
			<div id="bottom"></div>
		</div>
	</div>
</body>
</html>