/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service.impl;

import com.ecso.reseller.dao.contactDetailsDao;
import com.ecso.reseller.dao.itemOrderDao;
import com.ecso.reseller.dao.manageOrderDao;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.service.manageOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jiasingtan
 */
public class manageOrderServiceImpl implements manageOrderService {
    
        @Autowired
	manageOrderDao manageOrderDao;    
        @Autowired
	contactDetailsDao contactDetailsDao;  
    @Override
    public int insertOrderTrip(saleOrder saleOrderObject){
        return manageOrderDao.insertOrderTrip(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getOrderTripList(){
        return manageOrderDao.getOrderTripList();
    }
    
    @Override
    public int deleteOrderTrip(saleOrder saleOrderObject){
        return manageOrderDao.deleteOrderTrip(saleOrderObject);
    }
    
    @Override
    public int updateOrderTrip(saleOrder saleOrderObject){
        return manageOrderDao.updateOrderTrip(saleOrderObject);
    }
    
    @Override
    public saleOrder getOrderTrip(saleOrder saleOrderObject){
        return manageOrderDao.getOrderTrip(saleOrderObject);
    }
    
    public int updateOrderTripCurrentY(saleOrder saleOrderObject){
        return manageOrderDao.updateOrderTripCurrentY(saleOrderObject);
    }
    public int updateOrderTripCurrentN(saleOrder saleOrderObject){
        return manageOrderDao.updateOrderTripCurrentN(saleOrderObject);
    }
    
    @Override
    public String insertContactDetails(contactDetails contactDetailsObject){
        return contactDetailsDao.insertContactDetails(contactDetailsObject);
    }
    @Override
    public int updateContactDetails(contactDetails contactDetailsObject){
        return contactDetailsDao.updateContactDetails(contactDetailsObject);
    }
    @Override
    public contactDetails getContactDetails(contactDetails contactDetailsObject){
        return contactDetailsDao.getContactDetails(contactDetailsObject);
    }
    @Override
    public int deleteContactDetails(contactDetails contactDetailsObject){
        return contactDetailsDao.deleteContactDetails(contactDetailsObject);
    }
    @Override
    public List<contactDetails> getContactDetailsList(contactDetails contactDetailsObject){
        return contactDetailsDao.getContactDetailsList(contactDetailsObject);
    }
    
    @Override
    public saleOrder getCurrentOrderTrip(){
        return manageOrderDao.getCurrentOrderTrip();
    }
    
    @Override
    public int deleteOrderByOrderTrip(saleOrder saleOrderObject){
        manageOrderDao.deleteOrderByOrderTrip(saleOrderObject);
        return manageOrderDao.deleteOrderPaidByOrderTrip(saleOrderObject);
    }
    
    @Override
    public int deleteItemCategoryByOrderTrip(saleOrder saleOrderObject){
        return manageOrderDao.deleteItemCategoryByOrderTrip(saleOrderObject);
    }
    
    @Override
    public int deleteItemByItemCategory(saleOrder saleOrderObject){
        return manageOrderDao.deleteItemByItemCategory(saleOrderObject);
    }
    
    @Override
    public int deleteItemOptionByItemCategory(saleOrder saleOrderObject){
        return manageOrderDao.deleteItemOptionByItemCategory(saleOrderObject);
    }
//    @Override
//    public void displayOverViewSalesOrder(saleOrder salesOrderObject,List<saleOrder> pendingApproveSalesOrderObject,List<saleOrder> processingSalesOrderObject,List<saleOrder> onHoldSalesOrderObject,List<saleOrder> rejectSalesOrderObject){
//        List<saleOrder> salesOrderList = manageOrderDao.getSalesOrderSummaryList(salesOrderObject);
//        System.out.println("salesOrderList Size " + salesOrderList.size());
//        for(int i = 0; i < salesOrderList.size();i++){
//            System.out.println("salesOrderList.get(i).getRequestStatus() " + salesOrderList.get(i).getRequestStatus());
//            if("PA".equals(salesOrderList.get(i).getRequestStatus())){
//                pendingApproveSalesOrderObject.add(salesOrderList.get(i));
//            }
//            else if("OH".equals(salesOrderList.get(i).getRequestStatus())){
//                onHoldSalesOrderObject.add(salesOrderList.get(i));
//            }
//            else if("RJ".equals(salesOrderList.get(i).getRequestStatus())){
//                rejectSalesOrderObject.add(salesOrderList.get(i));
//            }
//            else{
//                processingSalesOrderObject.add(salesOrderList.get(i));
//            }
//        }
//        
//        System.out.println("PendingApproveSales Size " + pendingApproveSalesOrderObject.size());
//    }
//    
//    @Override
//    public saleOrder getSalesOrderSummaryByID(saleOrder saleOrderObject){
//        return manageOrderDao.getSalesOrderSummaryByID(saleOrderObject);
//    }
//    
//    @Override
//    public List<saleOrder> getSalesOrderDetails(saleOrder saleOrderObject){
//       
//        
//        return manageOrderDao.getSalesOrderDetails(saleOrderObject);
//    }
//    
//    @Override
//    public List<saleOrder> getSavePendingOrderSummaryList(saleOrder saleOrderObject){
//    
//        return manageOrderDao.getSavePendingOrderSummaryList(saleOrderObject);
//    }
//    
//    @Override
//    public List<saleOrder> getSalesOrderSummaryList(saleOrder saleOrderObject){
//        return manageOrderDao.getSalesOrderSummaryList(saleOrderObject);
//    }
    
}

