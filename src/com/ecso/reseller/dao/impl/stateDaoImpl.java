/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao.impl;

import com.ecso.reseller.dao.stateDao;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.model.contactDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jiasingtan
 */
public class stateDaoImpl implements stateDao {

	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}    
    
    public List<contactDetails> getStateList(){
    String Query = "SELECT T_STATE_ID,STATE_DESCRIPTION,STATE_CD FROM T_STATE";
		
		List<contactDetails> stateList = jdbcTemplate.query(Query, new Object[] { }, new RowMapper<contactDetails>(){
			public contactDetails mapRow(ResultSet rs, int rowNum) throws SQLException{
				contactDetails resultList = new contactDetails();
				resultList.setStateId(rs.getString(1));
                                resultList.setStateDescription(rs.getString(2));
                                resultList.setStateCode(rs.getString(3));
				return resultList;
			}
		});
		return stateList;
    }
    
}
