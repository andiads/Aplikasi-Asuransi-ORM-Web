/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Asuransi;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author dbayu
 */
public class AsuransiDAO implements InterfaceDAO{
    public Session session;
    private SessionFactory factory;
    public Transaction transaction;

    public FunctionDAO fdao;
    
    public AsuransiDAO() {
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
         return fdao.delete(Asuransi.class, object +"");
     }

    @Override
    public List<Object> getAll() {
      return fdao.getAll("FROM Asuransi");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Asuransi WHERE " + category + " LIKE '%" + search + "%'");
     }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Asuransi where kodeAsuransi='" + id + "'");
    }
    
    public String getAutoID(){
        return (String) fdao.getById("SELECT CONCAT('A', LPAD((TO_NUMBER(SUBSTR(MAX(kodeAsuransi),2,3))+1), 3, '0'))FROM Asuransi");
    }
}
