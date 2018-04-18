<%-- 
    Document   : DataAsuransi
    Created on : Apr 18, 2018, 8:40:12 AM
    Author     : dbayu
--%>

<%@page import="entities.Asuransi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test</title>
    </head>
    <body>
         <%
             
            String asuransi = (String) session.getAttribute("autoIDAsuransi");
            %>
        <form name="formupdate" action="asuransiinsert" method="POST">
           
            <div class="form-group">
                <label>Kode Asuransi </label>
                <input class="form-control" name="kdasuransi" readonly="true" type="text" value="<%=asuransi%>">
            </div>
            <div class="form-group">
                <label>Jenis Asuransi</label>
                <input class="form-control" name="jenisasuransi" type="text" value=""     >
            </div>
            <button> Simpan </button>
                
        </form>
      
    </body>
</html>
