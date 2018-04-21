/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author dbayu
 */
public class PembayaranDAO implements InterfaceDAO{

    public PembayaranDAO() {
        this.fdao = new FunctionDAO(HibernateUtil.getSessionFactory());
    }
    
    public Transaction transaction;
    public  FunctionDAO fdao;

    @Override
    public boolean insert(Object object) {
     return fdao.insert(object);    
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("from Pembayaran order by noPembayaran");
    }

    @Override
    public List<Object> search(String category, String search) {
    return fdao.getAll("FROM Pembayaran WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
    return fdao.getById("from Pembayaran where noPembayaran='" + id + "'");
    }
    
    public String getAutoID(){
        return (String) fdao.getById("SELECT CONCAT('B', LPAD((TO_NUMBER(SUBSTR(MAX(noPembayaran),2,3))+1), 3, '0'))FROM Pembayaran");
    }
    
}
