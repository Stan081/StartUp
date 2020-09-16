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
public class MyLocals {
    private String state_id;
    private String local_id;
    private String local_name;

    public MyLocals() {
    }

    public MyLocals(String state_id, String local_id, String local_name) {
        this.state_id = state_id;
        this.local_id = local_id;
        this.local_name = local_name;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public String getLocal_name() {
        return local_name;
    }

    public void setLocal_name(String local_name) {
        this.local_name = local_name;
    }

    @Override
    public String toString() {
        return "MyLocals{" + "state_id=" + state_id + ", local_id=" + local_id + ", local_name=" + local_name + '}';
    }
    
    
    
}
