/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import DAO.AdminDAO;
import entities.Admin;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdminI", urlPatterns = {"/admini"})
public class AdminI extends HttpServlet {

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
        String id = request.getParameter("idAdmin");
        String nama = request.getParameter("namaAdmin");
        String alamat = request.getParameter("alamat");
        String email = request.getParameter("email");
        String notelp = request.getParameter("noTelp");
        String pesan = "gagal mengubah data";
        RequestDispatcher dispatcher = null;
        AdminDAO adao = new AdminDAO();
         HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
           Admin a = new Admin();
           a.setIdAdmin(id);
           a.setNamaAdmin(nama);
           a.setAlamat(alamat);
           a.setEmail(email);
           a.setNoTelp(notelp);

            if (adao.insert(a)) {
                pesan = "berhasil mengubah data dengan ID : "+a.getIdAdmin();
                
            }
            session.setAttribute("pesaninsert", pesan);
            dispatcher = request.getRequestDispatcher("dataadminservlet");
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
