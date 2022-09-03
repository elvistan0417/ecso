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
        <link href="${pageContext.request.contextPath}/css/select2.min.css" rel="stylesheet" />
        <!--        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />-->
    </head><!--/head-->

    <script  type="text/javascript">
        //var listForPendingItem = [];
        var myJString = "";
        var myObj = {"": "0.00"};


        myObj = {
        <c:forEach items="${itemDetailList}" var="itemDetailList">
            "<c:out value="${itemDetailList.itemDetailID}" />": "<c:out value="${itemDetailList.itemPrice}" />",
        </c:forEach>
            "": "0.00"}


        function changeValue(itemID, displayID, customerID, option, quantity) {

            document.getElementById(displayID).value = myObj[itemID];

            if (itemID != "") {
                document.getElementById(customerID).required = true;
                document.getElementById(option).required = true;
                document.getElementById(quantity).required = true;
            } else {
                document.getElementById(customerID).required = false;
                document.getElementById(option).required = false;
                document.getElementById(quantity).required = false;
            }

        }
        ;

        function myFunction(value) {
            var checkBox = document.getElementById("myCheck");
            var text = document.getElementById(value);
            if (checkBox.checked == true) {
                text.style.display = "block";
            } else {
                text.style.display = "none";
            }
        }

        function myFunction2(val, totalAmountID, itemID, actualAmountID) {
//    document.getElementById(id).value 


            var xxx = val * document.getElementById(itemID).value;

            document.getElementById(totalAmountID).value = xxx;
            document.getElementById(actualAmountID).value = xxx;


        }

        function callFunction(value, item, option, quantity) {
            //$('#saleOrderListing0.itemID').prop('required',true);
            //alert("check value " + value);
            if (value != "") {
                document.getElementById(item).required = true;
                document.getElementById(option).required = true;
                document.getElementById(quantity).required = true;
            } else {
                document.getElementById(item).required = false;
                document.getElementById(option).required = false;
                document.getElementById(quantity).required = false;
            }

        }

    </script>
    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="label.addorder" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
 
                               <label><fmt:message key="label.currenttrip" /> - <font color="INDIANRED">${orderTripDescription}</font></label>
                                
                            </div>
                            <div class="panel-body">
                                <fmt:message key="label.customername" /> - ${customerDetail.customerName}
                                </div>
                            </div>
                            </div>
                            </div>
                  <div class="row">
                    <div class="col-lg-12">                                
                                <!-- /.row (nested) -->
                                <form:form method="POST" action="updateSaleOrder" modelAttribute="saleOrderObject" role="form">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                            
                                            <div class="panel-heading">
                                                <fmt:message key="label.insertdetail" />
<input type="submit" class="btn btn-default" value="Submit" onclick="return confirm('Confirm Update?')" />
                                            </div>
                                            <!-- /.panel-heading -->
                                            
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <table id="tab_logic" class="table table-striped table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                  
                                                                    <th><fmt:message key="label.item" />货物</th>
                                                                    <th><fmt:message key="label.itemprice" />货物价钱</th>
                                                                    <th><fmt:message key="label.itemoption" />货物选择</th>
                                                                    <th><fmt:message key="label.itemremarks" />其他选择</th>

                                                                    <th><fmt:message key="label.quantity" />数量</th>
                                                                    <th><fmt:message key="label.totalamount" />总价钱</th>
                                                                    <th><fmt:message key="label.remarks" />备注</th>
                                                                    <th><fmt:message key="label.delete" />？</th>
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                               <c:forEach var="saleOrderListing" items="${saleOrderObject.saleOrderListing}" varStatus = "status"> 
                                                                    <tr>
                                                                        <td>${status.index + 1}</td>
                                                                        <td>${saleOrderListing.itemCode} - ${saleOrderListing.itemDescription}</td>
                                                                      
                                                                        <td><form:input path="saleOrderListing[${status.index}].itemPrice" size="5" onchange="myFunction2(this.value,'saleOrderListing${status.index}.totalPrice','saleOrderListing${status.index}.itemQuantity','saleOrderListing${status.index}.itemActualAmount')" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/></td>
                                                                        <td>${saleOrderListing.itemOptionName}</td>
                                                                        <td>  <form:input path="saleOrderListing[${status.index}].itemOtherOption"/> </td>
                                                                        <td><form:input path="saleOrderListing[${status.index}].itemQuantity" size="5" onchange="myFunction2(this.value,'saleOrderListing${status.index}.totalPrice','saleOrderListing${status.index}.itemPrice','saleOrderListing${status.index}.itemActualAmount')" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/></td>
                                                                        <td><form:input path="saleOrderListing[${status.index}].totalPrice" size="5" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/></td>
                                                                        <td><form:input path="saleOrderListing[${status.index}].itemRemarks" /></td>
                                                                    <td><form:checkbox path="saleOrderListing[${status.index}].deleteFlag" value="Y"  class="form-control"/></td>
                                                                    </tr>
                                                                    <form:hidden path="saleOrderListing[${status.index}].itemID" /> 
                                                                    <form:hidden path="saleOrderListing[${status.index}].itemOptionID" /> 
                                                                 
                                                                    <form:hidden path="saleOrderListing[${status.index}].itemActualAmount" /> 
                                                                    <form:hidden path="saleOrderListing[${status.index}].customerID" /> 
                                                                    <form:hidden path="saleOrderListing[${status.index}].orderTripID" /> 
                                                                    <form:hidden path="saleOrderListing[${status.index}].itemCategory" /> 
                                                                    <form:hidden path="saleOrderListing[${status.index}].itemPriceEditFlag" /> 
                                                                    <form:hidden path="saleOrderListing[${status.index}].orderDetailID" /> 
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                        <form:hidden path="orderTripID" />
                                                        <form:hidden path="itemCategory" />
                                                        <form:hidden path="IsPayFlag" />
                                                        
                                                    </div>



                                                </div>
                                                <!-- /.panel-body -->
                                        </div>
                                        <!-- /.panel -->
                                    </div>
                                                     
                                    <!-- /.col-lg-12 -->
                                </div>
                                           </form:form>
                            </div>
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

                        <!-- Custom Theme JavaScript -->
                        <script src="${pageContext.request.contextPath}/js/startmin.js"></script>

                        <script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
                        <!--                        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>-->
                        <script>
                                                    $(document).ready(function () {
                                                        $('.js-example-basic-multiple').select2();
                                                    });
                        </script>

                 
                        </html>