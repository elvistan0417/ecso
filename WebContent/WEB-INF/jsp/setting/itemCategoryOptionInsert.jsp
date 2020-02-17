<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <script>
            var increment = 2;
            var index = 1;
            function add() {
              //  var row = $("#tab_logic > tbody > tr:first").html(); //You can create your own html here
         var row = '<td>  <label>货物选项'+increment+'</label> <input id="itemOptionList'+ index +'.itemOptionName" name="itemOptionList[' + index + '].itemOptionName" placeholder="输入" class="form-control" type="text" value=""   required="required"> </td>';
     
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
                        <h1 class="page-header">货物选项</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <div class="row">
                    <div class="col-lg-12">



                        <div class="panel panel-default">
                            <div class="panel-heading">
                                货物种类 - ${itemCategoryName}
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <form:form method="POST" action="insertItemCategoryOption" modelAttribute="itemCategoryForm" role="form">

                                        <div class="col-lg-6">
                                            <table id="tab_logic">
                                                <tr id="tr1">       
                                                    
                                                    <td>  <label>货物选项1</label> <form:input path="itemOptionList[0].itemOptionName" class="form-control" placeholder="输入"   required="required"/> </td>
                                                      
                                                    </tr>
                                                </table>
                                                <button type="button" class="btn btn-default" onclick="add()">增加选择 （+）</button>
                                                <button type="button" class="btn btn-default" onclick="deleterow()">删除 （-）</button> 
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