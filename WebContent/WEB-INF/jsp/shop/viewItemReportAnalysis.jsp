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

        <link href="${pageContext.request.contextPath}/css/morris.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    </head><!--/head-->

    <body>

        <div id="wrapper">

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">下单分析报告</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="col-lg-12">


                    <!-- /.panel-heading -->

                    <div class="col-lg-12">
                                               <div class="panel panel-default">
                            <div class="panel-heading">

                                <label>货物种类</label>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                
                            
                        <form role="form">

                            <div class="form-group">
                                <label></label>
                                <select class="form-control" onchange="location = this.value;" >
                                    <c:forEach var="itemCategoryObjectList" items="${itemCategoryObjectList}" varStatus = "itemCategoryObjectListLoop"> 

                                        <c:if test="${itemCategoryObjectList.itemCategoryID == choosenItemCategoryID}">
                                            <option selected="selected"  value='<c:url value='/getItemReport?itemCategoryID=${itemCategoryObjectList.itemCategoryID}'/>'>${itemCategoryObjectList.itemCategoryName}</option>
                                        </c:if>
                                        <c:if test="${itemCategoryObjectList.itemCategoryID != choosenItemCategoryID}">
                                            <option value='<c:url value='/getItemReport?itemCategoryID=${itemCategoryObjectList.itemCategoryID}'/>'>${itemCategoryObjectList.itemCategoryName}</option>                                                             
                                        </c:if>    
                                    </c:forEach>
                                </select>
                            </div>

                        </form>
                                </div>
                    </div>
                             </div>
                    <div class="col-lg-9">
                        <div class="panel panel-default">
                            <div class="panel-heading">

                                 <label>目前行程 - <font color="INDIANRED">${orderTripDescription}</font></label>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div id="morris-bar-chart"></div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>

        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/morris-data.js"></script>
    <script>

new Morris.Bar({
        element: 'morris-bar-chart',
                                        data: [
        <c:forEach items="${itemOrderObjectList}" var="itemOrderObjectList">
                                            {
                                                y: "<c:out value="${itemOrderObjectList.itemCodeDescription}" />",
                                                a: <c:out value="${itemOrderObjectList.itemQuantity}" />
                                            },
        </c:forEach>
                                        ],
        xkey: 'y',
        ykeys: ['a',],
        labels: ['货物数量'],
        hideHover: 'auto',
        resize: true
    });
    </script>
</body>
</html>