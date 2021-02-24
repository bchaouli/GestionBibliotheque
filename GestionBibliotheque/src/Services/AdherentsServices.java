/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitie.Adherents;
import db.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bahria
 */
public class AdherentsServices {
    
    public static List<Adherents> GetAll(){
        List<Adherents> listAdherents= new ArrayList<Adherents>();
        Connection con = ConnectionUtil.getConnection();
        if (con != null) {
            Statement stmt;
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Adherents order by adherent_id desc");

                while (rs.next()) {
                    listAdherents.add(new Adherents(rs.getInt(1),
                                                    rs.getString(2),
                                                    rs.getString(3), 
                                                    rs.getString(4),
                                                    rs.getString(5)));
                }
                
                rs.close();
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
        return listAdherents;
    }
    
     public static Boolean AjouterAdherents(int id , String nom, String prenom, String adresse, String dateInscription ){
        Boolean boolReslut = false;
        
        Connection con = ConnectionUtil.getConnection();
        
         if(con!=null){
            try {
                PreparedStatement pstmt=con.prepareStatement("insert into Adherents values (?, ?, ?,?, ?)");
                
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date parsed = format.parse(dateInscription);
                java.sql.Date sqlDateInscription = new java.sql.Date(parsed.getTime());
        
                pstmt.setInt(1, id);
                pstmt.setString(2, nom);
                pstmt.setString(3, prenom);
                pstmt.setString(4, adresse);
                pstmt.setDate(5, sqlDateInscription);
              
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
     
     public static Boolean ModifierAdherents(int id , String nom, String prenom, String adresse, String dateInscription ){
        Boolean boolReslut = false;
        
        Connection con = ConnectionUtil.getConnection();
        
         if(con!=null){
            try {
                
              PreparedStatement pstmt=con.prepareStatement("update Adherents set nom=?,prenom=?,adresse=?, date_inscription=? where adherent_id=?");
             
                pstmt.setString(1, nom);
                pstmt.setString(2, prenom);
                pstmt.setString(3, adresse);
                pstmt.setString(4, dateInscription);
                pstmt.setInt(5, id);
               
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
     
     public static Adherents RechercherAdherents(int id){
        Adherents objAdherents = null;
         Connection con=ConnectionUtil.getConnection();
        if(con!=null){
            try {
                String req = "";
                
                req += "select nom, prenom, adresse, date_inscription from Adherents where adherent_id=?";
                        
                PreparedStatement pstmt=con.prepareStatement(req);
                pstmt.setInt(1, id);
               
                ResultSet rs=pstmt.executeQuery();
                if(rs.next()){
                    objAdherents = new Adherents();
                    
                    objAdherents.setId(id);
                    objAdherents.setNom(rs.getString(1));
                    objAdherents.setPrenom(rs.getString(2));
                    objAdherents.setAdresse(rs.getString(3));
                    objAdherents.setDateInscription(rs.getString(4));
                   
                    
                }
                rs.close();
                pstmt.close();
                con.close();
                
            } catch(Exception ex){
                
                System.out.println(ex.getMessage());
            }
        }
        
        return objAdherents;
    }
     
     public static Boolean SupprimerAdherents(int id){
        Boolean boolResult = false;
        
        Connection con=ConnectionUtil.getConnection();
        if(con != null){
            try{

                PreparedStatement pstmt=con.prepareStatement("delete from Adherents where adherent_id=?");
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
