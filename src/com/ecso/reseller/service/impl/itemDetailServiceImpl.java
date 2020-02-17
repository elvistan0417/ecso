/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecso.reseller.dao.itemDetailDao;
import com.ecso.reseller.model.itemDetail;
import com.ecso.reseller.service.itemDetailService;
import java.util.ArrayList;
/**
 *
 * @author jiasingtan
 */
public class itemDetailServiceImpl implements itemDetailService{
    
	@Autowired
	itemDetailDao itemDetailDao;    
        
   public String insertItemDetail(itemDetail itemDetailObject){
      return itemDetailDao.insertItemDetail(itemDetailObject);
   };
    
    public List<itemDetail> getItemDetailList(itemDetail itemDetailObject){
        return itemDetailDao.getItemDetailList(itemDetailObject);
    };
    
    public int deleteItemDetail(itemDetail itemDetailObject){
        return itemDetailDao.deleteItemDetail(itemDetailObject);
    };
    public int updateItemDetail(itemDetail itemDetailObject){
        
        List<itemDetail> itemDetailList = itemDetailObject.getItemDetailList();
        System.out.println("Check if system got into  itemOptionList");
        for(int i = 0;i<itemDetailList.size();i++){
            if("Y".equals(itemDetailList.get(i).getItemDetailDeleteFlag())){
                System.out.println("Check if system got into delete itemOptionList");
                itemDetailDao.deleteItemDetail(itemDetailList.get(i));
            }
            else{
                itemDetailDao.updateItemDetail(itemDetailList.get(i));
            }
        }
        
        return 0;
        
//        return itemDetailDao.updateItemDetail(itemDetailObject);
        
        
        
        
    };
    
    public itemDetail getItemDetail(itemDetail itemDetailObject){
        return itemDetailDao.getItemDetail(itemDetailObject);
    };
        
}
