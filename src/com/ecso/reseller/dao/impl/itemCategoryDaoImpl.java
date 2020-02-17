/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao.impl;

import com.ecso.reseller.dao.itemCategoryDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecso.reseller.model.itemCategory;
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
public class itemCategoryDaoImpl implements itemCategoryDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public String insertItemCategory(final itemCategory itemCategoryObject) {
        final String insertQuery = "Insert into ITEM_CATEGORY (item_Category_ID_Name,item_Category_Create_DateTime,item_Category_Update_DateTime,order_Trip_ID) values (?,NOW(),NOW(),?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps
                        = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, itemCategoryObject.getItemCategoryName());
                ps.setString(2, itemCategoryObject.getOrderTripID());
                return ps;
            }
        },
                keyHolder);
        return keyHolder.getKey().toString();

    }

    @Override
    public List<itemCategory> getItemCategoryList() {

        String selectQuery = "select A.item_Category_ID,A.item_Category_ID_Name,A.item_Category_Create_DateTime,A.item_Category_Update_DateTime,A.order_Trip_ID,B.order_Trip_Description FROM ITEM_CATEGORY A LEFT JOIN ORDER_TRIP B ON A.order_Trip_ID = B.order_Trip_ID ORDER BY A.item_Category_Create_DateTime DESC";
        try {
            List<itemCategory> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{}, new RowMapper<itemCategory>() {
                public itemCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
                    itemCategory resultList = new itemCategory();
                    resultList.setItemCategoryID(rs.getString(1));
                    resultList.setItemCategoryName(rs.getString(2));
                    resultList.setItemCategoryCreateDate(rs.getDate(3));
                    resultList.setItemCategoryUpdateDate(rs.getDate(4));
                    resultList.setOrderTripID(rs.getString(5));
                    resultList.setOrderTripDescription(rs.getString(6));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    ;
     
    @Override
    public int deleteItemCategory(itemCategory itemCategoryObject) {
        String updateQuery = "DELETE FROM ITEM_CATEGORY  WHERE item_Category_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemCategoryObject.getItemCategoryID()});
    }

    public int updateItemCategory(itemCategory itemCategoryObject) {
        String updateQuery = "UPDATE ITEM_CATEGORY SET item_Category_ID_Name = ?, item_Category_Update_DateTime = NOW()  WHERE item_Category_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemCategoryObject.getItemCategoryName(), itemCategoryObject.getItemCategoryID()});
    }

    @Override
    public itemCategory getItemCategory(itemCategory itemCategoryObject) {
        String selectQuery = "select A.item_Category_ID,A.item_Category_ID_Name,A.item_Category_Create_DateTime,A.item_Category_Update_DateTime,A.order_Trip_ID,B.order_Trip_Description FROM ITEM_CATEGORY A LEFT JOIN ORDER_TRIP B  ON A.order_Trip_ID = B.order_Trip_ID WHERE A.item_Category_ID = ?";
        try {
            itemCategory salesOrderItemSummary = jdbcTemplate.queryForObject(selectQuery, new Object[]{itemCategoryObject.getItemCategoryID()},
                    new RowMapper<itemCategory>() {
                public itemCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
                    itemCategory resultList = new itemCategory();
                    resultList.setItemCategoryID(rs.getString(1));
                    resultList.setItemCategoryName(rs.getString(2));
                    resultList.setItemCategoryCreateDate(rs.getDate(3));
                    resultList.setItemCategoryUpdateDate(rs.getDate(4));
                    resultList.setOrderTripID(rs.getString(5));
                    resultList.setOrderTripDescription(rs.getString(6));
                    return resultList;
                }
            });

            return salesOrderItemSummary;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<itemCategory> getItemCategoryByOrderId(itemCategory itemCategoryObject) {
        String selectQuery = "select A.item_Category_ID,A.item_Category_ID_Name,A.item_Category_Create_DateTime,A.item_Category_Update_DateTime,A.order_Trip_ID FROM ITEM_CATEGORY A  WHERE A.order_Trip_ID = ?";
        try {
            List<itemCategory> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{itemCategoryObject.getOrderTripID()}, new RowMapper<itemCategory>() {
                public itemCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
                    itemCategory resultList = new itemCategory();
                    resultList.setItemCategoryID(rs.getString(1));
                    resultList.setItemCategoryName(rs.getString(2));
                    resultList.setItemCategoryCreateDate(rs.getDate(3));
                    resultList.setItemCategoryUpdateDate(rs.getDate(4));
                    resultList.setOrderTripID(rs.getString(5));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int insertItemOption(itemCategory itemCategoryObject) {
        String insertQuery = "Insert into ITEM_OPTION (item_Option_Name,item_Category_ID,item_Option_Create_DateTime,item_Option_Update_DateTime) values (?,?,NOW(),NOW())";

        return jdbcTemplate.update(insertQuery,
                new Object[]{itemCategoryObject.getItemOptionName(), itemCategoryObject.getItemCategoryID()});

    }

    @Override
    public List<itemCategory> getItemOptionListByItemCategory(itemCategory itemCategoryObject) {
        String selectQuery = "select item_Option_ID,item_Option_Name, item_Category_ID, item_Option_Create_DateTime, item_Option_Update_DateTime FROM ITEM_OPTION WHERE item_Category_ID = ?";
        try {
            List<itemCategory> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{itemCategoryObject.getItemCategoryID()}, new RowMapper<itemCategory>() {
                public itemCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
                    itemCategory resultList = new itemCategory();
                    resultList.setItemOptionID(rs.getString(1));
                    resultList.setItemOptionName(rs.getString(2));
                    resultList.setItemCategoryID(rs.getString(3));
                    resultList.setItemOptionCreateDate(rs.getDate(4));
                    resultList.setItemOptionUpdateDate(rs.getDate(5));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public int deleteItemOption(itemCategory itemCategoryObject) {
        String updateQuery = "DELETE FROM ITEM_OPTION  WHERE item_Option_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemCategoryObject.getItemOptionID()});
    }

    @Override
    public int updateItemOption(itemCategory itemCategoryObject) {
        String updateQuery = "UPDATE ITEM_OPTION SET item_Option_Name = ?, item_Option_Update_DateTime = NOW()  WHERE item_Option_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemCategoryObject.getItemOptionName(), itemCategoryObject.getItemOptionID()});
    }
    
    public int deleteItemOptionByCategoryID(itemCategory itemCategoryObject){
        String updateQuery = "DELETE FROM ITEM_CATEGORY   WHERE item_Category_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemCategoryObject.getItemCategoryID()});
  
    }
    public int updateItemCategoryOrderTrip(itemCategory itemCategoryObject){
        String updateQuery = "UPDATE ITEM_CATEGORY SET order_Trip_ID = ?  WHERE item_Category_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{itemCategoryObject.getOrderTripID(), itemCategoryObject.getItemCategoryID()});
 
    }


}
