<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
       <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="${pageContext.request.contextPath}/css/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="${pageContext.request.contextPath}/css/dataTables/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="${pageContext.request.contextPath}/css/dataTables/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/css/startmin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <style type="text/css">


            div.cut-text {

                width: 100px;

                word-wrap: break-word;

            }

        </style>
    </head><!--/head-->

    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <c:if test="${isPayFlag == 'N'}">  
                        <h1 class="page-header">客户未付款详情</h1>
                        </c:if>
                        <c:if test="${isPayFlag == 'Y'}">  
                        <h1 class="page-header">客户已付款详情</h1>
                        </c:if>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
<div class="row">
                    <div class="col-lg-12">
                      <label>目前行程 - <font color="INDIANRED">${currentTripDescription}</font></label>
            
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                 <c:if test="${isPayFlag == 'N'}">   
                                <label>未付款账单</label>
                                 </c:if>
                                 <c:if test="${isPayFlag == 'Y'}">   
                                <label>已付款账单</label>
                                 </c:if>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
<div class="row">
                                <div class="col-lg-4">
                              

                                        <div class="form-group">
                                            <label>客户名字</label>
                                            <p class="form-control-static">${contactDetailsObject.customerName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>电话号码</label>
                                            <p class="form-control-static">${contactDetailsObject.customerPhone}</p>
                                        </div>
  
        
                                   </div>
                              
                                 <div class="col-lg-4">
                                <div class="form-group">
                                            <label>wechat名</label>
                                            <p class="form-control-static">${contactDetailsObject.weChatName}</p>
                                        </div>
                                       <div class="form-group">
                                            <label>地址</label>
                                            <p class="form-control-static">${contactDetailsObject.customerAddress}</p>
                                        </div>
                                </div>
                                        <div class="col-lg-4">
                                         
                                        <div class="form-group">
                                            <label>facebook名</label>
                                            <p class="form-control-static">${contactDetailsObject.fbName}</p>
                                        </div>
                                       <div class="form-group">
                                            <label>Posting Full Name</label>
                                            <p class="form-control-static">${contactDetailsObject.customerFullName}</p>
                                        </div>
                                </div>
                            </div>
                                        <div class="col-lg-8">
                                    <div class="dataTable_wrapper">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>

                                                    <th>总货物数量</th>
                                                    <th>总价钱</th>
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
                                                        
                                                        
                                                        <td>
                                                        <c:if test="${isPayFlag == 'N'}">    
                                                            <a href="<c:url value='/updatePayToOrderByCustID?customerID=${unPaySaleOrderObjectList.customerID}'/>" class="btn btn-default" onclick="return confirm('确定已付款?')">设为已付款</a> 
                                                        </c:if> 
                                                        
                                                        </td>
                                                        
                                                    </tr>



                                                </c:forEach>
                                       
            
                                            </tbody>
                                        </table>
                                    <c:if test="${isPayFlag == 'Y'}">  
                                 <form:form action="downloadPayReceiptPDF" method="post" modelAttribute="saleOrderObject">
                                   <form:hidden path="orderTripID" /> 
                                   <form:hidden path="customerID" /> 
                                   Postage
                                   <form:input path="postPay" size="5" required="required"  pattern= "[0-99999]+(.[0-99999]{0,2})?$"/>
                                    <button type="submit" class="btn btn-default">下载收据</button> 
                                </form:form>  
                                     </c:if> 
                              <c:if test="${isPayFlag == 'N'}">  
                                 <form:form action="downloadUnPayReceiptPDF" method="post" modelAttribute="saleOrderObject">
                                   <form:hidden path="orderTripID" /> 
                                   <form:hidden path="customerID" /> 
                                   Discount
                                   <form:input path="discount" size="5" required="required" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/>

                                   Postage
                                   <form:input path="postPay" size="5" required="required" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/>
                                   <br>
                                   <br>
                                   Remarks
                                   <form:input path="remarks" size="100"/>
                                   <br>
                                   <br>
                                   <button type="submit" class="btn btn-default">下载收据</button> 
                                </form:form>  
                                     </c:if> 
                                    </div>
</div>

                            </div>

                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
<div class="panel panel-default">

                            <div class="panel-heading">
                                <c:if test="${isPayFlag == 'N'}">  
                                <label>未付款账单详情</label>
                                </c:if>
                                <c:if test="${isPayFlag == 'Y'}">  
                                    <label>已付款账单详情</label>
                                </c:if>
                                    
                                <c:if test="${isPayFlag == 'N'}">  
                                <a href="<c:url value='/updateUnPayOrderSaleList?customerID=${customerID}'/>" class="btn btn-default"">更新</a> 
                                </c:if>
                                <c:if test="${isPayFlag == 'Y'}">  
                                     <a href="<c:url value='/updatePaidOrderSaleList?customerID=${customerID}'/>" class="btn btn-default"">更新</a> 
                                </c:if>

                            </div>
                            <!-- /.panel-heading -->
<div class="panel-body">

                                    
                                    <div class="dataTable_wrapper">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>客户</th>
                                                    <th>货物</th>
                                                    <th>货物价钱</th>
                                                    <th>货物选择</th>
                                                    <th>选择备注</th>
                                                    <th>数量</th>
                                                    <th>总价钱</th>
                                                    <th>备注</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="unPaySaleOrderDetailList" items="${unPaySaleOrderDetailList}" varStatus = "unPaySaleOrderDetailListLoop"> 
                                                    <c:if test="${unPaySaleOrderDetailListLoop.index % 2 == 1}">
                                                        <tr class="odd">
                                                        </c:if> 
                                                        <c:if test="${unPaySaleOrderDetailListLoop.index % 2 == 0}">
                                                        <tr class="even">
                                                        </c:if> 
                                                            <td><a href="<c:url value='/viewSaleOrderDetail?saleOrderID=${unPaySaleOrderDetailList.orderDetailID}&isPayFlag=${isPayFlag}'/>">${unPaySaleOrderDetailListLoop.index + 1}</a></td>
                                                        <td>${unPaySaleOrderDetailList.customerName}</td>
                                                        <td>${unPaySaleOrderDetailList.itemCodeDescription}</td>
                                                        <td>${unPaySaleOrderDetailList.itemPrice}</td>
                                                        <td>${unPaySaleOrderDetailList.itemOptionName}</td>
                                                        <td>${unPaySaleOrderDetailList.itemOtherOption}</td>
                                                        <td>${unPaySaleOrderDetailList.itemQuantity}</td>
                                                        <td>${unPaySaleOrderDetailList.totalPrice}</td>
                                                        <td>${unPaySaleOrderDetailList.itemRemarks}</td>
                                                        
                                                       
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
  <!-- jQuery -->
<!--        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>-->

    <!-- Bootstrap Core JavaScript -->
<!--        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

     Metis Menu Plugin JavaScript 
    <script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>-->

    <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/js/dataTables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/dataTables/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/js/startmin.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
    
</html>