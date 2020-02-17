/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao.impl;

import com.ecso.reseller.dao.itemOrderDao;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.itemDetail;
import com.ecso.reseller.model.saleOrder;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author jiasingtan
 */
public class itemOrderDaoImpl implements itemOrderDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public String insertOrder(final saleOrder saleOrderObject) {
        final String insertQuery = "Insert into ORDER_DETAIL (CUSTOMER_ID,ITEM_ID,ORDER_TRIP_ID,ITEM_OPTION_ID,ITEM_OTHER_OPTION,ITEM_QUANTITY,ITEM_PRICE,ITEM_PRICE_EDIT_FLAG,ITEM_REMARKS,ORDER_DETAIL_CREATE_DATETIME,ORDER_DETAIL_UPDATE_DATETIME,item_total_amount,item_category_ID) values (?,?,?,?,?,?,?,?,?,NOW(),NOW(),?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps
                        = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, saleOrderObject.getCustomerID());
                ps.setString(2, saleOrderObject.getItemID());
                ps.setString(3, saleOrderObject.getOrderTripID());
                ps.setString(4, saleOrderObject.getItemOptionID());
                ps.setString(5, saleOrderObject.getItemOtherOption());
                ps.setInt(6, saleOrderObject.getItemQuantity());
                ps.setDouble(7, saleOrderObject.getItemPrice());
                ps.setString(8, saleOrderObject.getItemPriceEditFlag());
                ps.setString(9, saleOrderObject.getItemRemarks());
                ps.setDouble(10, saleOrderObject.getItemTotalPrice());
                ps.setString(11, saleOrderObject.getItemCategory());
                return ps;
            }
        },
                keyHolder);
        return keyHolder.getKey().toString();
    }

    @Override
    public int updateOrder(saleOrder saleOrderObject) {
        String updateQuery = "UPDATE ORDER_DETAIL SET CUSTOMER_ID = ?,ITEM_ID = ?, ORDER_TRIP_ID = ?, ITEM_OPTION_ID = ?, ITEM_OTHER_OPTION = ?, ITEM_QUANTITY = ?,ITEM_PRICE = ?,ITEM_PRICE_EDIT_FLAG = ?,ITEM_REMARKS = ?,ORDER_DETAIL_UPDATE_DATETIME = now(),item_Total_Amount = ?,item_Category_ID = ? WHERE ORDER_DETAIL_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getCustomerID(), saleOrderObject.getItemID(), saleOrderObject.getOrderTripID(), saleOrderObject.getItemOptionID(), saleOrderObject.getItemOtherOption(), saleOrderObject.getItemQuantity(), saleOrderObject.getItemPrice(), saleOrderObject.getItemPriceEditFlag(), saleOrderObject.getItemRemarks(), saleOrderObject.getTotalPrice(), saleOrderObject.getItemCategory(), saleOrderObject.getOrderDetailID()});

    }

    @Override
    public saleOrder getOrder(saleOrder saleOrderTemp) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description,OD.item_Category_ID FROM ORDER_DETAIL OD LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID WHERE OD.ORDER_DETAIL_ID = ?";

        try {
            saleOrder saleOrderObject = jdbcTemplate.queryForObject(selectQuery, new Object[]{saleOrderTemp.getSaleOrderID()},
                    new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setCustomerName(rs.getString(14));
                    resultList.setItemOptionName(rs.getString(15));
                    resultList.setItemCode(rs.getString(16));
                    resultList.setItemDescription(rs.getString(17));
                    resultList.setItemCategory(rs.getString(18));
                    return resultList;
                }
            });

            return saleOrderObject;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteOrder(saleOrder saleOrderObject) {
        String updateQuery = "delete from ORDER_DETAIL WHERE ORDER_DETAIL_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderDetailID()});

    }

    @Override
    public List<saleOrder> getOrderList(saleOrder saleOrderObject) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description FROM ORDER_DETAIL OD  LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID ORDER BY OD.ORDER_DETAIL_CREATE_DATETIME DESC";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getOrderListByPayFlag(saleOrder saleOrderObject) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description FROM ORDER_DETAIL OD  LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID ORDER BY OD.ORDER_DETAIL_CREATE_DATETIME DESC";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setCustomerName(rs.getString(14));
                    resultList.setItemOptionName(rs.getString(15));
                    resultList.setItemCode(rs.getString(16));
                    resultList.setItemDescription(rs.getString(17));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

//        @Override
//        public int updateOrderPayFlag(saleOrder saleOrderObject){
//       String updateQuery = "UPDATE ORDER_DETAIL SET order_is_pay = 'Y',ORDER_DETAIL_UPDATE_DATETIME = now() WHERE ORDER_DETAIL_ID = ?";
//        
//       return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderDetailID()});
//
//            }
    @Override
    public String insertOrderPaid(final saleOrder saleOrderObject) {
        final String insertQuery = "Insert into ORDER_DETAIL_PAID (CUSTOMER_ID,ITEM_ID,ORDER_TRIP_ID,ITEM_OPTION_ID,ITEM_OTHER_OPTION,ITEM_QUANTITY,ITEM_PRICE,ITEM_PRICE_EDIT_FLAG,ITEM_REMARKS,ORDER_DETAIL_CREATE_DATETIME,ORDER_DETAIL_UPDATE_DATETIME,ORDER_DETAIL_ID,item_total_amount,item_category_id) values (?,?,?,?,?,?,?,?,?,NOW(),NOW(),?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps
                        = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, saleOrderObject.getCustomerID());
                ps.setString(2, saleOrderObject.getItemID());
                ps.setString(3, saleOrderObject.getOrderTripID());
                ps.setString(4, saleOrderObject.getItemOptionID());
                ps.setString(5, saleOrderObject.getItemOtherOption());
                ps.setInt(6, saleOrderObject.getItemQuantity());
                ps.setDouble(7, saleOrderObject.getItemPrice());
                ps.setString(8, saleOrderObject.getItemPriceEditFlag());
                ps.setString(9, saleOrderObject.getItemRemarks());
                ps.setString(10, saleOrderObject.getOrderDetailID());
                ps.setDouble(11, saleOrderObject.getTotalPrice());
                ps.setString(12, saleOrderObject.getItemCategory());
                return ps;
            }
        },
                keyHolder);
        return keyHolder.getKey().toString();
    }

    @Override
    public List<saleOrder> searchOrderList(saleOrder saleOrderObject) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description FROM ORDER_DETAIL OD  LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID WHERE OD.CUSTOMER_ID LIKE ? AND OD.ORDER_TRIP_ID LIKE ? AND OD.ITEM_CATEGORY_ID LIKE ? AND OD.ITEM_ID LIKE ? AND OD.ITEM_OPTION_ID LIKE ? ORDER BY OD.ORDER_DETAIL_CREATE_DATETIME DESC";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getCustomerID(), saleOrderObject.getOrderTripID(), saleOrderObject.getItemCategory(), saleOrderObject.getItemID(), saleOrderObject.getItemOptionID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setCustomerName(rs.getString(14));
                    resultList.setItemOptionName(rs.getString(15));
                    resultList.setItemCode(rs.getString(16));
                    resultList.setItemDescription(rs.getString(17));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> searchPaidOrderList(saleOrder saleOrderObject) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description FROM ORDER_DETAIL_PAID OD  LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID WHERE OD.CUSTOMER_ID LIKE ? AND OD.ORDER_TRIP_ID LIKE ? AND OD.ITEM_CATEGORY_ID LIKE ? AND OD.ITEM_ID LIKE ? AND OD.ITEM_OPTION_ID LIKE ? ORDER BY OD.ORDER_DETAIL_CREATE_DATETIME DESC";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getCustomerID(), saleOrderObject.getOrderTripID(), saleOrderObject.getItemCategory(), saleOrderObject.getItemID(), saleOrderObject.getItemOptionID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setCustomerName(rs.getString(14));
                    resultList.setItemOptionName(rs.getString(15));
                    resultList.setItemCode(rs.getString(16));
                    resultList.setItemDescription(rs.getString(17));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getSummaryCustomerUnpay(saleOrder saleOrderObject) {
        String selectQuery = "select SUM(od.item_quantity),SUM(od.item_total_amount), od.customer_id,c.customer_name from order_detail od LEFT JOIN customer c on od.customer_id = c.customer_id where order_trip_id = ? group by customer_id";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setTotalOrderItemQuantity(rs.getInt(1));
                    resultList.setTotalOrderItemPrice(rs.getDouble(2));
                    resultList.setCustomerID(rs.getString(3));
                    resultList.setCustomerName(rs.getString(4));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getSummaryCustomerPay(saleOrder saleOrderObject) {
        String selectQuery = "select SUM(od.item_quantity),SUM(od.item_total_amount), od.customer_id,c.customer_name from order_detail_paid od LEFT JOIN customer c on od.customer_id = c.customer_id where order_trip_id = ? group by customer_id";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setTotalOrderItemQuantity(rs.getInt(1));
                    resultList.setTotalOrderItemPrice(rs.getDouble(2));
                    resultList.setCustomerID(rs.getString(3));
                    resultList.setCustomerName(rs.getString(4));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getSummaryCustomerUnpayByCustomerID(saleOrder saleOrderObject) {
        String selectQuery = "select SUM(od.item_quantity),SUM(od.item_total_amount), od.customer_id,c.customer_name from order_detail od LEFT JOIN customer c on od.customer_id = c.customer_id where od.order_trip_id = ? and c.customer_id = ? group by customer_id";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getOrderTripID(), saleOrderObject.getCustomerID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setTotalOrderItemQuantity(rs.getInt(1));
                    resultList.setTotalOrderItemPrice(rs.getDouble(2));
                    resultList.setCustomerID(rs.getString(3));
                    resultList.setCustomerName(rs.getString(4));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getSummaryCustomerPaidByCustomerID(saleOrder saleOrderObject) {
        String selectQuery = "select SUM(od.item_quantity),SUM(od.item_total_amount), od.customer_id,c.customer_name from order_detail_paid od LEFT JOIN customer c on od.customer_id = c.customer_id where od.order_trip_id = ? and c.customer_id = ? group by customer_id";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getOrderTripID(), saleOrderObject.getCustomerID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setTotalOrderItemQuantity(rs.getInt(1));
                    resultList.setTotalOrderItemPrice(rs.getDouble(2));
                    resultList.setCustomerID(rs.getString(3));
                    resultList.setCustomerName(rs.getString(4));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

   @Override
    public List<saleOrder> getSimpleOrderListByCustomerID(saleOrder saleOrderObject) {
        String selectQuery = "select ORDER_DETAIL_ID,CUSTOMER_ID,ITEM_ID,ORDER_TRIP_ID,ITEM_OPTION_ID,ITEM_OTHER_OPTION,ITEM_QUANTITY,ITEM_PRICE,ITEM_PRICE_EDIT_FLAG,ORDER_DETAIL_CREATE_DATETIME,ORDER_DETAIL_UPDATE_DATETIME,ITEM_REMARKS,item_Total_Amount,ITEM_CATEGORY_ID FROM ORDER_DETAIL  WHERE CUSTOMER_ID = ? AND ORDER_TRIP_ID = ? ORDER BY ORDER_DETAIL_CREATE_DATETIME DESC";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getCustomerID(), saleOrderObject.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setItemCategory(rs.getString(14));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public List<saleOrder> getOrderListByCustomerID(saleOrder saleOrderObject) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description,OD.ITEM_CATEGORY_ID FROM ORDER_DETAIL OD  LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID WHERE C.CUSTOMER_ID = ? AND OD.ORDER_TRIP_ID = ? ORDER BY OD.ORDER_DETAIL_CREATE_DATETIME DESC";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getCustomerID(), saleOrderObject.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setCustomerName(rs.getString(14));
                    resultList.setItemOptionName(rs.getString(15));
                    resultList.setItemCode(rs.getString(16));
                    resultList.setItemDescription(rs.getString(17));
                    resultList.setItemCategory(rs.getString(18));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getPaidOrderListByCustomerID(saleOrder saleOrderObject) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description,OD.ITEM_CATEGORY_ID FROM ORDER_DETAIL_PAID OD  LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID WHERE C.CUSTOMER_ID = ? AND OD.ORDER_TRIP_ID = ? ORDER BY OD.ORDER_DETAIL_CREATE_DATETIME DESC";
        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getCustomerID(), saleOrderObject.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setCustomerName(rs.getString(14));
                    resultList.setItemOptionName(rs.getString(15));
                    resultList.setItemCode(rs.getString(16));
                    resultList.setItemDescription(rs.getString(17));
                    resultList.setItemCategory(rs.getString(18));
                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public saleOrder getPaidOrder(saleOrder saleOrderTemp) {
        String selectQuery = "select OD.ORDER_DETAIL_ID,OD.CUSTOMER_ID,OD.ITEM_ID,OD.ORDER_TRIP_ID,OD.ITEM_OPTION_ID,OD.ITEM_OTHER_OPTION,OD.ITEM_QUANTITY,OD.ITEM_PRICE,OD.ITEM_PRICE_EDIT_FLAG,OD.ORDER_DETAIL_CREATE_DATETIME,OD.ORDER_DETAIL_UPDATE_DATETIME,OD.ITEM_REMARKS,OD.item_Total_Amount,C.customer_Name,IFNULL(IOP.item_Option_Name,'Other Option'),IT.item_Number,IT.item_Description,OD.item_Category_ID FROM ORDER_DETAIL_PAID OD  LEFT JOIN CUSTOMER C ON OD.customer_ID = C.customer_ID LEFT JOIN ITEM_OPTION IOP ON OD.item_Option_ID = IOP.item_Option_ID LEFT JOIN ITEM IT ON OD.ITEM_ID = IT.ITEM_ID WHERE OD.ORDER_DETAIL_ID = ?";

        try {
            saleOrder saleOrderObject = jdbcTemplate.queryForObject(selectQuery, new Object[]{saleOrderTemp.getSaleOrderID()},
                    new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setOrderDetailID(rs.getString(1));
                    resultList.setCustomerID(rs.getString(2));
                    resultList.setItemID(rs.getString(3));
                    resultList.setOrderTripID(rs.getString(4));
                    resultList.setItemOptionID(rs.getString(5));
                    resultList.setItemOtherOption(rs.getString(6));
                    resultList.setItemQuantity(rs.getInt(7));
                    resultList.setItemPrice(rs.getDouble(8));
                    resultList.setItemPriceEditFlag(rs.getString(9));
                    resultList.setOrderDetailCreateDateTime(rs.getDate(10));
                    resultList.setOrderDetailUpdateDateTime(rs.getDate(11));
                    resultList.setItemRemarks(rs.getString(12));
                    resultList.setTotalPrice(rs.getDouble(13));
                    resultList.setCustomerName(rs.getString(14));
                    resultList.setItemOptionName(rs.getString(15));
                    resultList.setItemCode(rs.getString(16));
                    resultList.setItemDescription(rs.getString(17));
                    resultList.setItemCategory(rs.getString(18));
                    return resultList;
                }
            });

            return saleOrderObject;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int updatePaidOrder(saleOrder saleOrderObject) {
        String updateQuery = "UPDATE ORDER_DETAIL_PAID SET CUSTOMER_ID = ?,ITEM_ID = ?, ORDER_TRIP_ID = ?, ITEM_OPTION_ID = ?, ITEM_OTHER_OPTION = ?, ITEM_QUANTITY = ?,ITEM_PRICE = ?,ITEM_PRICE_EDIT_FLAG = ?,ITEM_REMARKS = ?,ORDER_DETAIL_UPDATE_DATETIME = now(),item_Total_Amount = ?,item_Category_ID = ? WHERE ORDER_DETAIL_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getCustomerID(), saleOrderObject.getItemID(), saleOrderObject.getOrderTripID(), saleOrderObject.getItemOptionID(), saleOrderObject.getItemOtherOption(), saleOrderObject.getItemQuantity(), saleOrderObject.getItemPrice(), saleOrderObject.getItemPriceEditFlag(), saleOrderObject.getItemRemarks(), saleOrderObject.getTotalPrice(), saleOrderObject.getItemCategory(), saleOrderObject.getOrderDetailID()});

    }

    @Override
    public int deletePaidOrder(saleOrder saleOrderObject) {
        String updateQuery = "delete from ORDER_DETAIL_PAID WHERE ORDER_DETAIL_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderDetailID()});
    }

    @Override
    public List<saleOrder> getItemCategoryReport(saleOrder saleOrderTemp) {
        String selectQuery = "select a.item_category_id,sum(a.item_Quantity),b.item_Category_ID_Name from (SELECT item_category_id ,item_Quantity,order_trip_id FROM ORDER_DETAIL UNION ALL SELECT item_category_id ,item_Quantity,order_trip_id FROM ORDER_DETAIL_PAID  )  a left join ITEM_CATEGORY b  on a.item_category_id = b.item_category_id  WHERE a.order_trip_id = ? group by item_category_id";

        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderTemp.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setItemCategory(rs.getString(1));
                    resultList.setItemQuantity(rs.getInt(2));
                    resultList.setItemCategoryName(rs.getString(3));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getUnPayItemCategoryReport(saleOrder saleOrderTemp) {
        String selectQuery = "select a.item_category_id,sum(a.item_Quantity),b.item_Category_ID_Name from ORDER_DETAIL  a left join ITEM_CATEGORY b  on a.item_category_id = b.item_category_id  WHERE a.order_trip_id = ? group by item_category_id";

        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderTemp.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setItemCategory(rs.getString(1));
                    resultList.setItemQuantity(rs.getInt(2));
                    resultList.setItemCategoryName(rs.getString(3));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }    
    
   @Override
    public List<saleOrder> getItemReport(saleOrder saleOrderTemp) {
        String selectQuery = "select a.item_id, sum(a.item_Quantity),b.item_Number,b.item_description from (SELECT item_id,item_Quantity,item_Category_ID FROM ORDER_DETAIL_PAID UNION ALL SELECT item_id,item_Quantity,item_Category_ID FROM ORDER_DETAIL) a left join item b on a.item_ID = b.item_id where a.item_Category_ID = ? group by a.item_ID";

        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderTemp.getItemCategory()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setItemID(rs.getString(1));
                    resultList.setItemQuantity(rs.getInt(2));
                    resultList.setItemName(rs.getString(3));
                    resultList.setItemDescription(rs.getString(4));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public List<saleOrder> getItemCategoryPriceReport(saleOrder saleOrderObject){
        String selectQuery = "select a.item_category_id,sum(a.item_Total_Amount),b.item_Category_ID_Name from (SELECT item_category_id,item_Total_Amount,order_trip_id FROM ORDER_DETAIL_PAID UNION ALL SELECT item_category_id,item_Total_Amount,order_trip_id FROM ORDER_DETAIL) a left join ITEM_CATEGORY b  on a.item_category_id = b.item_category_id  WHERE a.order_trip_id = ? group by item_category_id";

        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setItemCategory(rs.getString(1));
                    resultList.setTotalPrice(rs.getDouble(2));
                    resultList.setItemCategoryName(rs.getString(3));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<saleOrder> getUnPayItemCategoryPriceReport(saleOrder saleOrderObject){
        String selectQuery = "select a.item_category_id,sum(a.item_Total_Amount),b.item_Category_ID_Name from ORDER_DETAIL  a left join ITEM_CATEGORY b  on a.item_category_id = b.item_category_id  WHERE a.order_trip_id = ? group by item_category_id";

        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderObject.getOrderTripID()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setItemCategory(rs.getString(1));
                    resultList.setTotalPrice(rs.getDouble(2));
                    resultList.setItemCategoryName(rs.getString(3));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public List<saleOrder> getUnpayItemReport(saleOrder saleOrderTemp){
        String selectQuery = "select a.item_id, sum(a.item_Quantity),b.item_Number,b.item_description from ORDER_DETAIL a left join item b on a.item_ID = b.item_id where a.item_Category_ID = ? group by a.item_ID";

        try {
            List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[]{saleOrderTemp.getItemCategory()}, new RowMapper<saleOrder>() {
                public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                    saleOrder resultList = new saleOrder();
                    resultList.setItemID(rs.getString(1));
                    resultList.setItemQuantity(rs.getInt(2));
                    resultList.setItemName(rs.getString(3));
                    resultList.setItemDescription(rs.getString(3));

                    return resultList;
                }
            });

            return orderTripList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
     public int deleteOrderByCustomerID(saleOrder saleOrderObject){
       String updateQuery = "delete from ORDER_DETAIL WHERE CUSTOMER_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getCustomerID()});
     }
     public int deletePaidOrderByCustomerID(saleOrder saleOrderObject){
        String updateQuery = "delete from ORDER_DETAIL_PAID WHERE CUSTOMER_ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getCustomerID()});
     }
}
