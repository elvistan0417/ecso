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
public class itemDetail {
    private String itemDetailID;
    private String itemCategoryID;
    private String itemUserDtlID;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private String version;
    private String createBy;
    private String createDt;
    private String updateBy;
    private String updateDT;
    private String itemPicture;
    private String promoteType;
    private String itemPictureID;
    private String isDetailFlag;
    private String itemWeight;
    private int itemQuantity1;
    private double itemPrice1;
    private int itemQuantity2;
    private double itemPrice2;
    private Date updateDate;
    private Date createDate;
    
    private List<itemDetail> itemDetailList;
    
    private String itemDetailDeleteFlag;
    private String itemCodeDescription;

    public String getItemCodeDescription() {
        return itemCodeDescription;
    }

    public void setItemCodeDescription(String itemCodeDescription) {
        this.itemCodeDescription = itemCodeDescription;
    }
    
    

    public void setItemDetailDeleteFlag(String itemDetailDeleteFlag) {
        this.itemDetailDeleteFlag = itemDetailDeleteFlag;
    }

    public String getItemDetailDeleteFlag() {
        return itemDetailDeleteFlag;
    }

    public String getItemDetailID() {
        return itemDetailID;
    }

    public String getItemCategoryID() {
        return itemCategoryID;
    }

    public String getItemUserDtlID() {
        return itemUserDtlID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getVersion() {
        return version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateDt() {
        return createDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public String getUpdateDT() {
        return updateDT;
    }

    public void setItemDetailID(String itemDetailID) {
        this.itemDetailID = itemDetailID;
    }

    public void setItemCategoryID(String itemCategoryID) {
        this.itemCategoryID = itemCategoryID;
    }

    public void setItemUserDtlID(String itemUserDtlID) {
        this.itemUserDtlID = itemUserDtlID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateDT(String updateDT) {
        this.updateDT = updateDT;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
    }

    public String getPromoteType() {
        return promoteType;
    }

    public void setPromoteType(String promoteType) {
        this.promoteType = promoteType;
    }

    public String getItemPictureID() {
        return itemPictureID;
    }

    public void setItemPictureID(String itemPictureID) {
        this.itemPictureID = itemPictureID;
    }

    public String getIsDetailFlag() {
        return isDetailFlag;
    }

    public void setIsDetailFlag(String isDetailFlag) {
        this.isDetailFlag = isDetailFlag;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<itemDetail> getItemDetailList() {
        return itemDetailList;
    }

    public void setItemDetailList(List<itemDetail> itemDetailList) {
        this.itemDetailList = itemDetailList;
    }
    
    
    
}
