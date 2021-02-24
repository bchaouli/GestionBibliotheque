/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie;

import java.util.Date;

/**
 *
 * @author Bahria
 */
public class Emprunts {
    
    private int empruntId;
    private int livreId;
    private int adherentId;
    private String datEmprunt;
    private String dateRetour;
    private boolean rendu;
    private String dateRendu;

    public Emprunts() {
    }

    public Emprunts(int empruntId, int livreId, int adherentId, String datEmprunt, String dateRetour, boolean rendu, String dateRendu) {
        this.empruntId = empruntId;
        this.livreId = livreId;
        this.adherentId = adherentId;
        this.datEmprunt = datEmprunt;
        this.dateRetour = dateRetour;
        this.rendu = rendu;
        this.dateRendu = dateRendu;
    }

   

 

    public int getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(int empruntId) {
        this.empruntId = empruntId;
    }

    public int getLivreId() {
        return livreId;
    }

    public void setLivreId(int livreId) {
        this.livreId = livreId;
    }

    public int getAdherentId() {
        return adherentId;
    }

    public void setAdherentId(int adherentId) {
        this.adherentId = adherentId;
    }

    public String getDatEmprunt() {
        return datEmprunt;
    }

    public void setDatEmprunt(String datEmprunt) {
        this.datEmprunt = datEmprunt;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public boolean getRendu() {
        return rendu;
    }

    public void setRendu(boolean rendu) {
        this.rendu = rendu;
    }

    public String getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(String dateRendu) {
        this.dateRendu = dateRendu;
    }

    public int getInt(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
