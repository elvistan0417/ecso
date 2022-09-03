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
                        <h1 class="page-header"><fmt:message key="label.itemcategorydetails" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.itemcategoryname" /> - ${itemCategoryName}
                                <br>
                                <fmt:message key="label.tripname" /> - ${orderTripDescription}
                               
                            </div>
                            
                            <!-- /.panel-heading -->
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
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th><fmt:message key="label.itemoption" /></th>
                                                <th><fmt:message key="label.creationdate" /></th>
                                                <th><fmt:message key="label.updatedate" /></th>
                                             
              
                                            </tr>
                                        </thead>
                                        <tbody>
                                             <c:forEach var="itemOptionList" items="${itemOptionList}" varStatus = "itemOptionListLoop"> 
                                            <tr>
                                                <td>${itemOptionListLoop.index + 1}</td>
                                                <td>${itemOptionList.itemOptionName}</td>
                                                <td>${itemOptionList.itemOptionCreateDate}</td>
                                                <td>${itemOptionList.itemOptionUpdateDate}</td>
                                                
                                                
                                            </tr>
                                            
                                            </c:forEach>
                                        </tbody>
                                    </table>
                   
                  
                                    <a href="<c:url value='/insertExstingItemOption?itemCategoryID=${itemCategoryID}&itemCategoryName=${itemCategoryName}'/>" class="btn btn-default"><fmt:message key="label.add" /></a>
                                    <a href="<c:url value='/viewUpdateItemCategoryDetail?itemCategoryID=${itemCategoryID}'/>" class="btn btn-default"><fmt:message key="label.update" /></a>
                                    <a href="<c:url value='/deleteItemCategory?itemCategoryID=${itemCategoryID}'/>" class="btn btn-default" onclick="return confirm('Confirm Delete?')"><fmt:message key="label.delete" /></a>
                                
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