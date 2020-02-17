<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        
    </head>
    <script>
            
        
        </script>
	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>Item List</h3>
			</div>
			<div class="row">
                            
                          
                            <form:form method="POST" action="updateChart" modelAttribute="orderForm">
				<div class="col-sm-8">
            <section id="cart_items">
		

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            <c:forEach var="itemPendingOderList" items="${orderForm.saleOrders}" varStatus = "status"> 
						<tr>
							<td class="cart_product">
								<a href=""><img height="40" width="50" src="<c:url value='/images/uploadImage/${itemPendingOderList.itemPicture}'/>" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${itemPendingOderList.itemName}</a></h4>
								<p>Weight Each :  ${itemPendingOderList.itemWeight} KG</p>
							</td>
							<td class="cart_price">
								<p>RM ${itemPendingOderList.itemPrice}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
                                                                    <p>${itemPendingOderList.numberOfOder}</p>
								</div>
							</td>
							<td class="cart_total">
								<p id = "cart_total_weight${itemPendingOderList.itemDetailID}">${itemPendingOderList.itemTotalWeight} KG</p>
                                                                <p class="cart_total_price" id = "cart_total_price${itemPendingOderList.itemDetailID}">RM ${itemPendingOderList.itemTotalPrice}</p>
							</td>
							
						</tr>
                                            </c:forEach>

					</tbody>
				</table>
			</div>

	</section> <!--/#cart_items-->
				</div>
				<div class="col-sm-4">
					<div class="total_area">
                                            <h4 style="padding-left: 40px;">Order Summary </h4>
						<ul>
							<li>Total Price<span>RM ${orderForm.totalItemPrice}</span></li>
							<li>Total Weight(KG) <span>${orderForm.totalItemWeight}</span></li>
                                                        <li>Shipping Cost(RM) <span>${orderForm.totalItemWeightPrice}</span></li>
							<li>Grant Total <span>RM ${orderForm.totalPrice}</span></li>
						</ul>
							</div>
				</div>
                   
			</div>
		</div>
	</section><!--/#do_action-->

<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>Delivery & Payment Details</h3>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
                                             <div style="margin-left:20px">
                                              <h4>Delivery Details</h4>
                                            <table>
                                                <col width="20%">
                                                <col width="80%">
						
                                                    	<tr>
                                                            <td><label>Customer Name  </label></td>
								<td>
                                                                    <p>${orderForm.customerName}</p>
                                                                
                                                                </td>
							</tr>
                                                        <tr>
								<td><label>Phone Contact  </label></td>
								<td>
                                                                   <p>${orderForm.phoneContact}</p>  
                                                                 
                                                                
                                                                </td>
							</tr>
    						<tr class="single_field">
								<td><label>Country</label></td>
								<td>
                                                                    <p>${orderForm.country}</p>  
									
								</td>
							</tr>
							<tr class="single_field">
								<td><label>Region / State</label></td>
								<td>
                                                                     <p>${orderForm.stateID}</p> 
                                                                   
							</td>
							</tr>
                                                        <tr>
								<td><label>Address  </label></td>
                                                               <td> 
                                                                   <p>${orderForm.address1}</p> 
                                                                   <p>${orderForm.address2}</p> 
                                                                   <p>${orderForm.address3}</p> 
                                                                   </td>
							</tr>         
                                                        <tr>
								<td><label>Remarks  </label></td>
						 <td> 
                                                      <p>${orderForm.remarks}</p> 
                                                     ${orderForm.paymentSlip}
							</tr>     
	

						
                                                </table>
                                                        
                                              </div>  
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
                                            <h4>Payment Details</h4>
                                            Payment Slip
                                            <br>
						 <img class="loading" id="myImg" src="/ecso/images/paymentSlip/${orderForm.paymentSlip}" alt="" height="400" width="250" onerror="this.style.display='none'"/>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
        </form:form>
</body>
</html>
