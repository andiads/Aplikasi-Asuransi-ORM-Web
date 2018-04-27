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
import tools.BCrypt;

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
        String pass = request.getParameter("pass");
        String hakakses = request.getParameter("hakakses");
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
           a.setPassword(BCrypt.hashpw(pass, BCrypt.gensalt()));
           a.setHakAkses(hakakses);
           
           Admin admin = new Admin(id, nama, alamat, email, notelp,pass);

            if (adao.insert(a)) {
                pesan = "berhasil menambah data dengan ID : "+a.getIdAdmin();
                 out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Good job!', 'Berhasil Menambahkan Data!', 'success');");
                out.println("});");
                out.println("</script>");
                session.setAttribute("pesaninsert", pesan);
            dispatcher = request.getRequestDispatcher("dataadminservlet");
            dispatcher.include(request, response);
            }
            else{
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'Gagal Menambahkan Data !!', 'error');");
                out.println("});");
                out.println("</script>");
                session.setAttribute("pesaninsert", pesan);
                dispatcher = request.getRequestDispatcher("NasAsBarutoInsert");
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
