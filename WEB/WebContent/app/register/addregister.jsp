<%@page import="org.model.beans.CustomerModel"%>
<%
	String path = request.getContextPath();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	

<%
response.sendRedirect(request.getContextPath() + "/Login.do");
	
		
	%>
	
  
	
</body>
</html>