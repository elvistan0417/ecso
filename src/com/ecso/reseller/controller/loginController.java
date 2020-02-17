/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.controller;

import com.ecso.reseller.model.UserAuthority;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.itemCategory;
import com.ecso.reseller.model.itemDetail;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.service.itemCategoryService;
import com.ecso.reseller.service.itemDetailService;
import com.ecso.reseller.service.itemOrderService;
import com.ecso.reseller.service.manageOrderService;
import java.security.Principal;
import java.util.List;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author jiasingtan
 */
@Controller
public class loginController {

    	@Autowired
	itemCategoryService itemCateService;

    	@Autowired
	itemDetailService itemDetService;
        
	@Autowired
	ServletContext context;

        @Autowired
        itemOrderService itemOrderService;
        
        @Autowired
        manageOrderService manageOrderService;
	@RequestMapping("/home")
	public String loginHome(Model model, Principal principal){
            
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserAuthority currentUser = (UserAuthority) auth.getPrincipal();
//     
//		List <itemCategory> itemCateList = itemCateService.getAllItemCategory();
//                model.addAttribute("itemCateList", itemCateList);
//                
//                List <itemDetail> promoteItemDetailList = itemDetService.getPromoteItemList();
//                List<saleOrder> pendingOrderItemList = itemOrderService.getPendingOrderItemList(currentUser.getUserID(),"P");
//                List <itemDetail> hotItemDetailList = itemDetService.getPromoteItemListByType(promoteItemDetailList, "H");
//                List <itemDetail> latestItemDetailList = itemDetService.getPromoteItemListByType(promoteItemDetailList, "L");
//                
//                System.out.println("pendingOrderItemList " + pendingOrderItemList.size());
//                 model.addAttribute("hotItemList", hotItemDetailList);
//                 model.addAttribute("latestItemList", latestItemDetailList);
//                 model.addAttribute("itemPendingOder", pendingOrderItemList);
                return "home";
                
	}    
        
	@RequestMapping("/")
	public String defaulHome(Model model){
            
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserAuthority currentUser = (UserAuthority) auth.getPrincipal();
//		List <itemCategory> itemCateList = itemCateService.getAllItemCategory();
//                model.addAttribute("itemCateList", itemCateList);
//                
//                List <itemDetail> promoteItemDetailList = itemDetService.getPromoteItemList();
//                
//                List <itemDetail> hotItemDetailList = itemDetService.getPromoteItemListByType(promoteItemDetailList, "H");
//                List <itemDetail> latestItemDetailList = itemDetService.getPromoteItemListByType(promoteItemDetailList, "L");
//                List<saleOrder> pendingOrderItemList = itemOrderService.getPendingOrderItemList(currentUser.getUserID(),"P");
//                 model.addAttribute("hotItemList", hotItemDetailList);
//                 model.addAttribute("latestItemList", latestItemDetailList);
//                  model.addAttribute("itemPendingOder", pendingOrderItemList);
                return "home";
                
	}           
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String displayLogin(HttpServletRequest request, HttpServletResponse response) {
//		return "login";
//	}

	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView executeLogin(@RequestParam(required=false) String authfailed, String logout, String denided, HttpServletRequest request, HttpServletResponse response) {
		//logger.info("login page");
		String message = "";
		
		if(authfailed!=null){
			message = "Invalid username or password!";
		}else if(logout!=null){
			message = "Logged out successfully";
		}else if(denided!=null){
			message = "Access denided!";
		}
		
		return new ModelAndView("login", "message", message);
		
	}
        
        
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String viewItemDetail(Model model, HttpServletRequest req) {
        
        String result = req.getParameter("result");
        contactDetails contactDetailsObject = new contactDetails();
         List<contactDetails> contactDetailsObjectList = manageOrderService.getContactDetailsList(contactDetailsObject);


        model.addAttribute("contactDetailsObjectList", contactDetailsObjectList);
        model.addAttribute("result", result);
        return "customer";

    }   
    
    @RequestMapping(value = "/viewInsertCustomer", method = RequestMethod.GET)
    public String viewInsertCustomer(Model model, HttpServletRequest req) {
        contactDetails contactDetailsObject = new contactDetails();

        model.addAttribute("contactDetailsForm", contactDetailsObject);

        return "customerInsert";

    }  

      @RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
    public ModelAndView insertItem(@ModelAttribute("contactDetailsForm") contactDetails contactDetailsForm, Model model, HttpServletRequest req) {
        
        try{
        for(int i = 0; i < contactDetailsForm.getContactDetailsList().size();i++){
            contactDetails contactDetailsObject = new contactDetails();
            contactDetailsObject = contactDetailsForm.getContactDetailsList().get(i);
            
            manageOrderService.insertContactDetails(contactDetailsObject);
        }
        

        contactDetails contactDetailsObject = new contactDetails();
        List<contactDetails> contactDetailsObjectList = manageOrderService.getContactDetailsList(contactDetailsObject);
        model.addAttribute("contactDetailsObjectList", contactDetailsObjectList);
        }
        catch(Exception a){
            return new ModelAndView("redirect:/customer?result=Y");
        }
        return new ModelAndView("redirect:/customer?result=Y");

    }
    

    @RequestMapping(value = "/viewCustomerDetail", method = RequestMethod.GET)
    public String viewCustomerDetail(Model model, HttpServletRequest req) {
        
        String customerID = req.getParameter("customerID");
        String result = req.getParameter("result");
        saleOrder orderTrip = manageOrderService.getCurrentOrderTrip();
        
        
        contactDetails contactDetailsObject = new contactDetails();
        
        contactDetailsObject.setCustomerID(customerID);
        orderTrip.setCustomerID(customerID);
        
        contactDetailsObject = manageOrderService.getContactDetails(contactDetailsObject);
        
        List<saleOrder> unPaySaleOrderObjectList = itemOrderService.getSummaryCustomerUnpayByCustomerID(orderTrip);
        
        List<saleOrder> paidSaleOrderObjectList = itemOrderService.getSummaryCustomerPaidByCustomerID(orderTrip);
        
        model.addAttribute("unPaySaleOrderObjectList", unPaySaleOrderObjectList);
        model.addAttribute("paidSaleOrderObjectList", paidSaleOrderObjectList);
        
        model.addAttribute("currentTripDescription",orderTrip.getOrderTripDescription());

        model.addAttribute("contactDetailsObject", contactDetailsObject);
        model.addAttribute("result", result);
        return "customerDetail";

    } 
    
    
    @RequestMapping(value = "/viewCustomerUpdate", method = RequestMethod.GET)
    public String viewCustomerUpdate(Model model, HttpServletRequest req) {
        
        String customerID = req.getParameter("customerID");
        
        
        contactDetails contactDetailsObject = new contactDetails();
        
        contactDetailsObject.setCustomerID(customerID);
        
        contactDetailsObject = manageOrderService.getContactDetails(contactDetailsObject);

        model.addAttribute("contactDetailsForm", contactDetailsObject);

        return "customerUpdate";

    } 
    
      @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@ModelAttribute("contactDetailsForm") contactDetails contactDetailsForm, Model model, HttpServletRequest req) {
        

            try{
        manageOrderService.updateContactDetails(contactDetailsForm);


        contactDetails contactDetailsObject = contactDetailsForm;
        
        
        contactDetailsObject = manageOrderService.getContactDetails(contactDetailsObject);

        model.addAttribute("contactDetailsObject", contactDetailsObject);

        }
        catch(Exception e){
             return new ModelAndView("redirect:/viewCustomerDetail?customerID=" + contactDetailsForm.getCustomerID() + "&result=N");
        }

         return new ModelAndView("redirect:/viewCustomerDetail?customerID=" + contactDetailsForm.getCustomerID() + "&result=Y");

        

    }
    
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(Model model, HttpServletRequest req) {
        
        String customerID = req.getParameter("customerID");
        
        try{
        contactDetails contactDetailsObject = new contactDetails();
        
        contactDetailsObject.setCustomerID(customerID);
        
        manageOrderService.deleteContactDetails(contactDetailsObject);

        saleOrder saleOrderObject = new saleOrder();
        
        saleOrderObject.setCustomerID(customerID);
        
        itemOrderService.deleteOrderByCustomerID(saleOrderObject);
        itemOrderService.deletePaidOrderByCustomerID(saleOrderObject);

         List<contactDetails> contactDetailsObjectList = manageOrderService.getContactDetailsList(contactDetailsObject);


        model.addAttribute("contactDetailsObjectList", contactDetailsObjectList);
        }
        catch(Exception e){
             return new ModelAndView("redirect:/customer?result=N");
        }

         return new ModelAndView("redirect:/customer?result=Y");


    } 
    
}
