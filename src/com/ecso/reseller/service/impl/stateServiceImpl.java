/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service.impl;

import com.ecso.reseller.dao.itemDetailDao;
import com.ecso.reseller.dao.stateDao;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.service.stateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jiasingtan
 */
public class stateServiceImpl implements stateService{
    
	@Autowired
	stateDao stateProfileDao; 
        @Override
        public List<contactDetails> getStateList(){
            return stateProfileDao.getStateList();
        }
}
