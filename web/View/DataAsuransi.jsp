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
    <a href="asuransitoinsert" class="Button">Tambah data</a>
    <body><table border="1">
            <thead>
                <tr>
                    <th>ID Asuransi</th>
                    <th>Jenis Asuransi</th>
                    <th colspan="2">test</th>
                </tr>
            </thead>

            <%
                List<Object> datas = (List<Object>) session.getAttribute("data_asuransi");

                for (Object data : datas) {
                    Asuransi a = (Asuransi) data;


            %>
            <tbody>
                <tr>
                    <td><%= a.getKodeAsuransi()%></td>
                    <td><%= a.getJenisAsuransi()%></td>
                    <td><a href="asuransiupdate?id=<%=a.getKodeAsuransi()%>">update</a></td>
                    <td><a href="asuransidelete?id=<%=a.getKodeAsuransi()%>">delete</a></td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>


    </body>
</html>
