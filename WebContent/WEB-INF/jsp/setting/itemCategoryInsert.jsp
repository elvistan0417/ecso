<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
                        <h1 class="page-header"><fmt:message key="label.createitemcategory" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        
             

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.createitemcategory" />
                                <br>
                                <fmt:message key="label.trip" /> - ${orderTripDescription}
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
        
                        <form:form method="POST" action="insertItemCategory" modelAttribute="itemCategoryForm" role="form">
				 <div class="form-group">
                                      <label><fmt:message key="label.newitemcategory" /></label>
                               <form:input path="itemCategoryName"  class="form-control"/>
                                <p class="help-block">Example ：Clothes</p>
                               
                          <form:hidden path="orderTripID" />   
                                <br>
                                <input type="submit" class="btn btn-default" value="Next" />
                          
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
                <!-- /.row -->
            </div>
                </div>
        <!-- /#wrapper -->
</body>
</html>