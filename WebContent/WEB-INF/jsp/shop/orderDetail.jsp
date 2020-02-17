<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>


    </head><!--/head-->

    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">订单详情</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                   订单详情

                    <a href="<c:url value='/viewOrderDetailUpdate?saleOrderID=${saleOrderDetail.orderDetailID}&isPayFlag=${isPayFlag}'/>" class="btn btn-default">更新</a>
                    <a href="<c:url value='/deleteOrderDetail?saleOrderID=${saleOrderDetail.orderDetailID}&isPayFlag=${isPayFlag}'/>" class="btn btn-default">删除</a>
                        </div>

                        <!-- /.panel-heading -->
                        <div class="panel-body">
                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    更新成功
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    更新失败，请联络技术人员
                                </div>
                                </c:if>
                            <div class="row">
                                <div class="col-lg-6">
                              

                                        <div class="form-group">
                                            <label>客户名字</label>
                                            <p class="form-control-static">${saleOrderDetail.customerName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>订单货物名</label>
                                            <p class="form-control-static">${saleOrderDetail.itemDescription}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>订单货物号码</label>
                                            <p class="form-control-static">${saleOrderDetail.itemCode}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>订单货物选择</label>
                                            <p class="form-control-static">${saleOrderDetail.itemOptionName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>其他选择备注</label>
                                            <p class="form-control-static">${saleOrderDetail.itemOtherOption}</p>
                                        </div>
                                   </div>
                              
                                 <div class="col-lg-6">
                         

                                          <div class="form-group">
                                            <label>货物价钱</label>
                                            <p class="form-control-static">${saleOrderDetail.itemPrice}</p>
                                        </div>
                                  <div class="form-group">
                                            <label>数量</label>
                                            <p class="form-control-static">${saleOrderDetail.itemQuantity}</p>
                                        </div>
                                       <div class="form-group">
                                            <label>总价钱</label>
                                            <p class="form-control-static">${saleOrderDetail.totalPrice}</p>
                                        </div>
                                    <div class="form-group">
                                            <label>备注</label>
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