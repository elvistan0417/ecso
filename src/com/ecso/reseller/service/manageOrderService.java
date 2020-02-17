/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service;

import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.saleOrder;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public interface manageOrderService {
      public int insertOrderTrip(saleOrder saleOrderObject);
      public List<saleOrder> getOrderTripList();
      public int deleteOrderTrip(saleOrder saleOrderObject);
      public int updateOrderTrip(saleOrder saleOrderObject);
      public saleOrder getOrderTrip(saleOrder saleOrderObject);

    public int updateOrderTripCurrentY(saleOrder saleOrderObject);
    public int updateOrderTripCurrentN(saleOrder saleOrderObject);
      
    public String insertContactDetails(contactDetails contactDetailsObject);
    public int updateContactDetails(contactDetails contactDetailsObject);
    public contactDetails getContactDetails(contactDetails contactDetailsObject);
    public int deleteContactDetails(contactDetails contactDetailsObject);
    public List<contactDetails> getContactDetailsList(contactDetails contactDetailsObject);
      public saleOrder getCurrentOrderTrip();
      
      
    public int deleteOrderByOrderTrip(saleOrder saleOrderObject);
    public int deleteItemCategoryByOrderTrip(saleOrder saleOrderObject);
    public int deleteItemByItemCategory(saleOrder saleOrderObject);
    public int deleteItemOptionByItemCategory(saleOrder saleOrderObject);
//    public void displayOverViewSalesOrder(saleOrder salesOrderObject,List<saleOrder> pendingApproveSalesOrderObject,List<saleOrder> processingSalesOrderObject,List<saleOrder> onHoldSalesOrderObject,List<saleOrder> rejectSalesOrderObject);
//    public saleOrder getSalesOrderSummaryByID(saleOrder saleOrderObject);
//    public List<saleOrder> getSalesOrderDetails(saleOrder saleOrderObject);
//    public List<saleOrder> getSavePendingOrderSummaryList(saleOrder saleOrderObject);
//    public List<saleOrder> getSalesOrderSummaryList(saleOrder saleOrderObject);

}
