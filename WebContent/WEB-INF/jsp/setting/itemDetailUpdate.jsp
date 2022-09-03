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
             <form:form method="POST" action="updateItemDetail" modelAttribute="itemDetailForm" role="form">
         <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="label.itemdetail" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.itemcategoryname" /> -
                                ${itemCategoryName}
                                <br>
                                <fmt:message key="label.tripname" /> -
                                ${orderTripDescription}
                               
                            </div>
                            
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th><fmt:message key="label.itemcode" /></th>
                                                <th><fmt:message key="label.itemname" /></th>
                                                <th><fmt:message key="label.itemprice" /></th>
                                                    <th><fmt:message key="label.delete" />？</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                             
                                            <c:forEach items="${itemDetailForm.itemDetailList}"  varStatus="status">
                                                 <tr>
                                                <td>${status.index + 1}</td>
                                                <td>
                                                  <form:input path="itemDetailList[${status.index}].itemName"  class="form-control"   required="required"/>
                                                </td>
                                              <td>
                                                  <form:input path="itemDetailList[${status.index}].itemDescription"  class="form-control"   required="required"/>
                                                </td>
                                              <td>
                                                  <form:input path="itemDetailList[${status.index}].itemPrice"  class="form-control" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/>
                                                </td>
                                                <td> 
                                                    <form:checkbox path="itemDetailList[${status.index}].itemDetailDeleteFlag" value="Y"  class="form-control"/>
                                                  
                                                    </td>
                                            </tr>
                                            <form:hidden path="itemDetailList[${status.index}].itemCategoryID" />  
                                            <form:hidden path="itemDetailList[${status.index}].itemDetailID" />  
                                            </c:forEach>
                                        </tbody>
                                    </table>
                   
                                <input type="submit" class="btn btn-default" value="Submit" />
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                
            </div>
                                     <form:hidden path="itemCategoryID" />  
                                      </form:form>
                </div>
        <!-- /#wrapper -->
</body>
</html>