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
        <link href="${pageContext.request.contextPath}/css/select2.min.css" rel="stylesheet" />
        <!--        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />-->
    </head><!--/head-->

   
    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">下单</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="label.addorderresult" />
                            </div>
                            <div class="panel-body">
                                <c:if test="${result == 'Y'}"> 
                                <div class="alert alert-success">
                                    <fmt:message key="label.addordersuccess" />
                                </div>
                                </c:if>
                                <c:if test="${result == 'N'}"> 
                                <div class="alert alert-danger">
                                    <fmt:message key="label.addorderfail" />
                                </div>
                                </c:if>
                                <div class="row">
                                     
                                    <!-- /.col-lg-6 (nested) -->
                                    <div class="col-lg-6">
                                        <form role="form">
                                                
                                            <div class="form-group">
                                                <label><fmt:message key="label.addorderresult" /></label>
<a href='<c:url value="viewOrderInsert"/>' class="btn btn-default"><fmt:message key="label.backtoaddorder" /></a>
                                            </div>

                                        </form>
                                    </div>
                                    <!-- /.col-lg-6 (nested) -->
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

                        <!-- Custom Theme JavaScript -->
                        <script src="${pageContext.request.contextPath}/js/startmin.js"></script>

                        <script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
                        <!--                        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>-->
                        <script>
                                                    $(document).ready(function () {
                                                        $('.js-example-basic-multiple').select2();
                                                    });
                        </script>

                        </script>
                        </html>