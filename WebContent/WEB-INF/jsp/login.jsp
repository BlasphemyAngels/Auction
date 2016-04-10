<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="qdu.ccl.tag" prefix="q" %>

<q:AdminForward/> --%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<script type="text/javascript" src="js/login.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/login.css" />
</head>
<body>
	<div id="container">
		<div id="login">
			<div id="top">
				<br> <br>
			</div>
			<div id="mid">
				<form id="loginform" method="post" onsubmit="return check()"
					action="${pageContext.request.contextPath }/LoginServlet?method=login">
					<div id="message">${message }</div>
					<div id="inpuser">
						用户名：<input type="text" id="username" name="username"
							value="${form.username }" /><span id="usernameSp"
							style="display: none">用户名不能为空！！！</span>
					</div>
					<div id="inpsw">
						密&nbsp;码：<input type="password" id="password"
							name="password" value="${form.password }" /><span
							id="passwordSp" style="display: none">密码不能为空！！！</span>
					</div>
					<div id="randomword">
						验证码：<input type="text" name="randomWord"><img alt="换一张"
							src="${pageContext.request.contextPath }/GenerateRandomImage"
							onclick="changeImage(this)" style="cursor: hand" /><span
							style="color: red;">${form.errors.randomWord }</span>
					</div>
					<div id="submit">
						<input type="submit" value="登录" /> <a
							href="${pageContext.request.contextPath }/RegisterUIServlet"><input
							type="button" value="注册" /></a> <a
							href="${pageContext.request.contextPath }/index.jsp"
							target="_self">[返回首页]</a>
					</div>
				</form>

			</div>
			<div id="bottom"></div>
		</div>
	</div>
</body>
</html>