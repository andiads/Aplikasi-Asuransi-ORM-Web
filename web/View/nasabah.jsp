<%-- 
    Document   : nasabah
    Created on : Apr 16, 2018, 4:13:48 PM
    Author     : Toshiba
--%>

<%@page import="entities.Nasabah"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Nasabah</title>
    </head>
    <a href="nasabahtoinsert" class="Button">Tambah data</a>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>No Polis</th>
                    <th>NIK</th>
                    <th>Nama Nasabah</th>
                    <th>Tanggal Lahir</th>
                    <th>Pekerjaan</th>
                    <th>Alamat</th>
                    <th>Status</th>
                    <th>Penghasilan</th>
                    <th>ID Admin</th>
                    <th colspan="2">Actions</th>
                </tr>
            </thead>
            <% List<Object> datas = (List<Object>) session.getAttribute("dataNasabah");
//            List<Object> datas = new AdminDAO().getAll();
                for (Object data : datas) {
                    Nasabah n = (Nasabah) data;%>
            <tbody>
                <tr>

                    <td><%= n.getNoPolis()%></td>
                    <td><%= n.getNik()%></td>
                    <td><%= n.getNmNasabah()%></td>
                    <td><%= n.getTglLahir()%></td>
                    <td><%= n.getPekerjaan()%></td>
                    <td><%= n.getAlamat()%></td>
                    <td><%= n.getStatus()%></td>
                    <td><%= n.getPengBulan()%></td>
                    <td><%= n.getIdAdmin()%></td>
                    <td><a href="nasabahupdate?id=<%=n.getNik()%>">update</a></td>
                    <td><a href="nasabahdelete?id=<%=n.getNoPolis()%>">delete</a></td>
                </tr>
            </tbody>
            <%}
            %>
        </table>
    </body>
</html>
