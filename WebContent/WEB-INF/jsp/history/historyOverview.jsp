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
                        <h2 class="title text-center">Order History </h2>    			    				    				
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
                                <c:forEach var="orderHistoryObject" items="${orderHistoryList}" varStatus = "status"> 
                                    <div class="tablerow">
                                        <div class="tablecell">
                                            ${status.index + 1}
                                        </div>
                                        <div class="tablecell">
                                            <a href = "showOrderDetail?id=${orderHistoryObject.saleOrderID}"> Click Details</a>
                                        </div>
                                        <div class="tablecell">
                                            ${orderHistoryObject.itemTotalWeight} KG
                                        </div>
                                        <div class="tablecell">
                                            RM ${orderHistoryObject.itemTotalPrice}
                                        </div>      
                                        <div class="tablecell">
                                            RM ${orderHistoryObject.itemTotalWeightPrice}
                                        </div> 
                                        <div class="tablecell">
                                            RM ${orderHistoryObject.totalPrice}
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