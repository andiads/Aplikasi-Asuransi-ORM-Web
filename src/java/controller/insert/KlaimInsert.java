/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import DAO.AsuransiDAO;
import DAO.DetailNasabahDAO;
import DAO.KlaimDAO;
import DAO.NasabahDAO;
import entities.Asuransi;
import entities.DetailNasabah;
import entities.Klaim;
import entities.Nasabah;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
@WebServlet(name = "KlaimInsert", urlPatterns = {"/klaiminsert"})
public class KlaimInsert extends HttpServlet {

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
        
        KlaimDAO kdao = new KlaimDAO();
        String id = request.getParameter("id");
        
        
        DetailNasabah dn = (DetailNasabah) new DetailNasabahDAO().getById(id);
        String idklaim = kdao.getAutoID();
        
        
        Date currentDate = new Date();
        LocalDateTime tglklaim = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        String convtglklaim = tglklaim.toString();

        
        
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(convtglklaim);
        } catch (ParseException ex) {
            Logger.getLogger(NasabahInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date date2 = null;
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dn.getTglJoin()+"");
        } catch (ParseException ex) {
            Logger.getLogger(NasabahInsert.class.getName()).log(Level.SEVERE, null, ex);
        }

        long perhitungantanggal = (date1.getTime() - date2.getTime());
        long masatunggu = TimeUnit.MILLISECONDS.toDays(perhitungantanggal);

        Asuransi asuransi = (Asuransi) new AsuransiDAO().getById(dn.getKodeAsuransi()+"");
        long masaberlaku = Long.parseLong(asuransi.getMasaBerlaku());
        long konvertkehari = masaberlaku * 365;
        System.out.println(masaberlaku);

        String pesan = "gagal mengubah data";
        RequestDispatcher dispatcher = null;

        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            Klaim klaim = new Klaim();

            if (masatunggu >= konvertkehari) {
                klaim.setIdklaim(idklaim);
                klaim.setKodeAsuransi(new Asuransi(dn.getKodeAsuransi()+""));
                klaim.setNoPolis(new Nasabah(dn.getNoPolis()+""));
                klaim.setTglKlaim(date1);
//                
                if (kdao.insert(klaim)) {
                    pesan = "berhasil mengubah data dengan ID : " + klaim.getIdklaim();
                    out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal('Good job!', 'Klaim Asuransi Berhasil...', 'success');");
                    out.println("});");
                    out.println("</script>");
                    session.setAttribute("pesaninsert", pesan);
                    dispatcher = request.getRequestDispatcher("View/DataPembayaran.jsp");
                    dispatcher.include(request, response);

                }

            } else {
                System.out.println("anda masuk masa tunggu");
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'Maaf Anda Masuk dalam Masa Tunggu..', 'error');");
                out.println("});");
                out.println("</script>");

                session.setAttribute("pesaninsert", pesan);
                dispatcher = request.getRequestDispatcher("View/DataPembayaran.jsp");
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
