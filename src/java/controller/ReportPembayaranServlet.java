/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PembayaranDAO;
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
import entities.Pembayaran;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dbayu
 */
public class ReportPembayaranServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        try {
            try {
                Document d = new Document();
                PdfWriter.getInstance(d, out);

                d.open();

                Paragraph paragraph = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                paragraph.add(new Phrase(" Contoh Report Pembayaran ", font));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.add(new Phrase(Chunk.NEWLINE));
                d.add(paragraph);

//                Paragraph paragraph2 = new Paragraph();
//                Font font2 = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
//                paragraph.add(new Phrase(" Contoh Report ", font2));
//                paragraph.setAlignment(Element.ALIGN_CENTER);
//                paragraph.add(new Phrase(Chunk.NEWLINE));
//                d.add(paragraph);
                PdfPTable pTable = new PdfPTable(5);
                PdfPCell cell1 = new PdfPCell(new Paragraph("Nomor Pembayaran", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Tanggal Pembayaran", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Jumlah Pembayaran", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Kode Asuransi", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell5 = new PdfPCell(new Paragraph("No Polis", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

                pTable.addCell(cell1);
                pTable.addCell(cell2);
                pTable.addCell(cell3);
                pTable.addCell(cell4);
                pTable.addCell(cell5);

                List<Object> datas2 = new PembayaranDAO().getAll();
                for (Object data : datas2) {
                    Pembayaran p = (Pembayaran) data;
                    pTable.addCell(p.getNoPembayaran());
                    pTable.addCell(p.getTglPembayaran().toString());
                    pTable.addCell(p.getJumlahBayar().toString());
                    pTable.addCell(p.getKodeAsuransi().toString());
                    pTable.addCell(p.getNoPolis().toString());
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
