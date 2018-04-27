/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Admin;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author dbayu
 */

public class AdminDAO implements InterfaceDAO {

    public Transaction transaction;

    public FunctionDAO fdao;

    public AdminDAO() {
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
         return fdao.delete(Admin.class, object +"");
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll(" FROM Admin");
    }

    @Override
    public List<Object> search(String category, String search) {
          return fdao.getAll("FROM Admin WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Admin where idAdmin='" + id + "'");
    }
    
    public String getAutoID(){
        return (String) fdao.getById("SELECT CONCAT('D', LPAD((TO_NUMBER(SUBSTR(MAX(idAdmin),2,3))+1), 3, '0'))FROM Admin");
    }
    
    public boolean login(String kategori, String Username, String pass){
        Admin a  = (Admin) search(kategori, Username).get(0);
        return BCrypt.checkpw(pass, a.getPassword());
    }
}

