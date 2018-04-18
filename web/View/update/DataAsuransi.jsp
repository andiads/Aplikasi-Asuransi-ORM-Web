<%-- 
    Document   : DataAsuransi
    Created on : Apr 17, 2018, 10:10:15 PM
    Author     : dbayu
--%>

<%@page import="entities.Asuransi"%>
<%@page import="entities.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test</title>
    </head>
    <body>
        <form name="formupdate" action="updateasuransi" method="POST">
            <%
            Asuransi a = (Asuransi) session.getAttribute("asuransi");
            
            
            %>
            <div class="form-group">
                <label>Kode Asuransi </label>
                <input class="form-control" name="kodeasuransi" readonly="true" 
                       type="text" value="<%= a.getKodeAsuransi()%>">
            </div>
            <div class="form-group">
                <label>Jenis Asuransi</label>
                <input class="form-control" name="jenisasuransi" type="text" 
                       value="<%= a.getJenisAsuransi()%>"     >
            </div>
            <button> Simpan </button>
                
        </form>
      
    </body>
</html>
