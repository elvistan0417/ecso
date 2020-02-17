/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service.impl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.ecso.reseller.dao.userDao;
import com.ecso.reseller.model.UserProfile;
import com.ecso.reseller.model.UserAuthority;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;


/**
 * This class is used by spring controller to authenticate and authorize user
 * modified this class to user our Database and defined user roles
 * 
 * @author abhishek.somani
 */
 @Component
//public class UserDetailServiceImpl implements UserDetailsService {
public class UserDetailServiceImpl {
//@Autowired
//userDao userDao;
//
//  public UserDetails loadUserByUsername(String username)
//               throws UsernameNotFoundException, DataAccessException {
//      
//          UserAuthority mediUser = null;
//          List authorities = new ArrayList();
// System.out.println("String user role 2");
//          if (!"".equals(username)) {
// System.out.println("String user role 3");
//               UserProfile userProfile = userDao.get(username);
// System.out.println("String user role 1");
//               if (null != userProfile) {
//                    List<String> userRoles = userProfile.getUserRole();
//
////                    if (null != userRoles && userRoles.size() > 0) {
//                        for (String temp : userRoles) {
//                            System.out.println("String user role " + temp);
//                               authorities.add(new GrantedAuthorityImpl(temp));
//                    }
////System.out.println("Do they come in ??? 123123aaaa" + username);
//                    mediUser = new UserAuthority(username,
//                    userProfile.getPassword(), true, true, true, true,authorities, 
//                       userProfile.getUserID(),null,
//                       null, 123, 123);
//
//              } else {
//                      mediUser = new UserAuthority(username, "NA", true, 
//                          true, true, true, authorities, null, null, null, 0, 0);
//              }          
//          } else {
//                 mediUser = new UserAuthority(username, "NA", true, 
//                    true, true, true, authorities, null, null, null, 0, 0);
//          }

//       userDao.closeSession();
//       return mediUser;
//     }

//     public LogInService getLogInService() {
//         return logInService;
//     }
//
//     public void setLogInService(LogInService logInService) {
//         this.logInService = logInService;
//     }

}