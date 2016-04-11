<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>提示</title>
<style type="text/css">
	#container{
		background-image: url(${pageContext.request.contextPath }/images/login_bj.jpg);
		width: 924px;
		height: 400px;
		margin: 0 auto;
	}
	#goToIndex{
		color: white;
		font-size: 40px;
		margin-top: 100px;
		width: 30px;
		float: left;
	}
	#container a{
		text-decoration: none;
	}
	#goToLogin{
		float: right;
		font-size: 40px;
		margin-right: 600px;
	}
	#lo{
		color: white;
		font-weight: bolder;
	}
	#message{
		margin-top: 130px;
		color: black;
		font-size: 35px;
		text-align: center;
		font-weight: bolder;
		font-family:  'Microsoft YaHei',arial,tahoma,\5b8b\4f53,sans-serif;
	}
</style>
</head>
<body>
	<div id="message">${message }</div>
	<div id="container">	
		<div id="goToIndex"><a href="${pageContext.request.contextPath }/index.jsp" target="_top"><img alt="返回主页" src="${pageContext.request.contextPath }/images/timg.jpg"></a></div>
		<div id="goToLogin"><a href="${pageContext.request.contextPath }/LoginUIServlet" target="_top"><span id="lo">去登录</span></a>
		</div>
	</div>
</body>
</html>