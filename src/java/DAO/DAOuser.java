/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HotelUtil;
import POJO.TblAdmin;
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
public class DAOuser {
    public List<TblRoom> retrieveTblRoom()
    {
        List stud = new ArrayList();
        TblRoom stud1 = new TblRoom();
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRoom");
            stud = query.list();
            stud.add(stud1.getIdRoom());
            stud.add(stud1.getNamaRoom());
            stud.add(stud1.getType());
            stud.add(stud1.getPrice());
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return stud;
    }
    
    public List<TblRoom> getbyID (String idA){
        TblRoom adm = new TblRoom();
        List<TblRoom> iadm = new ArrayList();
        
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRoom where id_room = :id");
            query.setString("id", idA);
            adm = (TblRoom) query.uniqueResult();
            iadm = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iadm;
    }
    
    public List<TblRoom> getbyID2 (String idA){
        TblRoom adm = new TblRoom();
        List<TblRoom> iadm = new ArrayList();
        
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRoom where id_room = :id");
            query.setString("id", idA);
            adm = (TblRoom) query.uniqueResult();
            iadm = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iadm;
    }
            
            
    public void deleteRoom (Integer idR)
    {
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblRoom room = (TblRoom) session.load(TblRoom.class, new Integer(idR));
            session.delete(room);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void editRoom (TblRoom room)
    {
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(room);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void add_room(TblRoom room){
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(room);
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<TblRoom> getbyNama (String nmR){
        TblRoom adm = new TblRoom();
        List<TblRoom> iadm = new ArrayList();
        
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRoom where nama_room = :nama");
            query.setString("nama", nmR);
            adm = (TblRoom) query.uniqueResult();
            iadm = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iadm;
    }
}
