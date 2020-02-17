/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecso.reseller.service.impl;

import com.ecso.reseller.dao.contactDetailsDao;
import com.ecso.reseller.dao.itemDetailDao;
import com.ecso.reseller.dao.itemOrderDao;
import com.ecso.reseller.model.contactDetails;
import com.ecso.reseller.model.itemDetail;
import com.ecso.reseller.model.saleOrder;
import com.ecso.reseller.model.saleOrderForm;
import com.ecso.reseller.service.itemOrderService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.round;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jiasingtan
 */
public class itemOrderServiceImpl implements itemOrderService {
    
    	@Autowired
	itemOrderDao itemOrderDao;
        
public static final String FONT = "ARIALUNI.TTF";


    @Override    
    public String insertOrder(saleOrder saleOrderObject){
        return itemOrderDao.insertOrder(saleOrderObject);
    }
    
    @Override
    public int updateOrder(saleOrder saleOrderObject){
        return itemOrderDao.updateOrder(saleOrderObject);
    }
    
    @Override
    public saleOrder getOrder(saleOrder saleOrderObject){
        return itemOrderDao.getOrder(saleOrderObject);
    }
    
    @Override
    public int deleteOrder(saleOrder saleOrderObject){
        return itemOrderDao.deleteOrder(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getOrderList(saleOrder saleOrderObject){
        return itemOrderDao.getOrderList(saleOrderObject);
    }
    
    @Override
    public String insertOrderService(saleOrder saleOrderObject){
        
        if(saleOrderObject.getItemActualAmount() != saleOrderObject.getItemTotalPrice()){
            saleOrderObject.setItemPriceEditFlag("Y");
        }
        else{
            saleOrderObject.setItemPriceEditFlag("N");
        }
        
        
        return itemOrderDao.insertOrder(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getOrderListByPayFlag(saleOrder saleOrderObject){
        return itemOrderDao.getOrderListByPayFlag(saleOrderObject);
    }
    
    @Override
    public String insertOrderPaid(final saleOrder saleOrderObject){
        return itemOrderDao.insertOrderPaid(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> searchOrderList(saleOrder saleOrderObject){
        return itemOrderDao.searchOrderList(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> searchPaidOrderList(saleOrder saleOrderObject){
        return itemOrderDao.searchPaidOrderList(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getSummaryCustomerUnpay(saleOrder saleOrderObject){
        return itemOrderDao.getSummaryCustomerUnpay(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getSummaryCustomerUnpayByCustomerID(saleOrder saleOrderObject){
        return itemOrderDao.getSummaryCustomerUnpayByCustomerID(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getSummaryCustomerPaidByCustomerID(saleOrder saleOrderObject){
        return itemOrderDao.getSummaryCustomerPaidByCustomerID(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getOrderListByCustomerID(saleOrder saleOrderObject){
        return itemOrderDao.getOrderListByCustomerID(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getPaidOrderListByCustomerID(saleOrder saleOrderObject){
        return itemOrderDao.getPaidOrderListByCustomerID(saleOrderObject);
    }
    
    @Override
    public saleOrder getPaidOrder(saleOrder saleOrderTemp){
        return itemOrderDao.getPaidOrder(saleOrderTemp);
    }
    
    @Override
    public int updatePaidOrder(saleOrder saleOrderObject){
        return itemOrderDao.updatePaidOrder(saleOrderObject);
    }
    
    @Override
    public int deletePaidOrder(saleOrder saleOrderObject){
        return itemOrderDao.deletePaidOrder(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getSummaryCustomerPay(saleOrder saleOrderObject){
        return itemOrderDao.getSummaryCustomerPay(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getItemCategoryReport(saleOrder saleOrderTemp){
        return itemOrderDao.getItemCategoryReport(saleOrderTemp);
    }
    
    @Override
    public List<saleOrder> getItemReport(saleOrder saleOrderObject){
        return itemOrderDao.getItemReport(saleOrderObject);
    }

    @Override
    public List<saleOrder> getUnPayItemReport(saleOrder saleOrderObject){
        return itemOrderDao.getUnpayItemReport(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getItemCategoryPriceReport(saleOrder saleOrderObject){
        return itemOrderDao.getItemCategoryPriceReport(saleOrderObject);
    }
    
    @Override
    public List<saleOrder> getSimpleOrderListByCustomerID(saleOrder saleOrderObject){
        return itemOrderDao.getSimpleOrderListByCustomerID(saleOrderObject);
    }
    
    private static void creteEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
  private static void createTable(contactDetails contactObject, List<saleOrder> reportObjectList, Document document) throws DocumentException {
        Paragraph paragraph = new Paragraph();
        Font font = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        creteEmptyLine(paragraph, 2);
        document.add(paragraph);
        PdfPTable table;

            table = new PdfPTable(8);

        PdfPCell c1 = new PdfPCell(new Phrase("#"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);


        c1 = new PdfPCell(new Phrase("Item"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);


        c1 = new PdfPCell(new Phrase("Item Price (RM)"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
        c1 = new PdfPCell(new Phrase("Item Option"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
       c1 = new PdfPCell(new Phrase("Option Remark"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

       c1 = new PdfPCell(new Phrase("Quantity"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
       c1 = new PdfPCell(new Phrase("Total Amount (RM)"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
       c1 = new PdfPCell(new Phrase("Remarks"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
        int i = 1;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (saleOrder o : reportObjectList) {
            
            String stringDate;
            table.setWidthPercentage(100);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(Integer.toString(i));
            table.addCell(new Paragraph(o.getItemCode()+ " - " + o.getItemDescription(),font));
            table.addCell(new Paragraph(Double.toString(o.getItemPrice()),font));
            table.addCell(new Paragraph(o.getItemOptionName(),font));
            table.addCell(new Paragraph(o.getItemOtherOption(),font));
            table.addCell(new Paragraph(Integer.toString(o.getItemQuantity()),font));
            table.addCell(new Paragraph(Double.toString(o.getTotalPrice()),font));
            table.addCell(new Paragraph(o.getItemRemarks(),font));
            i++;
        }
        document.add(table);
        


        
    }
  
  @Override
  public List<saleOrder> getUnPayItemCategoryPriceReport(saleOrder saleOrderObject){
      return itemOrderDao.getUnPayItemCategoryPriceReport(saleOrderObject);
  }
  
  @Override
  public List<saleOrder> getUnPayItemCategoryReport(saleOrder saleOrderObject){
      return itemOrderDao.getUnPayItemCategoryReport(saleOrderObject);
  }
  
      @Override
    public Document downloadPDF(contactDetails contactObject, final List<saleOrder> reportObjectList, String filename, saleOrder saleOrder) {
        Document document = null;

        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            addMetaData(document);

            addTitlePage(contactObject,document,saleOrder);

            createTable(contactObject, reportObjectList, document);

            document.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }       catch (DocumentException ex) { 
                    Logger.getLogger(itemOrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
        return document;

    }
    
   private static void addMetaData(Document document) {
        document.addTitle("ValueSource PDF report");
        document.addSubject("ValueSource PDF report");
        document.addAuthor("Java Honk");
        document.addCreator("Java Honk");
    }

    private static void addTitlePage(contactDetails contactObject, Document document,saleOrder saleOrder)
            throws DocumentException {
        Font font = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Paragraph preface = new Paragraph();
        creteEmptyLine(preface, 1);
        Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font font1 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        TIME_ROMAN = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        preface.add(new Paragraph("旺衣橱 ValueSource Enterprise Receipt", TIME_ROMAN));
        
        creteEmptyLine(preface, 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date todayDate = new java.util.Date();
        String stringDate = simpleDateFormat.format(todayDate);
        preface.add(new Paragraph("Receipt created on " + stringDate));
        preface.add(new Paragraph("Customer ID : " + contactObject.getCustomerID(),font));
        preface.add(new Paragraph("Customer Name : " + contactObject.getCustomerName(),font));
        preface.add(new Paragraph("Order Trip : " + contactObject.getCurrentTripDescription(),font));
        
        
        creteEmptyLine(preface, 1);
        
        preface.add(new Paragraph("Customer Posting Details"));
        preface.add(new Paragraph("Full Name : " + contactObject.getCustomerFullName(),font));
        preface.add(new Paragraph("Phone Number : " + contactObject.getCustomerPhone(),font));
        preface.add(new Paragraph("Address : " + contactObject.getCustomerAddress(),font));
        
        creteEmptyLine(preface, 1);
        
        preface.add(new Paragraph("Please bank in to bank account below"));
        preface.add(new Paragraph("Maybank : 112120030044 - PUA SION HUI"));
        preface.add(new Paragraph("Public Bank : 3210196031 - VALUESOURCE ENTERPRISE"));
        
        creteEmptyLine(preface, 1);
        preface.add(new Paragraph("Item Amount : RM " + contactObject.getTotalAmountNeedToPay(),font));
        preface.add(new Paragraph("Postage Amount : RM " + saleOrder.getPostPay() ,font));
        preface.add(new Paragraph("Discount Amount : RM " + saleOrder.getDiscount(),font));
        
        Phrase phrase = new Phrase();
        
        phrase.add(new Phrase("Total Amount Need to Pay ("+ contactObject.getTotalAmountNeedToPay() + " + " + saleOrder.getPostPay() + " - " +saleOrder.getDiscount() +") = ",font));
        phrase.add(new Phrase("RM " + (contactObject.getTotalAmountNeedToPay() + saleOrder.getPostPay() - saleOrder.getDiscount()),font1));
        
//        preface.add(new Phrase("Total Amount Need to Pay ("+ contactObject.getTotalAmountNeedToPay() + " + " + saleOrder.getPostPay() + " - " +saleOrder.getDiscount() +") = RM " + (contactObject.getTotalAmountNeedToPay() + saleOrder.getPostPay() - saleOrder.getDiscount())));
        preface.add(new Paragraph(phrase));


//        preface.add( "RM " + (contactObject.getTotalAmountNeedToPay() + saleOrder.getPostPay() - saleOrder.getDiscount()));
                
        creteEmptyLine(preface, 1);
        
        preface.add(new Paragraph("Remarks : " + (saleOrder.getRemarks() != ""?saleOrder.getRemarks():"-"),font));
        
        document.add(preface);


    }
    @Override
     public int deleteOrderByCustomerID(saleOrder saleOrderObject){
         return itemOrderDao.deleteOrderByCustomerID(saleOrderObject);
     }
     
     @Override
     public int deletePaidOrderByCustomerID(saleOrder saleOrderObject){
         return itemOrderDao.deletePaidOrderByCustomerID(saleOrderObject);
     }
    
//    @Override
//    public int updateOrderPayFlag(saleOrder saleOrderObject){
//        return itemOrderDao.updateOrderPayFlag(saleOrderObject);
//    }
    
    
//    	@Autowired
//	itemOrderDao itemOrderDao;
//        
//    	@Autowired
//	contactDetailsDao contactDetailsDao;          
//        
//        
//    @Override
//    public List<saleOrder> getPendingOrderItemList(String userID,String status){
//        return itemOrderDao.getPendingItemOrderDetailList(userID,status);
//    }
//    
//    
//    @Override
//    public int insertPendingOrderItem(saleOrder saleOrderObject){
//        return itemOrderDao.insertPendingOrderItemDetail(saleOrderObject);
//    }
//    
//    @Override
//    public void handleCart(List<saleOrder> saleOrderObjectList,String userID){
//        System.out.println("does it go in?");
//        Set<Integer> itemExistCart = new HashSet<Integer>();
//        String itemPendingOrderID;
//        System.out.println("check the list size " + saleOrderObjectList.size());
//        if(saleOrderObjectList.size() > 0){
//            System.out.println("come to if else");
//            if(itemOrderDao.checkPendingOrderItemTable(userID) == 0){
//                itemPendingOrderID = itemOrderDao.insertPendingOrderItem(userID);
//            }
//            else{
//                itemPendingOrderID = itemOrderDao.getPendingOrderItemId(userID);
//            }
//            System.out.println("itemPendingOrderID " + itemPendingOrderID);
//            for(int i = 0; i < saleOrderObjectList.size();i++){
//                saleOrderObjectList.get(i).setPendingOrderID(itemPendingOrderID);
//                saleOrderObjectList.get(i).setUserOrderDetailID(userID);
//                System.out.println("come to loop list itemID " + saleOrderObjectList.get(i).getItemDetailID() + " number Order " + saleOrderObjectList.get(i).getNumberOfOder());               
//                String checkPendingOrderDetailID = itemOrderDao.getPendingOrderItemDetail(saleOrderObjectList.get(i));
//                if( null == checkPendingOrderDetailID){
//                    System.out.println("Do insert??");
//                    itemOrderDao.insertPendingOrderItemDetail(saleOrderObjectList.get(i));
//                }
//                else{
//                    saleOrderObjectList.get(i).setPendingOrderDetailID(checkPendingOrderDetailID);
//                    System.out.println("Do update?? ID " + saleOrderObjectList.get(i).getPendingOrderDetailID() );
//                    itemOrderDao.updatePendingOrderItemDetail(saleOrderObjectList.get(i));
//                }
//                
//                itemExistCart.add(parseInt(saleOrderObjectList.get(i).getItemDetailID()));
//                
//               // System.out.println("itemExistChartList " + itemExistCart.);
//            }
//            Iterator<Integer> itr = itemExistCart.iterator();
//           while (itr.hasNext()) {
//            System.out.println("itemExistChartList " + itr.next());
//        }
//            
//            itemOrderDao.deletePendingOrderItemDetailExclude(itemPendingOrderID, itemExistCart);
// 
//        }
//        else{
//            
//            if(itemOrderDao.checkPendingOrderItemTable(userID) == 0){
//                itemPendingOrderID = itemOrderDao.insertPendingOrderItem(userID);
//            }
//            else{
//                itemPendingOrderID = itemOrderDao.getPendingOrderItemId(userID);
//            }
//            
//            itemExistCart.add(-1);
//            itemOrderDao.deletePendingOrderItemDetailExclude(itemPendingOrderID, itemExistCart);
//        }
//    }
//    @Override
//        public saleOrder updateChartSummary(List<saleOrder> pendingOrderSaleList,String userId){
//            saleOrder saleOrderObject = new saleOrder();
//            double totalPrice = 0;
//            double totalItemPrice = 0;
//            double totalItemWeight = 0;
//            double totalItemWeightPrice = 0;
//             String itemPendingOrderID = itemOrderDao.getPendingOrderItemId(userId);
//            for(int i = 0;i < pendingOrderSaleList.size();i++){
//                //totalItemPrice = totalItemPrice + (pendingOrderSaleList.get(i).getItemPrice() * parseDouble(pendingOrderSaleList.get(i).getNumberOfOder()));
//                //totalItemWeight = totalItemWeight + (parseDouble(pendingOrderSaleList.get(i).getItemWeight()) * parseDouble(pendingOrderSaleList.get(i).getNumberOfOder())) ;
//           totalItemPrice = totalItemPrice + pendingOrderSaleList.get(i).getItemTotalPrice();
//           totalItemWeight = totalItemWeight + pendingOrderSaleList.get(i).getItemTotalWeight();
//            }
//            
//           // totalItemWeightPrice = Math.round(itemOrderDao.getWeightPrice(totalItemWeight) * 100.00)/100.00;
//            totalPrice = Math.round((totalItemPrice + totalItemWeightPrice) * 100.00)/100.00;
//            totalItemPrice = Math.round(totalItemPrice * 100.00)/100.00;
//            saleOrderObject.setTotalPrice(totalPrice);
//            saleOrderObject.setItemTotalPrice(totalItemPrice);
//            saleOrderObject.setItemTotalWeight(totalItemWeight);
//            saleOrderObject.setItemTotalWeightPrice(totalItemWeightPrice);
//            
//            saleOrderObject.setPendingOrderID(itemPendingOrderID);
//            System.out.println("Total getTotalPrice " + saleOrderObject.getPendingOrderID());
//            System.out.println("Total getTotalPrice " + saleOrderObject.getTotalPrice());
//            System.out.println("Total getItemTotalPrice " + saleOrderObject.getItemTotalPrice());
//            System.out.println("Total getItemTotalWeight " + saleOrderObject.getItemTotalWeight());
//            System.out.println("Total getItemTotalWeightPrice " + saleOrderObject.getItemTotalWeightPrice());
//            itemOrderDao.updateTotalChart(saleOrderObject);
//            
//            return itemOrderDao.getPendingOrderSummary(itemPendingOrderID);
//        }    
//        
//        @Override
//        public void updateItemOrderNumber(List<saleOrder> orderList){
//            		if(null != orderList && orderList.size() > 0) {
//			
//			for (saleOrder saleOrderObject : orderList) {
//				System.out.println("Successffull get the lists of order " + "Detail ID " + saleOrderObject.getPendingOrderDetailID() + " Number Order " + saleOrderObject.getNumberOfOder());
//                                
//                                itemOrderDao.updatePendingOrderItemDetail(saleOrderObject);
//                                
//                                
//			}
//		}
//                        
//        }
//        
//        @Override
//        public saleOrder updateDeliveryDetails(saleOrderForm saleOrderFormObject,String userID){
//            saleOrder saleOrderObject = new saleOrder();
//            contactDetails contactDetailsObject = new contactDetails();
//            contactDetailsObject.setCustomerName(saleOrderFormObject.getCustomerName());
//            contactDetailsObject.setPhoneContact(saleOrderFormObject.getPhoneContact());
//            contactDetailsObject.setAddress1(saleOrderFormObject.getAddress1());
//            contactDetailsObject.setAddress2(saleOrderFormObject.getAddress2());
//            contactDetailsObject.setAddress3(saleOrderFormObject.getAddress3());
//            contactDetailsObject.setRemarks(saleOrderFormObject.getRemarks());
//            contactDetailsObject.setStateId(saleOrderFormObject.getStateID());
//            contactDetailsObject.setCountry(saleOrderFormObject.getCountry());
//            contactDetailsObject.setCreateBy(userID);
//            contactDetailsObject.setDeliveryDetailsID(saleOrderFormObject.getDeliveryAddress());
//            System.out.println("Check the itemDelivery " + saleOrderFormObject.getDeliveryAddress());
//            
//            System.out.println("System Sales ID " + saleOrderFormObject.getSalesOrderID());
//            
//            saleOrderObject = itemOrderDao.getPendingOrderSummary(saleOrderFormObject.getSalesOrderID());
//            
//            if("" == saleOrderFormObject.getDeliveryAddress()){
//            String contactDetailsID = contactDetailsDao.insertContactDetails(contactDetailsObject);
//            saleOrderObject.setItemDeliveryDetailsID(contactDetailsID);
//            }
//            else{
//                contactDetailsDao.updateContactDetails(contactDetailsObject);
//                saleOrderObject.setItemDeliveryDetailsID(saleOrderFormObject.getDeliveryAddress());
//            }
//            
//            double totalItemWeight = itemOrderDao.getTotalWeight(saleOrderFormObject.getSalesOrderID());
//            
//            double totalItemWeightPrice = itemOrderDao.getWeightPrice(totalItemWeight, saleOrderFormObject.getStateID());
//            
//            saleOrderObject.setPendingOrderID(saleOrderFormObject.getSalesOrderID());
//            
//           System.out.println("System Total Item Price " + saleOrderObject.getItemPrice());
//           
//            
//            saleOrderObject.setItemTotalWeightPrice(totalItemWeightPrice);
//            
//            
//            System.out.println("System Total Weight Price " + saleOrderObject.getItemTotalWeightPrice());
//            
//            saleOrderObject.setTotalPrice(saleOrderObject.getItemTotalWeightPrice() + saleOrderObject.getItemTotalPrice());
//            
//            
//            System.out.println("System Total Price " + saleOrderObject.getTotalPrice());
//            
//            System.out.println("Pending ID for delivery Item " + saleOrderFormObject.getSalesOrderID());
//            
//            
//            
//            itemOrderDao.updatePendingOrderDeliveryDetails(saleOrderObject);
//            
//            return saleOrderObject;
//        }
//        
//        @Override
//        public contactDetails getContactDetails(String contactDetailsID){
//            return contactDetailsDao.getContactDetails(contactDetailsID);
//        }
//        
//        @Override
//        public void updatePaymentSlip(saleOrderForm saleOrderFormObject){
//            
//            saleOrder saleOrderObject = new saleOrder();
//            
//            saleOrderObject.setPaymentSlip(saleOrderFormObject.getPaymentSlip());
//            saleOrderObject.setPendingOrderID(saleOrderFormObject.getSalesOrderID());
//            
//            itemOrderDao.updatePendingOrderPaymentSlip(saleOrderObject);
//        }
//        
//        @Override
//        public int updatePendingOrderSave(saleOrder saleOrderObject){
//            return itemOrderDao.updatePendingOrderSave(saleOrderObject);
//        }
//        
//        @Override
//        public void insertSalesOrder(saleOrder saleOrderObject){
//            
//            saleOrder pendingSaleOrder = itemOrderDao.getPendingOrderSummary(saleOrderObject.getPendingOrderID());
//            
//            List<saleOrder> pendingSaleOrderDetails = itemOrderDao.getPendingItemOrderDetailList(pendingSaleOrder.getUserOrderDetailID(),pendingSaleOrder.getRequestStatus());
//            
//            System.out.println("Pending Order Details Size " + pendingSaleOrderDetails.size());
//            
//            pendingSaleOrder.setRequestStatus("PA");
//            
//            String saleOrderID = itemOrderDao.insertSubmitOrderItem(pendingSaleOrder);
//            
//            
//            
//            for(int i = 0;i < pendingSaleOrderDetails.size();i++){
//                pendingSaleOrderDetails.get(i).setSaleOrderID(saleOrderID);
//                itemOrderDao.insertSubmitOrderItemDetails(pendingSaleOrderDetails.get(i));
//            }
//            
//            itemOrderDao.deletePendingOrderItem(pendingSaleOrder);
//            itemOrderDao.deletePendingOrderItemDetailsByPendingOrderID(pendingSaleOrder);
//        }
//        
//        @Override
//        public List<saleOrder> getSavePendingOrderDetailsList(saleOrder saleOrderObject){
//            return itemOrderDao.getSavePendingOrderDetailsList(saleOrderObject);
//        }
//        
//        @Override
//        public saleOrder getPendingOrderSummary(String pendingOrderItemId){
//            return itemOrderDao.getPendingOrderSummary(pendingOrderItemId);
//        }
//        
//        @Override
//        public saleOrder updateSaveChartSummary(List<saleOrder> pendingOrderSaleList,String itemPendingOrderID){
//            saleOrder saleOrderObject = new saleOrder();
//            double totalPrice = 0;
//            double totalItemPrice = 0;
//            double totalItemWeight = 0;
//            double totalItemWeightPrice = 0;
//             //String itemPendingOrderID = itemOrderDao.getPendingOrderItemId(userId);
//            for(int i = 0;i < pendingOrderSaleList.size();i++){
//                //totalItemPrice = totalItemPrice + (pendingOrderSaleList.get(i).getItemPrice() * parseDouble(pendingOrderSaleList.get(i).getNumberOfOder()));
//                //totalItemWeight = totalItemWeight + (parseDouble(pendingOrderSaleList.get(i).getItemWeight()) * parseDouble(pendingOrderSaleList.get(i).getNumberOfOder())) ;
//           totalItemPrice = totalItemPrice + pendingOrderSaleList.get(i).getItemTotalPrice();
//           totalItemWeight = totalItemWeight + pendingOrderSaleList.get(i).getItemTotalWeight();
//            }
//            
//           // totalItemWeightPrice = Math.round(itemOrderDao.getWeightPrice(totalItemWeight) * 100.00)/100.00;
//            totalPrice = Math.round((totalItemPrice + totalItemWeightPrice) * 100.00)/100.00;
//            totalItemPrice = Math.round(totalItemPrice * 100.00)/100.00;
//            saleOrderObject.setTotalPrice(totalPrice);
//            saleOrderObject.setItemTotalPrice(totalItemPrice);
//            saleOrderObject.setItemTotalWeight(totalItemWeight);
//            saleOrderObject.setItemTotalWeightPrice(totalItemWeightPrice);
//            
//            saleOrderObject.setPendingOrderID(itemPendingOrderID);
//            System.out.println("Total getTotalPrice " + saleOrderObject.getPendingOrderID());
//            System.out.println("Total getTotalPrice " + saleOrderObject.getTotalPrice());
//            System.out.println("Total getItemTotalPrice " + saleOrderObject.getItemTotalPrice());
//            System.out.println("Total getItemTotalWeight " + saleOrderObject.getItemTotalWeight());
//            System.out.println("Total getItemTotalWeightPrice " + saleOrderObject.getItemTotalWeightPrice());
//            itemOrderDao.updateTotalChart(saleOrderObject);
//            
//            return itemOrderDao.getPendingOrderSummary(itemPendingOrderID);
//        }    
}
