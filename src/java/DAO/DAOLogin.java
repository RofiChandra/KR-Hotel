/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HotelUtil;
import POJO.TblAdmin;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class DAOLogin {
    public List<TblAdmin> getBy(String uName , String uPass)
    {
        Transaction trans = null;
        TblAdmin adm = new TblAdmin();
        List<TblAdmin> admin = new ArrayList();
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblAdmin where username=:uName AND password =:uPass ");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            adm = (TblAdmin) query.uniqueResult();
            admin = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return admin;
    }
    
    public String add_user(TblAdmin admin){
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(admin);
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return "biodata";
    }
}
