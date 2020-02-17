/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public class UserProfile {
         private String userID;
         private String password;
         private String userName;
         private List<String> userRole;
         
         public String customerID;
         public String customerName;
         public String customerPhone;
         public String customerAddress;
         public Date customerCreateDateTime;
         public Date customerUpdateDateTime;
         public String fbName;
         public String weChatName;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<String> userRole) {
        this.userRole = userRole;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Date getCustomerCreateDateTime() {
        return customerCreateDateTime;
    }

    public Date getCustomerUpdateDateTime() {
        return customerUpdateDateTime;
    }

    public String getFbName() {
        return fbName;
    }

    public String getWeChatName() {
        return weChatName;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerCreateDateTime(Date customerCreateDateTime) {
        this.customerCreateDateTime = customerCreateDateTime;
    }

    public void setCustomerUpdateDateTime(Date customerUpdateDateTime) {
        this.customerUpdateDateTime = customerUpdateDateTime;
    }

    public void setFbName(String fbName) {
        this.fbName = fbName;
    }

    public void setWeChatName(String weChatName) {
        this.weChatName = weChatName;
    }

 
    
    
    
    
}
