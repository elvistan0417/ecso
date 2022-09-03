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
 <style type="text/css">


div.cut-text {

width: 100px;

word-wrap: break-word;

}

</style>
</head><!--/head-->

<body>
    
        <div id="wrapper">
            
         <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="label.customerlist" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

<div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                             <a href="<c:url value='/viewInsertCustomer'/>" class="btn btn-default"><fmt:message key="label.add" /></a>
                                                         </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    <fmt:message key="label.successexecution" />
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    <fmt:message key="label.failexecution" />
                                </div>
                                </c:if>
                                <div class="dataTable_wrapper">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th><fmt:message key="label.name" /></th>
                                                <th><fmt:message key="label.phonenumber" /></th>
                                                <th><fmt:message key="label.address" /></th>
                                                <th><fmt:message key="label.facebookname" /></th>
                                                <th><fmt:message key="label.wechatname" /></th>
                                                 <th><fmt:message key="label.fullname" /></th>
                                               <th><fmt:message key="label.creationdate" /></th>
                                               <th><fmt:message key="label.updatedate" /></th>
                                               <th> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="contactDetailsObjectList" items="${contactDetailsObjectList}" varStatus = "contactDetailsObjectListLoop"> 
                                                                <c:if test="${contactDetailsObjectListLoop.index % 2 == 1}">
                                                                    <tr class="odd">
                                                                    </c:if> 
                                                                    <c:if test="${contactDetailsObjectListLoop.index % 2 == 0}">
                                                                    <tr class="even">
                                                                    </c:if> 
                                                                    <td>${contactDetailsObjectListLoop.index + 1}</td>
                                                                    <td>${contactDetailsObjectList.customerID} - ${contactDetailsObjectList.customerName}</td>
                                                                    <td>${contactDetailsObjectList.customerPhone}</td>
                                                                    <td><div class = 'cut-text'>${contactDetailsObjectList.customerAddress}</div></td>
                                                                    <td>${contactDetailsObjectList.fbName}</td>
                                                                    <td>${contactDetailsObjectList.weChatName}</td>
                                                                     <td>${contactDetailsObjectList.customerFullName}</td>
                                                                    <td>${contactDetailsObjectList.createDate}</td>
                                                                    <td>${contactDetailsObjectList.updateDate}</td>
                                                                    <td><a href="<c:url value='/viewCustomerDetail?customerID=${contactDetailsObjectList.customerID}'/>" class="btn btn-default">详情</a> </td>

                                                                </tr>



                                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                
                                
                                
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
            </div>
                </div>
        <!-- /#wrapper -->
</body>
             

        <!-- jQuery -->
<!--        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>-->

        <!-- Bootstrap Core JavaScript -->
<!--        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

         Metis Menu Plugin JavaScript 
        <script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>-->

        <!-- DataTables JavaScript -->
        <script src="${pageContext.request.contextPath}/js/dataTables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dataTables/dataTables.bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${pageContext.request.contextPath}/js/startmin.js"></script>

        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
        <script>
            $(document).ready(function() {
                $('#dataTables-example').DataTable({
                        responsive: true
                });
            });
        </script>
</html>