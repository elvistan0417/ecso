/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao;

import com.ecso.reseller.model.itemCategory;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public interface itemCategoryDao {
    
   public String insertItemCategory(itemCategory itemCategoryObject);
    
    public List<itemCategory> getItemCategoryList();
    
    public int deleteItemCategory(itemCategory itemCategoryObject);
    public int updateItemCategory(itemCategory itemCategoryObject);
    
    public itemCategory getItemCategory(itemCategory itemCategoryObject);
    
    public List<itemCategory> getItemCategoryByOrderId(itemCategory itemCategoryObject);
    
    public int insertItemOption(itemCategory itemCategoryObject);
    
    public List<itemCategory> getItemOptionListByItemCategory(itemCategory itemCategoryObject);
    
    public int deleteItemOption(itemCategory itemCategoryObject);
    public int updateItemOption(itemCategory itemCategoryObject);
    
    public int deleteItemOptionByCategoryID(itemCategory itemCategoryObject);
    public int updateItemCategoryOrderTrip(itemCategory itemCategoryObject);
}
