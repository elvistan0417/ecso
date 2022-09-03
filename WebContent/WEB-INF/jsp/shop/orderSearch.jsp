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
        <script>

            $(document).ready(function () {

                $('#orderTrip').change(function (event) {

                    var orderTripID = $("select#orderTrip").val();
                    $.get('/ecso/getItemCategoryA', {
                        orderTripID: orderTripID
                    }, function (response) {

                        var select = $('#itemCategory');
                        select.find('option').remove();
                        $('<option>').val('%%').text('All').appendTo(select);
                        $.each(response, function (index, value) {
                            $('<option>').val(value.itemCategoryID).text(value.itemCategoryName).appendTo(select);
                        });
                    });
                });
                
                $('#itemCategory').change(function (event) {

                    var itemCategoryID = $("select#itemCategory").val();
                    $.get('/ecso/getItemA', {
                        itemCategoryID : itemCategoryID
                    }, function (response) {

                        var select = $('#itemID');
                        select.find('option').remove();
                        $('<option>').val('%%').text('All').appendTo(select);
                        $.each(response, function (index, value) {
                            $('<option>').val(value.itemDetailID).text(value.itemCodeDescription).appendTo(select);
                        });
                    });
                    
                    $.get('/ecso/getItemOptionA', {
                        itemCategoryID: itemCategoryID
                    }, function (response) {

                        var select = $('#itemOptionID');
                        select.find('option').remove();
                        $('<option>').val('%%').text('All').appendTo(select);
                        $.each(response, function (index, value) {
                            $('<option>').val(value.itemOptionID).text(value.itemOptionName).appendTo(select);
                        });
                    });
                    
                });
                
            });


        </script>
    </head><!--/head-->

    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="label.searchbill" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">



                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.searchinput" />
                            </div>
                            <form:form method="POST" action="searchSaleOrder" modelAttribute="saleOrderForm"> 
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-4">


                                            <div class="form-group">
                                                <label><fmt:message key="label.trip" /></label>
                                                <form:select path="orderTripID" id = "orderTrip" class="form-control">

                                                    <form:options items="${orderTripList}"/>
                                                </form:select> 

                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <label><fmt:message key="label.itemcategory" /></label>
                                                <form:select path="itemCategory" id = "itemCategory" class="form-control">

                                                    <form:options items="${itemCategoryList}"/>
                                                </form:select> 

                                            </div>      



                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <label><fmt:message key="label.customer" /></label>
                                                <form:select path="customerID" id = "customerID" class="form-control">

                                                    <form:options items="${customerList}"/>
                                                </form:select> 

                                            </div>      



                                        </div>

                                        <!-- /.col-lg-6 (nested) -->
                                    </div>

                                    <div class="row">
                                        <div class="col-lg-4">


                                            <div class="form-group">
                                                <label><fmt:message key="label.item" /></label>
                                                <form:select path="itemID" id = "itemID" class="form-control">

                                                    <form:options items="${itemList}"/>
                                                </form:select> 

                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <label><fmt:message key="label.itemoption" /></label>
                                                <form:select path="itemOptionID" id = "itemOptionID" class="form-control">

                                                    <form:options items="${itemOptionList}"/>
                                                </form:select> 

                                            </div>      



                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <label><fmt:message key="label.bill" />？</label>
                                                <form:select path="itemIsPay" id = "itemIsPay" class="form-control">

                                                    <form:options items="${itemIsPayList}"/>
                                                </form:select> 

                                            </div>      



                                        </div>

                                        <div class="col-lg-4"> <input type="submit" class="btn btn-default" value="Submit" /> </div>

                                        <!-- /.col-lg-6 (nested) -->
                                    </div>
                                </form:form>
                                <!-- /.row (nested) -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <label><fmt:message key="label.bill1" /></label>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">

                                
                                    
                                    <div class="dataTable_wrapper">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th><fmt:message key="label.customer" />客户</th>
                                                    <th><fmt:message key="label.item" />货物</th>
                                                    <th><fmt:message key="label.itemprice" />货物价钱</th>
                                                    <th><fmt:message key="label.itemoption" />货物选择</th>
                                                    <th><fmt:message key="label.optionremark" />选择备注</th>
                                                    <th><fmt:message key="label.quantity" />数量</th>
                                                    <th><fmt:message key="label.totalamount" />总价钱</th>
                                                    <th><fmt:message key="label.remarks" />备注</th>

                                                    <th><fmt:message key="label.bill" />？</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                  <c:forEach var="saleOrderList" items="${saleOrderList}" varStatus = "saleOrderListLoop"> 
                                                    <c:if test="${saleOrderListLoop.index % 2 == 1}">
                                                        <tr class="odd">
                                                        </c:if> 
                                                        <c:if test="${saleOrderListLoop.index % 2 == 0}">
                                                        <tr class="even">
                                                        </c:if> 
                                                        <td>${saleOrderListLoop.index + 1}</td>
                                                        <td>${saleOrderList.customerName}</td>
                                                        <td>${saleOrderList.itemCodeDescription}</td>
                                                        <td>${saleOrderList.itemPrice}</td>
                                                        <td>${saleOrderList.itemOptionName}</td>
                                                        <td>${saleOrderList.itemOtherOption}</td>
                                                        <td>${saleOrderList.itemQuantity}</td>
                                                        <td>${saleOrderList.totalPrice}</td>
                                                        <td>${saleOrderList.itemRemarks}</td>
                                                        <td>${saleOrderList.itemIsPay}</td>
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

    </body>
          <script src="${pageContext.request.contextPath}/js/dataTables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dataTables/dataTables.bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${pageContext.request.contextPath}/js/startmin.js"></script>

        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
        <script>
            $(document).ready(function() {
                $('#dataTables-example').DataTable({
                        responsive: true
                });
            });
        </script>
</html>