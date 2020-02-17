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

        <!-- DataTables CSS -->
        <link href="${pageContext.request.contextPath}/css/dataTables/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="${pageContext.request.contextPath}/css/dataTables/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/css/startmin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/select2.min.css" rel="stylesheet" />
        <!--        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />-->
    
<script>

            $(document).ready(function () {

                
                
                $('#itemCategory').change(function (event) {

                    var itemCategoryID = $("select#itemCategory").val();
                    $.get('/ecso/getItemA', {
                        itemCategoryID : itemCategoryID
                    }, function (response) {

                        var select = $('#itemID');
                        select.find('option').remove();
                        $('<option>').val('').text('Please Select').appendTo(select);
                        $.each(response, function (index, value) {
                            $('<option>').val(value.itemDetailID).text(value.itemCodeDescription).appendTo(select);
                        });
                    });
                    
                    $.get('/ecso/getItemOptionA', {
                        itemCategoryID: itemCategoryID
                    }, function (response) {

                        var select = $('#itemOptionID');
                        select.find('option').remove();
                        $('<option>').val('').text('Please Select').appendTo(select);
                        $.each(response, function (index, value) {
                            $('<option>').val(value.itemOptionID).text(value.itemOptionName).appendTo(select);
                        });
                    });
                    
                });
                
            });
        function myFunction2(val, itemAmount) {

            var xxx = val * document.getElementById(itemAmount).value;

            document.getElementById('totalPrice').value = xxx;

        }
        
         function myFunction(val, quantity) {

            var xxx = val * document.getElementById(quantity).value;

            document.getElementById('totalPrice').value = xxx;

        }


        </script>

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
 <form:form method="POST" action="updateOrderDetail" modelAttribute="saleOrderDetail" role="form">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                              
                                        <div class="form-group">
                                            <label>客户名字</label><br>
                                            
                                            ${saleOrderDetail.customerName}

                                        </div>
                                        
                                        <div class="form-group">
                                            <label>货物类型</label>
                                        <form:select path="itemCategory" items="${itemCategoryList}" class="form-control js-example-basic-multiple"  required="required"/>

                                        </div>
                                       
                                        
                                        <div class="form-group">
                                                <label>货物</label>
                                                <form:select path="itemID" id = "itemID" class="form-control"  required="required">

                                                    <form:options items="${itemDetailList}"/>
                                                </form:select> 

                                            </div>
                                         <div class="form-group">
                                                <label>货物选择</label>
                                                <form:select path="itemOptionID" id = "itemOptionID" class="form-control"  required="required">

                                                    <form:options items="${itemOptionList}"/>
                                                </form:select> 

                                            </div> 
                                        <div class="form-group">
                                            <label>其他选择备注</label>
                                          
                                            <form:input path="itemOtherOption"  class="form-control"/>
                                        </div>
                                        
                                   </div>
                              
                                 <div class="col-lg-6">
                         
                                    <div class="form-group">
                                            <label>货物价钱</label>
                                           
                                            <form:input path="itemPrice"  class="form-control" onchange="myFunction2(this.value,'itemQuantity')" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/>
                                        </div>
                                  <div class="form-group">
                                            <label>数量</label>
                                            <form:input path="itemQuantity"  class="form-control" onchange="myFunction2(this.value,'itemPrice')" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/>
                                           
                                        </div>
                                       <div class="form-group">
                                            <label>总价钱</label>
                                            <form:input path="totalPrice"  class="form-control" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/>
                                          
                                        </div>
                                    <div class="form-group">
                                            <label>备注</label>
                                             <form:input path="itemRemarks"  class="form-control"/>
                                           
                                        </div>
                                     
                                        
                                </div>
                            </div>
                                          <input type="submit" class="btn btn-default" value="Submit" />
                        </div>
                        <!-- /.panel-body -->
                     <form:hidden path="customerID" /> 
                     <form:hidden path="orderDetailID" /> 
                     <form:hidden path="orderTripID" /> 
                     <form:hidden path="isPayFlag" /> 
                         </form:form>
                    </div>
                    <!-- /.panel -->
                </div>

            </div>
        </div>
        <!-- /#wrapper -->
    </body>
<script src="${pageContext.request.contextPath}/js/startmin.js"></script>

                        <script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
                        <!--                        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>-->
                        <script>
                                                    $(document).ready(function () {
                                                        $('.js-example-basic-multiple').select2();
                                                    });
                        </script>
</html>