/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zayinlieva;

import javax.swing.JOptionPane;

/**
 *
 * @author STANLEY
 */
public class Users {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;
    private String sex;
    private String role;
    private String secretWord;

    public Users() {
    }

    public Users(String firstName, String lastName, String email, String phoneNumber, String userName, String password, String sex, String role, String secretWord) {
        if(firstName.matches("[A-Z][a-z]*")) {
             this.firstName = firstName;
        } else {
              JOptionPane.showMessageDialog(null, "START FIRST NAME WITH UPPER CASE", "LOGIN DETAILS", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (lastName.matches("[A-Z][a-z]*")) {
             this.lastName = lastName;
        }else{
              JOptionPane.showMessageDialog(null, "START LAST NAME WITH UPPER CASE", "LOGIN DETAILS", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(email.matches("^[a-z]+[a-z0-9._%+-]+@[a-z.-]+(\\.[a-z]{2,4})$")){
            this.email = email;
                }else{
               JOptionPane.showMessageDialog(null, "INVALID FORMAT FOR EMAIL!!!", "LOGIN DETAILS", JOptionPane.INFORMATION_MESSAGE);
         }
        
        if(phoneNumber.matches("[+234]+(\\d{10})")){
            this.phoneNumber = phoneNumber;
        }else{ 
            JOptionPane.showMessageDialog(null, "INVALID FORMAT FOR PHONE NUMBER!!!", "LOGIN DETAILS", JOptionPane.INFORMATION_MESSAGE);
        }
        
       
       
        
        
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.role = role;
        this.secretWord = secretWord;
    }

    public Users(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    @Override
    public String toString() {
        return "Users{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password + ", sex=" + sex + ", role=" + role + ", secretWord=" + secretWord + '}';
    }

  
    
   
}
