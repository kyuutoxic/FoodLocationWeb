<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="app-main__outer">
    <div class="app-main__inner">
        <h1 class="text-center text-info">THONG KE BAO CAO</h1>

        <div class="row mb-3">
            <div class="col-md-6 col-xs-12" style="height: 365px; overflow-y: scroll;">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Percentage</th>
                        <th>Revenue/(VND)</th>
                    </tr>
                    <c:forEach items="${revenuStats}" var="f">
                        <tr>
                            <td>${f[0]}</td>
                            <td>${f[1]}</td>
                            <td>${f[2]}</td>
                            <td>
                                <fmt:formatNumber type="number" value="${f[4]}" maxFractionDigits="2" />%
                            </td>
                            <td>
                                <fmt:formatNumber type="number" value="${f[3]}" maxFractionDigits="3" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-6 col-xs-12">
                <c:url value="/store/stats" var="action" />
                <form action="${action}">
                    <div class="mb-3 monthRevenue">
                        <label class="col-form-label" for="idStoreRevenue">Month</label>
                        <select class="form-control" name="month" id="monthRevenue">
                            <option value="0"></option>
                            <c:forEach begin="1" end="12" var="i">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3 quarterRevenue">
                        <label class="col-form-label" for="idStoreRevenue">Quarter</label>
                        <select class="form-control" name="quarter" id="quarterRevenue">
                            <option value="0"></option>
                            <c:forEach begin="1" end="4" var="i">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="col-form-label" for="yearStoreRevenue">Year</label>
                        <input type="number" class="form-control" placeholder="Nhap nam" name="year" id="yearStoreRevenue">
                    </div>
                    <button type="submit" class="btn btn-primary m-1">Filter</button>
                    <button id="resetAll" class="btn btn-primary m-1">Default</button>
                </form>
            </div>
        </div>
        <canvas id="revenueChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
    window.addEventListener("load", loadChart, false);
    function loadChart() {
        let data = [];
        let labels = [];

    <c:forEach items="${revenuStats}" var="f">
        data.push(${f[3]});
        labels.push('${f[1]}');
    </c:forEach>

        revenueStats(labels, data);
    }
</script>