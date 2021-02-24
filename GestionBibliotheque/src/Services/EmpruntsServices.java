/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitie.Emprunts;
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
public class EmpruntsServices {
    
     public static List<Emprunts> GetAll(){
        List<Emprunts> listEmprunts = new ArrayList<Emprunts>();
        Connection con = ConnectionUtil.getConnection();
        if (con != null) {
            Statement stmt;
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Emprunts order by emprunt_id desc");

                while (rs.next()) {
                    
                    listEmprunts.add(new Emprunts(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getBoolean(6),rs.getString(7)));
                }
                
                rs.close();
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
        return listEmprunts;
    }
    
     public static Boolean AjouterEmprunts(int Emid ,int Liid, int Adid,String DaEmprunt, String DaRetour, int Rendu, String DaRendu ){
        Boolean boolReslut = false;
        
        Connection con = ConnectionUtil.getConnection();
        
         if(con!=null){
            try {
                PreparedStatement pstmt=con.prepareStatement("insert into Emprunts values (?,?,?,?,?,?,?)");
                
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date parsed = format.parse(DaEmprunt);
                java.sql.Date sqlDaEmprunt = new java.sql.Date(parsed.getTime());
                
                java.sql.Date sqlDaRetour = new java.sql.Date(parsed.getTime());
                java.sql.Date sqlDaRendu= new java.sql.Date(parsed.getTime());
                
                
                pstmt.setInt(1, Emid);
                pstmt.setInt(2, Liid);
                pstmt.setInt(3, Adid);
                pstmt.setDate(4, sqlDaEmprunt);
                pstmt.setDate(5, sqlDaRetour);
                pstmt.setInt(6, Rendu);
                pstmt.setDate(7, sqlDaRendu);
              
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
     
      public static Emprunts RechercherEmprunts(int id){
        Emprunts objEmprunts = null;
         Connection con=ConnectionUtil.getConnection();
        if(con!=null){
            try {
                PreparedStatement pstmt=con.prepareStatement("select livre_id, adherent_id,date_emprunt,date_retour,rendu,date_rendu  from Emprunts where emprunt_id=?");
                pstmt.setInt(1, id);
               
                ResultSet rs=pstmt.executeQuery();
                if(rs.next()){
                    objEmprunts = new Emprunts();
                    
                    
                    objEmprunts.setLivreId(rs.getInt(1));
                    objEmprunts.setAdherentId(rs.getInt(2));
                    objEmprunts.setDatEmprunt(rs.getString(3));
                    objEmprunts.setDateRetour(rs.getString(4));
                    objEmprunts.setRendu(rs.getBoolean(5));
                    objEmprunts.setDateRendu(rs.getString(6));
                   
                }
                rs.close();
                pstmt.close();
                con.close();
                
            } catch(Exception ex){
                
                System.out.println(ex.getMessage());
            }
        }
        
        return objEmprunts;
    }

   
      
     
}
