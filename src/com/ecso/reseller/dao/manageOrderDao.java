/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao;

import com.ecso.reseller.model.saleOrder;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public interface manageOrderDao {
    
    public int insertOrderTrip(saleOrder saleOrderObject);
    
    public List<saleOrder> getOrderTripList();
    
    public int deleteOrderTrip(saleOrder saleOrderObject);
    public int updateOrderTrip(saleOrder saleOrderObject);
    
    public saleOrder getOrderTrip(saleOrder saleOrderObject);
    
    public int updateOrderTripCurrentY(saleOrder saleOrderObject);
    public int updateOrderTripCurrentN(saleOrder saleOrderObject);
    
    public saleOrder getCurrentOrderTrip();
    
    public int deleteOrderByOrderTrip(saleOrder saleOrderObject);
    public int deleteItemCategoryByOrderTrip(saleOrder saleOrderObject);
    public int deleteItemByItemCategory(saleOrder saleOrderObject);
    public int deleteItemOptionByItemCategory(saleOrder saleOrderObject);
    public int deleteOrderPaidByOrderTrip(saleOrder saleOrderObject);
//    public List<saleOrder> getSalesOrderSummaryList(saleOrder saleOrderObject);
//    public List<saleOrder> getSalesOrderDetails(saleOrder saleOrderObject);
//    
//    public saleOrder getSalesOrderSummaryByID(saleOrder saleOrderObject);
//    
//    public List<saleOrder> getSavePendingOrderSummaryList(saleOrder saleOrderObject);
    
    
    
    
}
