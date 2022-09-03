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
                        <h1 class="page-header"><fmt:message key="label.triplist" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             
             <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        
             

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.inserttrip" />
                            </div>
                            <div class="panel-body">
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
                                    <div class="col-lg-6">
        
                        <form:form method="POST" action="insertOrderTrip" modelAttribute="saleOrderForm" role="form">
				 <div class="form-group">
                                      <label><fmt:message key="label.tripdescription" /></label>
                               <form:input path="orderTripDescription"  class="form-control" required="required"/>
                                <p class="help-block">Example ：Bangkok_20180619</p>
                          <input type="submit" class="btn btn-default" value="Submit" />
                          
                             </div>
                         </form:form>
                                
                                    </div>
                                    <!-- /.col-lg-6 (nested) -->
                                </div>
                                <!-- /.row (nested) -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             <div class="row">
                <!-- /.row -->
             <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.triphistory" />
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th><fmt:message key="label.tripdescription" /></th>
                                                
                                                <th><fmt:message key="label.creationdate" /></th>
                                                <th><fmt:message key="label.updatedate" /></th>
                                                <th><fmt:message key="label.currenttrip" /></th>
                                                 <th></th>
                                                 <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="orderTripList" items="${orderTripList}" varStatus = "orderTripListLoop"> 
                                            <tr>
                                                <td>${orderTripListLoop.index + 1}</td>
                                                <td>${orderTripList.orderTripDescription}</td>
                                                <td>${orderTripList.orderTripCreatedDate}</td>
                                                <td>${orderTripList.orderTripUpdatedDate}</td>
                                                <td>${orderTripList.orderTripCurrentFlag}</td>
                                                <td><a href="<c:url value='/viewUpdateOrderTrip?orderTripID=${orderTripList.orderTripID}'/>" class="btn btn-default"><fmt:message key="label.update" /></a> </td>
                                                 <td>
                                                     
                                                     <c:if test ="${orderTripList.orderTripCurrentFlag != 'Y'}">
                                                     <a href="<c:url value='/deleteOrderTrip?orderTripID=${orderTripList.orderTripID}'/>" class="btn btn-default" onclick="return confirm('Confirm Delete?')"><fmt:message key="label.delete" /></a>
                                                     </c:if>
                                                 
                                                 </td>
                                                 <td><a href="<c:url value='/setCurrentTrip?orderTripID=${orderTripList.orderTripID}'/>" class="btn btn-default"><fmt:message key="label.setascurrenttrip" /></a> </td>
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
                </div>
        <!-- /#wrapper -->
</body>
</html>