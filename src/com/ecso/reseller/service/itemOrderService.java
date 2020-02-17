/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service;

import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.model.saleOrderForm;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public interface itemOrderService {
    
    
    public String insertOrder(saleOrder saleOrderObject);
    public int updateOrder(saleOrder saleOrderObject);
    public saleOrder getOrder(saleOrder saleOrderObject);
    public int deleteOrder(saleOrder saleOrderObject);
    public List<saleOrder> getOrderList(saleOrder saleOrderObject);
    
    public String insertOrderService(saleOrder saleOrderObject);
    public List<saleOrder> getOrderListByPayFlag(saleOrder saleOrderObject);
    public String insertOrderPaid(final saleOrder saleOrderObject);
    public List<saleOrder> searchOrderList(saleOrder saleOrderObject);
    public List<saleOrder> searchPaidOrderList(saleOrder saleOrderObject);
    public List<saleOrder> getSummaryCustomerUnpay(saleOrder saleOrderObject);
    public List<saleOrder> getSummaryCustomerUnpayByCustomerID(saleOrder saleOrderObject);
    public List<saleOrder> getSummaryCustomerPaidByCustomerID(saleOrder saleOrderObject);
    public List<saleOrder> getOrderListByCustomerID(saleOrder saleOrderObject);
    public List<saleOrder> getPaidOrderListByCustomerID(saleOrder saleOrderObject);
    public saleOrder getPaidOrder(saleOrder saleOrderTemp);
    public int updatePaidOrder(saleOrder saleOrderObject);
    public int deletePaidOrder(saleOrder saleOrderObject);
    public List<saleOrder> getSummaryCustomerPay(saleOrder saleOrderObject);
    public List<saleOrder> getItemCategoryReport(saleOrder saleOrderTemp);
    public List<saleOrder> getItemReport(saleOrder saleOrderObject);
    public List<saleOrder> getItemCategoryPriceReport(saleOrder saleOrderObject);
    public List<saleOrder> getSimpleOrderListByCustomerID(saleOrder saleOrderObject);
    public Document downloadPDF(contactDetails contactObject, final List<saleOrder> reportObjectList, String filename, saleOrder saleOrder);
    public List<saleOrder> getUnPayItemCategoryPriceReport(saleOrder saleOrderObject);
    public List<saleOrder> getUnPayItemCategoryReport(saleOrder saleOrderObject);
    public List<saleOrder> getUnPayItemReport(saleOrder saleOrderObject);
    
     public int deleteOrderByCustomerID(saleOrder saleOrderObject);
     public int deletePaidOrderByCustomerID(saleOrder saleOrderObject);
//    public int updateOrderPayFlag(saleOrder saleOrderObject);
    
//    public List<saleOrder> getPendingOrderItemList(String userID,String status);
//
//    public int insertPendingOrderItem(saleOrder saleOrderObject);
//    
//    public void handleCart(List<saleOrder> saleOrderObject,String userID);
//    
//    public saleOrder updateChartSummary(List<saleOrder> pendingOrderSaleList,String userId);
//    
//    public void updateItemOrderNumber(List<saleOrder> orderList);
//    
//    public saleOrder updateDeliveryDetails(saleOrderForm saleOrderFormObject,String userID);
//    
//    public contactDetails getContactDetails(String contactDetailsID);
//    
//    public void updatePaymentSlip(saleOrderForm saleOrderFormObject);
//    
//    public int updatePendingOrderSave(saleOrder saleOrderObject);
//    
//    public void insertSalesOrder(saleOrder saleOrderObject);
//    
//    public List<saleOrder> getSavePendingOrderDetailsList(saleOrder saleOrderObject);
//    
//    public saleOrder getPendingOrderSummary(String pendingOrderItemId);
//    
//    public saleOrder updateSaveChartSummary(List<saleOrder> pendingOrderSaleList,String userId);
}
