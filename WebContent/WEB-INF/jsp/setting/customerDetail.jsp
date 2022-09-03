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
                        <h1 class="page-header"><fmt:message key="label.customerdetail" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                         <fmt:message key="label.customer" />
                    <a href="<c:url value='/viewCustomerUpdate?customerID=${contactDetailsObject.customerID}'/>" class="btn btn-default">更新</a>
                    <a href="<c:url value='/deleteCustomer?customerID=${contactDetailsObject.customerID}'/>" class="btn btn-default" onclick="return confirm('确定删除?')">删除</a>
                        </div>

                        <!-- /.panel-heading -->
                        <div class="panel-body">
                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    <fmt:message key="label.successupdate" />
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    <fmt:message key="label.failupdate" />
                                </div>
                                </c:if>
                            <div class="row">
                                <div class="col-lg-6">
                              

                                        <div class="form-group">
                                            <label><fmt:message key="label.name" /></label>
                                            <p class="form-control-static">${contactDetailsObject.customerID} - ${contactDetailsObject.customerName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message key="label.phonenumber" /></label>
                                            <p class="form-control-static">${contactDetailsObject.customerPhone}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label><fmt:message key="label.facebookname" /></label>
                                            <p class="form-control-static">${contactDetailsObject.fbName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message key="label.wechatname" /></label>
                                            <p class="form-control-static">${contactDetailsObject.weChatName}</p>
                                        </div>
                                   </div>
                              
                                 <div class="col-lg-6">
                         
                                        <div class="form-group">
                                            <label><fmt:message key="label.creationdate" /></label>
                                            <p class="form-control-static">${contactDetailsObject.createDate}</p>
                                        </div>
                                          <div class="form-group">
                                            <label><fmt:message key="label.updatedate" /></label>
                                            <p class="form-control-static">${contactDetailsObject.updateDate}</p>
                                        </div>
                                       <div class="form-group">
                                            <label><fmt:message key="label.address" /></label>
                                            <p class="form-control-static">${contactDetailsObject.customerAddress}</p>
                                        </div>
                                       <div class="form-group">
                                            <label><fmt:message key="label.fullname" /></label>
                                            <p class="form-control-static">${contactDetailsObject.customerFullName}</p>
                                        </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
<div class="row">
                    <div class="col-lg-12">
                      <h4 class="page-header"><fmt:message key="label.billsummary" /></h4>
               
     
                        <label><fmt:message key="label.currenttrip" /> - <font color="INDIANRED">${currentTripDescription}</font></label>
                        <div class="panel panel-default">
                    
                            <div class="panel-heading">
                                <label><fmt:message key="label.unpaidbill" /></label>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">

                                    
                                    <div class="dataTable_wrapper">
                                        <table class="table">
                                            <thead>
                                                <tr>

                                                    <th><fmt:message key="label.totalstockquantity" /></th>
                                                    <th><fmt:message key="label.totalamount" /></th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="unPaySaleOrderObjectList" items="${unPaySaleOrderObjectList}" varStatus = "unPaySaleOrderObjectListLoop"> 
                                                    <c:if test="${unPaySaleOrderObjectListLoop.index % 2 == 1}">
                                                        <tr class="odd">
                                                        </c:if> 
                                                        <c:if test="${unPaySaleOrderObjectListLoop.index % 2 == 0}">
                                                        <tr class="even">
                                                        </c:if> 
                       
                                                        <td>${unPaySaleOrderObjectList.totalOrderItemQuantity}</td>
                                                        <td>${unPaySaleOrderObjectList.totalOrderItemPrice}</td>
                                                        
                                                        <td><a href="<c:url value='/viewCustomerDetailOrderDetail?customerID=${unPaySaleOrderObjectList.customerID}'/>" class="btn btn-default">详情</a> </td>
                                                        <td><a href="<c:url value='/updatePayToOrderByCustID?customerID=${unPaySaleOrderObjectList.customerID}'/>" class="btn btn-default" onclick="return confirm('确定已付款?')">设为已付款</a> </td>
                                                    </tr>



                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>


                            </div>

                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
<div class="panel panel-default">

                            <div class="panel-heading">
                                <label><fmt:message key="label.paidbill" /></label>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">

                                    
                                    <div class="dataTable_wrapper">
                                        <table class="table">
                                            <thead>
                                                <tr>

                                                    <th><fmt:message key="label.totalstockquantity" /></th>
                                                    <th><fmt:message key="label.totalamount" /></th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="paidSaleOrderObjectList" items="${paidSaleOrderObjectList}" varStatus = "paidSaleOrderObjectListLoop"> 
                                                    <c:if test="${paidSaleOrderObjectListLoop.index % 2 == 1}">
                                                        <tr class="odd">
                                                        </c:if> 
                                                        <c:if test="${paidSaleOrderObjectListLoop.index % 2 == 0}">
                                                        <tr class="even">
                                                        </c:if> 
                       
                                                        <td>${paidSaleOrderObjectList.totalOrderItemQuantity}</td>
                                                        <td>${paidSaleOrderObjectList.totalOrderItemPrice}</td>
                                                        
                                                        <td><a href="<c:url value='/viewCustomerDetailPaidOrderDetail?customerID=${paidSaleOrderObjectList.customerID}'/>" class="btn btn-default"><fmt:message key="label.details" /></a> </td>
                                                        <td></td>
                                                    </tr>



                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>


                            </div>

                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
            </div>
        </div>
        <!-- /#wrapper -->
    </body>
</html>