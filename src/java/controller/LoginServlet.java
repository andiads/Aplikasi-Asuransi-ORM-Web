/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAO;
import entities.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {


            String id = request.getParameter("idAdmin");
            String password = request.getParameter("password");
           
            String kategori = "idAdmin";

            
            
//            AdminDAO adao = new AdminDAO();
//            List<Object> datas = (List<Object>) adao.search(kategori, id);

//            if (adao.search(kategori, id).isEmpty() || !adao.login(kategori, id, password)) {
////                alert = "Username atau Password Salah...";
//
//
//            } else if (adao.login(kategori, id, password)) {
//                for (Object data : datas) {
//                    Admin admin = (Admin) data;
//                    if (admin.getIdAdmin().equals(id)) {
//                        if (admin.getHakAkses().equals("Admin")) {
//                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                            rd.include(request, response);
//                            
//                        } else if (admin.getHakAkses().equals("Teller")) {
//                            RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
//                            rd.include(request, response);
//
//                        } else if (admin.getHakAkses().equals("Manager")) {
//
//                            RequestDispatcher rd = request.getRequestDispatcher("IndexManager.jsp");
//                            rd.include(request, response);
//                        }
//                    }
//
//                }
//
//                session.setAttribute("pass", password);
//                session.setAttribute("err", id);
//                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//                rd.include(request, response);
//            }

            
            Admin adao = (Admin) new AdminDAO().getById(id);
            String alert = "";
            String Dataadmin = adao.getNamaAdmin();
            session.setAttribute("Data", adao);
            if (adao == null) {
                alert = "Login Failed...";

            } else if (id.equals("") || password == null) {
                alert = "Username harus diisi";
            } else if (password.equals("") || id == null) {
                alert = "Password harus diisi";
            } else if (adao.getPassword().equals(password)) {
                if (adao.getHakAkses().equals("Admin")) {

                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);

                } else if (adao.getHakAkses().equals("Teller")) {
                    RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
                    rd.forward(request, response);
                    
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("IndexManager.jsp");
                    rd.forward(request, response);
                    }
                alert = "Isi ID dan Password!";

            }
            alert = "Isi ID dan Password!";
            request.setAttribute("alert", alert);
            session.setAttribute("pass", password);
            session.setAttribute("err", id);

            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.include(request, response);
            
//            if (request.getAttribute("err")==null) {
//                response.sendRedirect("Login.jsp");
//            }
//            response.sendRedirect("Login.jsp");
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
