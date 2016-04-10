<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>竞拍网</title>
	<style type="text/css">
		.container{
			margin: 0 auto;
			width: 750px;
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
			color: #8EE5EE;
			font-size: 40px;
		}
		.table-striped tr{
			border-top: 2px solid #DDDDDD;
			border-bottom: 2px solid #DDDDDD;
			background-color: #F9F9F9;
		}
		.ttr th{
			width: 150px;
			height: 40px;
			margin: 0;
		}
		.link{
			text-decoration: none;
			color: #23527C;
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
			<li><a href="${pageContext.request.contextPath }/LoginUIServlet" >登录</a></li>
			<li><a href="">注册</a></li>
		</ul>
	</div>
	<div class="container">
		<div class="col-md-9">
			<h1 id="title">欢迎来到我们的网站</h1>
			<br/>
			<h2>在这里你可以找到你所喜欢的商品并用竞价的方式，以低廉的价格得到它们！</h2>
			<h2>拍卖者直接拍卖给买家，没有中间商赚差价。</h2>
			<h2>如果你有希望出售的产品，那么请你联系网站管理员。</h2>
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