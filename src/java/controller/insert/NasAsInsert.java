/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import DAO.AsuransiDAO;
import DAO.DetailNasabahDAO;
import DAO.PembayaranDAO;
import entities.Asuransi;
import entities.DetailNasabah;
import entities.Nasabah;
import entities.Pembayaran;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dbayu
 */
@WebServlet(name = "NasAsInsert", urlPatterns = {"/NasAsInsert"})
public class NasAsInsert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. buat nambah data ke detail nasabah sama pembayaran
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nopembayaran = request.getParameter("nmrpembayaran");
        String tglpembayaran = request.getParameter("tglpembayaran");
        String nopolis = request.getParameter("nmrpolis");
        String kodeasuransi = request.getParameter("kdasuransi");

        String nmrdaftar = request.getParameter("nmrdaftar");

        String pesan = "gagal mengubah data";
        RequestDispatcher dispatcher = null;
        PembayaranDAO pdao = new PembayaranDAO();
        DetailNasabahDAO dndao = new DetailNasabahDAO();
        HttpSession session = request.getSession();
        Date date1 = null;

        try {

            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tglpembayaran);
        } catch (ParseException ex) {
            Logger.getLogger(PembayaranInsert.class.getName()).log(Level.SEVERE, null, ex);
        }

        double saldo = 0;
        double totalbunga = 0;
        double totalsaldo = 0;
        try (PrintWriter out = response.getWriter()) {
            Asuransi a = (Asuransi) new AsuransiDAO().getById(kodeasuransi);
            double bungaawal = Long.parseLong(a.getBunga() + "");
            double jumlahbayar = Long.parseLong(a.getJmlBayar() + "");

            double bunga = bungaawal / 100;
            totalbunga = bunga * jumlahbayar;
            totalsaldo = totalbunga + saldo + jumlahbayar;

            BigInteger hasilpembayaran = BigDecimal.valueOf(totalsaldo).toBigInteger();

            Pembayaran pembayaran = new Pembayaran();
            pembayaran.setNoPembayaran(nopembayaran);
            pembayaran.setTglPembayaran(date1);
            pembayaran.setNoPolis(new Nasabah(nopolis));
            pembayaran.setKodeAsuransi(new Asuransi(kodeasuransi));
            pembayaran.setJumlahBayar(hasilpembayaran);

            DetailNasabah detailNasabah = new DetailNasabah();
            detailNasabah.setIdDetail(nmrdaftar);
            detailNasabah.setKodeAsuransi(new Asuransi(kodeasuransi));
            detailNasabah.setNoPolis(new Nasabah(nopolis));
            detailNasabah.setSaldo(hasilpembayaran);
            detailNasabah.setTglJoin(date1);
            if (pdao.insert(pembayaran) && dndao.insert(detailNasabah)) {
                pesan = "berhasil mengubah data dengan ID : " + pembayaran.getNoPembayaran();
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Good job!', 'Berhasil Menambahkan Data!', 'success');");
                out.println("});");
                out.println("</script>");

                session.setAttribute("pesaninsert", pesan);
                dispatcher = request.getRequestDispatcher("nasabahServlet");
                dispatcher.include(request, response);
            } else {
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'Gagal Menambahkan Data !!', 'error');");
                out.println("});");
                out.println("</script>");
                session.setAttribute("pesaninsert", pesan);
                dispatcher = request.getRequestDispatcher("nasabahServlet");
                dispatcher.include(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
