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
public class Items {
    private String id;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private String itemPrice;
    private String itemSize;

    public Items() {
    }

    public Items(String itemName, String itemDescription, String itemCategory, String itemSize) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemSize = itemSize;
    }
    
    

    public Items(String itemName, String itemDescription, String itemCategory, String itemPrice, String itemSize) {
       
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemSize = itemSize;
    }

    public Items(String id, String itemName, String itemDescription, String itemCategory, String itemPrice, String itemSize) {
        this.id = id;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemSize = itemSize;
    }
    
     
    
    public Items(String itemName, String itemCategory, String itemPrice) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
    }

    
    

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Items{" + "id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", itemCategory=" + itemCategory + ", itemPrice=" + itemPrice + ", itemSize=" + itemSize + '}';
    }
    
    
    

    
    
    
}
