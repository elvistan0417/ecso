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

<link href="${pageContext.request.contextPath}/css/morris.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    </head><!--/head-->

    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">下单分析报告</h1>
                        <label>目前行程 - <font color="INDIANRED">${orderTripDescription}</font></label>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="col-lg-12">


                        <!-- /.panel-heading -->

                    <div class="col-lg-5">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                
                                货物类型数量
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                         <div class="dataTable_wrapper">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
<th>#</th>
                                                    <th>货物类型</th>
                                                    <th>总数量</th>
                                                    
                                               
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="reportObjectList" items="${reportObjectList}" varStatus = "reportObjectListLoop"> 
                                                    <c:if test="${reportObjectListLoop.index % 2 == 1}">
                                                        <tr class="odd">
                                                        </c:if> 
                                                        <c:if test="${reportObjectListLoop.index % 2 == 0}">
                                                        <tr class="even">
                                                        </c:if> 
                                                        <td>${reportObjectListLoop.index + 1}</td>
                                                        <td>${reportObjectList.itemCategoryName}</td>
                                                        <td>${reportObjectList.itemQuantity}</td>
                                                        
                                                        
                            
                                                        
                                                    </tr>



                                                </c:forEach>
                                                    
                                                    <tr>
                                                        <td>Total Quantity</td>
                                                        <td></td>
                                                        <td>${totalQuantity}</td>
                                                    </tr>
                                            </tbody>
                                        </table>
                                    </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <div class="col-lg-7">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                
                                货物类型数量分析
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                        
<div class="col-lg-5">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                
                                货物类型价钱
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                         <div class="dataTable_wrapper">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                  <th>#</th>
                                                    <th>货物类型</th>
                                                    <th>总价钱 (RM)</th>
                                                    
                                               
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="reportObjectList1" items="${reportObjectList1}" varStatus = "reportObjectListLoop1"> 
                                                    <c:if test="${reportObjectListLoop1.index % 2 == 1}">
                                                        <tr class="odd">
                                                        </c:if> 
                                                        <c:if test="${reportObjectListLoop1.index % 2 == 0}">
                                                        <tr class="even">
                                                        </c:if> 
                                                        <td>${reportObjectListLoop1.index + 1}</td>
                                                        <td>${reportObjectList1.itemCategoryName}</td>
                                                        <td>${reportObjectList1.totalPrice}</td>
                                                        
                                                        
                            
                                                        
                                                    </tr>



                                                </c:forEach>
                                                    
                                                   <tr>
                                                        <td>Total Price (RM)</td>
                                                        <td></td>
                                                        <td>${totalPrice}</td>
                                                    </tr>
                                            </tbody>
                                        </table>
                                    </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <div class="col-lg-7">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                货物类型价钱分析
                                 
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div id="morris-donut-chart1"></div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>

            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/raphael.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/morris.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/morris-data.js"></script>
        <script>
            
  new  Morris.Donut({
        element: 'morris-donut-chart',
        data:[
        <c:forEach items="${reportObjectList}" var="reportObjectList">
          {  
          label: "<c:out value="${reportObjectList.itemCategoryName}" />",
          value: <c:out value="${reportObjectList.itemQuantity}" />
        },
        </c:forEach>
        ],
        resize: true
    });         
  new  Morris.Donut({
        element: 'morris-donut-chart1',
        data:[
        <c:forEach items="${reportObjectList1}" var="reportObjectList1">
          {  
          label: "<c:out value="${reportObjectList1.itemCategoryName}" />",
          value: <c:out value="${reportObjectList1.totalPrice}" />
        },
        </c:forEach>
        ],
        resize: true
    });        
        </script>
    </body>
</html>