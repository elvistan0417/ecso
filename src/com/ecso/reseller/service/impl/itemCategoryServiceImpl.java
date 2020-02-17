/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service.impl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.ecso.reseller.dao.itemCategoryDao;
import com.ecso.reseller.model.itemCategory;
import com.ecso.reseller.service.itemCategoryService;

/**
 *
 * @author jiasingtan
 */
public class itemCategoryServiceImpl implements itemCategoryService{
    
	@Autowired
	itemCategoryDao itemCateDao;    
        
    @Override
    public String insertItemCategory(itemCategory itemCategoryObject){
        return itemCateDao.insertItemCategory(itemCategoryObject);
    }
    
    @Override
    public List<itemCategory> getItemCategoryList(){
        return itemCateDao.getItemCategoryList();
    }
    
    @Override
    public int deleteItemCategory(itemCategory itemCategoryObject){
        return itemCateDao.deleteItemCategory(itemCategoryObject);
    }
    
    @Override
    public int updateItemCategory(itemCategory itemCategoryObject){
        return itemCateDao.updateItemCategory(itemCategoryObject);
    }
    
    @Override
    public itemCategory getItemCategory(itemCategory itemCategoryObject){
        return itemCateDao.getItemCategory(itemCategoryObject);
    }
    
    @Override
    public List<itemCategory> getItemCategoryByOrderId(itemCategory itemCategoryObject){
        return itemCateDao.getItemCategoryByOrderId(itemCategoryObject);
    }
    
    @Override
    public int insertItemOption(itemCategory itemCategoryObject){
        return itemCateDao.insertItemOption(itemCategoryObject);
    }
    
    @Override
    public List<itemCategory> getItemOptionListByItemCategory(itemCategory itemCategoryObject){
        return itemCateDao.getItemOptionListByItemCategory(itemCategoryObject);
    }
    
    @Override
    public String updateItemOption(itemCategory itemCategoryObject){
        
        List<itemCategory> itemOptionList = itemCategoryObject.getItemOptionList();
        
        for(int i = 0;i<itemOptionList.size();i++){
            System.out.println("updateItemOptionService " + itemOptionList.get(i).getItemOptionDeleteFlag());
            if("Y".equals(itemOptionList.get(i).getItemOptionDeleteFlag())){
                System.out.println("Check if system got into delete itemOptionList");
                itemCateDao.deleteItemOption(itemOptionList.get(i));
            }
            else{
                itemCateDao.updateItemOption(itemOptionList.get(i));
            }
        }
        
        return "Success";
    }
    
    @Override
    public int deleteItemOptionByCategoryID(itemCategory itemCategoryObject){
         return itemCateDao.deleteItemOptionByCategoryID(itemCategoryObject);
    }
    @Override
    public int updateItemCategoryOrderTrip(itemCategory itemCategoryObject){
         return itemCateDao.updateItemCategoryOrderTrip(itemCategoryObject);
        
    }
}
