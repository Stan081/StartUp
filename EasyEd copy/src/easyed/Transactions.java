/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

/**
 *
 * @author Stan
 */
public class Transactions {
    public String transId;
    public String classStudId;
    public String payId;
    public String itemId;
    public String itemDesc;
    public String quantity;
    public String price;
    public String date;
    
    public String name;
    public String stud_class;
    public String payType;
    
   
    
    
    
    public Transactions() {
    }

    public Transactions(String classStudId, String payId, String itemId, String itemDesc, String quantity, String price, String date) {
        this.classStudId = classStudId;
        this.payId = payId;
        this.itemId = itemId;
        this.itemDesc = itemDesc;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public Transactions(String transId, String name, String stud_class, String payType, String itemDesc, String quantity , String price, String date) {
        this.transId = transId;
        this.name = name;
        this.stud_class = stud_class;
        this.payType = payType;
        this.itemDesc = itemDesc;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        
       
    }

    public Transactions(String payId, String itemId, String itemDesc, String quantity, String price) {
        this.payId = payId;
        this.itemId = itemId;
        this.itemDesc = itemDesc;
        this.quantity = quantity;
        this.price = price;
    }

    public Transactions(String payId, String itemDesc, String quantity, String price) {
        this.payId = payId;
        this.itemDesc = itemDesc;
        this.quantity = quantity;
        this.price = price;
    }

    public Transactions(String itemDesc, String price, String date) {
        this.itemDesc = itemDesc;
        this.price = price;
        this.date = date;
    }

 

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getClassStudId() {
        return classStudId;
    }

    public void setClassStudId(String classStudId) {
        this.classStudId = classStudId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStud_class() {
        return stud_class;
    }

    public void setStud_class(String stud_class) {
        this.stud_class = stud_class;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "Transactions{" + "transId=" + transId + ", classStudId=" + classStudId + ", payId=" + payId + ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", quantity=" + quantity + ", price=" + price + ", date=" + date + ", name=" + name + ", stud_class=" + stud_class + ", payType=" + payType + '}';
    }


    
        
}
