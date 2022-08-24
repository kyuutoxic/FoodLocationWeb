<%-- 
    Document   : admin-add-product
    Created on : Aug 12, 2022, 2:17:48 PM
    Author     : kyuut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        <h5 class="card-title">Controls Types</h5>
        <c:url value="/admin/detail-menu" var="a" />
        <form:form method="post" action="${a}" modelAttribute="menu" enctype="multipart/form-data">
            <div class="position-relative form-group">
                <label for="name" class="">Name</label>
                <form:input value="${menu.menuName}" id="name" type="text" class="form-control" path="menuName" />
            </div>
            <div class="position-relative form-group">
                <label for="price" class="">Price</label>
                <form:input value="${menu.price}" id="price" type="text" class="form-control" path="price" />
            </div>  
            <div class="position-relative form-group">
                <label for="note" class="">Note</label>
                <form:textarea placeholder="${menu.menuNote}" id="note" class="form-control" path="menuNote"/>
            </div>
            <div class="position-relative form-group">
                <label for="exampleText" class="">Store</label>
                <form:select class="form-control" path="idStore">
                    <form:option value="">hihi</form:option>
                    <%--<c:forEach var="s" items="${store}">--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${s.id eq '2'}">--%>
                                <%--<form:option selected="true" value="${s.id}">${s.name}</form:option>--%>
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                                <%--<form:option value="${s.id}">${s.name}</form:option>--%>
                            <%--</c:otherwise>--%>
                        <%--</c:choose>--%> 
                    <%--</c:forEach>--%>
                </form:select>
            </div>
            <div class="position-relative form-group">
                <label for="status" class="">Status</label>
                <form:checkbox checked="checked" value="true" id="status" path="menuStatus"/>
                <%--<c:choose>--%>
                    <%--<c:when test="${t.status eq '1'}">--%>
                        <%--<form:checkbox checked="checked" value="true" id="status" path="menuStatus"/>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<form:checkbox value="true" id="status" path="menuStatus"/>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%> 
            </div>
            <div class="position-relative form-group">
                <label for="from" class="">From</label>
                <form:input value="${menu.menuFrom}" id="from" type="time" class="form-control" path="menuFrom" />
            </div>
            <div class="position-relative form-group">
                <label for="to" class="">To</label>
                <form:input value="${menu.menuTo}" id="to" type="time" class="form-control" path="menuTo" />
            </div>
            <div class="position-relative form-group">
                <label for="typeMenu" class="">Type Menu</label>
                <form:select class="form-control" path="typeId">
                    <%--<form:option value="currentID">haha</form:option>--%>
                    <c:forEach var="t" items="${type}">
                        <c:choose>
                            <c:when test="${t.id eq '1'}">
                                <form:option selected="true" value="${t.id}">${t.name}</form:option>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${t.id}">${t.name}</form:option>
                            </c:otherwise>
                        </c:choose> 
                        <%--<form:option value="${t.id}">${t.name}</form:option>--%>
                    </c:forEach>
                </form:select>
            </div>

            <div class="position-relative form-group">
                <label for="image" class="">Image</label>
                <form:input value="" type="file" class="form-control-file" path="file" />
            </div>
            <button type="submit" class="btn btn-primary btn-lg mb-3">Cap nhat</button>

        </form:form>
            <a href="<c:url value="/admin"/>"><button type="button" class="btn btn-danger btn-lg mb-3">Thoat</button></a>
    </div>
</div>

