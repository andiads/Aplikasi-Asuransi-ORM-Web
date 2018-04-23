/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import DAO.AsuransiDAO;
import DAO.NasabahDAO;
import controller.update.UpdateNasabah;
import entities.Admin;
import entities.Asuransi;
import entities.Nasabah;
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
@WebServlet(name = "NasabahInsert", urlPatterns = {"/nasabahinsert"})
public class NasabahInsert extends HttpServlet {

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
        String nik = request.getParameter("nik");
        String nmrpolis = request.getParameter("nmrpolis");
        String namanasabah = request.getParameter("nmnasabah");
        String tgllahir = request.getParameter("tgllahir");
        String pekerjaan = request.getParameter("pekerjaan");
        String alamat = request.getParameter("alamat");
        String status = request.getParameter("status");
        String penghasilan = request.getParameter("penghasilan");
        String idadmin = request.getParameter("idadmin");
        String pesan = "gagal mengubah data";
        RequestDispatcher dispatcher = null;
        NasabahDAO ndao = new NasabahDAO();
        HttpSession session = request.getSession();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tgllahir);
        } catch (ParseException ex) {
            Logger.getLogger(NasabahInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PrintWriter out = response.getWriter()) {
            Nasabah nasabah = new Nasabah();
            nasabah.setNik(nik);
            nasabah.setNoPolis(nmrpolis);
            nasabah.setNmNasabah(namanasabah);
            nasabah.setTglLahir(date1);
            nasabah.setPekerjaan(pekerjaan);
            nasabah.setAlamat(alamat);
            nasabah.setStatus(status);
            nasabah.setPengBulan(penghasilan);
            nasabah.setIdAdmin(new Admin(idadmin));
            if (ndao.insert(nasabah)) {
                pesan = "berhasil mengubah data dengan ID : " + nasabah.getNoPolis();
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Good job!', 'Berhasil Menambahkan Data!', 'success');");
                out.println("});");
                out.println("</script>");
                session.setAttribute("pesaninsert", pesan);
                dispatcher = request.getRequestDispatcher("NasAsBarutoInsert");
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
