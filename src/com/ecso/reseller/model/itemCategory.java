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
public class itemCategory {
    
    private String itemCategoryID;
    private String itemCategoryName;
    private String itemCategoryDescription;
    private String itemVersion;
    private String createBy;
    private String createDt;
    private String updateBy;
    private String updateDt;
    private String itemCategoryParentID;
    private String isParent;
    
    private Date itemCategoryCreateDate;
    private Date itemCategoryUpdateDate;
    private String orderTripID;
    
    private String itemOptionID;
    private String itemOptionName;
    private Date itemOptionCreateDate;
    private Date itemOptionUpdateDate;
    
    private String orderTripDescription;
    
    private List<itemCategory> itemOptionList;
    
    private String itemOptionDeleteFlag;

    public String getItemCategoryID() {
        return itemCategoryID;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public String getItemCategoryDescription() {
        return itemCategoryDescription;
    }

    public String getItemVersion() {
        return itemVersion;
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

    public String getUpdateDt() {
        return updateDt;
    }

    public void setItemCategoryID(String itemCategoryID) {
        this.itemCategoryID = itemCategoryID;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public void setItemCategoryDescription(String itemCategoryDescription) {
        this.itemCategoryDescription = itemCategoryDescription;
    }

    public void setItemVersion(String itemVersion) {
        this.itemVersion = itemVersion;
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

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public String getItemCategoryParentID() {
        return itemCategoryParentID;
    }

    public void setItemCategoryParentID(String itemCategoryParentID) {
        this.itemCategoryParentID = itemCategoryParentID;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public Date getItemCategoryCreateDate() {
        return itemCategoryCreateDate;
    }

    public Date getItemCategoryUpdateDate() {
        return itemCategoryUpdateDate;
    }

    public String getOrderTripID() {
        return orderTripID;
    }

    public String getItemOptionID() {
        return itemOptionID;
    }

    public String getItemOptionName() {
        return itemOptionName;
    }


    public void setItemCategoryCreateDate(Date itemCategoryCreateDate) {
        this.itemCategoryCreateDate = itemCategoryCreateDate;
    }

    public void setItemCategoryUpdateDate(Date itemCategoryUpdateDate) {
        this.itemCategoryUpdateDate = itemCategoryUpdateDate;
    }

    public void setOrderTripID(String orderTripID) {
        this.orderTripID = orderTripID;
    }

    public void setItemOptionID(String itemOptionID) {
        this.itemOptionID = itemOptionID;
    }

    public void setItemOptionName(String itemOptionName) {
        this.itemOptionName = itemOptionName;
    }

    public String getOrderTripDescription() {
        return orderTripDescription;
    }

    public void setOrderTripDescription(String orderTripDescription) {
        this.orderTripDescription = orderTripDescription;
    }

    public Date getItemOptionCreateDate() {
        return itemOptionCreateDate;
    }

    public Date getItemOptionUpdateDate() {
        return itemOptionUpdateDate;
    }

    public List<itemCategory> getItemOptionList() {
        return itemOptionList;
    }

    public void setItemOptionCreateDate(Date itemOptionCreateDate) {
        this.itemOptionCreateDate = itemOptionCreateDate;
    }

    public void setItemOptionUpdateDate(Date itemOptionUpdateDate) {
        this.itemOptionUpdateDate = itemOptionUpdateDate;
    }

    public void setItemOptionList(List<itemCategory> itemOptionList) {
        this.itemOptionList = itemOptionList;
    }

    public String getItemOptionDeleteFlag() {
        return itemOptionDeleteFlag;
    }

    public void setItemOptionDeleteFlag(String itemOptionDeleteFlag) {
        this.itemOptionDeleteFlag = itemOptionDeleteFlag;
    }
    
    
    
}
