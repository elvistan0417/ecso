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
        <link href="${pageContext.request.contextPath}/css/select2.min.css" rel="stylesheet" />
        <!--        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />-->
    </head><!--/head-->

    <script  type="text/javascript">
        var checkInput = false;
window.onbeforeunload = function() {
    if(checkInput){
    return "Data will be lost if you leave the page, are you sure?";
    }
};
        //var listForPendingItem = [];
        var myJString = "";
        var myObj = {"": "0.00"};


        myObj = {
        <c:forEach items="${itemDetailList}" var="itemDetailList">
            "<c:out value="${itemDetailList.itemDetailID}" />": "<c:out value="${itemDetailList.itemPrice}" />",
        </c:forEach>
            "": "0.00"}

function changeAlertFlag() {
checkInput = false;
};
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

        function myFunction2(val, totalAmountID, itemID, customer, option, quantity, actualAmountID) {
//    document.getElementById(id).value 


            var xxx = val * document.getElementById(itemID).value;

            document.getElementById(totalAmountID).value = xxx;
            document.getElementById(actualAmountID).value = xxx;

            if (val != "") {
                document.getElementById(customer).required = true;
                document.getElementById(option).required = true;
                document.getElementById(quantity).required = true;
            } else {
                document.getElementById(customer).required = false;
                document.getElementById(option).required = false;
                document.getElementById(quantity).required = false;
            }

        }

        function callFunction(value, item, option, quantity) {
            //$('#saleOrderListing0.itemID').prop('required',true);
            //alert("check value " + value);
            
            if (value != "") {
                checkInput = true;
                document.getElementById(item).required = true;
                document.getElementById(option).required = true;
                document.getElementById(quantity).required = true;
            } else {
                checkInput = false;
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
                        <h1 class="page-header">下单</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
 
                                <label>目前行程 - <font color="INDIANRED">${orderTripDescription}</font></label>
                            </div>
                            <div class="panel-body">
                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    下单成功
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    下单失败，请联络技术人员
                                </div>
                                </c:if>
                    
                                <div class="row">
                                     
                                    <!-- /.col-lg-6 (nested) -->
                                    <div class="col-lg-6">
                                        <form role="form">
                                                
                                            <div class="form-group">
                                                <label>货物种类</label>
                                                <select class="form-control" onchange="location = this.value;" >
                                                    <c:forEach var="itemCategoryObjectList" items="${itemCategoryObjectList}" varStatus = "itemCategoryObjectListLoop"> 

                                                        <c:if test="${itemCategoryObjectList.itemCategoryID == choosenItemCategoryID}">
                                                            <option selected="selected"  value='<c:url value='/viewOrderInsertByOC?itemCategoryID=${itemCategoryObjectList.itemCategoryID}&orderTripID=${choosenOrderID}'/>'>${itemCategoryObjectList.itemCategoryName}</option>
                                                        </c:if>
                                                        <c:if test="${itemCategoryObjectList.itemCategoryID != choosenItemCategoryID}">
                                                            <option value='<c:url value='/viewOrderInsertByOC?itemCategoryID=${itemCategoryObjectList.itemCategoryID}&orderTripID=${choosenOrderID}'/>'>${itemCategoryObjectList.itemCategoryName}</option>                                                             
                                                        </c:if>    
                                                    </c:forEach>
                                                </select>
                                            </div>

                                        </form>
                                    </div>
                                     </div>
                                    <!-- /.col-lg-6 (nested) -->
                                </div>
                             </div>
                             </div>
                             </div>
                             <div class="row">
                    <div class="col-lg-12">
                                <!-- /.row (nested) -->
                                <form:form method="POST" action="insertSaleOrder" modelAttribute="saleOrderObject" role="form">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                            
                                            <div class="panel-heading">
                                                资料输入
<input type="submit" class="btn btn-default" value="Submit" onclick="changeAlertFlag()"  />
                                            </div>
                                            <!-- /.panel-heading -->
                                            
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <table id="tab_logic" class="table table-striped table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                    <th>客户</th>
                                                                    <th>货物</th>
                                                                    <th>货物价钱</th>
                                                                    <th>货物选择</th>
                                                                    <th>其他选择</th>

                                                                    <th>数量</th>
                                                                    <th>总价钱</th>
                                                                    <th>备注</th>
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                <c:forEach var="counter" begin="0" end="19">
                                                                    <tr>
                                                                        <td>${counter + 1}</td>
                                                                        <td><form:select path="saleOrderListing[${counter}].customerID" items="${customerList}" class="form-control js-example-basic-multiple" onchange="callFunction(this.value,'saleOrderListing${counter}.itemID','saleOrderListing${counter}.itemOptionID','saleOrderListing${counter}.itemQuantity')"/></td>
                                                                        <td><form:select path="saleOrderListing[${counter}].itemID" items="${itemList}" class="form-control js-example-basic-multiple" onchange="changeValue(this.value,'saleOrderListing${counter}.itemPrice','saleOrderListing${counter}.customerID','saleOrderListing${counter}.itemOptionID','saleOrderListing${counter}.itemQuantity')"  /></td>
                                                                        <td><form:input path="saleOrderListing[${counter}].itemPrice" size="5" pattern= "[0-99999]+(.[0-99999]{0,2})?$" onchange="myFunction2(this.value,'saleOrderListing${counter}.itemTotalPrice','saleOrderListing${counter}.itemQuantity','saleOrderListing${counter}.customerID','saleOrderListing${counter}.itemOptionID','saleOrderListing${counter}.itemQuantity','saleOrderListing${counter}.itemActualAmount')"/></td>
                                                                        <td><form:select path="saleOrderListing[${counter}].itemOptionID" items="${itemOptionList}" class="form-control js-example-basic-multiple" /></td>
                                                                        <td>  <form:input path="saleOrderListing[${counter}].itemOtherOption"/> </td>
                                                                        <td><form:input path="saleOrderListing[${counter}].itemQuantity" size="5"  pattern= "[0-99999]+(.[0-99999]{0,2})?$" onchange="myFunction2(this.value,'saleOrderListing${counter}.itemTotalPrice','saleOrderListing${counter}.itemPrice','saleOrderListing${counter}.customerID','saleOrderListing${counter}.itemOptionID','saleOrderListing${counter}.itemQuantity','saleOrderListing${counter}.itemActualAmount')"/></td>
                                                                        <td><form:input path="saleOrderListing[${counter}].itemTotalPrice" size="5"  pattern= "[0-99999]+(.[0-99999]{0,2})?$"/></td>
                                                                        <td><form:input path="saleOrderListing[${counter}].itemRemarks" /></td>
                                                                    </tr>
                                                                    <form:hidden path="saleOrderListing[${counter}].itemActualAmount" /> 
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                        <form:hidden path="orderTripID" />
                                                        <form:hidden path="itemCategory" />
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