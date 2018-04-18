/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import DAO.AsuransiDAO;
import DAO.PembayaranDAO;
import entities.Asuransi;
import entities.Nasabah;
import entities.Pembayaran;
import java.io.IOException;
import java.io.PrintWriter;
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
        String nopembayaran = request.getParameter("nmrpembayaran");
        String tglpembayaran = request.getParameter("tglpembayaran");
        String jmlpembayaran = request.getParameter("jmlbayar");
        String nopolis = request.getParameter("nmrpolis");
        String kodeasuransi = request.getParameter("kdasuransi");
        String pesan = "gagal mengubah data";
        RequestDispatcher dispatcher = null;
        PembayaranDAO pdao = new PembayaranDAO();
         HttpSession session = request.getSession();
         Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(tglpembayaran);
        } catch (ParseException ex) {
            Logger.getLogger(PembayaranInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PrintWriter out = response.getWriter()) {
           Pembayaran pembayaran = new Pembayaran();
           pembayaran.setNoPembayaran(nopembayaran);
           pembayaran.setTglPembayaran(date1);
           pembayaran.setJmlhBayar(Long.parseLong(jmlpembayaran));
           pembayaran.setNoPolis(new Nasabah(nopolis));
           pembayaran.setKodeAsuransi(new Asuransi(kodeasuransi));
            if (pdao.insert(pembayaran)) {
                pesan = "berhasil mengubah data dengan ID : "+pembayaran.getNoPembayaran();
                
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
