/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.dao;

import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.model.saleOrderForm;
import java.util.List;

/**
 *
 * @author jiasingtan
 */
public interface contactDetailsDao {
    public String insertContactDetails(contactDetails contactDetailsObject);
    public int updateContactDetails(contactDetails contactDetailsObject);
    public contactDetails getContactDetails(contactDetails contactDetailsObject);
    public int deleteContactDetails(contactDetails contactDetailsObject);
    public List<contactDetails> getContactDetailsList(contactDetails contactDetailsObject);
}

