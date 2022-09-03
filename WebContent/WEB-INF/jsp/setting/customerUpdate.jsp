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
                        <h1 class="page-header"><fmt:message key="label.customerdetail" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                         <fmt:message key="label.customer" />
                   
                        </div>
 <form:form method="POST" action="updateCustomer" modelAttribute="contactDetailsForm" role="form">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                              

                                        <div class="form-group">
                                            <label><fmt:message key="label.name" /></label>
                                           
                                             <form:input path="customerName"  class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message key="label.phonenumber" /></label>
                                            
                                            <form:input path="customerPhone"  class="form-control"/>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label><fmt:message key="label.facebookname" /></label>
                                           
                                            <form:input path="fbName"  class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message key="label.wechatname" /></label>
                                            
                                            <form:input path="weChatName"  class="form-control"/>
                                        </div>
                                   </div>
                              
                                 <div class="col-lg-6">
                         
                                        <div class="form-group">
                                            <label><fmt:message key="label.creationdate" /></label>
                                           
                                            <form:input path="createDate"  class="form-control"/>
                                        </div>
                                          <div class="form-group">
                                            <label><fmt:message key="label.updatedate" /></label>
                                         
                                             <form:input path="updateDate"  class="form-control"/>
                                        </div>
                                       <div class="form-group">
                                            <label><fmt:message key="label.address" /></label>
                            
                                            <form:input path="customerAddress"  class="form-control"/>
                                        </div>
                                      <div class="form-group">
                                            <label><fmt:message key="label.fullname" /></label>
                            
                                            <form:input path="customerFullName"  class="form-control"/>
                                        </div>
                                </div>
                            </div>
                                          <input type="submit" class="btn btn-default" value="Submit" />
                        </div>
                        <!-- /.panel-body -->
                     <form:hidden path="customerID" />   
                         </form:form>
                    </div>
                    <!-- /.panel -->
                </div>

            </div>
        </div>
        <!-- /#wrapper -->
    </body>
</html>