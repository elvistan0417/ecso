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
        <script>
            var increment = 2;
            var index = 1;
            function add() {
              //  var row = $("#tab_logic > tbody > tr:first").html(); //You can create your own html here
         var row = '<td>'+increment+'</td> <td>  <input id="itemDetailList'+ index +'.itemName" name="itemDetailList[' + index + '].itemName" placeholder="货物ID输入" class="form-control" type="text" value=""   required="required"> </td>\n\
                    \n\
                    <td>  <input id="itemDetailList'+ index +'.itemDescription" name="itemDetailList[' + index + '].itemDescription" placeholder="货物名称输入" class="form-control" type="text" value=""   required="required"> </td>\n\
                    \n\
                    <td>  <input id="itemDetailList'+ index +'.itemPrice" name="itemDetailList[' + index + '].itemPrice" placeholder="货物价钱输入" class="form-control" type="text" value="0.0" pattern= "[0-99999]+(.[0-99999]{0,2})?$"> </td>';
     
        $('#tab_logic > tbody ').append('<tr>' + row + '</tr>');
                
                increment++;index++;

            }

            function removeElm(obj) {
                var row = $('#tab_logic > tbody > tr').length;

                if (row <= 1) {
                    alert("Not possible to delete this row");
                    return;
                }

                $(obj).parent().parent().remove();
            }
            
            function deleterow() {
            var table = document.getElementById("tab_logic");
            var rowCount = table.rows.length;

            table.deleteRow(rowCount -1);
            increment--;
            index--;
}
        </script>

    </head><!--/head-->

    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="label.createitem" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <div class="row">
                    <div class="col-lg-12">



                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.itemcategory" /> - ${itemCategoryName}
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <form:form method="POST" action="insertItemDetail" modelAttribute="itemDetailForm" role="form">

                                        <div class="col-lg-6">
                                            <table id="tab_logic"  class="table">
                                          <thead>
                                            <tr>
                                                <th>#</th>
                                                <th><fmt:message key="label.itemcode" /></th>
                                                <th><fmt:message key="label.itemname" /></th>
                                                <th><fmt:message key="label.itemprice" /></th>
                                             
              
                                            </tr>
                                        </thead>
                                                
                                                
                                        <tbody>
                                                <tr id="tr1">       
                                                    <td>1</td>
                                                    <td><form:input path="itemDetailList[0].itemName" class="form-control" placeholder="Item Code"   required="required"/> </td>
                                                    <td><form:input path="itemDetailList[0].itemDescription" class="form-control" placeholder="Item Name"   required="required"/>  </td>
                                                    <td><form:input path="itemDetailList[0].itemPrice" class="form-control" placeholder="Item Price" pattern= "[0-99999]+(.[0-99999]{0,2})?$"/> </td>
                                                      
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <button type="button" class="btn btn-default" onclick="add()"><fmt:message key="label.add" /> （+）</button>
                                                <button type="button" class="btn btn-default" onclick="deleterow()"><fmt:message key="label.delete" /> （-）</button>
                                        <input type="submit" class="btn btn-default" value="Submit" />    
                                        </div>
                                            <!-- /.col-lg-6 (nested) -->
                                            <form:hidden path="itemCategoryID" /> 
                                    </form:form>
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