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
                        <h1 class="page-header">行程表更新</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        
             

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                行程表更新输入
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
        
                        <form:form method="POST" action="updateOrderTrip" modelAttribute="saleOrderForm" role="form">
				 <div class="form-group">
                                      <label>行程描述</label>
                               <form:input path="orderTripDescription"  class="form-control"/>
                                <p class="help-block">Example ：Bangkok_20180619</p>
                                <p class="help-block">创造时间 ：${saleOrderForm.orderTripCreatedDate}</p>
                                <p class="help-block">更新时间 ：${saleOrderForm.orderTripUpdatedDate}</p>
                          <input type="submit" class="btn btn-default" value="Submit" />
                          
                             </div>
                                
                                <form:hidden path="orderTripID" />   
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