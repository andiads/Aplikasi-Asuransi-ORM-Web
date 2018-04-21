/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Klaim;
import java.util.List;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Toshiba
 */
public class KlaimDAO implements InterfaceDAO{
public Transaction transaction;

    public FunctionDAO fdao;

    public KlaimDAO() {
        this.fdao = new FunctionDAO(HibernateUtil.getSessionFactory());
    }
    
    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
      return fdao.delete(Klaim.class, object.toString());
    }

    @Override
    public List<Object> getAll() {
         return fdao.getAll(" from Klaim");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Klaim WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Nasabah where NIK='" + id + "'");
    }
    
     public String getAutoID(){
        return (String) fdao.getById("SELECT CONCAT('K', LPAD((TO_NUMBER(SUBSTR(MAX(idklaim),2,3))+1), 3, '0'))FROM Klaim");
    }
}
