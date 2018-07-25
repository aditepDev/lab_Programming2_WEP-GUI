<%-- 
    Document   : home
    Created on : Nov 21, 2017, 5:54:27 AM
    Author     : Aditep
--%>
<%@page import="org.model.beans.CustomerModel"%>
<%
	String path = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>STATIONERIES SHOP</title>
<hr />
<jsp:include page="/app/menu/menu.jsp" />
<hr />
</head>
<body>

	<div class="progress">
		<div class="progress-bar bg-dark" role="progressbar"
			style="width: 20%;" aria-valuenow="25" aria-valuemin="0"
			aria-valuemax="100"></div>
		
		<div class="progress-bar bg-danger" role="progressbar"
			style="width: 80%;" aria-valuenow="25" aria-valuemin="0"
			aria-valuemax="100"></div>

	</div>
	<div class="jumbotron" align="center">
		<h1 class="display-3">WELCOME</h1>
		<p>STATIONERIES SHOP</p>
		<p>BY ADITEP</p>
		

		<% 
			if (session.getAttribute("username") == null) {

				
		            response.sendRedirect(request.getContextPath() + "/Login.do");
		       
			} else {
		
	
			CustomerModel cusModal = (CustomerModel) request.getAttribute("cusModel");
		%>

		
		</div>
		<div class="alert alert-dismissible alert-danger" >
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<div class="container" align="center"><h4>Hi. <%=cusModal.getCusname()%></h4></div>

<%} %>
			
	</div>
</body>
</html>
