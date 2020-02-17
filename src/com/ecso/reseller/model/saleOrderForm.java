/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.model;

import java.util.List;

/**
 *
 * @author jiasingtan
 */
public class saleOrderForm {
    
    private List<saleOrder> saleOrders;
    
    private double totalPrice;
    private double totalItemPrice;
    private double totalItemWeightPrice;
    private double totalItemWeight;
    private String salesOrderID;
    private String stateID;
    private String customerName;
    private String phoneContact;
    private String country;
    private String address1;
    private String address2;
    private String address3;
    private String remarks;
    private String deliveryAddress;
    private String paymentSlip;
    private String requestStatus;
    
    private List<contactDetails> customerList;

    public List<contactDetails> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<contactDetails> customerList) {
        this.customerList = customerList;
    }
    
    

    public List<saleOrder> getSaleOrders() {
        return saleOrders;
    }

    public void setSaleOrders(List<saleOrder> saleOrders) {
        this.saleOrders = saleOrders;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalItemPrice() {
        return totalItemPrice;
    }

    public double getTotalItemWeightPrice() {
        return totalItemWeightPrice;
    }

    public double getTotalItemWeight() {
        return totalItemWeight;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public void setTotalItemWeightPrice(double totalItemWeightPrice) {
        this.totalItemWeightPrice = totalItemWeightPrice;
    }

    public void setTotalItemWeight(double totalItemWeight) {
        this.totalItemWeight = totalItemWeight;
    }

    public String getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public String getStateID() {
        return stateID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public String getCountry() {
        return country;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentSlip() {
        return paymentSlip;
    }

    public void setPaymentSlip(String paymentSlip) {
        this.paymentSlip = paymentSlip;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    
    

    
    
}
