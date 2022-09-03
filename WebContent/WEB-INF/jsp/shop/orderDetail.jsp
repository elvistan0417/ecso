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

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="label.orderdetail" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                   订单详情

                    <a href="<c:url value='/viewOrderDetailUpdate?saleOrderID=${saleOrderDetail.orderDetailID}&isPayFlag=${isPayFlag}'/>" class="btn btn-default"><fmt:message key="label.update" /></a>
                    <a href="<c:url value='/deleteOrderDetail?saleOrderID=${saleOrderDetail.orderDetailID}&isPayFlag=${isPayFlag}'/>" class="btn btn-default"><fmt:message key="label.delete" /></a>
                        </div>

                        <!-- /.panel-heading -->
                        <div class="panel-body">
                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    <fmt:message key="label.successexecution" />
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    <fmt:message key="label.failexecution" />
                                </div>
                                </c:if>
                            <div class="row">
                                <div class="col-lg-6">
                              

                                        <div class="form-group">
                                            <label><fmt:message key="label.customername" /></label>
                                            <p class="form-control-static">${saleOrderDetail.customerName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message key="label.orderitemname" /></label>
                                            <p class="form-control-static">${saleOrderDetail.itemDescription}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label><fmt:message key="label.orderitemcode" /></label>
                                            <p class="form-control-static">${saleOrderDetail.itemCode}</p>
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message key="label.orderitemoption" /></label>
                                            <p class="form-control-static">${saleOrderDetail.itemOptionName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message key="label.orderitemremarks" /></label>
                                            <p class="form-control-static">${saleOrderDetail.itemOtherOption}</p>
                                        </div>
                                   </div>
                              
                                 <div class="col-lg-6">
                         

                                          <div class="form-group">
                                            <label><fmt:message key="label.itemprice" /></label>
                                            <p class="form-control-static">${saleOrderDetail.itemPrice}</p>
                                        </div>
                                  <div class="form-group">
                                            <label><fmt:message key="label.quantity" /></label>
                                            <p class="form-control-static">${saleOrderDetail.itemQuantity}</p>
                                        </div>
                                       <div class="form-group">
                                            <label><fmt:message key="label.totalamount" /></label>
                                            <p class="form-control-static">${saleOrderDetail.totalPrice}</p>
                                        </div>
                                    <div class="form-group">
                                            <label><fmt:message key="label.remarks" /></label>
                                            <p class="form-control-static">${saleOrderDetail.itemRemarks}</p>
                                        </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>

            </div>
        </div>
        <!-- /#wrapper -->
    </body>
</html>