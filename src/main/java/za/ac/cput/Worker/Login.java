/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Worker;

/**
 *
 * @author Rhegan
 */
public class Login {
    private String userLogin;
    private String passLogin;
    private Boolean activity;
    
    public Login(String userLogin, String passLogin, Boolean activity) {
        this.userLogin = userLogin;
        this.passLogin = passLogin;
        this.activity = activity;
    }

    public String getuserLogin() {
        return userLogin;
    }

    public void setuserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getpassLogin() {
        return passLogin;
    }

    public void setpassLogin(String passLogin) {
        this.passLogin = passLogin;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Login{" + "userLogin=" + userLogin + ", passLogin=" + passLogin + ", activity=" + activity + '}';
    }

    
}
