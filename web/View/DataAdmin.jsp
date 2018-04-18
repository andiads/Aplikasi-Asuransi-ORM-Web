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
    <a href="admintoinsert" class="Button">Tambah data</a>
    <table border ="1">
        
        <thead>
           
            <tr>
                <th>ID ADMIN</th>
                <th>NAMA ADMIN</th>
                <th>ALAMAT</th>
                <th>E-MAIL</th>
                <th>NO.TELPON</th>
                <th colspan="2">test</th>
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
                <td><a href="adminupdate?id=<%=a.getIdAdmin()%>">update</a></td>
                <td><a href="admindelete?id=<%=a.getIdAdmin()%>">delete</a></td>
            </tr>
        <% }
        
            %>
        </tbody>
     </table>
        
        

</body>
</html>
