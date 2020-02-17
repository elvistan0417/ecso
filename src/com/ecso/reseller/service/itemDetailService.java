/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service;
import java.util.List;
import com.ecso.reseller.model.itemDetail;
/**
 *
 * @author jiasingtan
 */
public interface itemDetailService {
   public String insertItemDetail(itemDetail itemDetailObject);
    
    public List<itemDetail> getItemDetailList(itemDetail itemDetailObject);
    
    public int deleteItemDetail(itemDetail itemDetailObject);
    public int updateItemDetail(itemDetail itemDetailObject);
    
    public itemDetail getItemDetail(itemDetail itemDetailObject);
}
