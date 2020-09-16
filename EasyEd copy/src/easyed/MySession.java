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
public class MySession {
    private String session_id;
    private String session_desc;

    public MySession() {
    }

    public MySession(String session_id, String session_desc) {
        this.session_id = session_id;
        this.session_desc = session_desc;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_desc() {
        return session_desc;
    }

    public void setSession_desc(String session_desc) {
        this.session_desc = session_desc;
    }

    @Override
    public String toString() {
        return "MySession{" + "session_id=" + session_id + ", session_desc=" + session_desc + '}';
    }
    
    
}
