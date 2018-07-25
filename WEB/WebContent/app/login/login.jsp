<%-- 
    Document   : login
    Created on : Nov 21, 2017, 3:25:08 PM
    Author     : Aditep
--%>
<%
	String path = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<hr />
<jsp:include page="/app/menu/menu.jsp" />
<hr />

<title>Login</title>
</head>
<div align="center">
	<body>
		<div class="progress">
			<div class="progress-bar bg-dark" role="progressbar"
				style="width: 100%;" aria-valuenow="25" aria-valuemin="0"
				aria-valuemax="100"></div>


		</div>




	
		
		<%
				if (session.getAttribute("username") == null) {
			%>
			<form action="<%=path%>/ChkLogin.do" method="post">
			<div class="form-group" class="container">
			<h4>USERNAME<br></h4> <input type="text" name="username" type="text"  class="form-control" placeholder="Username Admin = root , Customer user = user" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px;"><br>
			<h4>PASSWORD<br></h4> <input type="password" name=password class="form-control" placeholder="Password = 1234" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px;"><br>
			<br> <input class="btn btn-secondary" type="submit"
				name="SUBMIT" value="SUBMIT"> | <input
				class="btn btn-danger" type="reset" value="RESET">
				</div>
			</form>
			<%
				} else {
			%>
				 <%
            response.sendRedirect(request.getContextPath() + "/Home.do");
        %>
		
			<%
				}
			%>

	</body>
</div>
</html>
