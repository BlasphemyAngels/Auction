<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户详细信息</title>
<style type="text/css">
	#body{
		overflow: hidden;
	}
	#left{
		float: left;
		margin-left: 200px;
		margin-top: 50px;
	}
	#right{
		margin-top: 50px;
		margin-left: 100px;
		float: left;
	}
</style>
</head>
<body>
	<div id="left">
		<iframe id="leftframe" name="leftframe" src="${pageContext.request.contextPath }/UserDetailLeftUIServlet"
				height="400px" width="200px" frameborder="0"></iframe>
	</div>
	<div id="right">
		<iframe id="rightframe" name="rightframe" src="${pageContext.request.contextPath }/UserDetailIndexUIServlet"
				height="400px" width="600px" frameborder="0"></iframe>
	</div>
</body>
</html>