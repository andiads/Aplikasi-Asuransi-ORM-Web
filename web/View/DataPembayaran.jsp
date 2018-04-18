<%-- 
    Document   : DataPembayaran
    Created on : Apr 16, 2018, 4:43:29 PM
    Author     : dbayu
--%>

<%@page import="entities.Pembayaran"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <a href="pembayarantoinsert" class="Button">Bayar Asuransi</a>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>NIK</th>
                    <th>Nama Nasabah</th>
                    <th>Kode Asuransi</th>
                    <th>Jenis Asuransi</th>
                    <th>Tanggal Bayar</th>
                    
                </tr>
            </thead>
             <%
          List<Object> datas = (List<Object>)session.getAttribute("data_pembayaran");
            
            for (Object data : datas) {
                Pembayaran a = (Pembayaran)data;
                
            
        %>
            <tbody>
                <tr>
                    <td><%= a.getNoPolis().getNik()%></td>
                    <td><%= a.getNoPolis().getNmNasabah()%></td>
                    <td><%= a.getKodeAsuransi()%></td>
                    <td><%= a.getKodeAsuransi().getJenisAsuransi()%></td>
                    <td><%= a.getTglPembayaran()%></td>
                    
                </tr>
            </tbody>
            <%
                }
             %>
        </table>

    </body>
</html>
