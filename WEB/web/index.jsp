<%-- 
    Document   : index
    Created on : Oct 31, 2017, 6:18:45 AM
    Author     : PoN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.sendRedirect(request.getContextPath() + "/Servlet/Home/Index.do");
        %>
    </body>
</html>
