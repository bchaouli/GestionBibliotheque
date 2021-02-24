/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitie.Livres;
import db.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bahria
 */
public class LivresServices {
    
    public static List<Livres> GetAll(){
        List<Livres> listLivres = new ArrayList<Livres>();
        Connection con = ConnectionUtil.getConnection();
        if (con != null) {
            Statement stmt;
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Livres order by livre_id desc");

                while (rs.next()) {
                    listLivres.add(new Livres(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
                }
                
                rs.close();
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
        return listLivres;
    }
    
     public static Boolean AjouterLivres(int id , String isbn, int annee, String langue, int themeId){
        Boolean boolReslut = false;
        
        Connection con = ConnectionUtil.getConnection();
        
         if(con!=null){
            try {
                PreparedStatement pstmt=con.prepareStatement("insert into Livres values (?, ?, ?,?,?)");
                pstmt.setInt(1, id);
                pstmt.setString(2, isbn);
                pstmt.setInt(3, annee);
                pstmt.setString(4, langue);
                pstmt.setInt(5, themeId);
              
                int bh=pstmt.executeUpdate();
                
                if(bh == 1){
                    boolReslut = true;
                }
                
                pstmt.close();
                con.close();
                
            }catch(Exception ex){
                System.out.println("Erreur !!!");
                        
                }
            }
         
        return boolReslut;
    }
    
     public static Livres RechercherLivres(int id){
        Livres objLivres = null;
         Connection con=ConnectionUtil.getConnection();
        if(con!=null){
            try {
                PreparedStatement pstmt=con.prepareStatement("select isbn, annee, langue, theme_id from Livres where livre_id=?");
                pstmt.setInt(1, id);
               
                ResultSet rs=pstmt.executeQuery();
                if(rs.next()){
                    objLivres = new Livres();
                    
                    objLivres.setId(id);
                    objLivres.setIsbn(rs.getString(1));
                    objLivres.setAnnee(rs.getInt(2));
                    objLivres.setLangue(rs.getString(3));
                    objLivres.setThemeId(rs.getInt(4));
                   
                }
                rs.close();
                pstmt.close();
                con.close();
                
            } catch(Exception ex){
                
                System.out.println(ex.getMessage());
            }
        }
        
        return objLivres;
    }
     
      public static Boolean ModifierLivres(int id ,String isbn, int annee, String langue, int themeId){
        Boolean boolReslut = false;
        
        Connection con = ConnectionUtil.getConnection();
        
         if(con!=null){
            try {
                
              PreparedStatement pstmt=con.prepareStatement("update Livres set isbn=?,annee=?, langue=?, theme_id=?  where livre_id=?");
             
                pstmt.setString(1, isbn);
                pstmt.setInt(2, annee);
                pstmt.setString(3, langue);
                pstmt.setInt(4, themeId);
                pstmt.setInt(5, id);
               
                int bh=pstmt.executeUpdate();
                
                if(bh == 1){
                    boolReslut = true;
                }
                
                pstmt.close();
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                }
            }
         
        return boolReslut;
}
      
      public static Boolean SupprimerLivres(int id){
        Boolean boolResult = false;
        
        Connection con=ConnectionUtil.getConnection();
        if(con != null){
            try{

                PreparedStatement pstmt=con.prepareStatement("delete from Livres where livre_id=?");
                pstmt.setInt(1, id);

                int bh = pstmt.executeUpdate();
                
                if(bh == 1){
                    boolResult = true;
                }

                pstmt.close();
                con.close();

               }catch(Exception ex){
                System.out.println(ex.getMessage());
               }
        }
        
        return boolResult;
    }
}
