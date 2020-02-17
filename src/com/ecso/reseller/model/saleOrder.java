/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public class saleOrder {
    private String pendingOrderID;
    private String orderID;
    private String userOrderDetailID;
    private Date orderDate;
    private String requestStatus;
    private double totalPrice;
    private String pendingDate;
    private String version;
    private String createBy;
    private String createDate;
    private String updateBy;
    private String updateDate;
    private String paymentSlip;
    private String pendingOrderDetailID;
    private String itemDetailID;
    private String itemName;
    private double itemPrice;
    private String numberOfOder;
    private String itemDescription;
    private String itemPicture;
    private String itemWeight;
    private double itemTotalPrice;
    private double itemTotalWeight;
    private double itemTotalWeightPrice;
    private String itemDeliveryDetailsID;
    private int itemQuantity1;
    private double itemPrice1;
    private int itemQuantity2;
    private double itemPrice2;
    
    
    private String saleOrderID;
    
    private String orderTripDescription;
    private String orderTripID;
    
    private Date orderTripCreatedDate;
    private Date orderTripUpdatedDate;
    
    
    private String orderDetailID;
    private String customerID;
    private String itemID;
    private String orderDetailQuantity;
    private Date orderDetailCreateDateTime;
    private Date orderDetailUpdateDateTime;
    private String itemOptionID;
    private String itemOtherOption;
    private int itemQuantity;
    private String itemPriceEditFlag;
    private String itemRemarks;
    private double itemActualAmount;
    private String orderTripCurrentFlag;

    private List<saleOrder> saleOrderListing;
    
    private String itemCategory;
    
    private String itemIsPay;
    
    private String customerName;
    private String itemOptionName;
    private String itemCode;
    private String itemCodeDescription;

    private int totalOrderItemQuantity;
    private double totalOrderItemPrice;
    
    private String isPayFlag;
    private String deleteFlag;
private String itemCategoryName;

    private double postPay;
    private double discount;
    
    private String remarks;

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }


    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    

    public String getIsPayFlag() {
        return isPayFlag;
    }

    public void setIsPayFlag(String isPayFlag) {
        this.isPayFlag = isPayFlag;
    }
    
    

    public int getTotalOrderItemQuantity() {
        return totalOrderItemQuantity;
    }

    public double getTotalOrderItemPrice() {
        return totalOrderItemPrice;
    }

    public void setTotalOrderItemQuantity(int totalOrderItemQuantity) {
        this.totalOrderItemQuantity = totalOrderItemQuantity;
    }

    public void setTotalOrderItemPrice(double totalOrderItemPrice) {
        this.totalOrderItemPrice = totalOrderItemPrice;
    }
    
    
    
    public String getItemCodeDescription() {
        return itemCodeDescription;
    }

    public void setItemCodeDescription(String itemCodeDescription) {
        this.itemCodeDescription = itemCodeDescription;
    }
    
    

    public String getCustomerName() {
        return customerName;
    }

    public String getItemOptionName() {
        return itemOptionName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItemOptionName(String itemOptionName) {
        this.itemOptionName = itemOptionName;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    
    
    public String getItemIsPay() {
        return itemIsPay;
    }

    public void setItemIsPay(String itemIsPay) {
        this.itemIsPay = itemIsPay;
    }
    
    

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
    
    

    public String getOrderTripCurrentFlag() {
        return orderTripCurrentFlag;
    }

    public void setOrderTripCurrentFlag(String orderTripCurrentFlag) {
        this.orderTripCurrentFlag = orderTripCurrentFlag;
    }

    
    
    public double getItemActualAmount() {
        return itemActualAmount;
    }

    public void setItemActualAmount(double itemActualAmount) {
        this.itemActualAmount = itemActualAmount;
    }

    
    
    public String getItemRemarks() {
        return itemRemarks;
    }

    public void setItemRemarks(String itemRemarks) {
        this.itemRemarks = itemRemarks;
    }
    
    
    

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setOrderDetailQuantity(String orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }

    public void setOrderDetailCreateDateTime(Date orderDetailCreateDateTime) {
        this.orderDetailCreateDateTime = orderDetailCreateDateTime;
    }

    public void setOrderDetailUpdateDateTime(Date orderDetailUpdateDateTime) {
        this.orderDetailUpdateDateTime = orderDetailUpdateDateTime;
    }

    public void setItemOptionID(String itemOptionID) {
        this.itemOptionID = itemOptionID;
    }

    public void setItemOtherOption(String itemOtherOption) {
        this.itemOtherOption = itemOtherOption;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemPriceEditFlag(String itemPriceEditFlag) {
        this.itemPriceEditFlag = itemPriceEditFlag;
    }

    
    public String getOrderDetailID() {
        return orderDetailID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    public Date getOrderDetailCreateDateTime() {
        return orderDetailCreateDateTime;
    }

    public Date getOrderDetailUpdateDateTime() {
        return orderDetailUpdateDateTime;
    }

    public String getItemOptionID() {
        return itemOptionID;
    }

    public String getItemOtherOption() {
        return itemOtherOption;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public String getItemPriceEditFlag() {
        return itemPriceEditFlag;
    }
    
    
    

    public String getOrderTripDescription() {
        return orderTripDescription;
    }

    public void setOrderTripDescription(String orderTripDescription) {
        this.orderTripDescription = orderTripDescription;
    }

    public void setOrderTripID(String orderTripID) {
        this.orderTripID = orderTripID;
    }

    public String getOrderTripID() {
        return orderTripID;
    }
    public String getPendingOrderID() {
        return pendingOrderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getUserOrderDetailID() {
        return userOrderDetailID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPendingDate() {
        return pendingDate;
    }

    public String getVersion() {
        return version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getPaymentSlip() {
        return paymentSlip;
    }

    public String getPendingOrderDetailID() {
        return pendingOrderDetailID;
    }

    public String getItemDetailID() {
        return itemDetailID;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getNumberOfOder() {
        return numberOfOder;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setPendingOrderID(String pendingOrderID) {
        this.pendingOrderID = pendingOrderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setUserOrderDetailID(String userOrderDetailID) {
        this.userOrderDetailID = userOrderDetailID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPendingDate(String pendingDate) {
        this.pendingDate = pendingDate;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setPaymentSlip(String paymentSlip) {
        this.paymentSlip = paymentSlip;
    }

    public void setPendingOrderDetailID(String pendingOrderDetailID) {
        this.pendingOrderDetailID = pendingOrderDetailID;
    }

    public void setItemDetailID(String itemDetailID) {
        this.itemDetailID = itemDetailID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setNumberOfOder(String numberOfOder) {
        this.numberOfOder = numberOfOder;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
    }

    public List<saleOrder> getSaleOrderListing() {
        return saleOrderListing;
    }

    public void setSaleOrderListing(List<saleOrder> saleOrderListing) {
        this.saleOrderListing = saleOrderListing;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public double getItemTotalPrice() {
        return itemTotalPrice;
    }

    public double getItemTotalWeight() {
        return itemTotalWeight;
    }

    public double getItemTotalWeightPrice() {
        return itemTotalWeightPrice;
    }

    public void setItemTotalPrice(double itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public void setItemTotalWeight(double itemTotalWeight) {
        this.itemTotalWeight = itemTotalWeight;
    }

    public void setItemTotalWeightPrice(double itemTotalWeightPrice) {
        this.itemTotalWeightPrice = itemTotalWeightPrice;
    }

    public String getItemDeliveryDetailsID() {
        return itemDeliveryDetailsID;
    }

    public void setItemDeliveryDetailsID(String itemDeliveryDetailsID) {
        this.itemDeliveryDetailsID = itemDeliveryDetailsID;
    }

    public String getSaleOrderID() {
        return saleOrderID;
    }

    public void setSaleOrderID(String saleOrderID) {
        this.saleOrderID = saleOrderID;
    }

    public int getItemQuantity1() {
        return itemQuantity1;
    }

    public double getItemPrice1() {
        return itemPrice1;
    }

    public int getItemQuantity2() {
        return itemQuantity2;
    }

    public double getItemPrice2() {
        return itemPrice2;
    }

    public void setItemQuantity1(int itemQuantity1) {
        this.itemQuantity1 = itemQuantity1;
    }

    public void setItemPrice1(double itemPrice1) {
        this.itemPrice1 = itemPrice1;
    }

    public void setItemQuantity2(int itemQuantity2) {
        this.itemQuantity2 = itemQuantity2;
    }

    public void setItemPrice2(double itemPrice2) {
        this.itemPrice2 = itemPrice2;
    }

    public Date getOrderTripCreatedDate() {
        return orderTripCreatedDate;
    }

    public Date getOrderTripUpdatedDate() {
        return orderTripUpdatedDate;
    }

    public void setOrderTripCreatedDate(Date orderTripCreatedDate) {
        this.orderTripCreatedDate = orderTripCreatedDate;
    }

    public void setOrderTripUpdatedDate(Date orderTripUpdatedDate) {
        this.orderTripUpdatedDate = orderTripUpdatedDate;
    }

    public double getPostPay() {
        return postPay;
    }

    public void setPostPay(double postPay) {
        this.postPay = postPay;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    


    
    
    
    
    
}
