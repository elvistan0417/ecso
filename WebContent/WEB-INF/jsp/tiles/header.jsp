<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/viewCustomerReport">报告系统</a>
                </div>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">

                </button>

                <ul class="nav navbar-nav navbar-left navbar-top-links">
                    <li><a href="${pageContext.request.contextPath}/viewCustomerReport"><i class="fa fa-home fa-fw"></i> Home</a></li>
                </ul>

                <ul class="nav navbar-right navbar-top-links">
                    <li><a href="${pageContext.request.contextPath}/logout"></i> Logout</a></li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/viewItemReportAnalysis"><i class="fa fa-dashboard fa-fw"></i> 货物分析报告</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/viewReportAnalysis"><i class="fa fa-dashboard fa-fw"></i> 货物类型分析报告</a>
                            </li>
                           <li>
                               <a href="${pageContext.request.contextPath}/viewCustomerReport"><i class="fa fa-bar-chart-o fa-fw"></i> 客户报告</a>
                                
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/viewOrderSearch"><i class="fa fa-search fa-fw"></i> 搜索账单</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/viewOrderInsert"><i class="fa fa-edit fa-fw"></i> 下单</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/viewSummaryOrderUnpay"><i class="fa fa-edit fa-fw"></i> 管理未付款</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/orderTrip"><i class="fa fa-wrench fa-fw"></i> 行程设置</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/itemCategory"><i class="fa fa-wrench fa-fw"></i> 货物种类设置</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/itemDetail"><i class="fa fa-wrench fa-fw"></i> 货物设置</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/customer"><i class="fa fa-wrench fa-fw"></i> 客户设置</a>
                            </li>
                           

                            
                        </ul>
                    </div>
                </div>
            </nav>
</div>