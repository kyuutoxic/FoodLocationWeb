<%-- 
    Document   : admin-index
    Created on : Aug 12, 2022, 11:32:50 AM
    Author     : kyuut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">  
        <c:forEach items="${statsStore}" var="s">
        <div class="row">
            <div class="col-md-6 col-xl-4">
                <div class="card mb-3 widget-content bg-midnight-bloom">
                    <div class="widget-content-wrapper text-white">
                        <div class="widget-content-left">
                            <div class="widget-heading">Total Orders</div>
                            <div class="widget-subheading">All the time</div>
                        </div>
                        <div class="widget-content-right">
                            <div class="widget-numbers text-white"><span>${s[0]}</span></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-xl-4">
                <div class="card mb-3 widget-content bg-arielle-smile">
                    <div class="widget-content-wrapper text-white row">
                        <div class="widget-content-left col-5">
                            <div class="widget-heading">Products Sold</div>
                            <div class="widget-subheading">Revenue streams</div>
                        </div>
                        <div class="widget-content-right col-7" style="padding: 0; overflow: clip; font-size: 20px; display: flex; text-align: right;">
                                <span title="${s[1]}" style="width: 70%; white-space: nowrap; overflow: clip; text-overflow: ellipsis;">
                                    <fmt:formatNumber type="number" value="${s[1]}" maxFractionDigits="2" /> 
                                </span>
                                <span style="width: 30%">VND</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-xl-4">
                <div class="card mb-3 widget-content bg-grow-early">
                    <div class="widget-content-wrapper text-white">
                        <div class="widget-content-left">
                            <div class="widget-heading">Followers</div>
                            <div class="widget-subheading">People Interested</div>
                        </div>
                        <div class="widget-content-right">
                            <div class="widget-numbers text-white"><span><fmt:formatNumber type="number" value="${s[2]}" maxFractionDigits="2" />%</span></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach> 
        <div class="row">
            <div class="col-md-12">
                <div class="main-card mb-3 card">
                    <div class="card-header">Manage Order</div>
                    <div class="table-responsive">
                        <table class="align-middle mb-0 table table-borderless table-striped table-hover">
                            <thead>
                                <tr>
                                    <th class="text-center">#</th>
                                    <th>Name</th>
                                    <th class="text-center">Address</th>
                                    <th class="text-center">Number</th>
                                    <th class="text-center">Status</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id="order-check-area">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    $(document).ready(function(){
        loadOrderDetailByStoreId();
    });
</script>
</div>