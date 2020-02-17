/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.controller;

import com.ecso.reseller.model.UserAuthority;
import com.ecso.reseller.model.itemCategory;
import com.ecso.reseller.model.itemDetail;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.model.saleOrderForm;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.service.itemCategoryService;
import com.ecso.reseller.service.itemDetailService;
import com.ecso.reseller.service.itemOrderService;
import com.ecso.reseller.service.manageOrderService;
import com.ecso.reseller.service.stateService;
import com.google.gson.Gson;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author jiasingtan
 */
@Controller
public class shoppingController {
    
    @Autowired
    manageOrderService manageOrderService;
    @Autowired
    itemCategoryService itemCategoryService;
//
    @Autowired
    itemOrderService itemOrderService;
//
    @Autowired
    itemDetailService itemDetService;
//
//    @Autowired
//    stateService stateProfileService;
//
//    @Autowired
//    ServletContext context;
//
//    List<itemCategory> itemCateList;
//    List<itemCategory> itemCateChildList;
//    List<itemDetail> itemDetailList;
//    saleOrderForm orderForm;
//    // List<saleOrder> pendingOrderItemList;
//
//    int current = 1;
//    int begin;
//    int end;
//    int maxPageNumber;
//
//    private static final String UPLOAD_DIRECTORY = "/images/paymentSlip";
//

    @RequestMapping(value = "/viewOrderInsert", method = RequestMethod.GET)
    public String viewOrderInsert(Model model, HttpServletRequest req) {
        
        String result = req.getParameter("result");
        
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        String orderTripID = orderTrip.getOrderTripID();
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        String itemCategoryID = "";
        if (itemCategoryObjectList.size() > 0) {
            itemCategoryID = itemCategoryObjectList.get(0).getItemCategoryID();
        }
        itemDetail itemDetailObjectTemp = new itemDetail();
        itemDetailObjectTemp.setItemCategoryID(itemCategoryID);
        
        contactDetails contactDetailsObject = new contactDetails();
        List<contactDetails> customerList = manageOrderService.getContactDetailsList(contactDetailsObject);
        List<itemDetail> itemList = itemDetService.getItemDetailList(itemDetailObjectTemp);
        
        itemCategory itemCategoryTemp = new itemCategory();
        itemCategoryTemp.setItemCategoryID(itemCategoryID);
        List<itemCategory> itemOptionLst = itemCategoryService.getItemOptionListByItemCategory(itemCategoryTemp);
        
        Map<String, String> customerReference = new LinkedHashMap<String, String>();
        customerReference.put("", "Please Select");
        for (int i = 0; i < customerList.size(); i++) {
            customerReference.put(customerList.get(i).getCustomerID(), customerList.get(i).getCustomerID() + " - " + customerList.get(i).getCustomerName());
        }
        
        Map<String, String> itemReference = new LinkedHashMap<String, String>();
        itemReference.put("", "Please Select");
        for (int i = 0; i < itemList.size(); i++) {
            itemReference.put(itemList.get(i).getItemDetailID(), itemList.get(i).getItemName() + " - " + itemList.get(i).getItemDescription());
        }
        
        Map<String, String> itemOptionReference = new LinkedHashMap<String, String>();
        itemOptionReference.put("", "Please Select");
        itemOptionReference.put("0", "Other Option");
        for (int i = 0; i < itemOptionLst.size(); i++) {
            itemOptionReference.put(itemOptionLst.get(i).getItemOptionID(), itemOptionLst.get(i).getItemOptionName());
        }
        
        saleOrder saleOrderObject = new saleOrder();
        
        int numberOfInput = 20;
        
        saleOrderObject.setOrderTripID(orderTripID);
        saleOrderObject.setItemCategory(itemCategoryID);
        
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("choosenOrderID", orderTripID);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("customerList", customerReference);
        model.addAttribute("itemOptionList", itemOptionReference);
        model.addAttribute("itemList", itemReference);
        model.addAttribute("itemDetailList", itemList);
        model.addAttribute("saleOrderObject", saleOrderObject);
        model.addAttribute("numberOfInput", numberOfInput);
        model.addAttribute("result", result);
        return "orderInsert";
        
    }
    
    @RequestMapping(value = "/viewOrderInsertByOC", method = RequestMethod.GET)
    public String viewOrderInsertByOC(Model model, HttpServletRequest req) {
        
        String orderTripID = req.getParameter("orderTripID");
        
        saleOrder orderTrip = new saleOrder();
        
        orderTrip.setOrderTripID(orderTripID);
        
        orderTrip = manageOrderService.getOrderTrip(orderTrip);
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        String itemCategoryID = req.getParameter("itemCategoryID");
        
        itemDetail itemDetailObjectTemp = new itemDetail();
        itemDetailObjectTemp.setItemCategoryID(itemCategoryID);
        
        contactDetails contactDetailsObject = new contactDetails();
        List<contactDetails> customerList = manageOrderService.getContactDetailsList(contactDetailsObject);
        List<itemDetail> itemList = itemDetService.getItemDetailList(itemDetailObjectTemp);
        
        itemCategory itemCategoryTemp = new itemCategory();
        itemCategoryTemp.setItemCategoryID(itemCategoryID);
        List<itemCategory> itemOptionLst = itemCategoryService.getItemOptionListByItemCategory(itemCategoryTemp);
        
        Map<String, String> customerReference = new LinkedHashMap<String, String>();
        customerReference.put("", "Please Select");
        for (int i = 0; i < customerList.size(); i++) {
            customerReference.put(customerList.get(i).getCustomerID(), customerList.get(i).getCustomerName());
        }
        
        Map<String, String> itemReference = new LinkedHashMap<String, String>();
        itemReference.put("", "Please Select");
        for (int i = 0; i < itemList.size(); i++) {
            itemReference.put(itemList.get(i).getItemDetailID(), itemList.get(i).getItemName() + " - " + itemList.get(i).getItemDescription());
        }
        
        Map<String, String> itemOptionReference = new LinkedHashMap<String, String>();
        itemOptionReference.put("", "Please Select");
        itemOptionReference.put("0", "Other Option");
        for (int i = 0; i < itemOptionLst.size(); i++) {
            itemOptionReference.put(itemOptionLst.get(i).getItemOptionID(), itemOptionLst.get(i).getItemOptionName());
        }
        
        saleOrder saleOrderObject = new saleOrder();
        
        int numberOfInput = 20;
        
        saleOrderObject.setOrderTripID(orderTripID);
        saleOrderObject.setItemCategory(itemCategoryID);
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("choosenOrderID", orderTripID);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("customerList", customerReference);
        model.addAttribute("itemOptionList", itemOptionReference);
        model.addAttribute("itemList", itemReference);
        model.addAttribute("itemDetailList", itemList);
        model.addAttribute("saleOrderObject", saleOrderObject);
        model.addAttribute("numberOfInput", numberOfInput);
        
        return "orderInsert";
        
    }
    
    @RequestMapping(value = "/insertSaleOrder", method = RequestMethod.POST)
    public ModelAndView insertSaleOrder(@ModelAttribute("saleOrderObject") saleOrder saleOrder, Model model, HttpServletRequest req) {
        
        String orderTripID = saleOrder.getOrderTripID();
        String itemCategory = saleOrder.getItemCategory();
        try{
        for (int i = 0; i < saleOrder.getSaleOrderListing().size(); i++) {
            
            saleOrder saleOrderTemp = new saleOrder();
            
            saleOrderTemp = saleOrder.getSaleOrderListing().get(i);
            if ("" != saleOrderTemp.getCustomerID()) {
                System.out.println("check with here " + saleOrder.getSaleOrderListing().get(i).getItemID());
                saleOrderTemp.setOrderTripID(orderTripID);
                saleOrderTemp.setItemCategory(itemCategory);
                itemOrderService.insertOrderService(saleOrderTemp);
                
            }
        }
        }
        catch (Exception e){
//            model.addAttribute("result", "N");
            return new ModelAndView("redirect:/viewOrderInsert?result=N");

        }
        
//        model.addAttribute("result", "Y");
        return new ModelAndView("redirect:/viewOrderInsert?result=Y");
        
    }
    
    @RequestMapping(value = "/viewOrderManage", method = RequestMethod.GET)
    public String viewOrderManage(Model model, HttpServletRequest req) {
        
        
        saleOrder unPaySaleOrderObject = new saleOrder();
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        unPaySaleOrderObject.setItemIsPay("N");
        List<saleOrder> unPaySaleOrderObjectList = itemOrderService.getOrderListByPayFlag(unPaySaleOrderObject);
        
        for (int i = 0; i < unPaySaleOrderObjectList.size(); i++) {
            String itemCode = unPaySaleOrderObjectList.get(i).getItemCode();
            String itemDescription = unPaySaleOrderObjectList.get(i).getItemDescription();
            unPaySaleOrderObjectList.get(i).setItemCodeDescription(itemCode + " - " + itemDescription);
        }
        unPaySaleOrderObject.setSaleOrderListing(unPaySaleOrderObjectList);
        
        model.addAttribute("unPaySaleOrderObjectList", unPaySaleOrderObjectList);
        model.addAttribute("saleOrderForm", unPaySaleOrderObject);
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());

        return "orderManage";
        
    }
    
    @RequestMapping(value = "/viewSummaryOrderUnpay", method = RequestMethod.GET)
    public String viewSummaryOrderUnpay(Model model, HttpServletRequest req) {
        
        String result = req.getParameter("result");
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();


        List<saleOrder> unPaySaleOrderObjectList = itemOrderService.getSummaryCustomerUnpay(orderTrip);
        

        
        model.addAttribute("unPaySaleOrderObjectList", unPaySaleOrderObjectList);
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
//        model.addAttribute("saleOrderForm", unPaySaleOrderObject);
        model.addAttribute("result", result);
        return "orderManage";
        
    }
    
    
    @RequestMapping(value = "/updatePayToOrder", method = RequestMethod.POST)
    public String updatePayToOrder(@ModelAttribute("saleOrderForm") saleOrder saleOrder, Model model, HttpServletRequest req) {
        
        for (int i = 0; i < saleOrder.getSaleOrderListing().size(); i++) {
            
            saleOrder saleOrderTemp = new saleOrder();
            saleOrderTemp = saleOrder.getSaleOrderListing().get(i);
            System.out.println("Testing " + saleOrder.getSaleOrderListing().get(i).getItemIsPay() + " " + saleOrder.getSaleOrderListing().get(i).getOrderDetailID());
            
            if ("Y".equals(saleOrderTemp.getItemIsPay())) {
                saleOrderTemp = itemOrderService.getOrder(saleOrderTemp);
                itemOrderService.deleteOrder(saleOrderTemp);
                itemOrderService.insertOrderPaid(saleOrderTemp);
            }
            
        }
        
        return "orderInsertResult";
        
    }
    
    @RequestMapping(value = "/viewOrderSearch", method = RequestMethod.GET)
    public String viewOrderSearch(Model model, HttpServletRequest req) {
        
        List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        
        Map<String, String> orderTripListReference = new LinkedHashMap<String, String>();
        
        for (int i = 0; i < orderTripList.size(); i++) {
            orderTripListReference.put(orderTripList.get(i).getOrderTripID(), orderTripList.get(i).getOrderTripDescription());
        }
        
        itemCategory itemCategoryObject = new itemCategory();
        
        if (orderTripList.size() > 0) {
            itemCategoryObject.setOrderTripID(orderTripList.get(0).getOrderTripID());
        }
        
        List<itemCategory> itemCategoryList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
        Map<String, String> itemCategoryListReference = new LinkedHashMap<String, String>();
        itemCategoryListReference.put("%%", "All");
        
        for (int i = 0; i < itemCategoryList.size(); i++) {
            itemCategoryListReference.put(itemCategoryList.get(i).getItemCategoryID(), itemCategoryList.get(i).getItemCategoryName());
        }
        
        contactDetails contactDetailsObject = new contactDetails();
        
        List<contactDetails> customerList = manageOrderService.getContactDetailsList(contactDetailsObject);
        
        Map<String, String> customerReference = new LinkedHashMap<String, String>();
        customerReference.put("%%", "All");
        for (int i = 0; i < customerList.size(); i++) {
            customerReference.put(customerList.get(i).getCustomerID(), customerList.get(i).getCustomerName());
        }
        
        Map<String, String> itemReference = new LinkedHashMap<String, String>();
        itemReference.put("%%", "All");
        
        Map<String, String> itemOptionReference = new LinkedHashMap<String, String>();
        itemOptionReference.put("%%", "All");
        itemOptionReference.put("0", "Other Option");
        
        Map<String, String> itemIsPayReference = new LinkedHashMap<String, String>();
        itemIsPayReference.put("%%", "All");
        itemIsPayReference.put("Y", "Yes");
        itemIsPayReference.put("N", "No");
        
        saleOrder saleOrderForm = new saleOrder();
        
        model.addAttribute("orderTripList", orderTripListReference);
        model.addAttribute("itemCategoryList", itemCategoryListReference);
        model.addAttribute("customerList", customerReference);
        model.addAttribute("itemList", itemReference);
        model.addAttribute("itemOptionList", itemOptionReference);
        model.addAttribute("itemIsPayList", itemIsPayReference);
        model.addAttribute("saleOrderList", saleOrderForm.getSaleOrderListing());
        model.addAttribute("saleOrderForm", saleOrderForm);
        
        return "orderSearch";
        
    }
    
    @RequestMapping(value = "/getItemCategoryA", method = RequestMethod.GET)
    public void getItemCategoryListAjax(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String orderTripID = req.getParameter("orderTripID");
        
        System.out.println("Check system to come in ajax with orderTrip " + orderTripID);
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        String json;
        
        List<itemCategory> itemCategoryList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
        json = new Gson().toJson(itemCategoryList);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
    
    @RequestMapping(value = "/getItemA", method = RequestMethod.GET)
    public void getitemA(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String itemCategoryID = req.getParameter("itemCategoryID");
        
        System.out.println("Check system to come in ajax with itemCategoryID " + itemCategoryID);
        
        itemDetail itemDetailObject = new itemDetail();
        itemDetailObject.setItemCategoryID(itemCategoryID);
        String json;
        
        List<itemDetail> itemDetailList = itemDetService.getItemDetailList(itemDetailObject);
        
        for (int i = 0; i < itemDetailList.size(); i++) {
            itemDetailList.get(i).setItemCodeDescription(itemDetailList.get(i).getItemName() + " - " + itemDetailList.get(i).getItemDescription());
        }
        
        json = new Gson().toJson(itemDetailList);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
    
    @RequestMapping(value = "/getItemOptionA", method = RequestMethod.GET)
    public void getItemOptionA(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String itemCategoryID = req.getParameter("itemCategoryID");
        
        System.out.println("Check system to come in ajax with itemCategoryID " + itemCategoryID);
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setItemCategoryID(itemCategoryID);
        String json;
        
        List<itemCategory> itemCategoryList = itemCategoryService.getItemOptionListByItemCategory(itemCategoryObject);
        
        json = new Gson().toJson(itemCategoryList);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
    
    @RequestMapping(value = "/searchSaleOrder", method = RequestMethod.POST)
    public String searchSaleOrder(@ModelAttribute("saleOrderForm") saleOrder saleOrder, Model model, HttpServletRequest req) {
        
        System.out.println("check input value " + saleOrder.getCustomerID() + " " + saleOrder.getOrderTripID() + " " + saleOrder.getItemCategory() + " " + saleOrder.getItemID() + " " + saleOrder.getItemOptionID());
        
        List<saleOrder> saleOrderList;
        //check flag check
        if ("%%".equals(saleOrder.getItemIsPay())) {
            
            saleOrderList = itemOrderService.searchPaidOrderList(saleOrder);
            
            for (int i = 0; i < saleOrderList.size(); i++) {
                saleOrderList.get(i).setItemIsPay("Y");
            }
            
            List<saleOrder> saleOrderUnpayList = itemOrderService.searchOrderList(saleOrder);
            
            for (int i = 0; i < saleOrderUnpayList.size(); i++) {
                saleOrderUnpayList.get(i).setItemIsPay("N");
                
                saleOrderList.add(saleOrderUnpayList.get(i));
                
            }
            
        } else if ("Y".equals(saleOrder.getItemIsPay())) {
            saleOrderList = itemOrderService.searchPaidOrderList(saleOrder);
            
            for (int i = 0; i < saleOrderList.size(); i++) {
                saleOrderList.get(i).setItemIsPay("Y");
            }
        } else {
            saleOrderList = itemOrderService.searchOrderList(saleOrder);
            
            for (int i = 0; i < saleOrderList.size(); i++) {
                saleOrderList.get(i).setItemIsPay("N");
                
            }
        }
        //setItemCodeDescription(itemCode + " - " + itemDescription)
        if(saleOrderList.size() > 0){
        for(int i = 0;i< saleOrderList.size();i++){
            saleOrderList.get(i).setItemCodeDescription(saleOrderList.get(i).getItemCode() + " - " + saleOrderList.get(i).getItemDescription());
        }
    }
        
        List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        
        Map<String, String> orderTripListReference = new LinkedHashMap<String, String>();
        
        for (int i = 0; i < orderTripList.size(); i++) {
            orderTripListReference.put(orderTripList.get(i).getOrderTripID(), orderTripList.get(i).getOrderTripDescription());
        }
        
        itemCategory itemCategoryObject = new itemCategory();
        
        itemCategoryObject.setItemCategoryID(saleOrder.getItemCategory());
        itemCategoryObject.setOrderTripID(saleOrder.getOrderTripID());
        
        List<itemCategory> itemCategoryList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
        Map<String, String> itemCategoryListReference = new LinkedHashMap<String, String>();
        itemCategoryListReference.put("%%", "All");
        
        for (int i = 0; i < itemCategoryList.size(); i++) {
            itemCategoryListReference.put(itemCategoryList.get(i).getItemCategoryID(), itemCategoryList.get(i).getItemCategoryName());
        }
        
        contactDetails contactDetailsObject = new contactDetails();
        
        List<contactDetails> customerList = manageOrderService.getContactDetailsList(contactDetailsObject);
        
        Map<String, String> customerReference = new LinkedHashMap<String, String>();
        customerReference.put("%%", "All");
        for (int i = 0; i < customerList.size(); i++) {
            customerReference.put(customerList.get(i).getCustomerID(), customerList.get(i).getCustomerName());
        }
        
        Map<String, String> itemReference = new LinkedHashMap<String, String>();
        itemReference.put("%%", "All");
        
        if (!"%%".equals(saleOrder.getItemCategory())) {
            itemDetail itemDetailObject = new itemDetail();
            
            itemDetailObject.setItemCategoryID(saleOrder.getItemCategory());
            
            List<itemDetail> itemDetailList = itemDetService.getItemDetailList(itemDetailObject);
            
            for (int i = 0; i < itemDetailList.size(); i++) {
                itemReference.put(itemDetailList.get(i).getItemDetailID(), itemDetailList.get(i).getItemDescription());
            }
        }
        
        Map<String, String> itemOptionReference = new LinkedHashMap<String, String>();
        itemOptionReference.put("%%", "All");
        itemOptionReference.put("0", "Other Option");
        
        if (!"%%".equals(saleOrder.getItemCategory())) {
            
            List<itemCategory> itemOptionLst = itemCategoryService.getItemOptionListByItemCategory(itemCategoryObject);
            for (int i = 0; i < itemOptionLst.size(); i++) {
                itemOptionReference.put(itemOptionLst.get(i).getItemOptionID(), itemOptionLst.get(i).getItemOptionName());
            }
        }
        
        Map<String, String> itemIsPayReference = new LinkedHashMap<String, String>();
        itemIsPayReference.put("%%", "All");
        itemIsPayReference.put("Y", "Yes");
        itemIsPayReference.put("N", "No");
        
        model.addAttribute("orderTripList", orderTripListReference);
        model.addAttribute("itemCategoryList", itemCategoryListReference);
        model.addAttribute("customerList", customerReference);
        model.addAttribute("itemList", itemReference);
        model.addAttribute("itemOptionList", itemOptionReference);
        model.addAttribute("itemIsPayList", itemIsPayReference);
        model.addAttribute("saleOrderList", saleOrderList);
        model.addAttribute("saleOrderForm", saleOrder);
        return "orderSearch";
        
    }
    
    
    @RequestMapping(value = "/viewCustomerDetailOrderDetail", method = RequestMethod.GET)
    public String viewCustomerDetailOrderDetail(Model model, HttpServletRequest req) {
        
        String customerID = req.getParameter("customerID");

        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        
        contactDetails contactDetailsObject = new contactDetails();
        
        contactDetailsObject.setCustomerID(customerID);
        orderTrip.setCustomerID(customerID);
        
        contactDetailsObject = manageOrderService.getContactDetails(contactDetailsObject);
        
        List<saleOrder> unPaySaleOrderDetailList = itemOrderService.getOrderListByCustomerID(orderTrip);
        
        for (int i = 0; i < unPaySaleOrderDetailList.size(); i++) {
            String itemCode = unPaySaleOrderDetailList.get(i).getItemCode();
            String itemDescription = unPaySaleOrderDetailList.get(i).getItemDescription();
            unPaySaleOrderDetailList.get(i).setItemCodeDescription(itemCode + " - " + itemDescription);
        }
        
        model.addAttribute("unPaySaleOrderDetailList", unPaySaleOrderDetailList);
        List<saleOrder> unPaySaleOrderObjectList = itemOrderService.getSummaryCustomerUnpayByCustomerID(orderTrip);
        
        model.addAttribute("unPaySaleOrderObjectList", unPaySaleOrderObjectList);
        model.addAttribute("currentTripDescription",orderTrip.getOrderTripDescription());

        model.addAttribute("contactDetailsObject", contactDetailsObject);
        model.addAttribute("isPayFlag","N");

        model.addAttribute("customerID",customerID);
        model.addAttribute("saleOrderObject", orderTrip);
        return "orderDetailCustomerDetail";

    } 
    
        
    @RequestMapping(value = "/updatePayToOrderByCustID", method = RequestMethod.GET)
    public ModelAndView updatePayToOrderByCustID(Model model, HttpServletRequest req) {
        
         String customerID = req.getParameter("customerID");
         
         try{
         saleOrder saleOrderObject = manageOrderService.getCurrentOrderTrip();
         saleOrderObject.setCustomerID(customerID);
        
         List<saleOrder> saleOrderList = itemOrderService.getSimpleOrderListByCustomerID(saleOrderObject);
         
         for(int i = 0;i < saleOrderList.size();i++){
             saleOrder saleOrderObjectTemp = new saleOrder();
             saleOrderObjectTemp = saleOrderList.get(i);
             itemOrderService.insertOrderPaid(saleOrderObjectTemp);
             itemOrderService.deleteOrder(saleOrderObjectTemp);
         }
         }
        
         catch (Exception e){
//            model.addAttribute("result", "N");
            return new ModelAndView("redirect:/viewSummaryOrderUnpay?result=N");

        }
         
         
        return new ModelAndView("redirect:/viewSummaryOrderUnpay?result=Y");
        
    }
    
   @RequestMapping(value = "/viewSaleOrderDetail", method = RequestMethod.GET)
    public String viewSaleOrderDetail(Model model, HttpServletRequest req) {        
        
        String saleOrderID = req.getParameter("saleOrderID");
        
        String isPayFlag = req.getParameter("isPayFlag");
    String result = req.getParameter("result");
       saleOrder saleOrderObject = new saleOrder();
       
       saleOrderObject.setSaleOrderID(saleOrderID);
       
       if("N".equals(isPayFlag)){
       saleOrderObject = itemOrderService.getOrder(saleOrderObject);
       }
       else{
           saleOrderObject = itemOrderService.getPaidOrder(saleOrderObject);
       }
       
        model.addAttribute("saleOrderDetail", saleOrderObject);
        model.addAttribute("isPayFlag",isPayFlag);
        model.addAttribute("result",result);
        return "orderDetail";        
        

    } 
    
   @RequestMapping(value = "/viewOrderDetailUpdate", method = RequestMethod.GET)
    public String viewOrderDetailUpdate(Model model, HttpServletRequest req) {        
        
        String saleOrderID = req.getParameter("saleOrderID");
        String isPayFlag = req.getParameter("isPayFlag");
       saleOrder saleOrderObject = new saleOrder();
       
       saleOrderObject.setSaleOrderID(saleOrderID);
       
       if("N".equals(isPayFlag)){
       saleOrderObject = itemOrderService.getOrder(saleOrderObject);
       saleOrderObject.setIsPayFlag("N");
       }
       else{
           saleOrderObject = itemOrderService.getPaidOrder(saleOrderObject);
           saleOrderObject.setIsPayFlag("Y");
           System.out.println("Check item option + " + saleOrderObject.getItemOptionID());
           System.out.println("Check item name + " + saleOrderObject.getItemID());
           System.out.println("Check item category + " + saleOrderObject.getItemCategory());
       }
       
       itemCategory itemCategoryObjectTemp = new itemCategory();
       
       itemCategoryObjectTemp.setOrderTripID(saleOrderObject.getOrderTripID());
       itemCategoryObjectTemp.setItemCategoryID(saleOrderObject.getItemCategory());
       
       List<itemCategory> itemCategoryList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObjectTemp);
       

       
        Map<String, String> itemCategoryReference = new LinkedHashMap<String, String>();

        for (int i = 0; i < itemCategoryList.size(); i++) {
            itemCategoryReference.put(itemCategoryList.get(i).getItemCategoryID(), itemCategoryList.get(i).getItemCategoryName());
        }
       
       itemDetail itemDetailObjectTemp = new itemDetail();
       
       itemDetailObjectTemp.setItemCategoryID(saleOrderObject.getItemCategory());
        
       List<itemDetail> itemDetailList = itemDetService.getItemDetailList(itemDetailObjectTemp);

        
        Map<String, String> itemDetailReference = new LinkedHashMap<String, String>();

        for (int i = 0; i < itemDetailList.size(); i++) {
            itemDetailReference.put(itemDetailList.get(i).getItemDetailID(),itemDetailList.get(i).getItemName() + " - " + itemDetailList.get(i).getItemDescription());
        }

        List<itemCategory> itemOptionList = itemCategoryService.getItemOptionListByItemCategory(itemCategoryObjectTemp);

        Map<String, String> itemOptionReference = new LinkedHashMap<String, String>();

        for (int i = 0; i < itemOptionList.size(); i++) {
            itemOptionReference.put(itemOptionList.get(i).getItemOptionID(),itemOptionList.get(i).getItemOptionName());
        }
        itemOptionReference.put("0","Other Option");
        model.addAttribute("saleOrderDetail", saleOrderObject);
        model.addAttribute("itemCategoryList", itemCategoryReference);
        model.addAttribute("itemDetailList", itemDetailReference);
        model.addAttribute("itemOptionList", itemOptionReference);
        
        return "orderDetailUpdate";        
        

    } 
   @RequestMapping(value = "/updateOrderDetail", method = RequestMethod.POST)
    public ModelAndView updateOrderDetail(@ModelAttribute("saleOrderForm") saleOrder saleOrder, Model model, HttpServletRequest req) {
        
        try{
        if("N".equals(saleOrder.getIsPayFlag())){
        itemOrderService.updateOrder(saleOrder);
        }else{
          itemOrderService.updatePaidOrder(saleOrder);  
        }
        }
        catch(Exception a){
            return new ModelAndView("redirect:/viewSaleOrderDetail?saleOrderID="+saleOrder.getOrderDetailID()+"&isPayFlag="+saleOrder.getIsPayFlag()+"&result=N");
        }
        return new ModelAndView("redirect:/viewSaleOrderDetail?saleOrderID="+saleOrder.getOrderDetailID()+"&isPayFlag="+saleOrder.getIsPayFlag()+"&result=Y");

        
    }
    
       @RequestMapping(value = "/deleteOrderDetail", method = RequestMethod.GET)
    public ModelAndView deleteOrderDetail(Model model, HttpServletRequest req) {        
        
        String saleOrderID = req.getParameter("saleOrderID");
        String isPayFlag = req.getParameter("isPayFlag");
        
        try{
        saleOrder saleOrderObject = new saleOrder();
        
        saleOrderObject.setOrderDetailID(saleOrderID);
        
        if("N".equals(isPayFlag)){
        itemOrderService.deleteOrder(saleOrderObject);
        }
        else{
         itemOrderService.deletePaidOrder(saleOrderObject);   
        }
        }
        catch(Exception a){
            return new ModelAndView("redirect:/viewCustomerReport?result=N");
        }
        
        return new ModelAndView("redirect:/viewCustomerReport?result=Y");
    }
    
    @RequestMapping(value = "/viewCustomerDetailPaidOrderDetail", method = RequestMethod.GET)
    public String viewCustomerDetailPaidOrderDetail(Model model, HttpServletRequest req) {
        
        String customerID = req.getParameter("customerID");
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        
        contactDetails contactDetailsObject = new contactDetails();
        
        contactDetailsObject.setCustomerID(customerID);
        orderTrip.setCustomerID(customerID);
        
        contactDetailsObject = manageOrderService.getContactDetails(contactDetailsObject);
        
        List<saleOrder> unPaySaleOrderDetailList = itemOrderService.getPaidOrderListByCustomerID(orderTrip);
        
        for (int i = 0; i < unPaySaleOrderDetailList.size(); i++) {
            String itemCode = unPaySaleOrderDetailList.get(i).getItemCode();
            String itemDescription = unPaySaleOrderDetailList.get(i).getItemDescription();
            unPaySaleOrderDetailList.get(i).setItemCodeDescription(itemCode + " - " + itemDescription);
        }
        
        model.addAttribute("unPaySaleOrderDetailList", unPaySaleOrderDetailList);
        List<saleOrder> unPaySaleOrderObjectList = itemOrderService.getSummaryCustomerPaidByCustomerID(orderTrip);
        
        model.addAttribute("unPaySaleOrderObjectList", unPaySaleOrderObjectList);
        model.addAttribute("currentTripDescription",orderTrip.getOrderTripDescription());
model.addAttribute("saleOrderObject", orderTrip);
        model.addAttribute("contactDetailsObject", contactDetailsObject);
        model.addAttribute("isPayFlag","Y");
        model.addAttribute("customerID",customerID);
        return "orderDetailCustomerDetail";

    } 
    @RequestMapping(value = "/viewCustomerReport", method = RequestMethod.GET)
    public String viewReport(Model model, HttpServletRequest req) {   
        
        String result = req.getParameter("result");
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();


        List<saleOrder> unPaySaleOrderObjectList = itemOrderService.getSummaryCustomerUnpay(orderTrip);
        List<saleOrder> paidSaleOrderObjectList = itemOrderService.getSummaryCustomerPay(orderTrip);

        model.addAttribute("unPaySaleOrderObjectList", unPaySaleOrderObjectList);
        model.addAttribute("paidSaleOrderObjectList", paidSaleOrderObjectList);
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("result", result);
        return "viewCustomerReport";   

    }
    @RequestMapping(value = "/updatePaidOrderSaleList", method = RequestMethod.GET)
    public String updatePaidOrderSaleList(Model model, HttpServletRequest req) {
        
        String customerID = req.getParameter("customerID");
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        String orderTripID = orderTrip.getOrderTripID();
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        String itemCategoryID = "";
        if (itemCategoryObjectList.size() > 0) {
            itemCategoryID = itemCategoryObjectList.get(0).getItemCategoryID();
        }
        itemDetail itemDetailObjectTemp = new itemDetail();
        itemDetailObjectTemp.setItemCategoryID(itemCategoryID);
        
        contactDetails contactDetailsObject = new contactDetails();
        List<contactDetails> customerList = manageOrderService.getContactDetailsList(contactDetailsObject);
        List<itemDetail> itemList = itemDetService.getItemDetailList(itemDetailObjectTemp);
        
        itemCategory itemCategoryTemp = new itemCategory();
        itemCategoryTemp.setItemCategoryID(itemCategoryID);
        List<itemCategory> itemOptionLst = itemCategoryService.getItemOptionListByItemCategory(itemCategoryTemp);
        
        Map<String, String> customerReference = new LinkedHashMap<String, String>();
        customerReference.put("", "Please Select");
        for (int i = 0; i < customerList.size(); i++) {
            customerReference.put(customerList.get(i).getCustomerID(), customerList.get(i).getCustomerName());
        }
        
        Map<String, String> itemReference = new LinkedHashMap<String, String>();
        itemReference.put("", "Please Select");
        for (int i = 0; i < itemList.size(); i++) {
            itemReference.put(itemList.get(i).getItemDetailID(), itemList.get(i).getItemName() + " - " + itemList.get(i).getItemDescription());
        }
        
        Map<String, String> itemOptionReference = new LinkedHashMap<String, String>();
        itemOptionReference.put("", "Please Select");
        itemOptionReference.put("0", "Other Option");
        for (int i = 0; i < itemOptionLst.size(); i++) {
            itemOptionReference.put(itemOptionLst.get(i).getItemOptionID(), itemOptionLst.get(i).getItemOptionName());
        }
        
        saleOrder saleOrderObject = new saleOrder();
        
        
        saleOrderObject.setOrderTripID(orderTripID);
        saleOrderObject.setItemCategory(itemCategoryID);
        saleOrderObject.setCustomerID(customerID);
        
        contactDetailsObject.setCustomerID(customerID);
        contactDetails customerDetail = manageOrderService.getContactDetails(contactDetailsObject);
        
        List<saleOrder> saleOrderObjectList = itemOrderService.getPaidOrderListByCustomerID(saleOrderObject);
        saleOrderObject.setSaleOrderListing(saleOrderObjectList);
        saleOrderObject.setIsPayFlag("Y");
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("choosenOrderID", orderTripID);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("customerList", customerReference);
        model.addAttribute("itemOptionList", itemOptionReference);
        model.addAttribute("itemList", itemReference);
        model.addAttribute("itemDetailList", itemList);
        model.addAttribute("saleOrderObject", saleOrderObject);

        model.addAttribute("customerDetail", customerDetail);

        return "orderUpdate";
        
    }
    
    @RequestMapping(value = "/updateUnPayOrderSaleList", method = RequestMethod.GET)
    public String updateUnPayOrderSaleList(Model model, HttpServletRequest req) {
        
        String customerID = req.getParameter("customerID");
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        String orderTripID = orderTrip.getOrderTripID();
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        String itemCategoryID = "";
        if (itemCategoryObjectList.size() > 0) {
            itemCategoryID = itemCategoryObjectList.get(0).getItemCategoryID();
        }
        itemDetail itemDetailObjectTemp = new itemDetail();
        itemDetailObjectTemp.setItemCategoryID(itemCategoryID);
        
        contactDetails contactDetailsObject = new contactDetails();
        List<contactDetails> customerList = manageOrderService.getContactDetailsList(contactDetailsObject);
        List<itemDetail> itemList = itemDetService.getItemDetailList(itemDetailObjectTemp);
        
        itemCategory itemCategoryTemp = new itemCategory();
        itemCategoryTemp.setItemCategoryID(itemCategoryID);
        List<itemCategory> itemOptionLst = itemCategoryService.getItemOptionListByItemCategory(itemCategoryTemp);
        
        Map<String, String> customerReference = new LinkedHashMap<String, String>();
        customerReference.put("", "Please Select");
        for (int i = 0; i < customerList.size(); i++) {
            customerReference.put(customerList.get(i).getCustomerID(), customerList.get(i).getCustomerName());
        }
        
        Map<String, String> itemReference = new LinkedHashMap<String, String>();
        itemReference.put("", "Please Select");
        for (int i = 0; i < itemList.size(); i++) {
            itemReference.put(itemList.get(i).getItemDetailID(), itemList.get(i).getItemName() + " - " + itemList.get(i).getItemDescription());
        }
        
        Map<String, String> itemOptionReference = new LinkedHashMap<String, String>();
        itemOptionReference.put("", "Please Select");
        itemOptionReference.put("0", "Other Option");
        for (int i = 0; i < itemOptionLst.size(); i++) {
            itemOptionReference.put(itemOptionLst.get(i).getItemOptionID(), itemOptionLst.get(i).getItemOptionName());
        }
        
        saleOrder saleOrderObject = new saleOrder();
        
        
        saleOrderObject.setOrderTripID(orderTripID);
        saleOrderObject.setItemCategory(itemCategoryID);
        saleOrderObject.setCustomerID(customerID);
        
        contactDetailsObject.setCustomerID(customerID);
        contactDetails customerDetail = manageOrderService.getContactDetails(contactDetailsObject);
        
        List<saleOrder> saleOrderObjectList = itemOrderService.getOrderListByCustomerID(saleOrderObject);
        saleOrderObject.setSaleOrderListing(saleOrderObjectList);
        saleOrderObject.setIsPayFlag("N");
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("choosenOrderID", orderTripID);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("customerList", customerReference);
        model.addAttribute("itemOptionList", itemOptionReference);
        model.addAttribute("itemList", itemReference);
        model.addAttribute("itemDetailList", itemList);
        model.addAttribute("saleOrderObject", saleOrderObject);

        model.addAttribute("customerDetail", customerDetail);

        return "orderUpdate";
        
    }
    @RequestMapping(value = "/updateSaleOrder", method = RequestMethod.POST)
    public ModelAndView updateSaleOrder(@ModelAttribute("saleOrderObject") saleOrder saleOrder, Model model, HttpServletRequest req) {
        
        try{
        for (int i = 0; i < saleOrder.getSaleOrderListing().size(); i++) {
            
            saleOrder saleOrderTemp = new saleOrder();
            
            String isPayFlag = saleOrder.getIsPayFlag();
            
            saleOrderTemp = saleOrder.getSaleOrderListing().get(i);
            if ("" != saleOrderTemp.getCustomerID()) {
                System.out.println("check with here " + saleOrder.getSaleOrderListing().get(i).getItemID());
                
                if("Y".equals(saleOrderTemp.getDeleteFlag())){
                if("N".equals(isPayFlag)){
                itemOrderService.deleteOrder(saleOrderTemp);
                }
                else{
                    itemOrderService.deletePaidOrder(saleOrderTemp);
                }
                }
                else{
                if("N".equals(isPayFlag)){
                itemOrderService.updateOrder(saleOrderTemp);
                }
                else{
                    itemOrderService.updatePaidOrder(saleOrderTemp);
                }
                }
                
            }
        }
        
        model.addAttribute("itemCategoryID", saleOrder.getItemCategory());
        model.addAttribute("choosenOrderID", saleOrder.getOrderTripID());
        }
        catch(Exception a){
            return new ModelAndView("redirect:/viewCustomerReport?result=N");
        }
        return new ModelAndView("redirect:/viewCustomerReport?result=Y");
        
    }
    
    @RequestMapping(value = "/viewReportAnalysis", method = RequestMethod.GET)
    public String viewReportAnalysis(Model model, HttpServletRequest req) {   
        
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        List<saleOrder> reportObjectList = itemOrderService.getItemCategoryReport(orderTrip);
        
        List<saleOrder> reportObjectListPrice = itemOrderService.getItemCategoryPriceReport(orderTrip);
        
//        List<saleOrder> unPayReportObjectList = itemOrderService.getUnPayItemCategoryReport(orderTrip);
        
 //       List<saleOrder> unPayReportObjectListPrice = itemOrderService.getUnPayItemCategoryPriceReport(orderTrip);
        
        
        int totalQuantity = 0;
        double totalPrice = 0;
        
        for(int i = 0;i<reportObjectList.size();i++){
           
            totalQuantity += reportObjectList.get(i).getItemQuantity();
            
        }
        
        for(int i = 0;i<reportObjectListPrice.size();i++){
           
            totalPrice += reportObjectListPrice.get(i).getTotalPrice();
            
        }
        
        model.addAttribute("reportObjectList", reportObjectList);
        model.addAttribute("reportObjectList1", reportObjectListPrice);
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("totalQuantity", totalQuantity);
        model.addAttribute("totalPrice", totalPrice);
        
        return "viewReportAnalysis";   

    }
    
    
    @RequestMapping(value = "/viewItemReportAnalysis", method = RequestMethod.GET)
    public String viewItemReportAnalysis(Model model, HttpServletRequest req) {   
        
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTrip.getOrderTripID());
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        String choosenItemCategoryID = "";
        if(itemCategoryObjectList.size() > 0){
            choosenItemCategoryID = itemCategoryObjectList.get(0).getItemCategoryID();
        }
        saleOrder itemOrderObject = new saleOrder();
        itemOrderObject.setItemCategory(choosenItemCategoryID);
        List<saleOrder> itemOrderObjectList = itemOrderService.getItemReport(itemOrderObject);
//        List<saleOrder> unPaytemOrderObjectList = itemOrderService.getUnPayItemReport(itemOrderObject);

        
        for(int i = 0;i < itemOrderObjectList.size();i++){
            
            itemOrderObjectList.get(i).setItemCodeDescription(itemOrderObjectList.get(i).getItemName()+ " - " + itemOrderObjectList.get(i).getItemDescription());

        }
        
        
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("choosenItemCategoryID", choosenItemCategoryID);
        model.addAttribute("itemOrderObjectList", itemOrderObjectList);
        return "viewItemReportAnalysis";   

    }
    
    @RequestMapping(value = "/getItemReport", method = RequestMethod.GET)
    public String getItemReport(Model model, HttpServletRequest req) {   
        
        
        String itemCategory = req.getParameter("itemCategoryID");
        
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTrip.getOrderTripID());
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);

       saleOrder itemOrderObject = new saleOrder();
       
       itemOrderObject.setItemCategory(itemCategory);
        List<saleOrder> itemOrderObjectList = itemOrderService.getItemReport(itemOrderObject);
//        List<saleOrder> unPaytemOrderObjectList = itemOrderService.getUnPayItemReport(itemOrderObject);
        
        
        for(int i = 0;i < itemOrderObjectList.size();i++){
            
            itemOrderObjectList.get(i).setItemCodeDescription(itemOrderObjectList.get(i).getItemName()+ " - " + itemOrderObjectList.get(i).getItemDescription());

        }
        
        
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        model.addAttribute("choosenItemCategoryID", itemCategory);
        
        model.addAttribute("itemOrderObjectList", itemOrderObjectList);
        return "viewItemReportAnalysis";   

    }
    
    
    @RequestMapping(value = "/downloadPayReceiptPDF")
    public void downloadPayReceiptPDF(@ModelAttribute("saleOrderObject") saleOrder saleOrder, HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date todayDate = new Date();

        List<saleOrder> saleOrderList = itemOrderService.getPaidOrderListByCustomerID(saleOrder);
        
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();

        final ServletContext servletContext = request.getSession().getServletContext();
        final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        final String temperotyFilePath = tempDirectory.getAbsolutePath();


        
        contactDetails customerObject = new contactDetails();
        customerObject.setCustomerID(saleOrder.getCustomerID());
        customerObject = manageOrderService.getContactDetails(customerObject);
        customerObject.setCurrentTripID(orderTrip.getOrderTripID());
        customerObject.setCurrentTripDescription(orderTrip.getOrderTripDescription());
        
        String fileName = "Valuesource_"+customerObject.getCustomerID()+"_" + date.format(todayDate) + ".pdf";
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        
        double totalPrice = 0;
        
        for(int i = 0;i<saleOrderList.size();i++){
            totalPrice += saleOrderList.get(i).getTotalPrice();
        }
        
        customerObject.setTotalAmountNeedToPay(totalPrice);
        
        try {

            itemOrderService.downloadPDF(customerObject, saleOrderList, temperotyFilePath + "\\" + fileName, saleOrder );
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
    
    @RequestMapping(value = "/downloadUnPayReceiptPDF")
    public void downloadUnPayReceiptPDF(@ModelAttribute("saleOrderObject") saleOrder saleOrder, HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date todayDate = new Date();

        List<saleOrder> saleOrderList = itemOrderService.getOrderListByCustomerID(saleOrder);
        
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();

        final ServletContext servletContext = request.getSession().getServletContext();
        final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        final String temperotyFilePath = tempDirectory.getAbsolutePath();


        
        contactDetails customerObject = new contactDetails();
        customerObject.setCustomerID(saleOrder.getCustomerID());
        customerObject = manageOrderService.getContactDetails(customerObject);
        customerObject.setCurrentTripID(orderTrip.getOrderTripID());
        customerObject.setCurrentTripDescription(orderTrip.getOrderTripDescription());
        
        String fileName = "Valuesource_"+customerObject.getCustomerID()+"_" + date.format(todayDate) + ".pdf";
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        
        double totalPrice = 0;
        
        for(int i = 0;i<saleOrderList.size();i++){
            totalPrice += saleOrderList.get(i).getTotalPrice();
        }
        
        customerObject.setTotalAmountNeedToPay(totalPrice);
        
        try {

            itemOrderService.downloadPDF(customerObject, saleOrderList, temperotyFilePath + "\\" + fileName,saleOrder);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
    
   private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

        InputStream inputStream = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {

            inputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];
            baos = new ByteArrayOutputStream();

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos;
    }
}
