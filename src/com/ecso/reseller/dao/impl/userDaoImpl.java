/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao.impl;

import com.ecso.reseller.dao.userDao;
import com.ecso.reseller.model.UserProfile;
import com.ecso.reseller.model.UserAuthority;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jiasingtan
 */
public class userDaoImpl implements userDao {
    
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}        
    
    public  UserProfile get(String userName){
        UserProfile userObject;
		String selectQuery = "SELECT T_USER_DTL_ID,USER_NAME,PASSWORD FROM T_USER_DTL WHERE USER_NAME = ?";
		try{
			userObject  = jdbcTemplate.queryForObject(selectQuery, new Object[] { userName },
				new RowMapper<UserProfile>() {
					public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserProfile resultList = new UserProfile();
						resultList.setUserID(rs.getString(1));
                                                resultList.setUserName(rs.getString(2));
                                                resultList.setPassword(rs.getString(3));
						return resultList;
					}
				});

		//return userObject;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
    
        String Query = "SELECT b.ROLE as role FROM T_USER_DTL a, T_USER_ROLE b WHERE a.T_USER_DTL_ID = b.T_USER_DTL_ID AND a.USER_NAME =?";
		
		List<String> userRoleList = jdbcTemplate.query(Query,new Object[]{userObject.getUserName()}, new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum) throws SQLException{
				String resultList = new String();
				resultList = rs.getString(1);
				return resultList;
			}
		});
        userObject.setUserRole(userRoleList);
    
    return userObject;
    
    }
}
