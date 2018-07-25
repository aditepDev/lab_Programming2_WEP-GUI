<%@page import="org.model.beans.ReceiptDetailsModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.model.beans.CustomerModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" 
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="<%=path%>/Login.do">STATIONERRIES</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor03" aria-controls="navbarColor03"
		aria-expanded="false" aria-label="Toggle navigation" style="">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor03">
		<ul class="navbar-nav mr-auto">




			<%
				if (session.getAttribute("username") == null) {
			%>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/Register.do">REGISTER <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/Login.do">LOGIN <span class="sr-only">(current)</span></a>
			</li>

			<!-- Login  -->
			<%
				} else {
					String strUser = String.valueOf(session.getAttribute("STATUS"));

					int sta = Integer.parseInt(strUser);

					if (sta == 0) {
			%>

			<li class="nav-item active"><a class="nav-link"
				href="<%=path%>/Home.do">HOME <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/Sell.do">SELL <span class="sr-only">(current)</span></a></li>

			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/User.do">PROFILE <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/Logout.do">LOGOUT<span class="sr-only">(current)</span></a>
			</li>
<li class="nav-item"><a class="nav-link"><div class="container">	<span class="badge bg-dack">User</span></div></span></a></li>

			<%
				} else {
			%>
			<li class="nav-item active"><a class="nav-link"
				href="<%=path%>/Home.do">HOME <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/Sell.do">SELL <span class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/Report.do">REPORT<span class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/User.do">PROFILE <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="<%=path%>/Logout.do">LOGOUT<span class="sr-only">(current)</span></a>
			</li>

		</li>
			<li class="nav-item"><a class="nav-link"><div class="container">	<span class="badge bg-danger">Admin</span></div></span></a></li>

</ul>

	</div>


	<%
		}
		}
	%>
	



</nav>


</head>

<body>






</body>