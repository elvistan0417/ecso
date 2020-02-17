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
             <form:form method="POST" action="updateItemCategory" modelAttribute="itemCategoryForm" role="form">
         <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">货物种类详情</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                货物种类名 -
                                <form:input path="itemCategoryName"  class="form-control"/>
                                <br>
                                行程名 - ${orderTripDescription}
                               
                            </div>
                            
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>选择</th>
                                                    <th>删除？</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                             
                                            <c:forEach items="${itemCategoryForm.itemOptionList}"  varStatus="status">
                                                 <tr>
                                                <td>${status.index + 1}</td>
                                                <td>
                                                  <form:input path="itemOptionList[${status.index}].itemOptionName"  class="form-control"   required="required"/>
                                                </td>
                                                <td> 
                                                    <form:checkbox path="itemOptionList[${status.index}].itemOptionDeleteFlag" value="Y"  class="form-control"/>
                                                  
                                                    </td>
                                            </tr>
                                            <form:hidden path="itemOptionList[${status.index}].itemOptionID" />  
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