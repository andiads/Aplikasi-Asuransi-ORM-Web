<%-- 
    Document   : DataNasabah
    Created on : Apr 18, 2018, 9:26:34 AM
    Author     : dbayu
--%>

<%@page import="entities.Nasabah"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test</title>
    </head>
    <body>
        <form name="formupdate" action="updatenasabah" method="POST">
            <%
                Nasabah nasabah = (Nasabah) session.getAttribute("nasabah");
            %>
            <div class="form-group">
                <label>NIK </label>
                <input class="form-control" name="nik" readonly="true" 
                       type="text" value="<%= nasabah.getNik()%>">
            </div>
            <div class="form-group">
                <label>Nomor Polis</label>
                <input class="form-control" name="nmrpolis" type="text" 
                       value="<%= nasabah.getNoPolis()%>"     >
                <div class="form-group">
                    <label>Nama Nasabah</label>
                    <input class="form-control" name="nmnasabah" type="text" 
                           value="<%= nasabah.getNmNasabah()%>"     >
                    <div class="form-group">
                        <label>Tanggal Lahir</label>
                        <input class="form-control" name="tgllahir" type="Date" 
                               value="<%= nasabah.getTglLahir()%>"     >
                        <div class="form-group">
                            <label>Pekerjaan</label>
                            <input class="form-control" name="pekerjaan" type="text" 
                                   value="<%= nasabah.getPekerjaan()%>"     >
                            <div class="form-group">
                                <label>Alamat</label>
                                <input class="form-control" name="alamat" type="text" 
                                       value="<%= nasabah.getAlamat()%>"     >
                                <div class="form-group">
                                    <label>Status</label>
                                    <!--<input class="form-control" name="status" type="text"--> 
                                    <% if (nasabah.getStatus().equals("Kawin")) {%>
                                    <input type="radio" name="status" value="kawin" checked >Kawin  
                                    <input type="radio" name="status" value="Belum Kawin">Belum Kawin<br/> 
                                    <% } else {%>
                                    <input type="radio" name="status" value="kawin"  >Kawin  
                                    <input type="radio" name="status" value="Belum Kawin" checked>Belum Kawin<br/>  
                                    <% }%>
                                </div>
                                <div class="form-group">
                                    <label>Penghasilan</label>
                                    <input class="form-control" name="penghasilan" type="text" 
                                           value="<%= nasabah.getPengBulan()%>"     >
                                </div>
                                <div class="form-group">
                                    <label>ID Admin</label>
                                    <input class="form-control" name="idadmin" type="text" 
                                           value="<%= nasabah.getIdAdmin()%>"     >
                                </div>
                                <button> Simpan </button>

                                </form>

                                </body>
                                </html>

