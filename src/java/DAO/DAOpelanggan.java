/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HotelUtil;
import POJO.TblPelanggan;
import POJO.TblRoom;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class DAOpelanggan {
      
     public void add_pelanggan(TblPelanggan data){
        Transaction trans = null;
        Session session = HotelUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(data);
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
