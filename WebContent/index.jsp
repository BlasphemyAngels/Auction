<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>竞拍网</title>
	<style type="text/css">
		.container{
			margin: 0 auto;
			width: 1000px;
			margin-left: 20%;
		}
		#head{
			height: 50px;
			background-color: #f8f8f8;
		}
		#head-left,#head-right{
			list-style: none;
		}
		#head-left li{
			font-size: 20px;
			float: left;
			margin-left: 10px;
			margin-top: 15px;
		}
		#head-left li a, #head-right li a{
			text-decoration: none;
			color: #C5C1AA;
		}
		#head-right li{
			font-size: 18px;
			float: right;
			margin-right: 20px;
			margin-top: 15px;
		}
		#title{
			color: black/* #8EE5EE */;
			font-size: 50px;
			font-weight: bolder;
			text-align: center;
			font-family:  'Microsoft YaHei',arial,tahoma,\5b8b\4f53,sans-serif;
		}
		.table-striped tr{
			border-top: 2px solid #DDDDDD;
			border-bottom: 2px solid #DDDDDD;
			background-color: #F9F9F9;
		}
		.ttr th{
			width: 200px;
			height: 40px;
			margin: 0;
		}
		.link{
			text-decoration: none;
			color: #23527C;
		}
		#content{
			background-image: url(${pageContext.request.contextPath }/images/index.jpg);
			height: 500px;
		}
	</style>
</head>
<body>
	<div id="head">
		<ul id="head-left">
			<li><a href="#" style="font-weight: bold;">竞拍网</a></li>
			<li><a href="#" style="font-size: 18px">主页</a></li>
			<li><a href="#" style="font-size: 18px">竞拍列表</a></li>
		</ul>
		<ul id="head-right">
			<li>
			<c:choose>
			<c:when test="${user!=null }"><a href="${pageContext.request.contextPath }/index.jsp" >${user.username }</a></c:when>
			<c:otherwise>
			<a href="${pageContext.request.contextPath }/LoginUIServlet" >登录</a>
			</c:otherwise>
			</c:choose>
			</li>
			<li>
			<c:choose>
			<c:when test="${user!=null }"><a href="${pageContext.request.contextPath }/LoginServlet?method=logout">注销</a></c:when>
			<c:otherwise>
			<a href="${pageContext.request.contextPath }/RegisterUIServlet">注册</a>
			</c:otherwise>
			</c:choose>
			</li>
		</ul>
	</div>
	<div class="container">
		<div class="col-md-9">
			<h1 id="title">欢迎来到我们的网站</h1>
			<br/>
			<div id="content">
			</div>
			<hr>
			<h3>部分商品</h3>
			<table border="0" cellspacing="0" cellpadding="0" class="table-striped" style="border-collapse:collapse;">
				<tr class="ttr">
					<th>#</th>
					<th>拍品名称</th>
					<th>发布时间</th>
					<th>截止时间</th>
					<th>发布人</th>
				</tr>
				
				<!--                 {% for commodity in commodities %}
                    <tr>
                        <td>{{ commodity.id }}</td>
                        <td><a href="{% url 'auction:detail' commodity.id %}">{{ commodity.title }}</a></td>
                        <td>{{ commodity.pub_date }}</td>
                        <td>{{ commodity.end_date }}</td>
                        <td>{{ commodity.owner }}</td>
                    </tr>
                {% endfor %}
 -->
			</table>
			<br/>
			<a class="link" href="#">查看全部商品</a>
		</div>
	</div>

</body>
</html>