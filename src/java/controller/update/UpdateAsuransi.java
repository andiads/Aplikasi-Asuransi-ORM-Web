/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import DAO.AdminDAO;
import DAO.AsuransiDAO;
import entities.Admin;
import entities.Asuransi;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dbayu
 */
@WebServlet(name = "UpdateAsuransi", urlPatterns = {"/updateasuransi"})
public class UpdateAsuransi extends HttpServlet {

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
        String id = request.getParameter("kodeasuransi");
        String jenis = request.getParameter("jenisasuransi");
        String masaberlaku = request.getParameter("masaberlaku");
        String bunga = request.getParameter("bunga");
        String pembayaran = request.getParameter("pembayaran/bulan");
        String pesan = "gagal mengubah data";
        RequestDispatcher dispatcher = null;
        AsuransiDAO adao = new AsuransiDAO();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           Asuransi asuransi = new Asuransi(id);
           asuransi.setJenisAsuransi(jenis);
           asuransi.setMasaBerlaku(masaberlaku);
           asuransi.setBunga(new BigInteger(bunga));
           asuransi.setJmlBayar(new BigInteger(pembayaran));
//           adao.update(a);
           
            if (adao.update(asuransi)) {
                pesan = "berhasil mengubah data dengan ID : "+asuransi.getKodeAsuransi();
                
            }
            out.print(pesan);
            dispatcher = request.getRequestDispatcher("dataasuransiservlet");
            dispatcher.forward(request, response);
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
