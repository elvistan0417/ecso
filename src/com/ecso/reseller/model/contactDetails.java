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
public class contactDetails {
    
    private String stateId;
    private String stateDescription;
    private String stateCode;
    private String deliveryDetailsID;
    private String customerName;
    private String phoneContact;
    private String country;
    private String address1;
    private String address2;
    private String address3;
    private String remarks;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    
         public String customerID;

         public String customerPhone;
         public String customerAddress;
         public Date customerCreateDateTime;
         public Date customerUpdateDateTime;
         public String fbName;
         public String weChatName;
         public String currentTripID;
         public String currentTripDescription;
         
         public double totalAmountNeedToPay;
         
         public String customerFullName;
         
         
     public List<contactDetails> contactDetailsList;   

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

     
     
     
    public double getTotalAmountNeedToPay() {
        return totalAmountNeedToPay;
    }

    public void setTotalAmountNeedToPay(double totalAmountNeedToPay) {
        this.totalAmountNeedToPay = totalAmountNeedToPay;
    }

     
     
    public String getCurrentTripID() {
        return currentTripID;
    }

    public String getCurrentTripDescription() {
        return currentTripDescription;
    }

    public void setCurrentTripID(String currentTripID) {
        this.currentTripID = currentTripID;
    }

    public void setCurrentTripDescription(String currentTripDescription) {
        this.currentTripDescription = currentTripDescription;
    }
     
     

    public void setContactDetailsList(List<contactDetails> contactDetailsList) {
        this.contactDetailsList = contactDetailsList;
    }

    public List<contactDetails> getContactDetailsList() {
        return contactDetailsList;
    }

    public String getStateId() {
        return stateId;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getDeliveryDetailsID() {
        return deliveryDetailsID;
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

    public String getCreateBy() {
        return createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setDeliveryDetailsID(String deliveryDetailsID) {
        this.deliveryDetailsID = deliveryDetailsID;
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

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Date getCustomerCreateDateTime() {
        return customerCreateDateTime;
    }

    public Date getCustomerUpdateDateTime() {
        return customerUpdateDateTime;
    }

    public String getFbName() {
        return fbName;
    }

    public String getWeChatName() {
        return weChatName;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerCreateDateTime(Date customerCreateDateTime) {
        this.customerCreateDateTime = customerCreateDateTime;
    }

    public void setCustomerUpdateDateTime(Date customerUpdateDateTime) {
        this.customerUpdateDateTime = customerUpdateDateTime;
    }

    public void setFbName(String fbName) {
        this.fbName = fbName;
    }

    public void setWeChatName(String weChatName) {
        this.weChatName = weChatName;
    }
    
    
    
}
