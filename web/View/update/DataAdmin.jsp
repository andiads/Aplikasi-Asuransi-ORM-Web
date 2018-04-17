<%-- 
    Document   : DataAdmin
    Created on : Apr 17, 2018, 9:55:11 AM
    Author     : dbayu
--%>

<%@page import="entities.Admin"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test</title>
    </head>
    <body>
        <form name="formupdate" action="fixupdate" method="POST">
            <%
            Admin a = (Admin) session.getAttribute("admin");
            
            
            %>
            <div class="form-group">
                <label>ID Admin </label>
                <input class="form-control" name="idAdmin" readonly="true" type="text" value="<%= a.getIdAdmin()%>">
            </div>
            <div class="form-group">
                <label>Nama Admin</label>
                <input class="form-control" name="namaAdmin" type="text" value="<%= a.getNamaAdmin()%>"     >
            </div>
            <div class="form-group">
                <label>Alamat</label>
                <input class="form-control" name="alamat" type="text" value="<%= a.getAlamat()%>">
            </div>
            <div class="form-group">
                <label>E-mail</label>
                <input class="form-control" name="email" type="text" value="<%= a.getEmail()%>">
            </div>
            <div class="form-group">
                <label>No Telpon</label>
                <input class="form-control" name="noTelp" type="text" value="<%= a.getNoTelp()%>">
            </div>
            <button> Simpan </button>
                
        </form>
      
    </body>
</html>
