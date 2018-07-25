<%-- 
    Document   : Add
    Created on : Oct 31, 2017, 4:54:26 AM
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
        <h1>Add!</h1>
        <hr />
        <form action="<%=request.getContextPath()%>/Servlet/Home/ConfirmAdd.do" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>NAME</th>
                        <th>SURNAME</th>
                        <th>USERNAME</th>
                        <th>PASSWORD</th>
                        <th>SUBMIT</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="name" value="" /></td>
                        <td><input type="text" name="surname" value="" /></td>
                        <td><input type="text" name="username" value="" /></td>
                        <td><input type="password" name="password" value="" /></td>
                        <td><input type="submit" value="ADD" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
