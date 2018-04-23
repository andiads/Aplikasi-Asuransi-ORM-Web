/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import DAO.AdminDAO;
import DAO.AsuransiDAO;
import DAO.PembayaranDAO;
import entities.Admin;
import entities.Asuransi;
import entities.Pembayaran;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dbayu
 */
public class Cek {
    public static void main(String[] args) {
//        List<Object> datas = new AdminDAO().getAll();
//        for (Object data : datas) {
//            Admin a = (Admin) data;
//            System.out.println(datas.size());


            
//        }

//        AsuransiDAO adao = new AsuransiDAO();
//        System.out.println(adao.getAutoID());
//        
//        PembayaranDAO dAO = new PembayaranDAO();
//        System.out.println(dAO.getAutoID());
        
//                        double saldo = 10000;
//        double totalbunga = 0;
//        double totalsaldo = 0;
//            Asuransi a = (Asuransi) new AsuransiDAO().getById("A001");
//            double bungaawal = Long.parseLong(a.getBunga()+"");
//            
//            double bunga = bungaawal/100;
//            totalbunga = bunga*Integer.parseInt("100000");
//            totalsaldo = totalbunga+saldo+Integer.parseInt("100000");
//            BigInteger hasil = BigDecimal.valueOf(totalsaldo).toBigInteger();
//            
//            System.out.println(hasil);
//            
    






//int hasil = 0;
//List<Object> datas2 = new PembayaranDAO().getAll();
//                
//                for (int i = 0; i <datas2.size() ; i++) {
//                    hasil = hasil+1;
//                }
                
                
                Pembayaran p  = (Pembayaran) new PembayaranDAO().getById("A001");
                int hasil =0;
                List<Object> datas2 = new PembayaranDAO().getAll();
                if (p.getNoPolis().equals("P005") ) {
                
                
                for (int i = 0; i <datas2.size() ; i++) {
                    hasil = hasil+1;
                }
                System.out.println(hasil);
            }
            
}
}