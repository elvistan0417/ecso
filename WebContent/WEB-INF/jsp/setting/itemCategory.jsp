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
                        <h1 class="page-header">货物种类</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             <div class="col-lg-12">
                 
                   <div class="form-group">
                                                <label>行程表</label>
                                                <select class="form-control" onchange="location = this.value;" >
                                                     <c:forEach var="orderTripList" items="${orderTripList}" varStatus = "orderTripListLoop"> 
                                                         
                                                         <c:if test="${orderTripList.orderTripID == choosenOrderID}">
                                                         <option selected="selected"  value='<c:url value='/listItemCategory?orderTripID=${orderTripList.orderTripID}'/>'>${orderTripList.orderTripDescription}</option>
                                                         </c:if>
                                                         <c:if test="${orderTripList.orderTripID != choosenOrderID}">
                                                         <option value='<c:url value='/listItemCategory?orderTripID=${orderTripList.orderTripID}'/>'>${orderTripList.orderTripDescription}</option>                                                             
                                                          </c:if>    
                                                    </c:forEach>
                                                </select>
                                            </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                货物种类
                                <a href="<c:url value='/viewInsertItemCategory?orderTripID=${choosenOrderID}'/>" class="btn btn-default">新增</a> 
                            </div>
                            
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    执行成功
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    执行失败，请联络技术人员
                                </div>
                                </c:if>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>货物种类</th>
                                                <th>创造时间</th>
                                                <th>更新时间</th>
                                                 <th></th>
                                                    <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                             <c:forEach var="itemCategoryObjectList" items="${itemCategoryObjectList}" varStatus = "itemCategoryObjectListLoop"> 
                                            <tr>
                                                <td>${itemCategoryObjectListLoop.index + 1}</td>
                                                <td>${itemCategoryObjectList.itemCategoryName}</td>
                                                <td>${itemCategoryObjectList.itemCategoryCreateDate}</td>
                                                <td>${itemCategoryObjectList.itemCategoryUpdateDate}</td>
                                                <td><a href="<c:url value='/viewItemCategoryDetail?itemCategoryID=${itemCategoryObjectList.itemCategoryID}'/>" class="btn btn-default">选项条目</a> <td>
                                                <td><a href="<c:url value='/viewItemDetailList?itemCategoryID=${itemCategoryObjectList.itemCategoryID}'/>" class="btn btn-default">货物条目</a> <td>
                                            </tr>
                                            
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
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