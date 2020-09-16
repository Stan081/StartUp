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
public class MyClassStud {
    private String class_stud_id;
    private String stud_id;
    private String session_id;
    private String term_id;
    private String class_id;

    public MyClassStud() {
    }

    public MyClassStud(String class_stud_id, String stud_id, String session_id, String term_id, String class_id) {
        this.class_stud_id = class_stud_id;
        this.stud_id = stud_id;
        this.session_id = session_id;
        this.term_id = term_id;
        this.class_id = class_id;
    }

    public MyClassStud(String stud_id, String session_id, String term_id, String class_id) {
        this.stud_id = stud_id;
        this.session_id = session_id;
        this.term_id = term_id;
        this.class_id = class_id;
    }
    

    public String getClass_stud_id() {
        return class_stud_id;
    }

    public void setClass_stud_id(String class_stud_id) {
        this.class_stud_id = class_stud_id;
    }

    public String getStud_id() {
        return stud_id;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "MyClassStud{" + "class_stud_id=" + class_stud_id + ", stud_id=" + stud_id + ", session_id=" + session_id + ", term_id=" + term_id + ", class_id=" + class_id + '}';
    }
    
    
    
}
