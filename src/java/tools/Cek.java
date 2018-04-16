/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import DAO.AdminDAO;
import entities.Admin;
import java.util.List;

/**
 *
 * @author dbayu
 */
public class Cek {
    public static void main(String[] args) {
        List<Object> datas = new AdminDAO().getAll();
        for (Object data : datas) {
            Admin a = (Admin) data;
            System.out.println(datas.size());
            
        }
    }
    
}
