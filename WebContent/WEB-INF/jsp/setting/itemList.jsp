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
                        <h1 class="page-header"><fmt:message key="label.itemcategory" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             <div class="col-lg-12">
                 
                   <div class="form-group">
                                                <label><fmt:message key="label.triplist" /></label>
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
                                <fmt:message key="label.itemcategory" />
                                <a href="<c:url value='/viewInsertItemCategory?orderTripID=${choosenOrderID}'/>" class="btn btn-default"><fmt:message key="label.add" /></a>
                            </div>
                            
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th><fmt:message key="label.itemcategory" /></th>
                                                <th><fmt:message key="label.creationdate" /></th>
                                                <th><fmt:message key="label.updatedate" /></th>
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
                                                <td><a href="<c:url value='/viewItemCategoryDetail?itemCategoryID=${itemCategoryObjectList.itemCategoryID}'/>" class="btn btn-default"><fmt:message key="label.details" /></a> <td>
                                                
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