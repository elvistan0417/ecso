/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao.impl;

import com.ecso.reseller.dao.contactDetailsDao;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.saleOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author jiasingtan
 */
public class contactDetailsDaoImpl implements contactDetailsDao{

	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}    
    
    
    @Override
    public String insertContactDetails(final contactDetails contactDetailsObject) {
        
	final String insertQuery="Insert into CUSTOMER (CUSTOMER_NAME,CUSTOMER_PHONE,CUSTOMER_ADDRESS,CUSTOMER_FB_NAME,CUSTOMER_WECHAT_NAME,CUSTOMER_CREATE_DATETIME,customer_Update_DateTime,CUSTOMER_FULL_NAME) values (?,?,?,?,?,NOW(),NOW(),?)";
		
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            PreparedStatement ps =
                connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contactDetailsObject.getCustomerName());
            ps.setString(2, contactDetailsObject.getCustomerPhone());
            ps.setString(3, contactDetailsObject.getCustomerAddress());
            ps.setString(4, contactDetailsObject.getFbName());
            ps.setString(5, contactDetailsObject.getWeChatName());
            ps.setString(6, contactDetailsObject.getCustomerFullName());
            return ps;
        }
    },
    keyHolder);
        return keyHolder.getKey().toString();


    }
    
        @Override
        public int updateContactDetails(contactDetails contactDetailsObject) {
        String updateQuery = "UPDATE CUSTOMER SET CUSTOMER_NAME = ?,CUSTOMER_PHONE = ?, CUSTOMER_ADDRESS = ?, CUSTOMER_FB_NAME = ?, CUSTOMER_WECHAT_NAME = ?, CUSTOMER_UPDATE_DATETIME = now(),CUSTOMER_FULL_NAME = ? WHERE CUSTOMER_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{contactDetailsObject.getCustomerName(),contactDetailsObject.getCustomerPhone(),contactDetailsObject.getCustomerAddress(),contactDetailsObject.getFbName(),contactDetailsObject.getWeChatName(),contactDetailsObject.getCustomerFullName(),contactDetailsObject.getCustomerID()});
        }     

        
        @Override
        public contactDetails getContactDetails(contactDetails contactDetails) {
        String selectQuery = "select CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_PHONE,CUSTOMER_ADDRESS,CUSTOMER_CREATE_DATETIME,customer_Update_DateTime,CUSTOMER_FB_NAME,CUSTOMER_WECHAT_NAME,CUSTOMER_FULL_NAME from CUSTOMER WHERE CUSTOMER_ID = ?";
         
		try{
			contactDetails contactDetailsObject  = jdbcTemplate.queryForObject(selectQuery, new Object[] { contactDetails.getCustomerID() },
				new RowMapper<contactDetails>() {
					public contactDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						contactDetails resultList = new contactDetails();
                                                resultList.setCustomerID(rs.getString(1));
						resultList.setCustomerName(rs.getString(2));
                                                resultList.setCustomerPhone(rs.getString(3));
                                                resultList.setCustomerAddress(rs.getString(4));
                                                resultList.setCreateDate(rs.getDate(5));
                                                resultList.setUpdateDate(rs.getDate(6));
                                                resultList.setFbName(rs.getString(7));
                                                resultList.setWeChatName(rs.getString(8));
                                                resultList.setCustomerFullName(rs.getString(9));
						return resultList;
					}
				});

		return contactDetailsObject;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
            

    }      
        
     @Override
        public int deleteContactDetails(contactDetails contactDetailsObject) {
        String updateQuery = "delete from CUSTOMER WHERE CUSTOMER_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{contactDetailsObject.getCustomerID()});
        } 
        
     @Override
     public List<contactDetails> getContactDetailsList(contactDetails contactDetailsObject){
        String selectQuery = "select CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_PHONE,CUSTOMER_ADDRESS,CUSTOMER_CREATE_DATETIME,customer_Update_DateTime,CUSTOMER_FB_NAME,CUSTOMER_WECHAT_NAME,CUSTOMER_FULL_NAME from CUSTOMER  ORDER BY CUSTOMER_CREATE_DATETIME DESC";
		try{
			List<contactDetails> orderTripList = jdbcTemplate.query(selectQuery, new Object[] {}, new RowMapper<contactDetails>(){
			public contactDetails mapRow(ResultSet rs, int rowNum) throws SQLException{
				contactDetails resultList = new contactDetails();
                                                resultList.setCustomerID(rs.getString(1));
						resultList.setCustomerName(rs.getString(2) );
                                                resultList.setCustomerPhone(rs.getString(3));
                                                resultList.setCustomerAddress(rs.getString(4));
                                                resultList.setCreateDate(rs.getDate(5));
                                                resultList.setUpdateDate(rs.getDate(6));
                                                resultList.setFbName(rs.getString(7));
                                                resultList.setWeChatName(rs.getString(8));
                                                resultList.setCustomerFullName(rs.getString(9));
						return resultList;
					}
				});

		return orderTripList;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
     }
        
}
