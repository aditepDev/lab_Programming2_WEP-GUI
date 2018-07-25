<%-- 
    Document   : Update
    Created on : Oct 31, 2017, 4:54:37 AM
    Author     : PoN
--%>

<%@page import="org.model.beans.UsersModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update!</h1>
        <hr />
        <form action="<%=request.getContextPath()%>/Servlet/Home/ConfirmUpdate.do" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>U_ID</th>
                        <th>NAME</th>
                        <th>SURNAME</th>
                        <th>USERNAME</th>
                        <th>PASSWORD</th>
                        <th>UPDATE</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        UsersModel uModel = (UsersModel) request.getAttribute("uModel");
                        int id = uModel.getU_ID();
                        String name = uModel.getNAME();
                        String surname = uModel.getSURNAME();
                        String username = uModel.getUSERNAME();
                        String password = uModel.getPASSWORD();
                    %>
                    <tr>
                        <td><input type="text" name="id" value="<%=id%>" readonly /></td>
                        <td><input type="text" name="name" value="<%=name%>" /></td>
                        <td><input type="text" name="surname" value="<%=surname%>" /></td>
                        <td><input type="text" name="username" value="<%=username%>" /></td>
                        <td><input type="password" name="password" value="<%=password%>" /></td>
                        <td><input type="submit" value="UPDATE" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
