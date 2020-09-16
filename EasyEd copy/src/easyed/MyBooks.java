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
public class MyBooks {
    
    public String book_id;
    public String book_desc;
    public String book_price;

    public MyBooks() {
    }

    public MyBooks(String book_id, String book_desc, String book_price) {
        this.book_id = book_id;
        this.book_desc = book_desc;
        this.book_price = book_price;
    }

    public MyBooks(String book_id, String book_desc) {
        this.book_id = book_id;
        this.book_desc = book_desc;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_desc() {
        return book_desc;
    }

    public void setBook_desc(String book_desc) {
        this.book_desc = book_desc;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    @Override
    public String toString() {
        return "MyBooks{" + "book_id=" + book_id + ", book_desc=" + book_desc + ", book_price=" + book_price + '}';
    }
    
    
    
}
