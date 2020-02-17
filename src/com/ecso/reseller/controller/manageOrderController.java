/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.controller;

import com.ecso.reseller.model.UserAuthority;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.model.saleOrderForm;
import com.ecso.reseller.service.itemCategoryService;
import com.ecso.reseller.service.itemOrderService;
import com.ecso.reseller.service.manageOrderService;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ecso.reseller.model.itemCategory;
import com.ecso.reseller.model.itemDetail;
import com.ecso.reseller.service.itemDetailService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author jiasingtan
 */
@Controller
public class manageOrderController {
    
    @Autowired
    manageOrderService manageOrderService;
    
    saleOrderForm orderForm;
    
    saleOrder saleOrder;
    
    itemDetail itemDetail;
    
    itemCategory itemCategoryForm;
    
    @Autowired
    itemOrderService itemOrderService;    
    
        @Autowired
    itemCategoryService itemCategoryService;   
    
    @Autowired
    itemDetailService itemDetailService;
    
    
   @RequestMapping(value = "/orderTrip", method = RequestMethod.GET)
    public String viewTripCategory(Model model, HttpServletRequest req) {
        
        String result = req.getParameter("result");
        
        List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        saleOrder = new saleOrder();

        model.addAttribute("saleOrderForm", saleOrder);
        model.addAttribute("orderTripList", orderTripList);
        model.addAttribute("result", result);
        return "orderTrip";

    }
    
   @RequestMapping(value = "/insertOrderTrip", method = RequestMethod.POST)
    public ModelAndView insertOrderTrip(@ModelAttribute("orderForm") saleOrder saleOrder, Model model, HttpServletRequest req) {
        
        try{
        manageOrderService.insertOrderTrip(saleOrder);
        
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        
        saleOrder = new saleOrder();

        model.addAttribute("saleOrderForm", saleOrder);
        model.addAttribute("orderTripList", orderTripList);
        }
        catch(Exception a){
            return new ModelAndView("redirect:/orderTrip?result=N");
        }
        return new ModelAndView("redirect:/orderTrip?result=Y");

    }
    
    @RequestMapping(value = "/deleteOrderTrip", method = RequestMethod.GET)
    public ModelAndView deleteOrderTrip(Model model, HttpServletRequest req) {
        
        String orderTripID = req.getParameter("orderTripID");
        
        try{
        saleOrder deleteOrderTrip = new saleOrder();
        
        deleteOrderTrip.setOrderTripID(orderTripID);
        
        
        manageOrderService.deleteOrderByOrderTrip(deleteOrderTrip);
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
        for(int i = 0;i < itemCategoryObjectList.size();i++){
          saleOrder deleteOrderTripTemp = new saleOrder();
          deleteOrderTripTemp.setItemCategory(itemCategoryObjectList.get(i).getItemCategoryID());
          manageOrderService.deleteItemByItemCategory(deleteOrderTripTemp);
          manageOrderService.deleteItemOptionByItemCategory(deleteOrderTripTemp);
        }
        
        manageOrderService.deleteOrderTrip(deleteOrderTrip);
        
        
        List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        
        saleOrder = new saleOrder();

        model.addAttribute("saleOrderForm", saleOrder);
        model.addAttribute("orderTripList", orderTripList);
        }
        catch(Exception a){
            return new ModelAndView("redirect:/orderTrip?result=N");
        }
        return new ModelAndView("redirect:/orderTrip?result=Y");

    }

    @RequestMapping(value = "/setCurrentTrip", method = RequestMethod.GET)
    public ModelAndView setCurrentTrip(Model model, HttpServletRequest req) {
        
        String orderTripID = req.getParameter("orderTripID");
        try{
        saleOrder orderTripObject = new saleOrder();
        
        orderTripObject.setOrderTripID(orderTripID);
        
        manageOrderService.updateOrderTripCurrentY(orderTripObject);
        manageOrderService.updateOrderTripCurrentN(orderTripObject);
        
        List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        
        saleOrder = new saleOrder();

        model.addAttribute("saleOrderForm", saleOrder);
        model.addAttribute("orderTripList", orderTripList);
    }
        catch(Exception a){
            return new ModelAndView("redirect:/orderTrip?result=N");
        }
        return new ModelAndView("redirect:/orderTrip?result=Y");

    }    
    
    
    @RequestMapping(value = "/viewUpdateOrderTrip", method = RequestMethod.GET)
    public String viewUpdateOrderTrip(Model model, HttpServletRequest req) {
        
        String orderTripID = req.getParameter("orderTripID");
        
        saleOrder viewOrderTrip = new saleOrder();
        
        viewOrderTrip.setOrderTripID(orderTripID);
        
        saleOrder = manageOrderService.getOrderTrip(viewOrderTrip);

        model.addAttribute("saleOrderForm", saleOrder);

        return "updateOrderTrip";
    }
    
   @RequestMapping(value = "/updateOrderTrip", method = RequestMethod.POST)
    public ModelAndView updateOrderTrip(@ModelAttribute("orderForm") saleOrder saleOrder, Model model, HttpServletRequest req) {
        
       try{
        manageOrderService.updateOrderTrip(saleOrder);
        
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        
        saleOrder = new saleOrder();

        model.addAttribute("saleOrderForm", saleOrder);
        model.addAttribute("orderTripList", orderTripList);
       }
                catch(Exception a){
            return new ModelAndView("redirect:/orderTrip?result=N");
        }
        return new ModelAndView("redirect:/orderTrip?result=Y");



    }
    
   @RequestMapping(value = "/itemCategory", method = RequestMethod.GET)
    public String itemCategory(Model model, HttpServletRequest req) {
        

                String result = req.getParameter("result");
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();

         
        itemCategory itemCategoryObject = new itemCategory();
                
        itemCategoryObject.setOrderTripID(orderTripList.get(0).getOrderTripID());
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
        String orderID = "";
        if(orderTripList.size() > 0){
            orderID = orderTripList.get(0).getOrderTripID();
        }
   
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripList", orderTripList);
        model.addAttribute("choosenOrderID", orderID);
model.addAttribute("result", result);
        return "itemCategory";

    }
    
    
   @RequestMapping(value = "/viewInsertItemCategory", method = RequestMethod.GET)
    public String viewInsertItemCategory(Model model, HttpServletRequest req) {
        String orderTripID = req.getParameter("orderTripID");
//        List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        saleOrder tempOrderTripObject = new saleOrder();
        tempOrderTripObject.setOrderTripID(orderTripID);
        System.out.println("check tempOrderTripOnject " + tempOrderTripObject.getOrderTripID());
        saleOrder orderTripObject = manageOrderService.getOrderTrip(tempOrderTripObject);
        itemCategoryForm = new itemCategory();
        itemCategoryForm.setOrderTripID(orderTripID);
//        Map referenceData = new HashMap();
//        Map<String, String> orderTripReferenceList = new LinkedHashMap<String, String>();
//
//        for (int i = 0; i < orderTripList.size(); i++) {
//            orderTripReferenceList.put(orderTripList.get(i).getOrderTripID(), orderTripList.get(i).getOrderTripDescription());
//        }
//        
        
        model.addAttribute("itemCategoryForm", itemCategoryForm);
        model.addAttribute("orderTripDescription", orderTripObject.getOrderTripDescription());
//        model.addAttribute("orderTripList", orderTripReferenceList);
        return "viewInsertItemCategory";

    }
    
   @RequestMapping(value = "/insertItemCategory", method = RequestMethod.POST)
    public String insertItemCategory(@ModelAttribute("itemCategoryForm") itemCategory itemCategoryForm, Model model, HttpServletRequest req) {
        
       
        String itemCategoryID = itemCategoryService.insertItemCategory(itemCategoryForm);
        
        System.out.print("item Category ID = " + itemCategoryID);
        
        itemCategoryForm.setItemCategoryID(itemCategoryID);
        model.addAttribute("itemCategoryForm", itemCategoryForm);
        model.addAttribute("itemCategoryName", itemCategoryForm.getItemCategoryName());
        return "itemCategoryOption";

    }
    
   @RequestMapping(value = "/listItemCategory",  method = RequestMethod.GET)
    public String listItemCategory(Model model, HttpServletRequest req) {        
       
        String orderTripID = req.getParameter("orderTripID");
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
         
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripList", orderTripList);
        model.addAttribute("choosenOrderID", orderTripID);
        
        return "itemCategory";

    }

   @RequestMapping(value = "/viewItemCategoryOption", method = RequestMethod.POST)
    public String viewItemCategoryOption(@ModelAttribute("itemCategoryForm") itemCategory itemCategoryForm, Model model, HttpServletRequest req) {
        
        itemCategoryForm = new itemCategory();
       model.addAttribute("itemCategoryForm", itemCategoryForm);
        return "itemCategoryOption";

    }  
    
   @RequestMapping(value = "/insertItemCategoryOption", method = RequestMethod.POST)
    public ModelAndView insertItemCategoryOption(@ModelAttribute("itemCategoryForm") itemCategory itemCategoryForm, Model model, HttpServletRequest req) {
        
        try{
        for(int i = 0; i < itemCategoryForm.getItemOptionList().size();i++){
            System.out.println("Check input List " + itemCategoryForm.getItemOptionList().get(i).getItemOptionName() );
            itemCategory itemOptionObject = new itemCategory();
            itemOptionObject.setItemOptionName(itemCategoryForm.getItemOptionList().get(i).getItemOptionName());
            itemOptionObject.setItemCategoryID(itemCategoryForm.getItemCategoryID());
            itemCategoryService.insertItemOption(itemOptionObject);
        }
        
        

        
        itemCategory itemCategoryObject = itemCategoryService.getItemCategory(itemCategoryForm);
        
        
        saleOrder saleOrderObject = new saleOrder();
        
        saleOrderObject.setOrderTripID(itemCategoryObject.getOrderTripID());
        
        saleOrder orderTripObject = manageOrderService.getOrderTrip(saleOrderObject);
        
        List<itemCategory> itemOptionList = itemCategoryService.getItemOptionListByItemCategory(itemCategoryForm);
        model.addAttribute("itemOptionList", itemOptionList);
        model.addAttribute("itemCategoryName", itemCategoryObject.getItemCategoryName());
        model.addAttribute("orderTripDescription", orderTripObject.getOrderTripDescription());
        model.addAttribute("itemCategoryID", itemCategoryObject.getItemCategoryID());
        }
        catch(Exception a){
            return new ModelAndView("redirect:/viewItemCategoryDetail?result=Y");
        }
        
        return new ModelAndView("redirect:/viewItemCategoryDetail?result=Y");

    }
    
    
   @RequestMapping(value = "/viewItemCategoryDetail", method = RequestMethod.GET)
    public String viewItemCategoryDetail(Model model, HttpServletRequest req) {        

        String itemCategoryID = req.getParameter("itemCategoryID");
        String result = req.getParameter("result");
        itemCategoryForm = new itemCategory();
        
        itemCategoryForm.setItemCategoryID(itemCategoryID);
        
        itemCategory itemCategoryObject = itemCategoryService.getItemCategory(itemCategoryForm);
        
        saleOrder saleOrderObject = new saleOrder();
        
        saleOrderObject.setOrderTripID(itemCategoryObject.getOrderTripID());
        
        saleOrder orderTripObject = manageOrderService.getOrderTrip(saleOrderObject);
        
        List<itemCategory> itemOptionList = itemCategoryService.getItemOptionListByItemCategory(itemCategoryForm);
        model.addAttribute("itemOptionList", itemOptionList);
        model.addAttribute("itemCategoryName", itemCategoryObject.getItemCategoryName());
        model.addAttribute("itemCategoryID", itemCategoryObject.getItemCategoryID());
        model.addAttribute("orderTripDescription", orderTripObject.getOrderTripDescription());
        model.addAttribute("result", result);
        return "itemCategoryDetail";

    }
    
    
   @RequestMapping(value = "/insertExstingItemOption", method = RequestMethod.GET)
    public String insertExstingItemOption(Model model, HttpServletRequest req) {
        
       String itemCategoryID = req.getParameter("itemCategoryID");
       String itemCategoryName = req.getParameter("itemCategoryName");
        

        itemCategoryForm = new itemCategory();
        itemCategoryForm.setItemCategoryID(itemCategoryID);
        itemCategoryForm.setItemCategoryName(itemCategoryName);
        model.addAttribute("itemCategoryForm", itemCategoryForm);
        model.addAttribute("itemCategoryName", itemCategoryForm.getItemCategoryName());
        return "itemCategoryOption";

    }
    
    
    @RequestMapping(value = "/viewUpdateItemCategoryDetail", method = RequestMethod.GET)
    public String viewUpdateItemCategoryDetail(Model model, HttpServletRequest req) {
        
        String itemCategoryID = req.getParameter("itemCategoryID");
        
        itemCategory tempItemCategoryObject = new itemCategory();
        
        tempItemCategoryObject.setItemCategoryID(itemCategoryID);
        
        itemCategory itemCategoryObject = itemCategoryService.getItemCategory(tempItemCategoryObject);
        
        List<itemCategory> itemOptionList = itemCategoryService.getItemOptionListByItemCategory(tempItemCategoryObject);
        
        itemCategoryObject.setItemOptionList(itemOptionList);
        
        model.addAttribute("itemCategoryForm", itemCategoryObject);

        return "itemCategoryDetailUpdate";
    }
    
    
   @RequestMapping(value = "/updateItemCategory", method = RequestMethod.POST)
    public ModelAndView updateItemCategory(@ModelAttribute("itemCategoryForm") itemCategory itemCategoryForm, Model model, HttpServletRequest req) {

            try{
        String itemCategoryID = itemCategoryForm.getItemCategoryID();
        System.out.println("check category ID " + itemCategoryForm.getItemCategoryID());
        System.out.println("check category Name " + itemCategoryForm.getItemCategoryName());
        System.out.println("check category size " + itemCategoryForm.getItemOptionList().size());
        for(int i = 0;i < itemCategoryForm.getItemOptionList().size();i++){
            System.out.println("check with item category flag " + itemCategoryForm.getItemOptionList().get(i).getItemOptionDeleteFlag());
            System.out.println("check with item option name " + itemCategoryForm.getItemOptionList().get(i).getItemOptionName());
System.out.println("check with item option ID " + itemCategoryForm.getItemOptionList().get(i).getItemOptionID());
        }
//        
        itemCategoryService.updateItemOption(itemCategoryForm);
        
        itemCategoryForm = new itemCategory();
        
        itemCategoryForm.setItemCategoryID(itemCategoryID);
        
        itemCategory itemCategoryObject = itemCategoryService.getItemCategory(itemCategoryForm);
        
        saleOrder saleOrderObject = new saleOrder();
        
        saleOrderObject.setOrderTripID(itemCategoryObject.getOrderTripID());
        
        saleOrder orderTripObject = manageOrderService.getOrderTrip(saleOrderObject);
        
        List<itemCategory> itemOptionList = itemCategoryService.getItemOptionListByItemCategory(itemCategoryForm);
            

        model.addAttribute("itemOptionList", itemOptionList);
        model.addAttribute("itemCategoryName", itemCategoryObject.getItemCategoryName());
        model.addAttribute("itemCategoryID", itemCategoryObject.getItemCategoryID());
        model.addAttribute("orderTripDescription", orderTripObject.getOrderTripDescription());
            }
           catch(Exception a){
              return new ModelAndView("redirect:/viewItemCategoryDetail?result=Y");  
            }
        return new ModelAndView("redirect:/viewItemCategoryDetail?result=Y");

    }
    
    
   @RequestMapping(value = "/deleteItemCategory", method = RequestMethod.GET)
    public ModelAndView deleteItemCategory(Model model, HttpServletRequest req) {
        try{
       String itemCategoryID = req.getParameter("itemCategoryID");
       itemCategory itemCategoryObject = new itemCategory();
       itemCategoryObject.setItemCategoryID(itemCategoryID);
        itemCategoryService.deleteItemCategory(itemCategoryForm);
        
        itemCategoryService.deleteItemOptionByCategoryID(itemCategoryObject);
        
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();

         
        itemCategoryObject = new itemCategory();
        
        System.out.println("item Category ID from list of item category " + orderTripList.get(0).getOrderTripID());
        
        itemCategoryObject.setOrderTripID(orderTripList.get(0).getOrderTripID());
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);

   
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripList", orderTripList);
        model.addAttribute("choosenOrderID", orderTripList.get(0).getOrderTripID());

            }
           catch(Exception a){
              return new ModelAndView("redirect:/itemCategory?result=Y");  
            }
        return new ModelAndView("redirect:/itemCategory?result=Y");

    }
    
   @RequestMapping(value = "/itemDetail", method = RequestMethod.GET)
    public String viewItemDetail(Model model, HttpServletRequest req) {
        
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        String orderTripID = orderTripList.get(0).getOrderTripID();
        
                itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        String itemCategoryID = "";
        if(itemCategoryObjectList.size() > 0){
         itemCategoryID = itemCategoryObjectList.get(0).getItemCategoryID();
        }
        itemDetail itemDetailObjectTemp = new itemDetail();
        itemDetailObjectTemp.setItemCategoryID(itemCategoryID);
        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailObjectTemp);
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripList", orderTripList);
        model.addAttribute("choosenOrderID", orderTripID);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("itemDetailList", itemDetailList);
        return "itemDetail";

    }    
    
   @RequestMapping(value = "/getItemCategory",  method = RequestMethod.GET)
    public String getItemCategory(Model model, HttpServletRequest req) {        
       
        String orderTripID = req.getParameter("orderTripID");
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setOrderTripID(orderTripID);
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();
        String itemCategoryID = "";
        if(itemCategoryObjectList.size() > 0){
         itemCategoryID = itemCategoryObjectList.get(0).getItemCategoryID();
        }
        itemDetail itemDetailObjectTemp = new itemDetail();
        itemDetailObjectTemp.setItemCategoryID(itemCategoryID);
        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailObjectTemp);
        
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripList", orderTripList);
        model.addAttribute("choosenOrderID", orderTripID);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("itemDetailList", itemDetailList);
        return "itemDetail";

    }
    
   @RequestMapping(value = "/listItemDetail",  method = RequestMethod.GET)
    public String listItemDetail(Model model, HttpServletRequest req) {        
       
        String itemCategoryID = req.getParameter("itemCategoryID");
        
        itemDetail itemDetailObjectTemp = new itemDetail();
        itemDetailObjectTemp.setItemCategoryID(itemCategoryID);
        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailObjectTemp);
        
        
        itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setItemCategoryID(itemCategoryID);
        
        
        
        itemCategoryObject = itemCategoryService.getItemCategory(itemCategoryObject);
        
//        itemCategoryObject.setOrderTripID(orderTripID);
        List<itemCategory> itemCategoryObjectList = itemCategoryService.getItemCategoryByOrderId(itemCategoryObject);
        
         List<saleOrder> orderTripList = manageOrderService.getOrderTripList();

        
        model.addAttribute("itemCategoryObjectList", itemCategoryObjectList);
        model.addAttribute("orderTripList", orderTripList);
        model.addAttribute("choosenOrderID", itemCategoryObject.getOrderTripID());
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("itemDetailList", itemDetailList);
        return "itemDetail";

    }
    
    
   @RequestMapping(value = "/viewInsertItem", method = RequestMethod.GET)
    public String viewInsertItem(Model model, HttpServletRequest req) {
        
       String itemCategoryID = req.getParameter("itemCategoryID");
       
       itemCategory itemCategoryObject = new itemCategory();
        itemCategoryObject.setItemCategoryID(itemCategoryID);
        itemCategoryObject  = itemCategoryService.getItemCategory(itemCategoryObject);
       
       String itemCategoryName = req.getParameter("itemCategoryName");
        
        System.out.print("item Detail ID = " + itemCategoryID);
        itemDetail itemDetailForm = new itemDetail();
        itemDetailForm.setItemCategoryID(itemCategoryID);
//        itemDetailForm.setItemCategoryName(itemCategoryName);
        model.addAttribute("itemDetailForm", itemDetailForm);
        model.addAttribute("itemCategoryName", itemCategoryObject.getItemCategoryName());
        return "itemDetailInsert";

    }
    
    @RequestMapping(value = "/insertItemDetail", method = RequestMethod.POST)
    public ModelAndView insertItemDetail(@ModelAttribute("itemDetailID") itemDetail itemDetailForm, Model model, HttpServletRequest req) {
        
        
        try{
        for(int i =0;i<itemDetailForm.getItemDetailList().size();i++){
        itemDetail itemDetailTempObject = new itemDetail();
        
        itemDetailTempObject = itemDetailForm.getItemDetailList().get(i);
        itemDetailTempObject.setItemCategoryID(itemDetailForm.getItemCategoryID());
        
        itemDetailService.insertItemDetail(itemDetailTempObject);
        }
        
        
        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailForm);
        model.addAttribute("itemDetailList", itemDetailList);
        model.addAttribute("choosenItemCategoryID", itemDetailForm.getItemCategoryID());
        }
        catch(Exception a){
            return new ModelAndView("redirect:/viewItemDetailList?result=N&itemCategoryID="+itemDetailForm.getItemCategoryID()); 
        }
        return new ModelAndView("redirect:/viewItemDetailList?result=Y&itemCategoryID="+itemDetailForm.getItemCategoryID()); 
        

    }  
    
   @RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
    public ModelAndView deleteItem(Model model, HttpServletRequest req) {
        
       String itemID = req.getParameter("itemDetailID");
       String itemCategoryID = req.getParameter("itemCategoryID");
       
       try{
       itemDetail itemDetailObject = new itemDetail();
       itemDetailObject.setItemDetailID(itemID);
       
       itemDetailService.deleteItemDetail(itemDetailObject);
       
       
       
       itemDetailObject.setItemCategoryID(itemCategoryID);

        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailObject);
        model.addAttribute("itemDetailList", itemDetailList);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
       }
       catch(Exception a){
           return new ModelAndView("redirect:/viewItemDetailList?result=N&itemCategoryID="+itemCategoryID); 
       }
        
        return new ModelAndView("redirect:/viewItemDetailList?result=Y&itemCategoryID="+itemCategoryID); 

    }
    
    
   @RequestMapping(value = "/viewItemDetailUpdate", method = RequestMethod.GET)
    public String viewItemDetailUpdate(Model model, HttpServletRequest req) {
        
       String itemCategoryID = req.getParameter("itemCategoryID");

       itemDetail itemDetailObject = new itemDetail();

       
       itemDetailObject.setItemCategoryID(itemCategoryID);
       
       

        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailObject);
        model.addAttribute("itemDetailList", itemDetailList);
        itemDetailObject.setItemDetailList(itemDetailList);
        
        itemCategory itemCategoryObject = new itemCategory();
        
        itemCategoryObject.setItemCategoryID(itemCategoryID);
        
        itemCategoryObject = itemCategoryService.getItemCategory(itemCategoryObject);
        
        saleOrder  orderTrip = new saleOrder();
        orderTrip.setOrderTripID(itemCategoryObject.getOrderTripID());
                
         orderTrip =       manageOrderService.getOrderTrip(orderTrip);
        
        model.addAttribute("itemDetailForm", itemDetailObject);
        model.addAttribute("itemCategoryName", itemCategoryObject.getItemCategoryName());
        model.addAttribute("orderTripDescription", orderTrip.getOrderTripDescription());
        
        return "itemDetailUpdate";

    }
    
   @RequestMapping(value = "/viewItemDetailList", method = RequestMethod.GET)
    public String viewItemDetailList(Model model, HttpServletRequest req) {        
        
        String itemCategoryID = req.getParameter("itemCategoryID");
        String result = req.getParameter("result");
       itemDetail itemDetailObject = new itemDetail();

       
       itemDetailObject.setItemCategoryID(itemCategoryID);
        
        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailObject);
        model.addAttribute("itemDetailList", itemDetailList);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        model.addAttribute("result", result);
        return "itemDetailInsertResult";        
        

    } 
    
   @RequestMapping(value = "/updateItemDetail", method = RequestMethod.POST)
    public ModelAndView updateItemDetail(@ModelAttribute("itemDetailForm") itemDetail itemDetailForm, Model model, HttpServletRequest req) {

            
        String itemCategoryID = itemDetailForm.getItemCategoryID();
        try{
        System.out.println("check item Detail come in to update " + itemDetailForm.getItemDetailList().size());
        itemDetailService.updateItemDetail(itemDetailForm);
       itemDetail itemDetailObject = new itemDetail();

       
       itemDetailObject.setItemCategoryID(itemCategoryID);
        
        List<itemDetail> itemDetailList = itemDetailService.getItemDetailList(itemDetailObject);
        model.addAttribute("itemDetailList", itemDetailList);
        model.addAttribute("choosenItemCategoryID", itemCategoryID);
        }
        catch(Exception a){
            return new ModelAndView("redirect:/viewItemDetailList?result=N&itemCategoryID="+itemDetailForm.getItemCategoryID());
        }
        
        return new ModelAndView("redirect:/viewItemDetailList?result=Y&itemCategoryID="+itemDetailForm.getItemCategoryID()); 

    }
    

}
