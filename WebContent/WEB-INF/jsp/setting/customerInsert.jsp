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
            var row = '<td>' + increment + '</td> <td>  <input id="contactDetailsList' + index + '.customerName" name="contactDetailsList[' + index + '].customerName" placeholder="名字" class="form-control" type="text" value=""> </td>\n\
                    \n\
                    <td>  <input id="contactDetailsList' + index + '.customerPhone" name="contactDetailsList[' + index + '].customerPhone" placeholder="电话号码" class="form-control" type="text" value=""> </td>\n\
                    \n\
                    <td>  <input id="contactDetailsList' + index + '.customerAddress" name="contactDetailsList[' + index + '].customerAddress" placeholder="地址" class="form-control" type="text" value=""> </td>\n\
                    \n\
                    <td>  <input id="contactDetailsList' + index + '.fbName" name="contactDetailsList[' + index + '].fbName" placeholder="facebook名" class="form-control" type="text" value=""> </td>\n\
                    \n\
                    <td>  <input id="contactDetailsList' + index + '.weChatName" name="contactDetailsList[' + index + '].weChatName" placeholder="wechat名" class="form-control" type="text" value=""> </td> \n\
                    <td>  <input id="contactDetailsList' + index + '.customerFullName" name="contactDetailsList[' + index + '].customerFullName" placeholder="Posting Full Name" class="form-control" type="text" value=""> </td>';
            $('#tab_logic > tbody ').append('<tr>' + row + '</tr>');
            increment++; index++;
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
            table.deleteRow(rowCount - 1);
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
                        <h1 class="page-header">客户新增</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <div class="row">
                    <div class="col-lg-12">



                        <div class="panel panel-default">
                            <div class="panel-heading">
                                客户输入
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <form:form method="POST" action="insertCustomer" modelAttribute="contactDetailsForm" role="form">

                                        <div class="col-lg-12">
                                            <table id="tab_logic"  class="table">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>名字</th>
                                                        <th>电话号码</th>
                                                        <th>地址</th>
                                                        <th>facebook名</th>
                                                        <th>wechat名</th>
                                                        <th>Posting Full Name</th>


                                                    </tr>
                                                </thead>


                                                <tbody>
                                                    <tr id="tr1">       
                                                        <td>1</td>
                                                        <td><form:input path="contactDetailsList[0].customerName" class="form-control" placeholder="名字"/> </td>
                                                        <td><form:input path="contactDetailsList[0].customerPhone" class="form-control" placeholder="电话号码"/> </td>
                                                        <td><form:input path="contactDetailsList[0].customerAddress" class="form-control" placeholder="地址"/> </td>
                                                        <td><form:input path="contactDetailsList[0].fbName" class="form-control" placeholder="facebook名"/> </td>
                                                        <td><form:input path="contactDetailsList[0].weChatName" class="form-control" placeholder="wechat名"/> </td>
                                                        <td><form:input path="contactDetailsList[0].customerFullName" class="form-control" placeholder="Posting Full Name"/> </td>

                                                    </tr>
                                                </tbody>
                                            </table>
                                            <button type="button" class="btn btn-default" onclick="add()">增加选择 （+）</button>
                                            <button type="button" class="btn btn-default" onclick="deleterow()">删除 （-）</button> 
                                            <input type="submit" class="btn btn-default" value="Submit" />    
                                        </div>

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