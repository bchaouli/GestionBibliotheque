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
public class Theme {
    
    private int id;
    private String intituleTheme;
    private String descriptionTheme;

    public Theme() {
    }

    public Theme(int id, String intituleTheme, String descriptionTheme) {
        this.id = id;
        this.intituleTheme = intituleTheme;
        this.descriptionTheme = descriptionTheme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntituleTheme() {
        return intituleTheme;
    }

    public void setIntituleTheme(String intituleTheme) {
        this.intituleTheme = intituleTheme;
    }

    public String getDescriptionTheme() {
        return descriptionTheme;
    }

    public void setDescriptionTheme(String descriptionTheme) {
        this.descriptionTheme = descriptionTheme;
    }
    
    
}
