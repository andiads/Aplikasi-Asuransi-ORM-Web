<%-- 
    Document   : ReportNasabahAsuransi
    Created on : Apr 26, 2018, 6:32:23 AM
    Author     : Toshiba
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
   <body>
          <%
            try {
//                String path = "E://MII//tugas//WebOverTime//web//view//report//reportAll.jasper";
//                String path = "//view//report//reportBulanNip.jasper";
//                String driver = "oracle.jdbc.OracleDriver";
//                String konek = "jdbc:oracle:thin:@localhost:1521:XE";
//                String user = "system";
//                String password = "password";
                HashMap parameter = new HashMap();
//                int nopol = Integer.parseInt(request.getParameter("kategory"));
                String nopol = request.getParameter("kategory");
                parameter.put("kategory", nopol);
//                parameter.put("bulan", bulan);
//                Class.forName(driver);
//                Connection conn = DriverManager.getConnection(konek, user, password);                
                Connection connection = HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
                File reportFile = new File(application.getRealPath("/View/report/ReportNasabahAsuransi.jasper"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameter, connection);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                out.println("Error :" + e.getMessage());
            }
        %>
    </body>
</html>
