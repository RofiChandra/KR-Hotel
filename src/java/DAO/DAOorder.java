/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HotelUtil;
import POJO.TblOrder;
import POJO.TblRoom;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class DAOorder {
     public List<TblRoom> retrieveRoom()
    {

        List admin=new ArrayList();
        Transaction trans=null;
        Session session=HotelUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from TblRoom");
            admin=query.list();

            trans.commit();

        }
        catch(Exception e)
        {

        }
        return admin;
    }
    
    public List<TblRoom> getbyID2 (int idR){
        TblRoom adm = new TblRoom();
        List<TblRoom> iadm = new ArrayList();
        
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRoom where id_room = :id");
            query.setInteger("id", idR);
            adm = (TblRoom) query.uniqueResult();
            iadm = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iadm;
    }
    
        public void add_order(TblOrder order){
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(order);
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
