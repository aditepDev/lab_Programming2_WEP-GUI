<%-- 
    Document   : Index
    Created on : Oct 31, 2017, 4:25:47 AM
    Author     : PoN
--%>

<%@page import="org.model.beans.UsersLogsModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.model.beans.UsersModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to MVC web!</h1>
        <a href="<%=request.getContextPath()%>/Servlet/Home/Add.do">เพิ่ม</a>
        <hr />
        <table border="1">
            <thead>
                <tr>
                    <th>U_ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                    <th>TIME_REG</th>
                    <th>UPDATE</th>
                    <th>DELETE</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<UsersModel> uList = (ArrayList<UsersModel>) request.getAttribute("uList");
                    for (Iterator<UsersModel> iterator = uList.iterator(); iterator.hasNext();) {
                        UsersModel next = iterator.next();
                        int id = next.getU_ID();
                        String name = next.getNAME();
                        String surname = next.getSURNAME();
                        String username = next.getUSERNAME();
                        String password = next.getPASSWORD();
                        String time = next.getTIME_REG();
                %>
                <tr>
                    <td><%=id%></td>
                    <td><%=name%></td>
                    <td><%=surname%></td>
                    <td><%=username%></td>
                    <td><%=password%></td>
                    <td><%=time%></td>
                    <td align="center"><a href="<%=request.getContextPath()%>/Servlet/Home/Update.do?id=<%=id%>">แก้ไข</a></td>
                    <td align="center"><a href="<%=request.getContextPath()%>/Servlet/Home/Delete.do?id=<%=id%>">ลบ</a></td>
                </tr>
                <% }%>
            </tbody>
        </table>
        <hr />
        <h1>MVC + DAO!</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>LOG_ID</th>
                    <th>U_ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                    <th>USER TIME</th>
                    <th>LOG TIME</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<UsersLogsModel> uLList = (ArrayList<UsersLogsModel>) request.getAttribute("uLList");
                    for (Iterator<UsersLogsModel> iterator = uLList.iterator(); iterator.hasNext();) {
                        UsersLogsModel next = iterator.next();
                        int lid = next.getUL_ID();
                        int uid = next.getUSERS().getU_ID();
                        String name = next.getUSERS().getNAME();
                        String surname = next.getUSERS().getSURNAME();
                        String username = next.getUSERS().getUSERNAME();
                        String password = next.getUSERS().getPASSWORD();
                        String time = next.getUSERS().getTIME_REG();
                        String ultime = next.getTIME_REG();
                %>
                <tr>
                    <td><%=lid%></td>
                    <td><%=uid%></td>
                    <td><%=name%></td>
                    <td><%=surname%></td>
                    <td><%=username%></td>
                    <td><%=password%></td>
                    <td><%=time%></td>
                    <td><%=ultime%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
