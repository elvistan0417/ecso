/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao.impl;
import com.ecso.reseller.dao.itemDetailDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.ecso.reseller.model.itemDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
/**
 *
 * @author jiasingtan
 */
public class itemDetailDaoImpl implements itemDetailDao{
    
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
        
   public String insertItemDetail(final itemDetail itemDetailObject){
        final String insertQuery = "Insert into ITEM (item_Number,item_Description,item_Category_ID,item_Price,item_Create_DateTime,item_Update_DateTime) values (?,?,?,?,NOW(),NOW())";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps
                        = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, itemDetailObject.getItemName());
                ps.setString(2, itemDetailObject.getItemDescription());
                ps.setString(3, itemDetailObject.getItemCategoryID());
                ps.setDouble(4, itemDetailObject.getItemPrice());
                return ps;
            }
        },
                keyHolder);
        return keyHolder.getKey().toString();
   };
    
    public List<itemDetail> getItemDetailList(itemDetail itemDetailObject){
        String selectQuery = "select item_ID,item_Number,item_Description,item_Price,item_Create_DateTime,item_Update_DateTime,item_category_id from item where item_category_id = ?";
        try {
            List<itemDetail> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{itemDetailObject.getItemCategoryID()}, new RowMapper<itemDetail>() {
                public itemDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
                    itemDetail resultList = new itemDetail();
                    resultList.setItemDetailID(rs.getString(1));
                    resultList.setItemName(rs.getString(2));
                    resultList.setItemDescription(rs.getString(3));
                    resultList.setItemPrice(rs.getDouble(4));
                    resultList.setCreateDate(rs.getDate(5));
                    resultList.setUpdateDate(rs.getDate(6));
                    resultList.setItemCategoryID(rs.getString(7));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    };
    
    public int deleteItemDetail(itemDetail itemDetailObject){
        String updateQuery = "DELETE FROM ITEM  WHERE item_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemDetailObject.getItemDetailID()});

    };
    public int updateItemDetail(itemDetail itemDetailObject){
        String updateQuery = "UPDATE ITEM SET item_Number = ?,item_Description = ?,item_Price = ? , item_Update_DateTime = NOW()  WHERE item_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemDetailObject.getItemName(),itemDetailObject.getItemDescription(),itemDetailObject.getItemPrice(), itemDetailObject.getItemDetailID()});

    };
    
    public itemDetail getItemDetail(itemDetail itemDetailObject){
        String selectQuery = "select item_ID,item_Number,item_Description,item_Price,item_Create_DateTime,item_Update_DateTime,item_category_id from item where item_ID = ?";
        try {
            itemDetail salesOrderItemSummary = jdbcTemplate.queryForObject(selectQuery, new Object[]{itemDetailObject.getItemDetailID()},
                    new RowMapper<itemDetail>() {
                public itemDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
                    itemDetail resultList = new itemDetail();
                    resultList.setItemDetailID(rs.getString(1));
                    resultList.setItemName(rs.getString(2));
                    resultList.setItemDescription(rs.getString(3));
                    resultList.setItemPrice(rs.getDouble(4));
                    resultList.setCreateDate(rs.getDate(5));
                    resultList.setUpdateDate(rs.getDate(6));
                    resultList.setItemCategoryID(rs.getString(7));
   
                    return resultList;
                }
            });

            return salesOrderItemSummary;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    };
    
}
