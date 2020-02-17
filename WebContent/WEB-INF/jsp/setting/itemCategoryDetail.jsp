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
                        <h1 class="page-header">货物种类详情</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
             <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                货物种类名 - ${itemCategoryName}
                                <br>
                                行程名 - ${orderTripDescription}
                               
                            </div>
                            
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    执行成功
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    执行失败，请联络技术人员
                                </div>
                                </c:if>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>货物选项</th>
                                                <th>创造时间</th>
                                                <th>更新时间</th>
                                             
              
                                            </tr>
                                        </thead>
                                        <tbody>
                                             <c:forEach var="itemOptionList" items="${itemOptionList}" varStatus = "itemOptionListLoop"> 
                                            <tr>
                                                <td>${itemOptionListLoop.index + 1}</td>
                                                <td>${itemOptionList.itemOptionName}</td>
                                                <td>${itemOptionList.itemOptionCreateDate}</td>
                                                <td>${itemOptionList.itemOptionUpdateDate}</td>
                                                
                                                
                                            </tr>
                                            
                                            </c:forEach>
                                        </tbody>
                                    </table>
                   
                  
                                    <a href="<c:url value='/insertExstingItemOption?itemCategoryID=${itemCategoryID}&itemCategoryName=${itemCategoryName}'/>" class="btn btn-default">新增</a> 
                                    <a href="<c:url value='/viewUpdateItemCategoryDetail?itemCategoryID=${itemCategoryID}'/>" class="btn btn-default">更新</a>
                                    <a href="<c:url value='/deleteItemCategory?itemCategoryID=${itemCategoryID}'/>" class="btn btn-default" onclick="return confirm('确定删除此货物?')">删除</a> 
                                
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                
            </div>
                </div>
        <!-- /#wrapper -->
</body>
</html>