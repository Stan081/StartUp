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
public class MyStates {
    private String state_id;
    private String name;

    public MyStates(String state_id, String name) {
        this.state_id = state_id;
        this.name = name;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyStates{" + "state_id=" + state_id + ", name=" + name + '}';
    }
    
    
    
    
}
