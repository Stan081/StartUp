/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zayinlieva;

/**
 *
 * @author STANLEY
 */
public class Category {
    private String categorie;

    public Category() {
    }

    public Category(String categorie) {
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Category{" + "categorie=" + categorie + '}';
    }
    
    
}
