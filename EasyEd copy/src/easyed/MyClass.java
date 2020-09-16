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
public class MyClass {
    private String class_id;
    private String class_name;

    public MyClass() {
    }

    public MyClass(String class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "MyClass{" + "class_id=" + class_id + ", class_name=" + class_name + '}';
    }
    
    
}
    