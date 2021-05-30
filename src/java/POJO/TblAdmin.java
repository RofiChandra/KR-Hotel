package POJO;
// Generated Oct 26, 2020 5:52:23 PM by Hibernate Tools 4.3.1

import DAO.DAOLogin;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * TblAdmin generated by hbm2java
 */
@ManagedBean
public class TblAdmin  implements java.io.Serializable {


     private Integer idAdmin;
     private String username;
     private String password;

     public String login_user()
     {
         DAOLogin uDao = new DAOLogin();
         List<TblAdmin> adm = uDao.getBy(username, password);
         try {
              if(adm != null)
         {
             username = adm.get(0).username;
             password = adm.get(0).password;
             return "homepage";
         }
             
         } catch (Exception e) {
             System.out.println(e);
         }
         return "login_failed";
     }
     
     public String login_admin()
     {
         DAOLogin uDao = new DAOLogin();
         List<TblAdmin> adm = uDao.getBy(username, password);
         try {
              if(adm != null)
         {
             username = adm.get(0).username;
             password = adm.get(0).password;
             return "admin_page";
         }
             
         } catch (Exception e) {
             System.out.println(e);
         }
         return "login_failed";
     }
     
     public String save_admin()
     {
         DAOLogin add = new DAOLogin();
         add.add_user(this);
         return "biodata";
     }
     
     
    public TblAdmin() {
    }

    public TblAdmin(String username, String password) {
       this.username = username;
       this.password = password;
    }
   
    public Integer getIdAdmin() {
        return this.idAdmin;
    }
    
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


