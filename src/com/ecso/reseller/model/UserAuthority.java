/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.model;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 *
 * @author jiasingtan
 */
public class UserAuthority extends User {

     private static final long serialVersionUID = -3531439484732724601L;
     
     private final String userID;
     private final String middleName;
     private final String lastName;
     private final long phNumber;
     private final long altPhNumber;
     

     


     public UserAuthority(String username, String password, boolean enabled,
         boolean accountNonExpired, boolean credentialsNonExpired,
         boolean accountNonLocked,
         Collection authorities,
         String userID, String middleName, String lastName,
         long phNumber, long altPhNumber) {

             super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);

             this.userID = userID;
             this.middleName = middleName;
             this.lastName = lastName;
             this.phNumber = phNumber;
             this.altPhNumber = altPhNumber;
     }

     public static long getSerialversionuid() {
        return serialVersionUID;
     }

     public String getUserID() {
        return userID;
     }

     public String getMiddleName() {
        return middleName;
     }

     public String getLastName() {
        return lastName;
     }

     public long getPhNumber() {
       return phNumber;
     }

     public long getAltPhNumber() {
       return altPhNumber;
     }

  
     
     
  }