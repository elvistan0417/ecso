<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html lang="en">
    <head>

    </head><!--/head-->

    <body>


        <div id="contact-page" class="container">
            <div class="bg">
                <div class="row">    		
                    <div class="col-sm-12">    			   			
                        <h2 class="title text-center">Pending Approve </h2>    	
                        
                        <a href="viewOrderHistory">View all history</a>
                        <div class="tablewrapper">
                            <div class="tabledesign">

                                <div class="tablerow header blue">
                                    <div class="tablecell">
                                        No
                                    </div>
                                    <div class="tablecell">
                                        
                                    </div>
                                    <div class="tablecell">
                                        Total Weight
                                    </div>
                                    <div class="tablecell">
                                        Total Item Price
                                    </div>
                                    <div class="tablecell">
                                        Transport Fee
                                    </div>
                                    <div class="tablecell">
                                        Total Price
                                    </div>
                                </div>
                                <c:forEach var="pendingApproveSalesOrderObject" items="${pendingApproveSalesOrderObject}" varStatus = "status"> 
                                    <div class="tablerow">
                                        <div class="tablecell">
                                            ${status.index + 1}
                                        </div>
                                        <div class="tablecell">
                                            <a href = "showOrderDetail?id=${pendingApproveSalesOrderObject.saleOrderID}"> Click Details</a>
                                        </div>
                                        <div class="tablecell">
                                            ${pendingApproveSalesOrderObject.itemTotalWeight} KG
                                        </div>
                                        <div class="tablecell">
                                            RM ${pendingApproveSalesOrderObject.itemTotalPrice}
                                        </div>      
                                        <div class="tablecell">
                                            RM ${pendingApproveSalesOrderObject.itemTotalWeightPrice}
                                        </div> 
                                        <div class="tablecell">
                                            RM ${pendingApproveSalesOrderObject.totalPrice}
                                        </div>       
                                    </div>
                                </c:forEach>    
                            </div>
                        </div>


                    </div>			 		

                    <div class="col-sm-12">    			   			
                        <h2 class="title text-center">Processing </h2>    			    				    				

                        <div class="tablewrapper">

                            <div class="tabledesign">

                                <div class="tablerow header blue">
                                    <div class="tablecell">
                                        No
                                    </div>
                                    <div class="tablecell">
                                       
                                    </div>
                                    <div class="tablecell">
                                        Total Weight
                                    </div>
                                    <div class="tablecell">
                                        Total Item Price
                                    </div>
                                    <div class="tablecell">
                                        Transport Fee
                                    </div>
                                    <div class="tablecell">
                                        Total Price
                                    </div>
                                    <div class="tablecell">
                                        Status
                                    </div>
                                </div>

                                <c:forEach var="processingSalesOrderObject" items="${processingSalesOrderObject}" varStatus = "status"> 
                                    <div class="tablerow">
                                        <div class="tablecell">
                                            ${status.index + 1}
                                        </div>
                                        <div class="tablecell">
                                           <a href = "showOrderDetail?id=${processingSalesOrderObject.saleOrderID}"> Click Details</a>
                                        </div>
                                        <div class="tablecell">
                                            ${processingSalesOrderObject.itemTotalWeight} KG
                                        </div>
                                        <div class="tablecell">
                                            RM ${processingSalesOrderObject.itemTotalPrice}
                                        </div>      
                                        <div class="tablecell">
                                            RM ${processingSalesOrderObject.itemTotalWeightPrice}
                                        </div> 
                                        <div class="tablecell">
                                            RM ${processingSalesOrderObject.totalPrice}
                                        </div>       
                                        <div class="tablecell">
                                            ${processingSalesOrderObject.requestStatus}
                                        </div> 
                                    </div>
                                </c:forEach>    


                            </div>

                        </div>

                    </div>			 		

                    <div class="col-sm-12">    			   			
                        <h2 class="title text-center">On Hold</h2>    			    				    				
                        <div class="tablewrapper">
                            <div class="tabledesign">


                                <div class="tablerow header blue">
                                    <div class="tablecell">
                                        No
                                    </div>
                                    <div class="tablecell">
                                         
                                    </div>
                                    <div class="tablecell">
                                        Total Weight
                                    </div>
                                    <div class="tablecell">
                                        Total Item Price
                                    </div>
                                    <div class="tablecell">
                                        Transport Fee
                                    </div>
                                    <div class="tablecell">
                                        Total Price
                                    </div>
                                    <div class="tablecell">
                                        Status
                                    </div>

                                </div>

                                <c:forEach var="onHoldSalesOrderObject" items="${onHoldSalesOrderObject}" varStatus = "status"> 
                                    <div class="tablerow">
                                        <div class="tablecell">
                                            ${status.index + 1}
                                        </div>
                                        <div class="tablecell">
                                           <a href = "showOrderDetail?id=${onHoldSalesOrderObject.saleOrderID}"> Click Details</a>
                                        </div>
                                        <div class="tablecell">
                                            ${onHoldSalesOrderObject.itemTotalWeight} KG
                                        </div>
                                        <div class="tablecell">
                                            RM ${onHoldSalesOrderObject.itemTotalPrice}
                                        </div>      
                                        <div class="tablecell">
                                            RM ${onHoldSalesOrderObject.itemTotalWeightPrice}
                                        </div> 
                                        <div class="tablecell">
                                            RM ${onHoldSalesOrderObject.totalPrice}
                                        </div>
                                        <div class="tablecell">
                                            ${onHoldSalesOrderObject.requestStatus}
                                        </div> 
                                    </div>
                                </c:forEach> 


                            </div>
                        </div>
                    </div>	
                </div>
                <br>
                <br>
                <div class="col-sm-12">    			   			
                    <h2 class="title text-center">Reject <strong>Us</strong></h2>    			    				    				
                    <div class="tablewrapper">
                        <div class="tabledesign">


                            <div class="tablerow header blue">
                                <div class="tablecell">
                                    No
                                </div>
                                <div class="tablecell">
                                    
                                </div>
                                <div class="tablecell">
                                    Total Weight
                                </div>
                                <div class="tablecell">
                                    Total Item Price
                                </div>
                                <div class="tablecell">
                                    Transport Fee
                                </div>
                                <div class="tablecell">
                                    Total Price
                                </div>
                                <div class="tablecell">
                                    Status
                                </div>

                            </div>

                            <c:forEach var="rejectSalesOrderObject" items="${rejectSalesOrderObject}" varStatus = "status"> 
                                <div class="tablerow">
                                    <div class="tablecell">
                                        ${status.index + 1}
                                    </div>
                                    <div class="tablecell">
                                        <a href = "showOrderDetail?id=${rejectSalesOrderObject.saleOrderID}"> Click Details</a>
                                    </div>
                                    <div class="tablecell">
                                        ${rejectSalesOrderObject.itemTotalWeight} KG
                                    </div>
                                    <div class="tablecell">
                                        RM ${rejectSalesOrderObject.itemTotalPrice}
                                    </div>      
                                    <div class="tablecell">
                                        RM ${rejectSalesOrderObject.itemTotalWeightPrice}
                                    </div> 
                                    <div class="tablecell">
                                        RM ${rejectSalesOrderObject.totalPrice}
                                    </div>
                                    <div class="tablecell">
                                       ${rejectSalesOrderObject.requestStatus}
                                    </div> 
                                </div>
                            </c:forEach> 


                        </div>
                    </div>
                </div>
            </div>
        </div>    
    </div>	
</div><!--/#contact-page-->


</body>
</html>