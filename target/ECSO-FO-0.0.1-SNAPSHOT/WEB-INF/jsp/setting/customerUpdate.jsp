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
                        <h1 class="page-header">客户详情</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                         客户
                   
                        </div>
 <form:form method="POST" action="updateCustomer" modelAttribute="contactDetailsForm" role="form">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                              

                                        <div class="form-group">
                                            <label>名字</label>
                                           
                                             <form:input path="customerName"  class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label>电话号码</label>
                                            
                                            <form:input path="customerPhone"  class="form-control"/>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>facebook名</label>
                                           
                                            <form:input path="fbName"  class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label>wechat名</label>
                                            
                                            <form:input path="weChatName"  class="form-control"/>
                                        </div>
                                   </div>
                              
                                 <div class="col-lg-6">
                         
                                        <div class="form-group">
                                            <label>创造日期</label>
                                           
                                            <form:input path="createDate"  class="form-control"/>
                                        </div>
                                          <div class="form-group">
                                            <label>更新日期</label>
                                         
                                             <form:input path="updateDate"  class="form-control"/>
                                        </div>
                                       <div class="form-group">
                                            <label>地址</label>
                            
                                            <form:input path="customerAddress"  class="form-control"/>
                                        </div>
                                      <div class="form-group">
                                            <label>Posting Full Name</label>
                            
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