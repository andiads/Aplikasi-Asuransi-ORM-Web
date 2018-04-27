/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Admin;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dbayu
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/ReportServlet"})
public class ReportServlet extends HttpServlet {

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
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {

            try {
                Document d = new Document();
                PdfWriter.getInstance(d, out);

                d.open();

                Paragraph paragraph = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                paragraph.add(new Phrase(" Contoh Report ", font));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.add(new Phrase(Chunk.NEWLINE));
                paragraph.add(new Phrase(Chunk.NEWLINE));
                d.add(paragraph);

//                Paragraph paragraph2 = new Paragraph();
//                Font font2 = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
//                paragraph.add(new Phrase(" Contoh Report ", font2));
//                paragraph.setAlignment(Element.ALIGN_CENTER);
//                paragraph.add(new Phrase(Chunk.NEWLINE));
//                paragraph.add(new Phrase(Chunk.NEWLINE));
//                d.add(paragraph);

                PdfPTable pTable = new PdfPTable(5);
                PdfPCell cell1 = new PdfPCell(new Paragraph("ID Admin", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Nama Admin", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Nomor Telp", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Email", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell5 = new PdfPCell(new Paragraph("Alamat", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

                pTable.addCell(cell1);
                pTable.addCell(cell2);
                pTable.addCell(cell3);
                pTable.addCell(cell4);
                pTable.addCell(cell5);

                

                List<Object> datas2 = new AdminDAO().getAll();
                for (Object data : datas2) {
                    Admin admin = (Admin) data;
                    pTable.addCell(admin.getIdAdmin());
                    pTable.addCell(admin.getNamaAdmin());
                    pTable.addCell(admin.getNoTelp());
                    pTable.addCell(admin.getEmail());
                    pTable.addCell(admin.getAlamat());
                }
                d.add(pTable);
                d.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
        } finally {
            out.close();
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
