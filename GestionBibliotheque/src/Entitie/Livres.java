/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie;

/**
 *
 * @author Bahria
 */
public class Livres {
    
    private int id;
    private String isbn;
    private int annee;
    private String langue;
    private int themeId;

    public Livres() {
    }

    public Livres(int id, String isbn, int annee, String langue, int themeId) {
        this.id = id;
        this.isbn = isbn;
        this.annee = annee;
        this.langue = langue;
        this.themeId = themeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }
    
    
}
