/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dell
 */
public class Customer {
    String name;
    String account;
    String password;
    String email;
    String telephone;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    
  
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getTelephone(){
        return telephone;
    }
    public void setTelephone(String telephone){
        this.telephone=telephone;
    }
}
