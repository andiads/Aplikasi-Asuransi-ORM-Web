<%-- 
    Document   : DataAdmin
    Created on : Apr 17, 2018, 2:08:22 PM
    Author     : dbayu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test</title>
    </head>
    <body>
        <%
            String Admin = (String) session.getAttribute("autoID");
            %>
     
        <form name="formupdate" action="admini" method="POST">
           
            <div class="form-group">
                <label>ID Admin </label>
                <input class="form-control" name="idAdmin" readonly="true" type="text" value="<%=Admin%>">
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
                <input class="form-control" name="email" type="email" value="">
            </div>
            <div class="form-group">
                <label>No Telpon</label>
                <input class="form-control" name="noTelp" type="text" value="">
            </div>
            <button> Simpan </button>
                
        </form>
      
    </body>
</html>
