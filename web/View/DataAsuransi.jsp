<%-- 
    Document   : DataAsuransi
    Created on : Apr 16, 2018, 4:15:17 PM
    Author     : dbayu
--%>

<%@page import="entities.Asuransi"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><table border="1">
            <thead>
                <tr>
                    <th>ID Asuransi</th>
                    <th>Jenis Asuransi</th>
                </tr>
            </thead>
            
            <%
          List<Object> datas = (List<Object>)session.getAttribute("data_asuransi");
            
            for (Object data : datas) {
                Asuransi a = (Asuransi)data;
                
            
        %>
            <tbody>
                <tr>
                    <td><%= a.getJenisAsuransi()%></td>
                    <td><%= a.getJenisAsuransi()%></td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>


    </body>
</html>
