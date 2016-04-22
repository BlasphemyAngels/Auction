<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户详细信息</title>
<style type="text/css">
	#left{
		float: left;
		margin-left: 300px;
		margin-top: 150px;
	}
	#right{
		margin-top: 150px;
		margin-left: 150px;
		float: left;
	}
</style>
</head>
<body>
	<div id="left">
		<iframe id="leftframe" name="leftframe" src="${pageContext.request.contextPath }/UserDetailLeftUIServlet"
				height="600px" width="300px" frameborder="0"></iframe>
	</div>
	<div id="right">
		<iframe id="rightframe" name="rightframe" src="${pageContext.request.contextPath }/UserDetailIndexUIServlet"
				height="600px" width="800px" frameborder="0"></iframe>
	</div>
</body>
</html>