/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.User;

/**
 *
 * @author 834171
 */
public class AccountService {
    private String betty,adam,password;
    
    public AccountService(){
    this.adam="adam";
    this.betty="betty";
    this.password="password";
    }
    public User login(String username, String password){
        
        if((username.equals(this.adam) || username.equals(this.betty)) && password.equals(this.password)){
            return new User(username,password);
        }
        return null;
    }
    }

