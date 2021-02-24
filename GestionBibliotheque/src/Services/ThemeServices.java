/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitie.Theme;
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
public class ThemeServices {
    
     public static List<Theme> GetAll(){
        List<Theme> listTheme = new ArrayList<Theme>();
        Connection con = ConnectionUtil.getConnection();
        if (con != null) {
            Statement stmt;
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Theme order by theme_id desc");

                while (rs.next()) {
                    listTheme.add(new Theme(rs.getInt(1),rs.getString(2),rs.getString(3)));
                }
                
                rs.close();
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
        return listTheme;
    }
    
     public static Boolean AjouterTheme(int id , String intituleTheme, String descriptionTheme){
        Boolean boolReslut = false;
        
        Connection con = ConnectionUtil.getConnection();
        
         if(con!=null){
            try {
                PreparedStatement pstmt=con.prepareStatement("insert into Theme values (?, ?, ?)");
                pstmt.setInt(1, id);
                pstmt.setString(2, intituleTheme);
                pstmt.setString(3, descriptionTheme);
              
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
     
      public static Theme RechercherTheme(int id){
        Theme objTheme = null;
         Connection con=ConnectionUtil.getConnection();
        if(con!=null){
            try {
                PreparedStatement pstmt=con.prepareStatement("select intituleTheme, descriptionTheme  from Theme where theme_id=?");
                pstmt.setInt(1, id);
               
                ResultSet rs=pstmt.executeQuery();
                if(rs.next()){
                    objTheme = new Theme();
                    
                    objTheme.setId(id);
                    objTheme.setIntituleTheme(rs.getString(1));
                    objTheme.setDescriptionTheme(rs.getString(2));
                   
                }
                rs.close();
                pstmt.close();
                con.close();
                
            } catch(Exception ex){
                
                System.out.println(ex.getMessage());
            }
        }
        
        return objTheme;
    }
      
      public static Boolean ModifierTheme(int id , String intituleTheme, String descriptionTheme){
        Boolean boolReslut = false;
        
        Connection con = ConnectionUtil.getConnection();
        
         if(con!=null){
            try {
                
              PreparedStatement pstmt=con.prepareStatement("update Theme set intituleTheme=?,descriptionTheme=? where theme_id=?");
             
                pstmt.setString(1, intituleTheme);
                pstmt.setString(2, descriptionTheme);
                pstmt.setInt(3, id);
               
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
      
       public static Boolean SupprimerTheme(int id){
        Boolean boolResult = false;
        
        Connection con=ConnectionUtil.getConnection();
        if(con != null){
            try{

                PreparedStatement pstmt=con.prepareStatement("delete from Theme where theme_id=?");
                pstmt.setInt(1, id);

                int bh = pstmt.executeUpdate();
                
                if(bh == 1){
                    boolResult = true;
                }

                pstmt.close();
                con.close();

               }catch(Exception ex){
                   System.out.println("Erreur !!!");
               }
        }
        
        return boolResult;
    }
}
