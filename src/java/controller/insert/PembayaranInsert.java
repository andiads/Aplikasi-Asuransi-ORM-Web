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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "PembayaranInsert", urlPatterns = {"/pembayaraninsert"})
public class PembayaranInsert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");

        String pesan = "gagal mengubah data";
        RequestDispatcher dispatcher = null;
        PembayaranDAO pdao = new PembayaranDAO();
        HttpSession session = request.getSession();
        DetailNasabah dn = (DetailNasabah) new DetailNasabahDAO().getById(id);
        
        String nopembayaran = pdao.getAutoID();
        Date currentDate = new Date();
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        String tglpembayaran = localDateTime.toString();
        double jmlpembayaran = Long.parseLong(dn.getKodeAsuransi().getJmlBayar()+"");
    
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
            Asuransi a = (Asuransi) new AsuransiDAO().getById(dn.getKodeAsuransi()+"");
            double bungaawal = Long.parseLong(a.getBunga() + "");

            double bunga = bungaawal / 100;
            totalbunga = bunga * jmlpembayaran;
            totalsaldo = totalbunga + saldo + jmlpembayaran;

            BigInteger hasilpembayaran = BigDecimal.valueOf(totalsaldo).toBigInteger();

            Pembayaran pembayaran = new Pembayaran();
            pembayaran.setNoPembayaran(nopembayaran);
            pembayaran.setTglPembayaran(date1);
            pembayaran.setNoPolis(new Nasabah(dn.getNoPolis()+""));
            pembayaran.setKodeAsuransi(new Asuransi(dn.getKodeAsuransi()+""));
            pembayaran.setJumlahBayar(hasilpembayaran);
            if (pdao.insert(pembayaran)) {
                pesan = "berhasil mengubah data dengan ID : " + pembayaran.getNoPembayaran();

            }

            session.setAttribute("pesaninsert", pesan);
            dispatcher = request.getRequestDispatcher("datapembayaranservlet");
            dispatcher.include(request, response);
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
