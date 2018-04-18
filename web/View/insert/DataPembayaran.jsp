 <%-- 
    Document   : DataPembayaran
    Created on : Apr 18, 2018, 8:53:42 AM
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
      
        <form name="formupdate" action="pembayaraninsert" method="POST">
           
            <div class="form-group">
                <label>Nomor Pembayaran </label>
                <input class="form-control" name="nmrpembayaran"  type="text" value="">
            </div>
            <div class="form-group">
                <label>Tanggal Pembayaran</label>
                <input class="form-control" name="tglpembayaran" type="Date" value=""     >
            </div>
            <div class="form-group">
                <label>Jumlah Pembayaran</label>
                <input class="form-control" name="jmlbayar" type="text" value=""     >
            </div>
            <div class="form-group">
                <label>Nomor Polis</label>
                <input class="form-control" name="nmrpolis" type="text" value=""     >
            </div>
            <div class="form-group">
                <label>Kode Asuransi</label>
                <input class="form-control" name="kdasuransi" type="text" value=""     >
            </div>
            <button> Simpan </button>
                
        </form>
      
    </body>
</html>
