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
public class MyTerm {
    private String term_id;
    private String term_desc;

    public MyTerm() {
    }

    public MyTerm(String term_id, String term_desc) {
        this.term_id = term_id;
        this.term_desc = term_desc;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getTerm_desc() {
        return term_desc;
    }

    public void setTerm_desc(String term_desc) {
        this.term_desc = term_desc;
    }

    @Override
    public String toString() {
        return "MyTerm{" + "term_id=" + term_id + ", term_desc=" + term_desc + '}';
    }
    
    
    
}
