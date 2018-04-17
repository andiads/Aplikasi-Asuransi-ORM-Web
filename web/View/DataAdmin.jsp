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
        
        <form name="formupdate" action="admini" method="POST">
           
            <div class="form-group">
                <label>ID Admin </label>
                <input class="form-control" name="idAdmin"  type="text">
            </div>
            <div class="form-group">
                <label>Nama Admin</label>
                <input class="form-control" name="namaAdmin" type="text" value=""     >
            </div>
            <div class="form-group">
                <label>Alamat</label>
                <input class="form-control" name="alamat" type="text" value="">
            </div>
            <div class="form-group">
                <label>E-mail</label>
                <input class="form-control" name="email" type="text" value="">
            </div>
            <div class="form-group">
                <label>No Telpon</label>
                <input class="form-control" name="noTelp" type="text" value="">
            </div>
            <button> Simpan </button>
                
        </form>

</body>
</html>
