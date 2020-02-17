/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao.impl;

import com.ecso.reseller.dao.itemOrderDao;
import com.ecso.reseller.dao.manageOrderDao;
import com.ecso.reseller.model.saleOrder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author jiasingtan
 */
public class manageOrderDaoImpl implements manageOrderDao{
    
	private JdbcTemplate jdbcTemplate;
   
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
             
	}    
            
      @Override
      public int insertOrderTrip(saleOrder saleOrderObject){
        String insertQuery="Insert into ORDER_TRIP (order_Trip_Description,order_Trip_Create_DateTime,order_Trip_Update_DateTime) values (?,NOW(),NOW())";
		
	return jdbcTemplate.update(insertQuery,
            new Object[]{saleOrderObject.getOrderTripDescription()});

      }
      
    @Override
    public List<saleOrder> getOrderTripList(){
        
        String selectQuery = "select order_Trip_ID,order_Trip_Description,order_Trip_Create_DateTime,order_Trip_UPdate_DateTime,current_Trip_Flag from order_trip ORDER BY order_Trip_Create_DateTime DESC";
		try{
			List<saleOrder> orderTripList = jdbcTemplate.query(selectQuery, new Object[] {}, new RowMapper<saleOrder>(){
			public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException{
				saleOrder resultList = new saleOrder();
				resultList.setOrderTripID(rs.getString(1));
                                resultList.setOrderTripDescription(rs.getString(2));
                                resultList.setOrderTripCreatedDate(rs.getDate(3));
                                resultList.setOrderTripUpdatedDate(rs.getDate(4));
                                resultList.setOrderTripCurrentFlag(rs.getString(5));
						return resultList;
					}
				});

		return orderTripList;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
        
    };
     
    @Override
    public int deleteOrderTrip(saleOrder saleOrderObject){
        String updateQuery = "DELETE FROM order_trip  WHERE order_Trip_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderTripID()});
    }
    
    public int updateOrderTrip(saleOrder saleOrderObject){
        String updateQuery = "UPDATE order_trip SET order_Trip_Description = ?, order_Trip_UPdate_DateTime = NOW()  WHERE order_Trip_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderTripDescription(),saleOrderObject.getOrderTripID()});
    }
    
    @Override
    public saleOrder getOrderTrip(saleOrder saleOrderObject){
        String selectQuery = "select order_Trip_ID,order_Trip_Description,order_Trip_Create_DateTime,order_Trip_UPdate_DateTime,current_Trip_Flag from order_trip WHERE order_Trip_ID = ?";
		try{
			saleOrder salesOrderItemSummary  = jdbcTemplate.queryForObject(selectQuery, new Object[] { saleOrderObject.getOrderTripID()},
				new RowMapper<saleOrder>() {
					public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
				saleOrder resultList = new saleOrder();
				resultList.setOrderTripID(rs.getString(1));
                                resultList.setOrderTripDescription(rs.getString(2));
                                resultList.setOrderTripCreatedDate(rs.getDate(3));
                                resultList.setOrderTripUpdatedDate(rs.getDate(4)); 
                                resultList.setOrderTripCurrentFlag(rs.getString(5));
						return resultList;
					}
				});

		return salesOrderItemSummary;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
    }
    @Override
    public int updateOrderTripCurrentY(saleOrder saleOrderObject){
        String updateQuery = "UPDATE order_trip SET current_Trip_Flag = 'Y', order_Trip_UPdate_DateTime = NOW()  WHERE order_Trip_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderTripID()});
    }
    @Override
    public int updateOrderTripCurrentN(saleOrder saleOrderObject){
        String updateQuery = "UPDATE order_trip SET current_Trip_Flag = 'N', order_Trip_UPdate_DateTime = NOW()  WHERE order_Trip_ID != ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderTripID()});
    }
    
    
    @Override
    public saleOrder getCurrentOrderTrip(){
        String selectQuery = "select order_Trip_ID,order_Trip_Description,order_Trip_Create_DateTime,order_Trip_UPdate_DateTime,current_Trip_Flag from order_trip WHERE current_Trip_Flag = 'Y'";
		try{
			saleOrder salesOrderItemSummary  = jdbcTemplate.queryForObject(selectQuery, new Object[] { },
				new RowMapper<saleOrder>() {
					public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
				saleOrder resultList = new saleOrder();
				resultList.setOrderTripID(rs.getString(1));
                                resultList.setOrderTripDescription(rs.getString(2));
                                resultList.setOrderTripCreatedDate(rs.getDate(3));
                                resultList.setOrderTripUpdatedDate(rs.getDate(4)); 
                                resultList.setOrderTripCurrentFlag(rs.getString(5));
						return resultList;
					}
				});

		return salesOrderItemSummary;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
    }
    
    @Override
    public int deleteOrderByOrderTrip(saleOrder saleOrderObject){
        String updateQuery = "DELETE FROM ORDER_DETAIL  WHERE order_Trip_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderTripID()});
        
        
    }

        @Override
    public int deleteOrderPaidByOrderTrip(saleOrder saleOrderObject){
        String updateQuery = "DELETE FROM ORDER_DETAIL_PAID  WHERE order_Trip_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderTripID()});
        
        
    }
    
    public int deleteItemCategoryByOrderTrip(saleOrder saleOrderObject){
       String updateQuery = "DELETE FROM ITEM_CATEGORY  WHERE order_Trip_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getOrderTripID()});

    }
    public int deleteItemByItemCategory(saleOrder saleOrderObject){
       String updateQuery = "DELETE FROM ITEM  WHERE ITEM_CATEGORY_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getItemCategory()});

    }
    public int deleteItemOptionByItemCategory(saleOrder saleOrderObject){
       String updateQuery = "DELETE FROM ITEM_OPTION  WHERE ITEM_CATEGORY_ID = ?";
        
        return jdbcTemplate.update(updateQuery, new Object[]{saleOrderObject.getItemCategory()});

    }
//    @Override
//    public List<saleOrder> getSalesOrderSummaryList(saleOrder saleOrderObject){
//        
//        String selectQuery = "SELECT T_SALES_ORDER_ID,T_USER_DTL_ID,ORDER_DT,REQUEST_STS,PAYSLIP,TOTAL_PRICE,VERSION,CREATE_BY,TOTAL_ITEM_PRICE,TOTAL_ITEM_WEIGHT_PRICE,TOTAL_ITEM_WEIGHT,T_DELIVERY_DETAILS_ID FROM T_SALES_ORDER WHERE T_USER_DTL_ID = ? ORDER BY ORDER_DT DESC";
//		try{
//			List<saleOrder> salesOrderItemSummaryList = jdbcTemplate.query(selectQuery, new Object[] { saleOrderObject.getUserOrderDetailID()}, new RowMapper<saleOrder>(){
//			public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException{
//				saleOrder resultList = new saleOrder();
//				resultList.setSaleOrderID(rs.getString(1));
//                                resultList.setUserOrderDetailID(rs.getString(2));
//                                resultList.setOrderDate(rs.getDate(3));
//                                resultList.setRequestStatus(rs.getString(4));
//                                resultList.setPaymentSlip(rs.getString(5));
//                                resultList.setTotalPrice(rs.getDouble(6));
//                                resultList.setVersion(rs.getString(7));
//                                resultList.setCreateBy(rs.getString(8));
//                                resultList.setItemTotalPrice(rs.getDouble(9));
//                                resultList.setItemTotalWeightPrice(rs.getDouble(10));
//                                resultList.setItemTotalWeight(rs.getDouble(11));
//                                resultList.setItemDeliveryDetailsID(rs.getString(12));
//						return resultList;
//					}
//				});
//
//		return salesOrderItemSummaryList;
//		}catch(EmptyResultDataAccessException e){
//			return null;
//		}
//        
//    };
//    
//    @Override
//    public List<saleOrder> getSalesOrderDetails(saleOrder saleOrderObject){
//        String Query = "SELECT A.T_ITEM_DTL_ID,A.NUMBER_ORDER,A.VERSION,B.NAME,B.PRICE,B.PICTURE,B.ITEM_WEIGHT_KG from t_sales_order_detail A INNER JOIN T_ITEM_DTL B ON A.T_ITEM_DTL_ID = B.T_ITEM_DTL_ID where A.T_SALES_ORDER_ID = ?";
//		
//		List<saleOrder> salesOrderItemList = jdbcTemplate.query(Query, new Object[] { saleOrderObject.getSaleOrderID()}, new RowMapper<saleOrder>(){
//			public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException{
//				saleOrder resultList = new saleOrder();
//				
//                                resultList.setItemDetailID(rs.getString(1));
//                                resultList.setNumberOfOder(rs.getString(2));
//                                resultList.setVersion(rs.getString(3));
//                                resultList.setItemName(rs.getString(4));
//                                resultList.setItemPrice(rs.getDouble(5));
//                                resultList.setItemPicture(rs.getString(6));
//                                resultList.setItemWeight(rs.getString(7));
//				return resultList;
//			}
//		});
//		return salesOrderItemList;
//    };
//    
//    @Override
//    public saleOrder getSalesOrderSummaryByID(saleOrder saleOrderObject){
//        String selectQuery = "SELECT T_SALES_ORDER_ID,T_USER_DTL_ID,ORDER_DT,REQUEST_STS,PAYSLIP,TOTAL_PRICE,VERSION,CREATE_BY,TOTAL_ITEM_PRICE,TOTAL_ITEM_WEIGHT_PRICE,TOTAL_ITEM_WEIGHT,T_DELIVERY_DETAILS_ID FROM T_SALES_ORDER WHERE T_SALES_ORDER_ID = ?";
//		try{
//			saleOrder salesOrderItemSummary  = jdbcTemplate.queryForObject(selectQuery, new Object[] { saleOrderObject.getSaleOrderID() },
//				new RowMapper<saleOrder>() {
//					public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
//						saleOrder resultList = new saleOrder();
//						resultList.setSaleOrderID(rs.getString(1));
//                                resultList.setUserOrderDetailID(rs.getString(2));
//                                resultList.setOrderDate(rs.getDate(3));
//                                resultList.setRequestStatus(rs.getString(4));
//                                resultList.setPaymentSlip(rs.getString(5));
//                                resultList.setTotalPrice(rs.getDouble(6));
//                                resultList.setVersion(rs.getString(7));
//                                resultList.setCreateBy(rs.getString(8));
//                                resultList.setItemTotalPrice(rs.getDouble(9));
//                                resultList.setItemTotalWeightPrice(rs.getDouble(10));
//                                resultList.setItemTotalWeight(rs.getDouble(11));
//                                resultList.setItemDeliveryDetailsID(rs.getString(12)); 
//						return resultList;
//					}
//				});
//
//		return salesOrderItemSummary;
//		}catch(EmptyResultDataAccessException e){
//			return null;
//		}
//    }
//    
//    @Override
//    public List<saleOrder> getSavePendingOrderSummaryList(saleOrder saleOrderObject){
// String selectQuery = "select T_PENDING_ORDER_ID,T_USER_DTL_ID,ORDER_DT,PAYMENT_SLIP,TOTAL_ITEM_PRICE,TOTAL_ITEM_WEIGHT_PRICE,TOTAL_ITEM_WEIGHT,TOTAL_PRICE,T_DELIVERY_DETAILS_ID from T_PENDING_ORDER WHERE REQUEST_STS = 'S' AND T_USER_DTL_ID = ? ORDER BY ORDER_DT DESC";
//		try{
//			List<saleOrder> salesOrderItemSummaryList = jdbcTemplate.query(selectQuery, new Object[] { saleOrderObject.getUserOrderDetailID()}, new RowMapper<saleOrder>(){
//			public saleOrder mapRow(ResultSet rs, int rowNum) throws SQLException{
//				saleOrder resultList = new saleOrder();
//				resultList.setPendingOrderID(rs.getString(1));
//                                resultList.setUserOrderDetailID(rs.getString(2));
//                                resultList.setOrderDate(rs.getDate(3));
//                                resultList.setPaymentSlip(rs.getString(4));
//                                resultList.setItemTotalPrice(rs.getDouble(5));
//                                resultList.setItemTotalWeightPrice(rs.getDouble(6));
//                                resultList.setItemTotalWeight(rs.getDouble(7));
//                                resultList.setTotalPrice(rs.getDouble(8));
//                                resultList.setItemDeliveryDetailsID(rs.getString(9));
//				return resultList;
//					}
//				});
//
//		return salesOrderItemSummaryList;
//		}catch(EmptyResultDataAccessException e){
//			return null;
//		}
//    }
}
