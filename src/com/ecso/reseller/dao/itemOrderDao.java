/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao;

import com.ecso.reseller.model.saleOrder;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jiasingtan
 */
public interface itemOrderDao {
    /**
     * 
     * @param userID
     * @return pendingItemOrder Without Save or Submit 
     */
    
    public String insertOrder(saleOrder saleOrderObject);
    public int updateOrder(saleOrder saleOrderObject);
    public saleOrder getOrder(saleOrder saleOrderObject);
    public int deleteOrder(saleOrder saleOrderObject);
    public List<saleOrder> getOrderList(saleOrder saleOrderObject);
    public List<saleOrder> getOrderListByPayFlag(saleOrder saleOrderObject);
//    public int updateOrderPayFlag(saleOrder saleOrderObject);
    public List<saleOrder> searchOrderList(saleOrder saleOrderObject);
    public List<saleOrder> searchPaidOrderList(saleOrder saleOrderObject);
     public String insertOrderPaid(saleOrder saleOrderObject);
    public List<saleOrder> getSummaryCustomerUnpay(saleOrder saleOrderObject);
    public List<saleOrder> getSummaryCustomerUnpayByCustomerID(saleOrder saleOrderObject);
    
    public List<saleOrder> getSummaryCustomerPaidByCustomerID(saleOrder saleOrderObject);
    
    public List<saleOrder> getOrderListByCustomerID(saleOrder saleOrderObject);
    public List<saleOrder> getPaidOrderListByCustomerID(saleOrder saleOrderObject);
    public saleOrder getPaidOrder(saleOrder saleOrderTemp);
    public int updatePaidOrder(saleOrder saleOrderObject);
    
    public int deletePaidOrder(saleOrder saleOrderObject);
    public List<saleOrder> getSummaryCustomerPay(saleOrder saleOrderObject);
    public List<saleOrder> getItemCategoryReport(saleOrder saleOrderObject);
     public List<saleOrder> getItemReport(saleOrder saleOrderObject);
     public List<saleOrder> getItemCategoryPriceReport(saleOrder saleOrderObject);
     public List<saleOrder> getSimpleOrderListByCustomerID(saleOrder saleOrderObject);
     public List<saleOrder> getUnPayItemCategoryReport(saleOrder saleOrderTemp);
     public List<saleOrder> getUnPayItemCategoryPriceReport(saleOrder saleOrderObject);
     public List<saleOrder> getUnpayItemReport(saleOrder saleOrderObject);
     
     public int deleteOrderByCustomerID(saleOrder saleOrderObject);
     public int deletePaidOrderByCustomerID(saleOrder saleOrderObject);
    
//    public List<saleOrder> getPendingItemOrderDetailList(String userID,String status);
//    
//    public String insertPendingOrderItem(String userId);
//    
//    public int updatePendingOrderItem(saleOrder saleOrderObject);
//    
//    public int deletePendingOrderItem(saleOrder saleOrderObject);
//    
//    public int insertPendingOrderItemDetail(saleOrder saleOrderObject);
//    
//    public int updatePendingOrderItemDetail(saleOrder saleOrderObject);
//    
//    public int deletePendingOrderItemDetail(saleOrder saleOrderObject);
//    
//    public String getPendingOrderItemDetail(saleOrder saleOrderObject);
//    
//    public int checkPendingOrderItemTable(String userID);
//    
//    public int deletePendingOrderItemDetailExclude(String orderItemId,Set<Integer> itemInCart);
//    
//    public String getPendingOrderItemId(String userId);
////    
//    public int updateTotalChart(saleOrder saleOrderObject);
//    
//    public saleOrder getPendingOrderSummary(String pendingOrderItemId);
//    
//    public double getWeightPrice(double itemTotalWeight,String stateCD);
//    
//    public int updatePendingOrderDeliveryDetails(saleOrder saleOrderObject);
//    
//    public double getTotalWeight(String pendingOrderID);
//    
//    public int updatePendingOrderPaymentSlip(saleOrder saleOrderObject);
//    
//    public int updatePendingOrderSave(saleOrder saleOrderObject);
//    
//    public String insertSubmitOrderItem(saleOrder saleOrderObject);
//    
//    public int insertSubmitOrderItemDetails(saleOrder saleOrderObject);
//    
//    public int deletePendingOrderItemDetailsByPendingOrderID(saleOrder saleOrderObject);
//    
//    
//    public List<saleOrder> getSavePendingOrderDetailsList(saleOrder saleOrderObject);

}
