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
</head><!--/head-->

<body>
    
        <div id="wrapper">
            
         <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="label.customerreport" /></h1>
                         <label><fmt:message key="label.currenttrip" /> - <font color="INDIANRED">${orderTripDescription}</font></label>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
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
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                                     <fmt:message key="label.unpaidbill" />
                                                         </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="dataTable_wrapper">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                     <th>#</th>
                                                    <th><fmt:message key="label.customer" /></th>
                                                    <th><fmt:message key="label.totalstockquantity" /></th>
                                                    <th><fmt:message key="label.totalamount" /></th>
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
                                                        <td>${unPaySaleOrderObjectListLoop.index + 1}</td>
                                                        <td><a href="<c:url value='/viewCustomerDetail?customerID=${unPaySaleOrderObjectList.customerID}'/>">${unPaySaleOrderObjectList.customerName}</a></td>
                                                        <td>${unPaySaleOrderObjectList.totalOrderItemQuantity}</td>
                                                        <td>${unPaySaleOrderObjectList.totalOrderItemPrice}</td>
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
<div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                                     <fmt:message key="label.paidbill" />
                                                         </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="dataTable_wrapper">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example1">
                                        <thead>
                                            <tr>
                                                     <th>#</th>
                                                    <th><fmt:message key="label.customer" /></th>
                                                    <th><fmt:message key="label.totalstockquantity" /></th>
                                                    <th><fmt:message key="label.totalamount" /></th>
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
                                                        <td>${paidSaleOrderObjectListLoop.index + 1}</td>
                                                        <td><a href="<c:url value='/viewCustomerDetail?customerID=${paidSaleOrderObjectList.customerID}'/>">${paidSaleOrderObjectList.customerName}</a></td>
                                                        <td>${paidSaleOrderObjectList.totalOrderItemQuantity}</td>
                                                        <td>${paidSaleOrderObjectList.totalOrderItemPrice}</td>
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
            $(document).ready(function() {
                $('#dataTables-example').DataTable({
                        responsive: true
                });
               $('#dataTables-example1').DataTable({
                        responsive: true
                });
            });
        </script>
</html>