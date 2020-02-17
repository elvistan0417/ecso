/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service;

import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.model.contactDetails;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public interface stateService {
    public List<contactDetails> getStateList();
}
