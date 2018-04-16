<%-- 
    Document   : asuransi
    Created on : Apr 16, 2018, 1:16:45 PM
    Author     : dbayu
--%>

<%@page import="entities.Admin"%>
<%@page import="DAO.AdminDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


    </title>
</head>
<body>
    <table border ="1">
        <thead>
            <tr>
                <th>ID ADMIN</th>
                <th>NAMA ADMIN</th>
                <th>ALAMAT</th>
                <th>E-MAIL</th>
                <th>NO.TELPON</th>
            </tr>
        </thead>
        <%
//            List<Object> datas = new AdminDAO().getAll();
            List<Object> datas = (List<Object>)session.getAttribute("data_admin");
            
            for (Object data : datas) {
                Admin a = (Admin) data;
        %>
        <tbody>
            <tr>
                <td><%= a.getIdAdmin()%></td>
                <td><%= a.getNamaAdmin()%></td>
                <td><%=a.getAlamat()%></td>
                <td><%=a.getEmail()%></td>
                <td><%=a.getNoTelp()%></td>
            </tr>
        </tbody>
        <% }
        %>



    </table>
    <a href="..\asuransiservlet">test</a>
</body>
</html>
